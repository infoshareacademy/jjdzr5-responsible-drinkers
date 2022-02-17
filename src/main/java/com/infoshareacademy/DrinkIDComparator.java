package com.infoshareacademy;

import java.util.Comparator;

public class DrinkIDComparator implements Comparator<Drink> {
    @Override
    public int compare(Drink o1, Drink o2) {
        return 0;
    }

    @Override
    public Comparator<Drink> reversed() {
        return Comparator.super.reversed();
    }
}
