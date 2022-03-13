package com.infoshareacademy.drinkers.service.sorting;

import java.util.Date;

public enum SortItems {
    ID("ID"),
    DRINK_NAME("DrinkName"),
    ALCOHOLIC("Alcoholic"),
    DATE("DateModified");

    private final String name;

    SortItems(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
