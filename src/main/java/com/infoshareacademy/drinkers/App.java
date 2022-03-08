package com.infoshareacademy.drinkers;

import com.infoshareacademy.drinkers.domain.drink.Drink;
import com.infoshareacademy.drinkers.service.filtering.FilterElements;
import com.infoshareacademy.drinkers.service.filtering.FilterList;
import com.infoshareacademy.drinkers.service.gson.JsonReader;
import com.infoshareacademy.drinkers.service.printing.PrintElement;
import com.infoshareacademy.drinkers.service.printing.PrintElements;
import com.infoshareacademy.drinkers.service.properties.ApplicationProperties;
import com.infoshareacademy.drinkers.service.searching.Search;
import com.infoshareacademy.drinkers.service.sorting.SortDrinks;
import com.infoshareacademy.drinkers.service.sorting.SortItems;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    public final static String DATE_PATTERN = ApplicationProperties.getDatePattern();
    public final static String SORT_DIRECTION = ApplicationProperties.getSortDirection();

    public static void main(String[] args) {

        LOGGER.log(Level.INFO, "Responsible drinkers");
        JsonReader jsonReader = new JsonReader();

        FilterList filterList = new FilterList(jsonReader.getDrinkList());
        try {
            LocalDateTime startDate = LocalDateTime.of(2016, 1, 1, 0, 0, 0);
            LocalDateTime stopDate = LocalDateTime.of(2017, 12, 31, 23, 59);

            List<Drink> drinkList = new ArrayList<>(filterList
                    .getFilteredByDate(startDate, stopDate)
                    .getFilteredByIngredient(FilterElements.JUICE)
                    .getFilteredByAlcoholic(false)
                    .getResults());

            List<Drink> searchDrink = new Search(drinkList)
                    .searchByName("al")
                    .searchByIngredients("vodka")
                    .getResults();
//            for (Drink drink : searchDrink) {
  //              PrintElement.print(drink);
  //          }

        } catch (Exception e) {
            e.printStackTrace();
        }

//        PrintElement.print(new JsonReader().getDrinkList().get(5));
//        PrintElements printElements = new PrintElements(new JsonReader().getDrinkList());
//        printElements.print();

        Menu menu = new Menu();
        menu.run();
    }
}
