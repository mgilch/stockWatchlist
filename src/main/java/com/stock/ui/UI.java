package com.stock.ui;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;

import java.awt.Rectangle;

public class UI {
    Canvas canvas;
    GraphicsContext gc;
    Button addButton, removeButton, refreshButton;

    public UI(Canvas canvas, Group root) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();

        int width = (int) root.getLayoutBounds().getWidth();
        int height = (int) root.getLayoutBounds().getHeight();


        addButton = new Button("Add Stock");
        removeButton = new Button("Remove Stock");
        refreshButton = new Button("Refresh");

        addButton.setOnAction(event -> System.out.println("add stock"));
        removeButton.setOnAction(event -> System.out.println("remove stock"));
        refreshButton.setOnAction(event -> System.out.println("refresh  stock"));

        refreshButton.setTooltip(new Tooltip("hello"));

        // Location of the Button
        addButton.setLayoutX(width / 4);
        addButton.setLayoutY(height / 2.25);

        removeButton.setLayoutX(width / 2.25);
        removeButton.setLayoutY(height / 2.25);

        refreshButton.setLayoutX(width / 1.5);
        refreshButton.setLayoutY(height / 2.25);

        root.getChildren().addAll(addButton, refreshButton, removeButton);
    }
}
