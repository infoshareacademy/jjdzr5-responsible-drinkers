package com.infoshareacademy.drinkers.service.sorting;

import com.infoshareacademy.drinkers.domain.drink.Drink;

import java.util.Comparator;

public class DrinkDateModifiedComparator implements Comparator<Drink> {
    @Override
    public int compare(Drink o1, Drink o2) {
        return o1.getDateModified().compareTo(o2.getDateModified());
    }

    @Override
    public Comparator<Drink> reversed() {
        return Comparator.super.reversed();
    }
}
