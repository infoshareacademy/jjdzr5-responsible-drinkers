package com.infoshareacademy.drinkers;

import com.infoshareacademy.drinkers.service.menu.BetterMenu;
import com.infoshareacademy.drinkers.service.properties.ApplicationProperties;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    public final static String DATE_PATTERN = ApplicationProperties.getDatePattern();
    public final static String SORT_DIRECTION = ApplicationProperties.getSortDirection();

    public static void main(String[] args) {

        LOGGER.log(Level.INFO, "Responsible drinkers");
        BetterMenu menu = new BetterMenu();
        menu.start();
    }
}
