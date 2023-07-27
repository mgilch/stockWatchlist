package com.stock.util.datatypes;

import com.stock.api.APIHelper;

public class Stock {
    String name;
    Ticker ticker;
    StockHistory history;
    StockDetails details;

    Stock(String fullName) {
        this.name = fullName;
    }

    public Stock(Ticker ticker) {
        this.ticker = ticker;
        this.name = APIHelper.getFullName(ticker);
    }

    public StockHistory getHistory() {
        return history;
    }
}
