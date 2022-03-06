package com.infoshareacademy.drinkers.service.searching;

import com.infoshareacademy.drinkers.App;
import com.infoshareacademy.drinkers.domain.drink.Drink;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Search {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    private final List<Drink> drinkList;
    private final List<Drink> resultList = new ArrayList<>();

    public Search(List<Drink> drinkList) {
        if (!drinkList.isEmpty()) {
            this.drinkList = drinkList;
        } else {
            LOGGER.log(Level.INFO, "Collection is empty!");
            this.drinkList = new ArrayList<>();
        }
    }

    public Search searchByName(String textToFind) {
        textToFind = textToFind.toLowerCase();
        for (Drink drink : drinkList) {
            if (drink.getDrink().toLowerCase().contains(textToFind)) {
                resultList.add(drink);
            }
        }
        return this;
    }

    public Search searchByIngredients(String textToFind) {
        textToFind = textToFind.toLowerCase();
        for (Drink drink : drinkList) {
            if (drink.getIngredient1() != null && drink.getIngredient1().toLowerCase().contains(textToFind) ||
                    drink.getIngredient2() != null && drink.getIngredient2().toLowerCase().contains(textToFind) ||
                    drink.getIngredient3() != null && drink.getIngredient3().toLowerCase().contains(textToFind) ||
                    drink.getIngredient4() != null && drink.getIngredient4().toLowerCase().contains(textToFind) ||
                    drink.getIngredient5() != null && drink.getIngredient5().toLowerCase().contains(textToFind) ||
                    drink.getIngredient6() != null && drink.getIngredient6().toLowerCase().contains(textToFind) ||
                    drink.getIngredient7() != null && drink.getIngredient7().toLowerCase().contains(textToFind) ||
                    drink.getIngredient8() != null && drink.getIngredient8().toLowerCase().contains(textToFind) ||
                    drink.getIngredient9() != null && drink.getIngredient9().toLowerCase().contains(textToFind) ||
                    drink.getIngredient10() != null && drink.getIngredient10().toLowerCase().contains(textToFind) ||
                    drink.getIngredient11() != null && drink.getIngredient11().toLowerCase().contains(textToFind) ||
                    drink.getIngredient12() != null && drink.getIngredient12().toLowerCase().contains(textToFind) ||
                    drink.getIngredient13() != null && drink.getIngredient13().toLowerCase().contains(textToFind) ||
                    drink.getIngredient14() != null && drink.getIngredient14().toLowerCase().contains(textToFind) ||
                    drink.getIngredient15() != null && drink.getIngredient15().toLowerCase().contains(textToFind)) {
                resultList.add(drink);
            }
        }
        return this;
    }

    public List<Drink> getResults() {
        return resultList;
    }
}
