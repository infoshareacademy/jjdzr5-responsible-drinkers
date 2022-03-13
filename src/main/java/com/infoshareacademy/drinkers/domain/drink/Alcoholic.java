package com.infoshareacademy.drinkers.domain.drink;

public enum Alcoholic {
    ALCOHOLIC("Alcoholic"),
    NON_ALCOHOLIC("Non alcoholic");

    private final String name;

    Alcoholic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
