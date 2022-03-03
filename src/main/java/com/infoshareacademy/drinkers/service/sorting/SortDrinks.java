package com.infoshareacademy.drinkers.service.sorting;

import com.infoshareacademy.drinkers.App;
import com.infoshareacademy.drinkers.domain.drink.Drink;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortDrinks {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    private final List<Drink> drinkList;

    public SortDrinks(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    private List<Drink> getSortedByName(boolean isASC) {
        if (isASC) {
            return drinkList.stream().sorted(new DrinkNameComparator()).collect(Collectors.toList());
        }
        return drinkList.stream().sorted(new DrinkNameComparator().reversed()).collect(Collectors.toList());
    }

    private List<Drink> getSortedByID(boolean isASC) {
        if (isASC) {
            return drinkList.stream().sorted(new DrinkIDComparator()).collect(Collectors.toList());
        }
        return drinkList.stream().sorted(new DrinkIDComparator().reversed()).collect(Collectors.toList());
    }

    private List<Drink> getSortedByAlcoholic(boolean isASC) {
        if (isASC) {
            return drinkList.stream().sorted(new DrinkAlcoholicComparator()).collect(Collectors.toList());
        }
        return drinkList.stream().sorted(new DrinkAlcoholicComparator().reversed()).collect(Collectors.toList());
    }

    private List<Drink> getSortedByDateModified(boolean isASC) {
        if (isASC) {
            return drinkList.stream().sorted(new DrinkDateModifiedComparator()).collect(Collectors.toList());
        }
        return drinkList.stream().sorted(new DrinkDateModifiedComparator().reversed()).collect(Collectors.toList());
    }

    public List<Drink> getSortedList(SortItems item, boolean isASC) {
        List<Drink> result = new ArrayList<>();

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
