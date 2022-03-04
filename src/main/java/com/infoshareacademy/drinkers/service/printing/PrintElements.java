package com.infoshareacademy.drinkers.service.printing;

import com.infoshareacademy.drinkers.domain.drink.Drink;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class PrintElements {

    private final List<Drink> drinkList;

    public PrintElements(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public void print() {
        System.out.print(printFrameHorizontal());
        for (Drink drink : drinkList) {
            printElement(drink);
        }
        System.out.print(printFrameHorizontal());

    }

    private void printElement(Drink drink) {
        StringBuilder lineBuilder = new StringBuilder();
        lineBuilder
                .append("|")
                .append(StringUtils.center(String.format("%d ", drink.getIdDrink()),9))
                .append("|")
                .append(StringUtils.center(String.format("%s ", drink.getDrink()),16))
                .append("|")
                .append(StringUtils.center(String.format("%s ", drink.getAlcoholic()),16))
                .append("|")
                .append(StringUtils.center(String.format("%s ", drink.getGlass()),23))
                .append("|")
                .append(System.lineSeparator());
        System.out.print(lineBuilder);
    }

    private String printFrameHorizontal() {
        int width =85;
        StringBuilder result = new StringBuilder("+");
        for (int i=0;i<width;i++) {
                result.append("-");
        }
        result.append("+").append(System.lineSeparator());
        return result.toString();
    }
}
