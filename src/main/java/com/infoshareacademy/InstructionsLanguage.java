package com.infoshareacademy;

public enum InstructionsLanguage {
    ES("ES"),
    DE("DE"),
    EN("EN"),
    FR("FR"),
    IT("IT"),
    ZH_HANS("ZH-HANS"),
    ZH_HANT("ZH-HANT");

    private final String name;

    InstructionsLanguage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
