package com.stock;

import com.stock.stocks.Storage;
import com.stock.ui.UI;
import com.stock.util.datatypes.Ticker;
import com.stock.util.enums.Region;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;

public final class StockWatchList {
    UI ui;
    Storage storage = new Storage();
    public StockWatchList(Canvas canvas, Group root) {
        ui = new UI(canvas, root);
        ui.addButton.setOnAction(event -> {
           storage.addStock(new Ticker(ui.textField.getText()));
        });
    }

    public void run() {

    }
}
