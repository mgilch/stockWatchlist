package com.stock;

import com.stock.ui.UI;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;

public final class StockWatchList {
    UI ui;

    Thread worker = new Thread();
    public StockWatchList(Canvas canvas, Group root) {
        ui = new UI(canvas, root);
    }

    public void run() {

        System.out.println("Hello Stock Market");
    }
}
