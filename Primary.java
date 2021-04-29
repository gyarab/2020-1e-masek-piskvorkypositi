/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piskvorkyrocnikovaprace;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 *
 * @author denis
 */
public class Primary extends Application {

    Boolean clientNarade = true;
    Boolean serverNarade = false;

    class Tlacitko extends Button {

        int location;

        public Tlacitko(String text, int location) {
            super(text);
            this.location = location;
        }

        public int getLocation() {
            return location;
        }
    }

    List<Button> buttonList = new ArrayList<>();
    int count = 0;
    int a = 1;
    byte anim = 0;
    Label btn = new Label("| Hra probíhá! |");

    public String tlacitko(Button a) {
        String b = a.getText();
        return b;
    }

    private void animCount() {
        switch (anim) {
            case 1:
                btn.setText("X Vyhral!");
                break;
            case 2:
                btn.setText("O Vyhral!");
                break;
            default:
                count++;
                switch (count) {
                    case 1:
                        btn.setText("/ Hra probíhá! /");
                        break;
                    case 2:
                        btn.setText("– Hra probíhá! –");
                        break;
                    case 3:
                        btn.setText("\\ Hra probíhá! \\");
                        break;
                    case 4:
                        btn.setText("| Hra probíhá! |");
                        count = 0;
                        break;
                }
                break;
        }
    }

