package com.infoshareacademy.drinkers.service.manage;

import com.infoshareacademy.drinkers.domain.drink.Drink;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DrinkManager {

    private static final Logger LOGGER = Logger.getLogger(DrinkManager.class.getName());

    private final List<Drink> drinkList;

    public DrinkManager(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public List<Drink> addDrinkToList(Drink newDrink) {
        drinkList.add(newDrink);
        return drinkList;
    }

    public List<Drink> removeDrink(int byIndex) {
        try {
            drinkList.remove(byIndex);
        } catch (IndexOutOfBoundsException e) {
            LOGGER.log(Level.INFO, "Index out of bounds. Can't remove drink");
        }
        return drinkList;
    }

    public List<Drink> removeDrink(Drink drink) {
        try {
            int drinkIndex = drinkList.indexOf(drink);
            removeDrink(drinkIndex);
        } catch (NullPointerException e) {
            LOGGER.log(Level.INFO, "Can't find drink. Can't remove drink");
        }
        return drinkList;
    }

    public List<Drink> modifyDrink(Drink drinkToModify, Drink drinkModified) {
        try {
            int drinkIndex = drinkList.indexOf(drinkToModify);
            removeDrink(drinkIndex);
            addDrinkToList(drinkModified);
        } catch (NullPointerException e) {
            LOGGER.log(Level.INFO, "Drink is null. Can't modify drink");
        }
        return drinkList;
    }


}