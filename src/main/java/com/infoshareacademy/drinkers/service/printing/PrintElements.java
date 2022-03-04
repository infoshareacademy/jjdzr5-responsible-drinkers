package com.infoshareacademy.drinkers.service.printing;

import com.infoshareacademy.drinkers.domain.drink.Drink;

import java.util.List;

public class PrintElements {

    private final List<Drink> drinkList;

    public PrintElements(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public void print() {
        for (Drink drink : drinkList) {
            printElement(drink);
        }
    }

    private void printElement(Drink drink) {

    }
}
