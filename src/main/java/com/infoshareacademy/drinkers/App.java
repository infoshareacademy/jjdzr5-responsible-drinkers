package com.infoshareacademy.drinkers;

import com.infoshareacademy.drinkers.domain.drink.Drink;
import com.infoshareacademy.drinkers.service.filtering.FilterElements;
import com.infoshareacademy.drinkers.service.filtering.FilterList;
import com.infoshareacademy.drinkers.service.gson.JsonReader;
import com.infoshareacademy.drinkers.service.printing.PrintElement;
import com.infoshareacademy.drinkers.service.properties.AppProperties;
import com.infoshareacademy.drinkers.service.properties.ApplicationProperties;
import com.infoshareacademy.drinkers.service.sorting.SortDrinks;
import com.infoshareacademy.drinkers.service.sorting.SortItems;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        LOGGER.log(Level.INFO, "Responsible drinkers");
        JsonReader jsonReader = new JsonReader();

        FilterList filterList = new FilterList(jsonReader.getDrinkList());
        String start = "1/1/2016";
        String stop = "31/12/2016";
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date startDate, stopDate;

            startDate = dateFormat.parse(start);
            stopDate = dateFormat.parse(stop);

            List<Drink> drinkList = new ArrayList<>(filterList
                    .getFilteredByDate(startDate, stopDate)
//                    .getFilteredByIngredient(FilterElements.JUICE)
                    .getFilteredByAlcoholic(true)
                    .run());
            filterList.printResults(drinkList);

        } catch (ParseException e) {
            e.printStackTrace();
        }


        System.out.println(ApplicationProperties.getDatePattern());
        System.out.println(ApplicationProperties.getSortDirection());
        new AppProperties().printProperties();
        System.out.println(new SortDrinks(new JsonReader().getDrinkList()).getSortedList(SortItems.ID, true));

        PrintElement.print(new JsonReader().getDrinkList().get(5));
        Menu menu = new Menu();
//        menu.run();
    }
}
