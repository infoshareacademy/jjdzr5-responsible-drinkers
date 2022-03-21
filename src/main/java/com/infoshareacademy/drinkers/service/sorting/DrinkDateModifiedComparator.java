package com.infoshareacademy.drinkers.service.sorting;

import com.infoshareacademy.drinkers.domain.drink.Drink;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

public class DrinkDateModifiedComparator implements Comparator<Drink> {
    @Override
    public int compare(Drink o1, Drink o2) {
        Optional<LocalDateTime> optional1 = Optional.ofNullable(o1.getDateModified());
        Optional<LocalDateTime> optional2 = Optional.ofNullable(o2.getDateModified());
        if (optional1.isPresent() && optional2.isPresent()) {
            return o1.getDateModified().compareTo(o2.getDateModified());
        } else {
            return 0;
        }
    }

    @Override
    public Comparator<Drink> reversed() {
        return Comparator.super.reversed();
    }
}
