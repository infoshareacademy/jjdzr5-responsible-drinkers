package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

      LOGGER.log(Level.INFO, "Responsible drinkers");
        JsonReader jsonReader = new JsonReader();
        FilterList filterList = new FilterList(jsonReader.getDrinkList());
        List<Drink> drinkList = new ArrayList<>(filterList.getDrinkListFiltered(FilterElements.JUICE, FilterElements.ALCOHOL));
        filterList.printResults(drinkList);

        System.out.println(ApplicationProperties.getDatePattern());
        System.out.println(ApplicationProperties.getSortDirection());
        new AppProperties().printProperties();
        System.out.println(new SortDrinks(new JsonReader().getDrinkList()).getSortedList(SortItems.ID, true));

        PrintElement.print(new JsonReader().getDrinkList().get(5));
        Menu menu = new Menu();
        menu.run();
    }
}
