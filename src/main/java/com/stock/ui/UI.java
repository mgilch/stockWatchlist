package com.stock.ui;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

public class UI {
    public Button addButton, removeButton, refreshButton;
    public TextField textField;
    Canvas canvas;
    GraphicsContext gc;

    public UI(Canvas canvas, Group root) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();

        int width = (int) root.getLayoutBounds().getWidth();
        int height = (int) root.getLayoutBounds().getHeight();


        addButton = new Button("Add Stock");
        removeButton = new Button("Remove Stock");
        refreshButton = new Button("Refresh");


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


        textField = new TextField("add stock with ticker");


        root.getChildren().addAll(addButton, refreshButton, removeButton, textField);
    }
}
