package com.infoshareacademy;


import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "Responsible drinkers");
        System.out.println(ApplicationProperties.getDatePattern());
        System.out.println(ApplicationProperties.getSortDirection());
        new AppProperties().printProperties();
        System.out.println(new SortDrinks(new JsonReader().getDrinkList()).getSortedList(SortItems.ID, true));
        //   Menu menu = new Menu();
        //   menu.run();
    }
}
