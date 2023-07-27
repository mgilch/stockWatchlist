package com.stock.ui;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class InputHandler {

    public void handleKeyType(KeyEvent e) {
        System.out.println("key typed");
    }

    public void handleKeyPress(KeyEvent e) {
        System.out.println("key pressed");
    }

    public void handleKeyLift(KeyEvent e) {
        System.out.println("key lifted");
    }

    public void handleMouseMove(MouseEvent e) {

    }
}
