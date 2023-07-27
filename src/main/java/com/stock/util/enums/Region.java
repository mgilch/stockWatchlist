package com.stock.util.enums;

public enum Region {
    United_States, Europe, Asia;


    public static Region getRegion(String name) {
        name = name.replace(" ", "_");
        return valueOf(name);
    }
}
