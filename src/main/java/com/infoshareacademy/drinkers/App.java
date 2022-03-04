package com.infoshareacademy.drinkers;

import com.infoshareacademy.drinkers.domain.drink.Drink;
import com.infoshareacademy.drinkers.service.filtering.FilterElements;
import com.infoshareacademy.drinkers.service.filtering.FilterList;
import com.infoshareacademy.drinkers.service.gson.JsonReader;
import com.infoshareacademy.drinkers.service.printing.PrintElement;
import com.infoshareacademy.drinkers.service.printing.PrintElements;
import com.infoshareacademy.drinkers.service.properties.AppProperties;
import com.infoshareacademy.drinkers.service.properties.ApplicationProperties;
import com.infoshareacademy.drinkers.service.sorting.SortDrinks;
import com.infoshareacademy.drinkers.service.sorting.SortItems;

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
        PrintElements printElements = new PrintElements(new JsonReader().getDrinkList());
        printElements.print();

        Menu menu = new Menu();
        menu.run();
    }
}
