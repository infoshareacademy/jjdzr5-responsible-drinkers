package com.infoshareacademy;

import org.apache.log4j.Logger;

import java.util.List;

public class SortDrinks {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    private List<Drink> drinkList;

    public SortDrinks(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public List<Drink> getSortedByName() {
        return null;
    }

    public List<Drink> getSortedByID() {
        return null;
    }

    public List<Drink> getSortedByAlcohol() {
        return null;
    }
}
