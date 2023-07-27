package com.stock.ui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainWindow extends Application {

    //public static final float WIDTH = 800;
    //public static final float HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Stock Watch List");
        primaryStage.setResizable(true);
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);

        //canvas  | graphics context to draw 2d
        var canvas = new Canvas(primaryStage.getWidth(), primaryStage.getHeight());
        Button addButton = new Button("Add Stock");
        Button removeButton = new Button("Remove Stock");
        Button refreshButton = new Button("Refresh");

        // Location of the Button
        addButton.setLayoutX(primaryStage.getWidth() / 4);
        addButton.setLayoutY(primaryStage.getHeight() / 2.25);

        removeButton.setLayoutX(primaryStage.getWidth() / 2.25);
        removeButton.setLayoutY(primaryStage.getHeight() / 2.25);

        refreshButton.setLayoutX(primaryStage.getWidth() / 1.5);
        refreshButton.setLayoutY(primaryStage.getHeight() / 2.25);

        //layout
        Group root = new Group();
        root.getChildren().add(canvas);
        root.getChildren().add(addButton);
        root.getChildren().add(removeButton);
        root.getChildren().add(refreshButton);


        //scene | top level container
        var rootScene = new Scene(root);
        primaryStage.setScene(rootScene);
        primaryStage.show();

        //Button Logic
        addButton.setOnAction(actionEvent -> InputHandler.addStock());
        removeButton.setOnAction(actionEvent -> InputHandler.removeStock());
        refreshButton.setOnAction(actionEvent -> InputHandler.refresh());

        //final var inputHandler = new InputHandler();
        //new StockWatchList(canvas, rootScene).run();

        //rootScene.setOnKeyTyped(inputHandler::handleKeyType);
        //rootScene.setOnKeyPressed(inputHandler::handleKeyType);
        //rootScene.setOnKeyReleased(inputHandler::handleKeyLift);
    }
}