    public void client(Stage primaryStage, String ip) throws InterruptedException, IOException {
        Socket s = new Socket(ip, 25264);
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        int wait = 100;
        btn.setMinWidth(520);
        btn.setMinHeight(25);
        btn.setAlignment(Pos.CENTER);
        GridPane panel = new GridPane();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                Tlacitko but = new Tlacitko("", (i * 20) + j);
                but.setOnAction((ActionEvent event) -> {
                    if ("".equals(but.getText())) {
                        if (clientNarade) {
                            but.setText("O");
                            pr.println(but.getLocation());
                            pr.flush();
                            clientNarade = false;
                            for (int k = 0; k < 400; k++) {
                                try {
                                    if (tlacitko(buttonList.get(k)).equals("X")) {
                                        if (tlacitko(buttonList.get(k + 20)).equals("X")) {
                                            if (tlacitko(buttonList.get(k + 40)).equals("X")) {
                                                if (tlacitko(buttonList.get(k + 60)).equals("X")) {
                                                    if (tlacitko(buttonList.get(k + 80)).equals("X")) {
                                                        anim = 1;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(k)).equals("X") && k != 19 && k != 39 && k != 59 && k != 79 && k != 99 && k != 119 && k != 139 && k != 159 && k != 179 && k != 199 && k != 219 && k != 239 && k != 259 && k != 279 && k != 299 && k != 319 && k != 339 && k != 359 && k != 379 && k != 399) {
                                        if (tlacitko(buttonList.get(k + 1)).equals("X") && k + 1 != 19 && k + 1 != 39 && k + 1 != 59 && k + 1 != 79 && k + 1 != 99 && k + 1 != 119 && k + 1 != 139 && k + 1 != 159 && k + 1 != 179 && k + 1 != 199 && k + 1 != 219 && k + 1 != 239 && k + 1 != 259 && k + 1 != 279 && k + 1 != 299 && k + 1 != 319 && k + 1 != 339 && k + 1 != 359 && k + 1 != 379 && k + 1 != 399) {
                                            if (tlacitko(buttonList.get(k + 2)).equals("X") && k + 2 != 19 && k + 2 != 39 && k + 2 != 59 && k + 2 != 79 && k + 2 != 99 && k + 2 != 119 && k + 2 != 139 && k + 2 != 159 && k + 2 != 179 && k + 2 != 199 && k + 2 != 219 && k + 2 != 239 && k + 2 != 259 && k + 2 != 279 && k + 2 != 299 && k + 2 != 319 && k + 2 != 339 && k + 2 != 359 && k + 2 != 379 && k + 2 != 399) {
                                                if (tlacitko(buttonList.get(k + 3)).equals("X") && k + 3 != 19 && k + 3 != 39 && k + 3 != 59 && k + 3 != 79 && k + 3 != 99 && k + 3 != 119 && k + 3 != 139 && k + 3 != 159 && k + 3 != 179 && k + 3 != 199 && k + 3 != 219 && k + 3 != 239 && k + 3 != 259 && k + 3 != 279 && k + 3 != 299 && k + 3 != 319 && k + 3 != 339 && k + 3 != 359 && k + 3 != 379 && k + 3 != 399) {
                                                    if (tlacitko(buttonList.get(k + 4)).equals("X")) {
                                                        anim = 1;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(k)).equals("X") && k != 19 && k != 39 && k != 59 && k != 79 && k != 99 && k != 119 && k != 139 && k != 159 && k != 179 && k != 199 && k != 219 && k != 239 && k != 259 && k != 279 && k != 299 && k != 319 && k != 339 && k != 359 && k != 379 && k != 399) {
                                        if (tlacitko(buttonList.get(k + 21)).equals("X") && k + 21 != 19 && k + 21 != 39 && k + 21 != 59 && k + 21 != 79 && k + 21 != 99 && k + 21 != 119 && k + 21 != 139 && k + 21 != 159 && k + 21 != 179 && k + 21 != 199 && k + 21 != 219 && k + 21 != 239 && k + 21 != 259 && k + 21 != 279 && k + 21 != 299 && k + 21 != 319 && k + 21 != 339 && k + 21 != 359 && k + 21 != 379 && k + 21 != 399) {
                                            if (tlacitko(buttonList.get(k + 42)).equals("X") && k + 42 != 19 && k + 42 != 39 && k + 42 != 59 && k + 42 != 79 && k + 42 != 99 && k + 42 != 119 && k + 42 != 139 && k + 42 != 159 && k + 42 != 179 && k + 42 != 199 && k + 42 != 219 && k + 42 != 239 && k + 42 != 259 && k + 42 != 279 && k + 42 != 299 && k + 42 != 319 && k + 42 != 339 && k + 42 != 359 && k + 42 != 379 && k + 42 != 399) {
                                                if (tlacitko(buttonList.get(k + 63)).equals("X") && k + 63 != 19 && k + 63 != 39 && k + 63 != 59 && k + 63 != 79 && k + 63 != 99 && k + 63 != 119 && k + 63 != 139 && k + 63 != 159 && k + 63 != 179 && k + 63 != 199 && k + 63 != 219 && k + 63 != 239 && k + 63 != 259 && k + 63 != 279 && k + 63 != 299 && k + 63 != 319 && k + 63 != 339 && k + 63 != 359 && k + 63 != 379 && k + 63 != 399) {
                                                    if (tlacitko(buttonList.get(k + 84)).equals("X")) {
                                                        anim = 1;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(k)).equals("X") && k != 19 && k != 39 && k != 59 && k != 79 && k != 99 && k != 119 && k != 139 && k != 159 && k != 179 && k != 199 && k != 219 && k != 239 && k != 259 && k != 279 && k != 299 && k != 319 && k != 339 && k != 359 && k != 379 && k != 399) {
                                        if (tlacitko(buttonList.get(k - 19)).equals("X") && k - 19 != 19 && k - 19 != 39 && k - 19 != 59 && k - 19 != 79 && k - 19 != 99 && k - 19 != 119 && k - 19 != 139 && k - 19 != 159 && k - 19 != 179 && k - 19 != 199 && k - 19 != 219 && k - 19 != 239 && k - 19 != 259 && k - 19 != 279 && k - 19 != 299 && k - 19 != 319 && k - 19 != 339 && k - 19 != 359 && k - 19 != 379 && k - 19 != 399) {
                                            if (tlacitko(buttonList.get(k - 38)).equals("X") && k - 38 != 19 && k - 38 != 39 && k - 38 != 59 && k - 38 != 79 && k - 38 != 99 && k - 38 != 119 && k - 38 != 139 && k - 38 != 159 && k - 38 != 179 && k - 38 != 199 && k - 38 != 219 && k - 38 != 239 && k - 38 != 259 && k - 38 != 279 && k - 38 != 299 && k - 38 != 319 && k - 38 != 339 && k - 38 != 359 && k - 38 != 379 && k - 38 != 399) {
                                                if (tlacitko(buttonList.get(k - 57)).equals("X") && k - 57 != 19 && k - 57 != 39 && k - 57 != 59 && k - 57 != 79 && k - 57 != 99 && k - 57 != 119 && k - 57 != 139 && k - 57 != 159 && k - 57 != 179 && k - 57 != 199 && k - 57 != 219 && k - 57 != 239 && k - 57 != 259 && k - 57 != 279 && k - 57 != 299 && k - 57 != 319 && k - 57 != 339 && k - 57 != 359 && k - 57 != 379 && k - 57 != 399) {
                                                    if (tlacitko(buttonList.get(k - 76)).equals("X")) {
                                                        anim = 1;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(k)).equals("O")) {
                                        if (tlacitko(buttonList.get(k + 20)).equals("O")) {
                                            if (tlacitko(buttonList.get(k + 40)).equals("O")) {
                                                if (tlacitko(buttonList.get(k + 60)).equals("O")) {
                                                    if (tlacitko(buttonList.get(k + 80)).equals("O")) {
                                                        anim = 2;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(k)).equals("O") && k != 19 && k != 39 && k != 59 && k != 79 && k != 99 && k != 119 && k != 139 && k != 159 && k != 179 && k != 199 && k != 219 && k != 239 && k != 259 && k != 279 && k != 299 && k != 319 && k != 339 && k != 359 && k != 379 && k != 399) {
                                        if (tlacitko(buttonList.get(k + 1)).equals("O") && k + 1 != 19 && k + 1 != 39 && k + 1 != 59 && k + 1 != 79 && k + 1 != 99 && k + 1 != 119 && k + 1 != 139 && k + 1 != 159 && k + 1 != 179 && k + 1 != 199 && k + 1 != 219 && k + 1 != 239 && k + 1 != 259 && k + 1 != 279 && k + 1 != 299 && k + 1 != 319 && k + 1 != 339 && k + 1 != 359 && k + 1 != 379 && k + 1 != 399) {
                                            if (tlacitko(buttonList.get(k + 2)).equals("O") && k + 2 != 19 && k + 2 != 39 && k + 2 != 59 && k + 2 != 79 && k + 2 != 99 && k + 2 != 119 && k + 2 != 139 && k + 2 != 159 && k + 2 != 179 && k + 2 != 199 && k + 2 != 219 && k + 2 != 239 && k + 2 != 259 && k + 2 != 279 && k + 2 != 299 && k + 2 != 319 && k + 2 != 339 && k + 2 != 359 && k + 2 != 379 && k + 2 != 399) {
                                                if (tlacitko(buttonList.get(k + 3)).equals("O") && k + 3 != 19 && k + 3 != 39 && k + 3 != 59 && k + 3 != 79 && k + 3 != 99 && k + 3 != 119 && k + 3 != 139 && k + 3 != 159 && k + 3 != 179 && k + 3 != 199 && k + 3 != 219 && k + 3 != 239 && k + 3 != 259 && k + 3 != 279 && k + 3 != 299 && k + 3 != 319 && k + 3 != 339 && k + 3 != 359 && k + 3 != 379 && k + 3 != 399) {
                                                    if (tlacitko(buttonList.get(k + 4)).equals("O")) {
                                                        anim = 2;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(k)).equals("O") && k != 19 && k != 39 && k != 59 && k != 79 && k != 99 && k != 119 && k != 139 && k != 159 && k != 179 && k != 199 && k != 219 && k != 239 && k != 259 && k != 279 && k != 299 && k != 319 && k != 339 && k != 359 && k != 379 && k != 399) {
                                        if (tlacitko(buttonList.get(k + 21)).equals("O") && k + 21 != 19 && k + 21 != 39 && k + 21 != 59 && k + 21 != 79 && k + 21 != 99 && k + 21 != 119 && k + 21 != 139 && k + 21 != 159 && k + 21 != 179 && k + 21 != 199 && k + 21 != 219 && k + 21 != 239 && k + 21 != 259 && k + 21 != 279 && k + 21 != 299 && k + 21 != 319 && k + 21 != 339 && k + 21 != 359 && k + 21 != 379 && k + 21 != 399) {
                                            if (tlacitko(buttonList.get(k + 42)).equals("O") && k + 42 != 19 && k + 42 != 39 && k + 42 != 59 && k + 42 != 79 && k + 42 != 99 && k + 42 != 119 && k + 42 != 139 && k + 42 != 159 && k + 42 != 179 && k + 42 != 199 && k + 42 != 219 && k + 42 != 239 && k + 42 != 259 && k + 42 != 279 && k + 42 != 299 && k + 42 != 319 && k + 42 != 339 && k + 42 != 359 && k + 42 != 379 && k + 42 != 399) {
                                                if (tlacitko(buttonList.get(k + 63)).equals("O") && k + 63 != 19 && k + 63 != 39 && k + 63 != 59 && k + 63 != 79 && k + 63 != 99 && k + 63 != 119 && k + 63 != 139 && k + 63 != 159 && k + 63 != 179 && k + 63 != 199 && k + 63 != 219 && k + 63 != 239 && k + 63 != 259 && k + 63 != 279 && k + 63 != 299 && k + 63 != 319 && k + 63 != 339 && k + 63 != 359 && k + 63 != 379 && k + 63 != 399) {
                                                    if (tlacitko(buttonList.get(k + 84)).equals("O")) {
                                                        anim = 2;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(k)).equals("O") && k != 19 && k != 39 && k != 59 && k != 79 && k != 99 && k != 119 && k != 139 && k != 159 && k != 179 && k != 199 && k != 219 && k != 239 && k != 259 && k != 279 && k != 299 && k != 319 && k != 339 && k != 359 && k != 379 && k != 399) {
                                        if (tlacitko(buttonList.get(k - 19)).equals("O") && k - 19 != 19 && k - 19 != 39 && k - 19 != 59 && k - 19 != 79 && k - 19 != 99 && k - 19 != 119 && k - 19 != 139 && k - 19 != 159 && k - 19 != 179 && k - 19 != 199 && k - 19 != 219 && k - 19 != 239 && k - 19 != 259 && k - 19 != 279 && k - 19 != 299 && k - 19 != 319 && k - 19 != 339 && k - 19 != 359 && k - 19 != 379 && k - 19 != 399) {
                                            if (tlacitko(buttonList.get(k - 38)).equals("O") && k - 38 != 19 && k - 38 != 39 && k - 38 != 59 && k - 38 != 79 && k - 38 != 99 && k - 38 != 119 && k - 38 != 139 && k - 38 != 159 && k - 38 != 179 && k - 38 != 199 && k - 38 != 219 && k - 38 != 239 && k - 38 != 259 && k - 38 != 279 && k - 38 != 299 && k - 38 != 319 && k - 38 != 339 && k - 38 != 359 && k - 38 != 379 && k - 38 != 399) {
                                                if (tlacitko(buttonList.get(k - 57)).equals("O") && k - 57 != 19 && k - 57 != 39 && k - 57 != 59 && k - 57 != 79 && k - 57 != 99 && k - 57 != 119 && k - 57 != 139 && k - 57 != 159 && k - 57 != 179 && k - 57 != 199 && k - 57 != 219 && k - 57 != 239 && k - 57 != 259 && k - 57 != 279 && k - 57 != 299 && k - 57 != 319 && k - 57 != 339 && k - 57 != 359 && k - 57 != 379 && k - 57 != 399) {
                                                    if (tlacitko(buttonList.get(k - 76)).equals("O")) {
                                                        anim = 2;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                            }
                            try {
                                    buttonList.get(Integer.parseInt(bf.readLine())).setText("X");
                                    clientNarade = true;
                                } catch (IOException ex) {
                                    Logger.getLogger(Primary.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            for (int l = 0; l < 400; l++) {
                                try {
                                    if (tlacitko(buttonList.get(l)).equals("X")) {
                                        if (tlacitko(buttonList.get(l + 20)).equals("X")) {
                                            if (tlacitko(buttonList.get(l + 40)).equals("X")) {
                                                if (tlacitko(buttonList.get(l + 60)).equals("X")) {
                                                    if (tlacitko(buttonList.get(l + 80)).equals("X")) {
                                                        anim = 1;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(l)).equals("X") && l != 19 && l != 39 && l != 59 && l != 79 && l != 99 && l != 119 && l != 139 && l != 159 && l != 179 && l != 199 && l != 219 && l != 239 && l != 259 && l != 279 && l != 299 && l != 319 && l != 339 && l != 359 && l != 379 && l != 399) {
                                        if (tlacitko(buttonList.get(l + 1)).equals("X") && l + 1 != 19 && l + 1 != 39 && l + 1 != 59 && l + 1 != 79 && l + 1 != 99 && l + 1 != 119 && l + 1 != 139 && l + 1 != 159 && l + 1 != 179 && l + 1 != 199 && l + 1 != 219 && l + 1 != 239 && l + 1 != 259 && l + 1 != 279 && l + 1 != 299 && l + 1 != 319 && l + 1 != 339 && l + 1 != 359 && l + 1 != 379 && l + 1 != 399) {
                                            if (tlacitko(buttonList.get(l + 2)).equals("X") && l + 2 != 19 && l + 2 != 39 && l + 2 != 59 && l + 2 != 79 && l + 2 != 99 && l + 2 != 119 && l + 2 != 139 && l + 2 != 159 && l + 2 != 179 && l + 2 != 199 && l + 2 != 219 && l + 2 != 239 && l + 2 != 259 && l + 2 != 279 && l + 2 != 299 && l + 2 != 319 && l + 2 != 339 && l + 2 != 359 && l + 2 != 379 && l + 2 != 399) {
                                                if (tlacitko(buttonList.get(l + 3)).equals("X") && l + 3 != 19 && l + 3 != 39 && l + 3 != 59 && l + 3 != 79 && l + 3 != 99 && l + 3 != 119 && l + 3 != 139 && l + 3 != 159 && l + 3 != 179 && l + 3 != 199 && l + 3 != 219 && l + 3 != 239 && l + 3 != 259 && l + 3 != 279 && l + 3 != 299 && l + 3 != 319 && l + 3 != 339 && l + 3 != 359 && l + 3 != 379 && l + 3 != 399) {
                                                    if (tlacitko(buttonList.get(l + 4)).equals("X")) {
                                                        anim = 1;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(l)).equals("X") && l != 19 && l != 39 && l != 59 && l != 79 && l != 99 && l != 119 && l != 139 && l != 159 && l != 179 && l != 199 && l != 219 && l != 239 && l != 259 && l != 279 && l != 299 && l != 319 && l != 339 && l != 359 && l != 379 && l != 399) {
                                        if (tlacitko(buttonList.get(l + 21)).equals("X") && l + 21 != 19 && l + 21 != 39 && l + 21 != 59 && l + 21 != 79 && l + 21 != 99 && l + 21 != 119 && l + 21 != 139 && l + 21 != 159 && l + 21 != 179 && l + 21 != 199 && l + 21 != 219 && l + 21 != 239 && l + 21 != 259 && l + 21 != 279 && l + 21 != 299 && l + 21 != 319 && l + 21 != 339 && l + 21 != 359 && l + 21 != 379 && l + 21 != 399) {
                                            if (tlacitko(buttonList.get(l + 42)).equals("X") && l + 42 != 19 && l + 42 != 39 && l + 42 != 59 && l + 42 != 79 && l + 42 != 99 && l + 42 != 119 && l + 42 != 139 && l + 42 != 159 && l + 42 != 179 && l + 42 != 199 && l + 42 != 219 && l + 42 != 239 && l + 42 != 259 && l + 42 != 279 && l + 42 != 299 && l + 42 != 319 && l + 42 != 339 && l + 42 != 359 && l + 42 != 379 && l + 42 != 399) {
                                                if (tlacitko(buttonList.get(l + 63)).equals("X") && l + 63 != 19 && l + 63 != 39 && l + 63 != 59 && l + 63 != 79 && l + 63 != 99 && l + 63 != 119 && l + 63 != 139 && l + 63 != 159 && l + 63 != 179 && l + 63 != 199 && l + 63 != 219 && l + 63 != 239 && l + 63 != 259 && l + 63 != 279 && l + 63 != 299 && l + 63 != 319 && l + 63 != 339 && l + 63 != 359 && l + 63 != 379 && l + 63 != 399) {
                                                    if (tlacitko(buttonList.get(l + 84)).equals("X")) {
                                                        anim = 1;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(l)).equals("X") && l != 19 && l != 39 && l != 59 && l != 79 && l != 99 && l != 119 && l != 139 && l != 159 && l != 179 && l != 199 && l != 219 && l != 239 && l != 259 && l != 279 && l != 299 && l != 319 && l != 339 && l != 359 && l != 379 && l != 399) {
                                        if (tlacitko(buttonList.get(l - 19)).equals("X") && l - 19 != 19 && l - 19 != 39 && l - 19 != 59 && l - 19 != 79 && l - 19 != 99 && l - 19 != 119 && l - 19 != 139 && l - 19 != 159 && l - 19 != 179 && l - 19 != 199 && l - 19 != 219 && l - 19 != 239 && l - 19 != 259 && l - 19 != 279 && l - 19 != 299 && l - 19 != 319 && l - 19 != 339 && l - 19 != 359 && l - 19 != 379 && l - 19 != 399) {
                                            if (tlacitko(buttonList.get(l - 38)).equals("X") && l - 38 != 19 && l - 38 != 39 && l - 38 != 59 && l - 38 != 79 && l - 38 != 99 && l - 38 != 119 && l - 38 != 139 && l - 38 != 159 && l - 38 != 179 && l - 38 != 199 && l - 38 != 219 && l - 38 != 239 && l - 38 != 259 && l - 38 != 279 && l - 38 != 299 && l - 38 != 319 && l - 38 != 339 && l - 38 != 359 && l - 38 != 379 && l - 38 != 399) {
                                                if (tlacitko(buttonList.get(l - 57)).equals("X") && l - 57 != 19 && l - 57 != 39 && l - 57 != 59 && l - 57 != 79 && l - 57 != 99 && l - 57 != 119 && l - 57 != 139 && l - 57 != 159 && l - 57 != 179 && l - 57 != 199 && l - 57 != 219 && l - 57 != 239 && l - 57 != 259 && l - 57 != 279 && l - 57 != 299 && l - 57 != 319 && l - 57 != 339 && l - 57 != 359 && l - 57 != 379 && l - 57 != 399) {
                                                    if (tlacitko(buttonList.get(l - 76)).equals("X")) {
                                                        anim = 1;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(l)).equals("O")) {
                                        if (tlacitko(buttonList.get(l + 20)).equals("O")) {
                                            if (tlacitko(buttonList.get(l + 40)).equals("O")) {
                                                if (tlacitko(buttonList.get(l + 60)).equals("O")) {
                                                    if (tlacitko(buttonList.get(l + 80)).equals("O")) {
                                                        anim = 2;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(l)).equals("O") && l != 19 && l != 39 && l != 59 && l != 79 && l != 99 && l != 119 && l != 139 && l != 159 && l != 179 && l != 199 && l != 219 && l != 239 && l != 259 && l != 279 && l != 299 && l != 319 && l != 339 && l != 359 && l != 379 && l != 399) {
                                        if (tlacitko(buttonList.get(l + 1)).equals("O") && l + 1 != 19 && l + 1 != 39 && l + 1 != 59 && l + 1 != 79 && l + 1 != 99 && l + 1 != 119 && l + 1 != 139 && l + 1 != 159 && l + 1 != 179 && l + 1 != 199 && l + 1 != 219 && l + 1 != 239 && l + 1 != 259 && l + 1 != 279 && l + 1 != 299 && l + 1 != 319 && l + 1 != 339 && l + 1 != 359 && l + 1 != 379 && l + 1 != 399) {
                                            if (tlacitko(buttonList.get(l + 2)).equals("O") && l + 2 != 19 && l + 2 != 39 && l + 2 != 59 && l + 2 != 79 && l + 2 != 99 && l + 2 != 119 && l + 2 != 139 && l + 2 != 159 && l + 2 != 179 && l + 2 != 199 && l + 2 != 219 && l + 2 != 239 && l + 2 != 259 && l + 2 != 279 && l + 2 != 299 && l + 2 != 319 && l + 2 != 339 && l + 2 != 359 && l + 2 != 379 && l + 2 != 399) {
                                                if (tlacitko(buttonList.get(l + 3)).equals("O") && l + 3 != 19 && l + 3 != 39 && l + 3 != 59 && l + 3 != 79 && l + 3 != 99 && l + 3 != 119 && l + 3 != 139 && l + 3 != 159 && l + 3 != 179 && l + 3 != 199 && l + 3 != 219 && l + 3 != 239 && l + 3 != 259 && l + 3 != 279 && l + 3 != 299 && l + 3 != 319 && l + 3 != 339 && l + 3 != 359 && l + 3 != 379 && l + 3 != 399) {
                                                    if (tlacitko(buttonList.get(l + 4)).equals("O")) {
                                                        anim = 2;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(l)).equals("O") && l != 19 && l != 39 && l != 59 && l != 79 && l != 99 && l != 119 && l != 139 && l != 159 && l != 179 && l != 199 && l != 219 && l != 239 && l != 259 && l != 279 && l != 299 && l != 319 && l != 339 && l != 359 && l != 379 && l != 399) {
                                        if (tlacitko(buttonList.get(l + 21)).equals("O") && l + 21 != 19 && l + 21 != 39 && l + 21 != 59 && l + 21 != 79 && l + 21 != 99 && l + 21 != 119 && l + 21 != 139 && l + 21 != 159 && l + 21 != 179 && l + 21 != 199 && l + 21 != 219 && l + 21 != 239 && l + 21 != 259 && l + 21 != 279 && l + 21 != 299 && l + 21 != 319 && l + 21 != 339 && l + 21 != 359 && l + 21 != 379 && l + 21 != 399) {
                                            if (tlacitko(buttonList.get(l + 42)).equals("O") && l + 42 != 19 && l + 42 != 39 && l + 42 != 59 && l + 42 != 79 && l + 42 != 99 && l + 42 != 119 && l + 42 != 139 && l + 42 != 159 && l + 42 != 179 && l + 42 != 199 && l + 42 != 219 && l + 42 != 239 && l + 42 != 259 && l + 42 != 279 && l + 42 != 299 && l + 42 != 319 && l + 42 != 339 && l + 42 != 359 && l + 42 != 379 && l + 42 != 399) {
                                                if (tlacitko(buttonList.get(l + 63)).equals("O") && l + 63 != 19 && l + 63 != 39 && l + 63 != 59 && l + 63 != 79 && l + 63 != 99 && l + 63 != 119 && l + 63 != 139 && l + 63 != 159 && l + 63 != 179 && l + 63 != 199 && l + 63 != 219 && l + 63 != 239 && l + 63 != 259 && l + 63 != 279 && l + 63 != 299 && l + 63 != 319 && l + 63 != 339 && l + 63 != 359 && l + 63 != 379 && l + 63 != 399) {
                                                    if (tlacitko(buttonList.get(l + 84)).equals("O")) {
                                                        anim = 2;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(l)).equals("O") && l != 19 && l != 39 && l != 59 && l != 79 && l != 99 && l != 119 && l != 139 && l != 159 && l != 179 && l != 199 && l != 219 && l != 239 && l != 259 && l != 279 && l != 299 && l != 319 && l != 339 && l != 359 && l != 379 && l != 399) {
                                        if (tlacitko(buttonList.get(l - 19)).equals("O") && l - 19 != 19 && l - 19 != 39 && l - 19 != 59 && l - 19 != 79 && l - 19 != 99 && l - 19 != 119 && l - 19 != 139 && l - 19 != 159 && l - 19 != 179 && l - 19 != 199 && l - 19 != 219 && l - 19 != 239 && l - 19 != 259 && l - 19 != 279 && l - 19 != 299 && l - 19 != 319 && l - 19 != 339 && l - 19 != 359 && l - 19 != 379 && l - 19 != 399) {
                                            if (tlacitko(buttonList.get(l - 38)).equals("O") && l - 38 != 19 && l - 38 != 39 && l - 38 != 59 && l - 38 != 79 && l - 38 != 99 && l - 38 != 119 && l - 38 != 139 && l - 38 != 159 && l - 38 != 179 && l - 38 != 199 && l - 38 != 219 && l - 38 != 239 && l - 38 != 259 && l - 38 != 279 && l - 38 != 299 && l - 38 != 319 && l - 38 != 339 && l - 38 != 359 && l - 38 != 379 && l - 38 != 399) {
                                                if (tlacitko(buttonList.get(l - 57)).equals("O") && l - 57 != 19 && l - 57 != 39 && l - 57 != 59 && l - 57 != 79 && l - 57 != 99 && l - 57 != 119 && l - 57 != 139 && l - 57 != 159 && l - 57 != 179 && l - 57 != 199 && l - 57 != 219 && l - 57 != 239 && l - 57 != 259 && l - 57 != 279 && l - 57 != 299 && l - 57 != 319 && l - 57 != 339 && l - 57 != 359 && l - 57 != 379 && l - 57 != 399) {
                                                    if (tlacitko(buttonList.get(l - 76)).equals("O")) {
                                                        anim = 2;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                            }
                        }
                    }
                });
                but.setMinWidth(26);
                panel.add(but, j, i);
            }
        }

        for (Node currentNode
                : panel.getChildren()) {
            if (currentNode instanceof Tlacitko) {
                buttonList.add((Tlacitko) currentNode);
            }
        }

        VBox root = new VBox();

        root.getChildren()
                .add(btn);
        root.getChildren()
                .add(panel);

        Scene scene = new Scene(root, 520, 525);

        primaryStage.setScene(scene);

        primaryStage.show();

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        animCount();
                    }
                };

                while (true) {
                    try {
                        Thread.sleep(wait);
                    } catch (InterruptedException ex) {
                    }
                    Platform.runLater(updater);
                }
            }

        });

        thread.setDaemon(
                true);
        thread.start();
    }

    public void server(Stage primaryStage) throws InterruptedException, IOException {
        ServerSocket ss = new ServerSocket(25264);
        Socket s = ss.accept();
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        int wait = 100;
        btn.setMinWidth(520);
        btn.setMinHeight(25);
        btn.setAlignment(Pos.CENTER);
        GridPane panel = new GridPane();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                Tlacitko but = new Tlacitko("", (i * 20) + j);
                but.setOnAction((ActionEvent event) -> {
                    if ("".equals(but.getText())) {
                        if (serverNarade) {
                            but.setText("X");
                            pr.println(but.getLocation());
                            pr.flush();
                            serverNarade = false;
                            for (int k = 0; k < 400; k++) {
                                try {
                                    if (tlacitko(buttonList.get(k)).equals("X")) {
                                        if (tlacitko(buttonList.get(k + 20)).equals("X")) {
                                            if (tlacitko(buttonList.get(k + 40)).equals("X")) {
                                                if (tlacitko(buttonList.get(k + 60)).equals("X")) {
                                                    if (tlacitko(buttonList.get(k + 80)).equals("X")) {
                                                        anim = 1;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(k)).equals("X") && k != 19 && k != 39 && k != 59 && k != 79 && k != 99 && k != 119 && k != 139 && k != 159 && k != 179 && k != 199 && k != 219 && k != 239 && k != 259 && k != 279 && k != 299 && k != 319 && k != 339 && k != 359 && k != 379 && k != 399) {
                                        if (tlacitko(buttonList.get(k + 1)).equals("X") && k + 1 != 19 && k + 1 != 39 && k + 1 != 59 && k + 1 != 79 && k + 1 != 99 && k + 1 != 119 && k + 1 != 139 && k + 1 != 159 && k + 1 != 179 && k + 1 != 199 && k + 1 != 219 && k + 1 != 239 && k + 1 != 259 && k + 1 != 279 && k + 1 != 299 && k + 1 != 319 && k + 1 != 339 && k + 1 != 359 && k + 1 != 379 && k + 1 != 399) {
                                            if (tlacitko(buttonList.get(k + 2)).equals("X") && k + 2 != 19 && k + 2 != 39 && k + 2 != 59 && k + 2 != 79 && k + 2 != 99 && k + 2 != 119 && k + 2 != 139 && k + 2 != 159 && k + 2 != 179 && k + 2 != 199 && k + 2 != 219 && k + 2 != 239 && k + 2 != 259 && k + 2 != 279 && k + 2 != 299 && k + 2 != 319 && k + 2 != 339 && k + 2 != 359 && k + 2 != 379 && k + 2 != 399) {
                                                if (tlacitko(buttonList.get(k + 3)).equals("X") && k + 3 != 19 && k + 3 != 39 && k + 3 != 59 && k + 3 != 79 && k + 3 != 99 && k + 3 != 119 && k + 3 != 139 && k + 3 != 159 && k + 3 != 179 && k + 3 != 199 && k + 3 != 219 && k + 3 != 239 && k + 3 != 259 && k + 3 != 279 && k + 3 != 299 && k + 3 != 319 && k + 3 != 339 && k + 3 != 359 && k + 3 != 379 && k + 3 != 399) {
                                                    if (tlacitko(buttonList.get(k + 4)).equals("X")) {
                                                        anim = 1;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(k)).equals("X") && k != 19 && k != 39 && k != 59 && k != 79 && k != 99 && k != 119 && k != 139 && k != 159 && k != 179 && k != 199 && k != 219 && k != 239 && k != 259 && k != 279 && k != 299 && k != 319 && k != 339 && k != 359 && k != 379 && k != 399) {
                                        if (tlacitko(buttonList.get(k + 21)).equals("X") && k + 21 != 19 && k + 21 != 39 && k + 21 != 59 && k + 21 != 79 && k + 21 != 99 && k + 21 != 119 && k + 21 != 139 && k + 21 != 159 && k + 21 != 179 && k + 21 != 199 && k + 21 != 219 && k + 21 != 239 && k + 21 != 259 && k + 21 != 279 && k + 21 != 299 && k + 21 != 319 && k + 21 != 339 && k + 21 != 359 && k + 21 != 379 && k + 21 != 399) {
                                            if (tlacitko(buttonList.get(k + 42)).equals("X") && k + 42 != 19 && k + 42 != 39 && k + 42 != 59 && k + 42 != 79 && k + 42 != 99 && k + 42 != 119 && k + 42 != 139 && k + 42 != 159 && k + 42 != 179 && k + 42 != 199 && k + 42 != 219 && k + 42 != 239 && k + 42 != 259 && k + 42 != 279 && k + 42 != 299 && k + 42 != 319 && k + 42 != 339 && k + 42 != 359 && k + 42 != 379 && k + 42 != 399) {
                                                if (tlacitko(buttonList.get(k + 63)).equals("X") && k + 63 != 19 && k + 63 != 39 && k + 63 != 59 && k + 63 != 79 && k + 63 != 99 && k + 63 != 119 && k + 63 != 139 && k + 63 != 159 && k + 63 != 179 && k + 63 != 199 && k + 63 != 219 && k + 63 != 239 && k + 63 != 259 && k + 63 != 279 && k + 63 != 299 && k + 63 != 319 && k + 63 != 339 && k + 63 != 359 && k + 63 != 379 && k + 63 != 399) {
                                                    if (tlacitko(buttonList.get(k + 84)).equals("X")) {
                                                        anim = 1;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(k)).equals("X") && k != 19 && k != 39 && k != 59 && k != 79 && k != 99 && k != 119 && k != 139 && k != 159 && k != 179 && k != 199 && k != 219 && k != 239 && k != 259 && k != 279 && k != 299 && k != 319 && k != 339 && k != 359 && k != 379 && k != 399) {
                                        if (tlacitko(buttonList.get(k - 19)).equals("X") && k - 19 != 19 && k - 19 != 39 && k - 19 != 59 && k - 19 != 79 && k - 19 != 99 && k - 19 != 119 && k - 19 != 139 && k - 19 != 159 && k - 19 != 179 && k - 19 != 199 && k - 19 != 219 && k - 19 != 239 && k - 19 != 259 && k - 19 != 279 && k - 19 != 299 && k - 19 != 319 && k - 19 != 339 && k - 19 != 359 && k - 19 != 379 && k - 19 != 399) {
                                            if (tlacitko(buttonList.get(k - 38)).equals("X") && k - 38 != 19 && k - 38 != 39 && k - 38 != 59 && k - 38 != 79 && k - 38 != 99 && k - 38 != 119 && k - 38 != 139 && k - 38 != 159 && k - 38 != 179 && k - 38 != 199 && k - 38 != 219 && k - 38 != 239 && k - 38 != 259 && k - 38 != 279 && k - 38 != 299 && k - 38 != 319 && k - 38 != 339 && k - 38 != 359 && k - 38 != 379 && k - 38 != 399) {
                                                if (tlacitko(buttonList.get(k - 57)).equals("X") && k - 57 != 19 && k - 57 != 39 && k - 57 != 59 && k - 57 != 79 && k - 57 != 99 && k - 57 != 119 && k - 57 != 139 && k - 57 != 159 && k - 57 != 179 && k - 57 != 199 && k - 57 != 219 && k - 57 != 239 && k - 57 != 259 && k - 57 != 279 && k - 57 != 299 && k - 57 != 319 && k - 57 != 339 && k - 57 != 359 && k - 57 != 379 && k - 57 != 399) {
                                                    if (tlacitko(buttonList.get(k - 76)).equals("X")) {
                                                        anim = 1;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(k)).equals("O")) {
                                        if (tlacitko(buttonList.get(k + 20)).equals("O")) {
                                            if (tlacitko(buttonList.get(k + 40)).equals("O")) {
                                                if (tlacitko(buttonList.get(k + 60)).equals("O")) {
                                                    if (tlacitko(buttonList.get(k + 80)).equals("O")) {
                                                        anim = 2;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(k)).equals("O") && k != 19 && k != 39 && k != 59 && k != 79 && k != 99 && k != 119 && k != 139 && k != 159 && k != 179 && k != 199 && k != 219 && k != 239 && k != 259 && k != 279 && k != 299 && k != 319 && k != 339 && k != 359 && k != 379 && k != 399) {
                                        if (tlacitko(buttonList.get(k + 1)).equals("O") && k + 1 != 19 && k + 1 != 39 && k + 1 != 59 && k + 1 != 79 && k + 1 != 99 && k + 1 != 119 && k + 1 != 139 && k + 1 != 159 && k + 1 != 179 && k + 1 != 199 && k + 1 != 219 && k + 1 != 239 && k + 1 != 259 && k + 1 != 279 && k + 1 != 299 && k + 1 != 319 && k + 1 != 339 && k + 1 != 359 && k + 1 != 379 && k + 1 != 399) {
                                            if (tlacitko(buttonList.get(k + 2)).equals("O") && k + 2 != 19 && k + 2 != 39 && k + 2 != 59 && k + 2 != 79 && k + 2 != 99 && k + 2 != 119 && k + 2 != 139 && k + 2 != 159 && k + 2 != 179 && k + 2 != 199 && k + 2 != 219 && k + 2 != 239 && k + 2 != 259 && k + 2 != 279 && k + 2 != 299 && k + 2 != 319 && k + 2 != 339 && k + 2 != 359 && k + 2 != 379 && k + 2 != 399) {
                                                if (tlacitko(buttonList.get(k + 3)).equals("O") && k + 3 != 19 && k + 3 != 39 && k + 3 != 59 && k + 3 != 79 && k + 3 != 99 && k + 3 != 119 && k + 3 != 139 && k + 3 != 159 && k + 3 != 179 && k + 3 != 199 && k + 3 != 219 && k + 3 != 239 && k + 3 != 259 && k + 3 != 279 && k + 3 != 299 && k + 3 != 319 && k + 3 != 339 && k + 3 != 359 && k + 3 != 379 && k + 3 != 399) {
                                                    if (tlacitko(buttonList.get(k + 4)).equals("O")) {
                                                        anim = 2;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(k)).equals("O") && k != 19 && k != 39 && k != 59 && k != 79 && k != 99 && k != 119 && k != 139 && k != 159 && k != 179 && k != 199 && k != 219 && k != 239 && k != 259 && k != 279 && k != 299 && k != 319 && k != 339 && k != 359 && k != 379 && k != 399) {
                                        if (tlacitko(buttonList.get(k + 21)).equals("O") && k + 21 != 19 && k + 21 != 39 && k + 21 != 59 && k + 21 != 79 && k + 21 != 99 && k + 21 != 119 && k + 21 != 139 && k + 21 != 159 && k + 21 != 179 && k + 21 != 199 && k + 21 != 219 && k + 21 != 239 && k + 21 != 259 && k + 21 != 279 && k + 21 != 299 && k + 21 != 319 && k + 21 != 339 && k + 21 != 359 && k + 21 != 379 && k + 21 != 399) {
                                            if (tlacitko(buttonList.get(k + 42)).equals("O") && k + 42 != 19 && k + 42 != 39 && k + 42 != 59 && k + 42 != 79 && k + 42 != 99 && k + 42 != 119 && k + 42 != 139 && k + 42 != 159 && k + 42 != 179 && k + 42 != 199 && k + 42 != 219 && k + 42 != 239 && k + 42 != 259 && k + 42 != 279 && k + 42 != 299 && k + 42 != 319 && k + 42 != 339 && k + 42 != 359 && k + 42 != 379 && k + 42 != 399) {
                                                if (tlacitko(buttonList.get(k + 63)).equals("O") && k + 63 != 19 && k + 63 != 39 && k + 63 != 59 && k + 63 != 79 && k + 63 != 99 && k + 63 != 119 && k + 63 != 139 && k + 63 != 159 && k + 63 != 179 && k + 63 != 199 && k + 63 != 219 && k + 63 != 239 && k + 63 != 259 && k + 63 != 279 && k + 63 != 299 && k + 63 != 319 && k + 63 != 339 && k + 63 != 359 && k + 63 != 379 && k + 63 != 399) {
                                                    if (tlacitko(buttonList.get(k + 84)).equals("O")) {
                                                        anim = 2;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(k)).equals("O") && k != 19 && k != 39 && k != 59 && k != 79 && k != 99 && k != 119 && k != 139 && k != 159 && k != 179 && k != 199 && k != 219 && k != 239 && k != 259 && k != 279 && k != 299 && k != 319 && k != 339 && k != 359 && k != 379 && k != 399) {
                                        if (tlacitko(buttonList.get(k - 19)).equals("O") && k - 19 != 19 && k - 19 != 39 && k - 19 != 59 && k - 19 != 79 && k - 19 != 99 && k - 19 != 119 && k - 19 != 139 && k - 19 != 159 && k - 19 != 179 && k - 19 != 199 && k - 19 != 219 && k - 19 != 239 && k - 19 != 259 && k - 19 != 279 && k - 19 != 299 && k - 19 != 319 && k - 19 != 339 && k - 19 != 359 && k - 19 != 379 && k - 19 != 399) {
                                            if (tlacitko(buttonList.get(k - 38)).equals("O") && k - 38 != 19 && k - 38 != 39 && k - 38 != 59 && k - 38 != 79 && k - 38 != 99 && k - 38 != 119 && k - 38 != 139 && k - 38 != 159 && k - 38 != 179 && k - 38 != 199 && k - 38 != 219 && k - 38 != 239 && k - 38 != 259 && k - 38 != 279 && k - 38 != 299 && k - 38 != 319 && k - 38 != 339 && k - 38 != 359 && k - 38 != 379 && k - 38 != 399) {
                                                if (tlacitko(buttonList.get(k - 57)).equals("O") && k - 57 != 19 && k - 57 != 39 && k - 57 != 59 && k - 57 != 79 && k - 57 != 99 && k - 57 != 119 && k - 57 != 139 && k - 57 != 159 && k - 57 != 179 && k - 57 != 199 && k - 57 != 219 && k - 57 != 239 && k - 57 != 259 && k - 57 != 279 && k - 57 != 299 && k - 57 != 319 && k - 57 != 339 && k - 57 != 359 && k - 57 != 379 && k - 57 != 399) {
                                                    if (tlacitko(buttonList.get(k - 76)).equals("O")) {
                                                        anim = 2;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }      
                            }
                            try {
                                buttonList.get(Integer.parseInt(bf.readLine())).setText("O");
                                serverNarade = true;
                                } catch (IOException ex) {}
                            for (int l = 0; l < 400; l++) {
                                try {
                                    if (tlacitko(buttonList.get(l)).equals("X")) {
                                        if (tlacitko(buttonList.get(l + 20)).equals("X")) {
                                            if (tlacitko(buttonList.get(l + 40)).equals("X")) {
                                                if (tlacitko(buttonList.get(l + 60)).equals("X")) {
                                                    if (tlacitko(buttonList.get(l + 80)).equals("X")) {
                                                        anim = 1;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(l)).equals("X") && l != 19 && l != 39 && l != 59 && l != 79 && l != 99 && l != 119 && l != 139 && l != 159 && l != 179 && l != 199 && l != 219 && l != 239 && l != 259 && l != 279 && l != 299 && l != 319 && l != 339 && l != 359 && l != 379 && l != 399) {
                                        if (tlacitko(buttonList.get(l + 1)).equals("X") && l + 1 != 19 && l + 1 != 39 && l + 1 != 59 && l + 1 != 79 && l + 1 != 99 && l + 1 != 119 && l + 1 != 139 && l + 1 != 159 && l + 1 != 179 && l + 1 != 199 && l + 1 != 219 && l + 1 != 239 && l + 1 != 259 && l + 1 != 279 && l + 1 != 299 && l + 1 != 319 && l + 1 != 339 && l + 1 != 359 && l + 1 != 379 && l + 1 != 399) {
                                            if (tlacitko(buttonList.get(l + 2)).equals("X") && l + 2 != 19 && l + 2 != 39 && l + 2 != 59 && l + 2 != 79 && l + 2 != 99 && l + 2 != 119 && l + 2 != 139 && l + 2 != 159 && l + 2 != 179 && l + 2 != 199 && l + 2 != 219 && l + 2 != 239 && l + 2 != 259 && l + 2 != 279 && l + 2 != 299 && l + 2 != 319 && l + 2 != 339 && l + 2 != 359 && l + 2 != 379 && l + 2 != 399) {
                                                if (tlacitko(buttonList.get(l + 3)).equals("X") && l + 3 != 19 && l + 3 != 39 && l + 3 != 59 && l + 3 != 79 && l + 3 != 99 && l + 3 != 119 && l + 3 != 139 && l + 3 != 159 && l + 3 != 179 && l + 3 != 199 && l + 3 != 219 && l + 3 != 239 && l + 3 != 259 && l + 3 != 279 && l + 3 != 299 && l + 3 != 319 && l + 3 != 339 && l + 3 != 359 && l + 3 != 379 && l + 3 != 399) {
                                                    if (tlacitko(buttonList.get(l + 4)).equals("X")) {
                                                        anim = 1;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(l)).equals("X") && l != 19 && l != 39 && l != 59 && l != 79 && l != 99 && l != 119 && l != 139 && l != 159 && l != 179 && l != 199 && l != 219 && l != 239 && l != 259 && l != 279 && l != 299 && l != 319 && l != 339 && l != 359 && l != 379 && l != 399) {
                                        if (tlacitko(buttonList.get(l + 21)).equals("X") && l + 21 != 19 && l + 21 != 39 && l + 21 != 59 && l + 21 != 79 && l + 21 != 99 && l + 21 != 119 && l + 21 != 139 && l + 21 != 159 && l + 21 != 179 && l + 21 != 199 && l + 21 != 219 && l + 21 != 239 && l + 21 != 259 && l + 21 != 279 && l + 21 != 299 && l + 21 != 319 && l + 21 != 339 && l + 21 != 359 && l + 21 != 379 && l + 21 != 399) {
                                            if (tlacitko(buttonList.get(l + 42)).equals("X") && l + 42 != 19 && l + 42 != 39 && l + 42 != 59 && l + 42 != 79 && l + 42 != 99 && l + 42 != 119 && l + 42 != 139 && l + 42 != 159 && l + 42 != 179 && l + 42 != 199 && l + 42 != 219 && l + 42 != 239 && l + 42 != 259 && l + 42 != 279 && l + 42 != 299 && l + 42 != 319 && l + 42 != 339 && l + 42 != 359 && l + 42 != 379 && l + 42 != 399) {
                                                if (tlacitko(buttonList.get(l + 63)).equals("X") && l + 63 != 19 && l + 63 != 39 && l + 63 != 59 && l + 63 != 79 && l + 63 != 99 && l + 63 != 119 && l + 63 != 139 && l + 63 != 159 && l + 63 != 179 && l + 63 != 199 && l + 63 != 219 && l + 63 != 239 && l + 63 != 259 && l + 63 != 279 && l + 63 != 299 && l + 63 != 319 && l + 63 != 339 && l + 63 != 359 && l + 63 != 379 && l + 63 != 399) {
                                                    if (tlacitko(buttonList.get(l + 84)).equals("X")) {
                                                        anim = 1;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(l)).equals("X") && l != 19 && l != 39 && l != 59 && l != 79 && l != 99 && l != 119 && l != 139 && l != 159 && l != 179 && l != 199 && l != 219 && l != 239 && l != 259 && l != 279 && l != 299 && l != 319 && l != 339 && l != 359 && l != 379 && l != 399) {
                                        if (tlacitko(buttonList.get(l - 19)).equals("X") && l - 19 != 19 && l - 19 != 39 && l - 19 != 59 && l - 19 != 79 && l - 19 != 99 && l - 19 != 119 && l - 19 != 139 && l - 19 != 159 && l - 19 != 179 && l - 19 != 199 && l - 19 != 219 && l - 19 != 239 && l - 19 != 259 && l - 19 != 279 && l - 19 != 299 && l - 19 != 319 && l - 19 != 339 && l - 19 != 359 && l - 19 != 379 && l - 19 != 399) {
                                            if (tlacitko(buttonList.get(l - 38)).equals("X") && l - 38 != 19 && l - 38 != 39 && l - 38 != 59 && l - 38 != 79 && l - 38 != 99 && l - 38 != 119 && l - 38 != 139 && l - 38 != 159 && l - 38 != 179 && l - 38 != 199 && l - 38 != 219 && l - 38 != 239 && l - 38 != 259 && l - 38 != 279 && l - 38 != 299 && l - 38 != 319 && l - 38 != 339 && l - 38 != 359 && l - 38 != 379 && l - 38 != 399) {
                                                if (tlacitko(buttonList.get(l - 57)).equals("X") && l - 57 != 19 && l - 57 != 39 && l - 57 != 59 && l - 57 != 79 && l - 57 != 99 && l - 57 != 119 && l - 57 != 139 && l - 57 != 159 && l - 57 != 179 && l - 57 != 199 && l - 57 != 219 && l - 57 != 239 && l - 57 != 259 && l - 57 != 279 && l - 57 != 299 && l - 57 != 319 && l - 57 != 339 && l - 57 != 359 && l - 57 != 379 && l - 57 != 399) {
                                                    if (tlacitko(buttonList.get(l - 76)).equals("X")) {
                                                        anim = 1;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(l)).equals("O")) {
                                        if (tlacitko(buttonList.get(l + 20)).equals("O")) {
                                            if (tlacitko(buttonList.get(l + 40)).equals("O")) {
                                                if (tlacitko(buttonList.get(l + 60)).equals("O")) {
                                                    if (tlacitko(buttonList.get(l + 80)).equals("O")) {
                                                        anim = 2;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(l)).equals("O") && l != 19 && l != 39 && l != 59 && l != 79 && l != 99 && l != 119 && l != 139 && l != 159 && l != 179 && l != 199 && l != 219 && l != 239 && l != 259 && l != 279 && l != 299 && l != 319 && l != 339 && l != 359 && l != 379 && l != 399) {
                                        if (tlacitko(buttonList.get(l + 1)).equals("O") && l + 1 != 19 && l + 1 != 39 && l + 1 != 59 && l + 1 != 79 && l + 1 != 99 && l + 1 != 119 && l + 1 != 139 && l + 1 != 159 && l + 1 != 179 && l + 1 != 199 && l + 1 != 219 && l + 1 != 239 && l + 1 != 259 && l + 1 != 279 && l + 1 != 299 && l + 1 != 319 && l + 1 != 339 && l + 1 != 359 && l + 1 != 379 && l + 1 != 399) {
                                            if (tlacitko(buttonList.get(l + 2)).equals("O") && l + 2 != 19 && l + 2 != 39 && l + 2 != 59 && l + 2 != 79 && l + 2 != 99 && l + 2 != 119 && l + 2 != 139 && l + 2 != 159 && l + 2 != 179 && l + 2 != 199 && l + 2 != 219 && l + 2 != 239 && l + 2 != 259 && l + 2 != 279 && l + 2 != 299 && l + 2 != 319 && l + 2 != 339 && l + 2 != 359 && l + 2 != 379 && l + 2 != 399) {
                                                if (tlacitko(buttonList.get(l + 3)).equals("O") && l + 3 != 19 && l + 3 != 39 && l + 3 != 59 && l + 3 != 79 && l + 3 != 99 && l + 3 != 119 && l + 3 != 139 && l + 3 != 159 && l + 3 != 179 && l + 3 != 199 && l + 3 != 219 && l + 3 != 239 && l + 3 != 259 && l + 3 != 279 && l + 3 != 299 && l + 3 != 319 && l + 3 != 339 && l + 3 != 359 && l + 3 != 379 && l + 3 != 399) {
                                                    if (tlacitko(buttonList.get(l + 4)).equals("O")) {
                                                        anim = 2;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(l)).equals("O") && l != 19 && l != 39 && l != 59 && l != 79 && l != 99 && l != 119 && l != 139 && l != 159 && l != 179 && l != 199 && l != 219 && l != 239 && l != 259 && l != 279 && l != 299 && l != 319 && l != 339 && l != 359 && l != 379 && l != 399) {
                                        if (tlacitko(buttonList.get(l + 21)).equals("O") && l + 21 != 19 && l + 21 != 39 && l + 21 != 59 && l + 21 != 79 && l + 21 != 99 && l + 21 != 119 && l + 21 != 139 && l + 21 != 159 && l + 21 != 179 && l + 21 != 199 && l + 21 != 219 && l + 21 != 239 && l + 21 != 259 && l + 21 != 279 && l + 21 != 299 && l + 21 != 319 && l + 21 != 339 && l + 21 != 359 && l + 21 != 379 && l + 21 != 399) {
                                            if (tlacitko(buttonList.get(l + 42)).equals("O") && l + 42 != 19 && l + 42 != 39 && l + 42 != 59 && l + 42 != 79 && l + 42 != 99 && l + 42 != 119 && l + 42 != 139 && l + 42 != 159 && l + 42 != 179 && l + 42 != 199 && l + 42 != 219 && l + 42 != 239 && l + 42 != 259 && l + 42 != 279 && l + 42 != 299 && l + 42 != 319 && l + 42 != 339 && l + 42 != 359 && l + 42 != 379 && l + 42 != 399) {
                                                if (tlacitko(buttonList.get(l + 63)).equals("O") && l + 63 != 19 && l + 63 != 39 && l + 63 != 59 && l + 63 != 79 && l + 63 != 99 && l + 63 != 119 && l + 63 != 139 && l + 63 != 159 && l + 63 != 179 && l + 63 != 199 && l + 63 != 219 && l + 63 != 239 && l + 63 != 259 && l + 63 != 279 && l + 63 != 299 && l + 63 != 319 && l + 63 != 339 && l + 63 != 359 && l + 63 != 379 && l + 63 != 399) {
                                                    if (tlacitko(buttonList.get(l + 84)).equals("O")) {
                                                        anim = 2;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                                try {
                                    if (tlacitko(buttonList.get(l)).equals("O") && l != 19 && l != 39 && l != 59 && l != 79 && l != 99 && l != 119 && l != 139 && l != 159 && l != 179 && l != 199 && l != 219 && l != 239 && l != 259 && l != 279 && l != 299 && l != 319 && l != 339 && l != 359 && l != 379 && l != 399) {
                                        if (tlacitko(buttonList.get(l - 19)).equals("O") && l - 19 != 19 && l - 19 != 39 && l - 19 != 59 && l - 19 != 79 && l - 19 != 99 && l - 19 != 119 && l - 19 != 139 && l - 19 != 159 && l - 19 != 179 && l - 19 != 199 && l - 19 != 219 && l - 19 != 239 && l - 19 != 259 && l - 19 != 279 && l - 19 != 299 && l - 19 != 319 && l - 19 != 339 && l - 19 != 359 && l - 19 != 379 && l - 19 != 399) {
                                            if (tlacitko(buttonList.get(l - 38)).equals("O") && l - 38 != 19 && l - 38 != 39 && l - 38 != 59 && l - 38 != 79 && l - 38 != 99 && l - 38 != 119 && l - 38 != 139 && l - 38 != 159 && l - 38 != 179 && l - 38 != 199 && l - 38 != 219 && l - 38 != 239 && l - 38 != 259 && l - 38 != 279 && l - 38 != 299 && l - 38 != 319 && l - 38 != 339 && l - 38 != 359 && l - 38 != 379 && l - 38 != 399) {
                                                if (tlacitko(buttonList.get(l - 57)).equals("O") && l - 57 != 19 && l - 57 != 39 && l - 57 != 59 && l - 57 != 79 && l - 57 != 99 && l - 57 != 119 && l - 57 != 139 && l - 57 != 159 && l - 57 != 179 && l - 57 != 199 && l - 57 != 219 && l - 57 != 239 && l - 57 != 259 && l - 57 != 279 && l - 57 != 299 && l - 57 != 319 && l - 57 != 339 && l - 57 != 359 && l - 57 != 379 && l - 57 != 399) {
                                                    if (tlacitko(buttonList.get(l - 76)).equals("O")) {
                                                        anim = 2;
                                                        animCount();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                }
                            }
                        }
                    }
                });
                but.setMinWidth(26);
                panel.add(but, j, i);
            }
        }

        for (Node currentNode
                : panel.getChildren()) {
            if (currentNode instanceof Tlacitko) {
                buttonList.add((Tlacitko) currentNode);
            }
        }

        VBox root = new VBox();

        root.getChildren().add(btn);
        root.getChildren().add(panel);

        Scene scene = new Scene(root, 520, 525);

        primaryStage.setScene(scene);

        primaryStage.show();
        
        buttonList.get(Integer.parseInt(bf.readLine())).setText("O");
        serverNarade = true;

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        animCount();
                    }
                };

                while (true) {
                    try {
                        Thread.sleep(wait);
                    } catch (InterruptedException ex) {
                    }
                    Platform.runLater(updater);
                }
            }

        });

        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void start(Stage primaryStage) throws InterruptedException, IOException {
        Boolean selected = true;
        HBox men = new HBox();
        TextField ip = new TextField();
        ip.setPromptText("Zadejte IP adresu serveru");
        Button server = new Button("Hostovat Hru");
        server.setOnAction((ActionEvent event) -> {
            try {
                server(primaryStage);

            } catch (InterruptedException ex) {
                Logger.getLogger(Primary.class
                        .getName()).log(Level.SEVERE, null, ex);

            } catch (IOException ex) {
                Logger.getLogger(Primary.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        });

        Button client = new Button("Připojit se do hry");
        client.setOnAction((ActionEvent event) -> {
            try {
                client(primaryStage, ip.getText());

            } catch (InterruptedException ex) {
                Logger.getLogger(Primary.class.getName()).log(Level.SEVERE, null, ex);

            } catch (IOException ex) {
                Logger.getLogger(Primary.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Label localIp = new Label("Vaše IP: " + Inet4Address.getLocalHost().getHostAddress());
        localIp.setMinWidth(200);
        localIp.setMinHeight(25);
        localIp.setAlignment(Pos.CENTER);
        men.getChildren().add(localIp);
        men.getChildren().add(server);
        men.getChildren().add(ip);
        men.getChildren().add(client);
        Scene menu = new Scene(men);
        primaryStage.setTitle("Piškvorky!");
        primaryStage.setScene(menu);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
