package com.infoshareacademy.drinkers.service.searching;

import com.infoshareacademy.drinkers.domain.drink.Drink;

import java.util.ArrayList;
import java.util.List;

public class Search {

    private List<Drink> drinkList;

    public Search(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public List<Drink> searchByName(String textToFind) {
        textToFind = textToFind.toLowerCase();
        List<Drink> result = new ArrayList<>();
        for (Drink drink : drinkList) {
             if (drink.getDrink().toLowerCase().contains(textToFind)) {
                 result.add(drink);
             }
        }
        return result;
    }
}
