package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);


    public static void main(String[] args) {
        LOGGER.debug("Responsible drinkers");
        Menu menu = new Menu();
        menu.run();
    }
}
