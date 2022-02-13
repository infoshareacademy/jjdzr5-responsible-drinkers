package com.infoshareacademy;


import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.INFO,"Responsible drinkers");
        Menu menu = new Menu();
        menu.run();
    }
}
