package com.infoshareacademy.drinkers;

import java.util.Comparator;

public class DrinkNameComparator implements Comparator<Drink>   {
    @Override
    public int compare(Drink o1, Drink o2) {
        return o1.getDrink().compareTo(o2.getDrink());
    }

    @Override
    public Comparator<Drink> reversed() {
        return Comparator.super.reversed();
    }
}
