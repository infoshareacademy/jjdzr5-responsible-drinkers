package com.infoshareacademy;

import java.util.Comparator;

public class DrinkAlcoholicComparator implements Comparator<Drink> {
    @Override
    public int compare(Drink o1, Drink o2) {
        return o1.getAlcoholic().compareTo(o2.getAlcoholic());
    }

    @Override
    public Comparator<Drink> reversed() {
        return Comparator.super.reversed();
    }
}