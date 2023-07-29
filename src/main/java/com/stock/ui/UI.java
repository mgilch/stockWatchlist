package com.stock.ui;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;

public class UI {
    public Button addButton, removeButton, refreshButton;
    public TextField textField;
    Canvas canvas;
    GraphicsContext gc;

    public UI(Canvas canvas, AnchorPane anchorPane) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();

        int width = (int) anchorPane.getLayoutBounds().getWidth();
        int height = (int) anchorPane.getLayoutBounds().getHeight();

        addButton = new Button("Add Stock");
        removeButton = new Button("Remove Stock");
        refreshButton = new Button("Refresh");

        addButton.setOnAction(event -> System.out.println("Stock added"));
        removeButton.setOnAction(event -> System.out.println("Stock removed"));
        refreshButton.setOnAction(event -> System.out.println("Screen refreshed"));

        addButton.setTooltip(new Tooltip("Clicking this button will add a stock to your watchlist"));
        removeButton.setTooltip(new Tooltip("Clicking this button will remove a stock from your watchlist"));
        refreshButton.setTooltip(new Tooltip("Clicking this button will refresh the screen and fetch the most up to date stock data"));

        // Location of the Button
        AnchorPane.setTopAnchor(addButton, anchorPane.getHeight() / 2);
        AnchorPane.setLeftAnchor(addButton, 150.0);

        AnchorPane.setTopAnchor(removeButton, anchorPane.getHeight() / 2);
        AnchorPane.setLeftAnchor(removeButton, 250.0);

        AnchorPane.setTopAnchor(refreshButton, anchorPane.getHeight() / 2);
        AnchorPane.setLeftAnchor(refreshButton, 350.0);

        textField = new TextField("add stock with ticker");


        anchorPane.getChildren().addAll(addButton, refreshButton, removeButton, textField);
    }
}
