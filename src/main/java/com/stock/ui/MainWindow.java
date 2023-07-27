package com.stock.ui;

import com.stock.StockWatchList;
import com.stock.ui.InputHandler;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public final class MainWindow extends Application {

    public static final float WIDTH = 800;
    public static final float HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Stock Watch List");
        primaryStage.setResizable(true);
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);

        Group root = new Group();

        //canvas  | graphics context to draw 2d
        var canvas = new Canvas(primaryStage.getWidth(), primaryStage.getHeight());
        root.getChildren().add(canvas);

        //scene | top level container
        var rootScene = new Scene(root);
        primaryStage.setScene(rootScene);
        primaryStage.show();

        final var inputHandler = new InputHandler();
        new StockWatchList(canvas, root).run();

        rootScene.setOnKeyTyped(inputHandler::handleKeyType);
        rootScene.setOnKeyPressed(inputHandler::handleKeyType);
        rootScene.setOnKeyReleased(inputHandler::handleKeyLift);
        rootScene.setOnMouseMoved(inputHandler::handleMouseMove);
    }
}
