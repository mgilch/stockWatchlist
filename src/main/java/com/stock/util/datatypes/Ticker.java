package com.stock.util.datatypes;

public class Ticker {

    final String ticker;

    public Ticker(String name) {
        this.ticker = name;
    }

    @Override
    public String toString() {
        return ticker;
    }
}
