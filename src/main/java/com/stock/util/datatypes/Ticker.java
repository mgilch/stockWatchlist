package com.stock.util.datatypes;

public class Ticker {

    final String ticker;

    Ticker(String name) {
        this.ticker = name;
    }

    @Override
    public String toString() {
        return ticker;
    }
}
