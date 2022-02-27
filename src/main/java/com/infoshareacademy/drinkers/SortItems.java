package com.infoshareacademy.drinkers;

public enum SortItems {
    ID("ID"),
    DRINK_NAME("DrinkName"),
    ALCOHOLIC("Alcoholic");

    private final String name;

    SortItems(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
