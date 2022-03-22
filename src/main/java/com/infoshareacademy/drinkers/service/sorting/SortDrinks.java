package com.infoshareacademy.drinkers.service.sorting;

import com.infoshareacademy.drinkers.domain.drink.Drink;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.infoshareacademy.drinkers.App.SORT_DIRECTION;

public class SortDrinks {

    private static final Logger LOGGER = Logger.getLogger(SortDrinks.class.getName());

    private final List<Drink> drinkList;

    public SortDrinks(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    private List<Drink> getSortedByName(boolean isASC) {
        if (isASC) {
            return drinkList.stream()
                    .sorted(new DrinkNameComparator())
                    .toList();
        }
        return drinkList.stream()
                .sorted(new DrinkNameComparator().reversed())
                .toList();
    }

    private List<Drink> getSortedByID(boolean isASC) {
        if (isASC) {
            return drinkList.stream()
                    .sorted(new DrinkIDComparator())
                    .toList();
        }
        return drinkList.stream()
                .sorted(new DrinkIDComparator().reversed())
                .toList();
    }

    private List<Drink> getSortedByAlcoholic(boolean isASC) {
        if (isASC) {
            return drinkList.stream()
                    .sorted(new DrinkAlcoholicComparator())
                    .toList();
        }
        return drinkList.stream()
                .sorted(new DrinkAlcoholicComparator().reversed())
                .toList();
    }

    private List<Drink> getSortedByDateModified(boolean isASC) {
        if (isASC) {
            return drinkList.stream()
                    .sorted(Comparator.comparing(Drink::getDateModified, Comparator.nullsLast(Comparator.naturalOrder())))
                    .toList();
        }
        return drinkList.stream()
                .sorted(Comparator.comparing(Drink::getDateModified, Comparator.nullsLast(Comparator.reverseOrder())))
                .toList();
    }

    public List<Drink> getSortedList(SortItems item) {
        List<Drink> result = new ArrayList<>();
        boolean isASC = true;
        if (SORT_DIRECTION.equalsIgnoreCase("DESC")) {
            isASC = false;
        }

        switch (item) {
            case ID: {
                result = getSortedByID(isASC);
                break;
            }
            case ALCOHOLIC: {
                result = getSortedByAlcoholic(isASC);
                break;
            }
            case DRINK_NAME: {
                result = getSortedByName(isASC);
                break;
            }
            case DATE: {
                result = getSortedByDateModified(isASC);
                break;
            }
        }
        return result;
    }
}
