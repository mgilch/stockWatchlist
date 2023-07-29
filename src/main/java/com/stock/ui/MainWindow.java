package com.stock.ui;

import com.stock.StockWatchList;
import com.stock.ui.InputHandler;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public final class MainWindow extends Application {

    public static final float WIDTH = 800;
    public static final float HEIGHT = 600;
    AnchorPane anchorPane = new AnchorPane();
    HBox hb = new HBox();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Stock Watch List");
        primaryStage.setResizable(true);
        hb.setAlignment(Pos.CENTER);

        Group root = new Group();

        //canvas  | graphics context to draw 2d
        var canvas = new Canvas(primaryStage.getWidth(), primaryStage.getHeight());
        anchorPane.getChildren().addAll(hb ,canvas);

        //scene | top level container
        var rootScene = new Scene(anchorPane, 800, 600);
        primaryStage.setScene(rootScene);
        primaryStage.show();

        final var inputHandler = new InputHandler();
        new StockWatchList(canvas, anchorPane).run();

        rootScene.setOnKeyTyped(inputHandler::handleKeyType);
        rootScene.setOnKeyPressed(inputHandler::handleKeyType);
        rootScene.setOnKeyReleased(inputHandler::handleKeyLift);
        rootScene.setOnMouseMoved(inputHandler::handleMouseMove);
    }
}
