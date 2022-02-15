package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.INFO,"Responsible drinkers");
        JsonReader jsonReader = new JsonReader();
        FilterList filterList = new FilterList(jsonReader.getDrinkList());
        List<Drink> drinkList = new ArrayList<>(filterList.getDrinkListFiltered(FilterElements.JUICE,FilterElements.NON_ALCOHOL));
        filterList.printResults(drinkList);
    //    Menu menu = new Menu();
    //    menu.run();
    }
}
