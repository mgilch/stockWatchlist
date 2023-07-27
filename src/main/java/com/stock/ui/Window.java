package com.stock.ui;

import com.stock.StockWatchList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class Window extends Application {

    public static final float WIDTH = 800;
    public static final float HEIGHT = 800;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Stock Watch List");
        stage.setResizable(true);
        stage.setWidth(800);
        stage.setHeight(600);

        //canvas  | graphics context to draw 2d
        var canvas = new Canvas(stage.getWidth(), stage.getHeight());
        //layout
        Group root = new Group();
        root.getChildren().add(canvas);

        //scene | top level container
        var rootScene = new Scene(root);
        stage.setScene(rootScene);
        stage.show();


        final var inputHandler = new InputHandler();
        new StockWatchList(canvas, rootScene).run();

        rootScene.setOnKeyTyped(inputHandler::handleKeyType);
        rootScene.setOnKeyPressed(inputHandler::handleKeyType);
        rootScene.setOnKeyReleased(inputHandler::handleKeyLift);
    }
}
