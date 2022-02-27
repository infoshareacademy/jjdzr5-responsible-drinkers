package com.infoshareacademy.drinkers.service.filtering;

import com.infoshareacademy.drinkers.domain.drink.Drink;

import java.util.Comparator;

public class DrinkIDComparator implements Comparator<Drink> {
    @Override
    public int compare(Drink o1, Drink o2) {
        return o1.getIdDrink().compareTo(o2.getIdDrink());
    }

    @Override
    public Comparator<Drink> reversed() {
        return Comparator.super.reversed();
    }
}
