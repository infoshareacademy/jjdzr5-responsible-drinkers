package com.infoshareacademy.drinkers.service.printing;

import com.infoshareacademy.drinkers.domain.drink.Drink;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.logging.Logger;

public class PrintElements {

    private static final Logger LOGGER = Logger.getLogger(PrintElements.class.getName());
    private static final int LINE_LENGTH = 145;

    private final List<Drink> drinkList;

    public PrintElements(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public void print() {
        System.out.print(printFrameHorizontal());
        int index = 0;
        for (Drink drink : drinkList) {
            printElement(drink, index);
            index++;
        }
        System.out.print(printFrameHorizontal());

    }

    private void printElement(Drink drink, int index) {

        String strIngredients = "";
        for (String s : drink.getIngredients()) {
            if (strIngredients.equals("")) {
                strIngredients = s;
            } else {
                strIngredients += ", " + s;
            }
        }
        String colorLine;
        String colorLineReset = ConsoleColors.RESET;
        if (index % 2 == 0) {
            colorLine = ConsoleColors.BLACK_BOLD + ConsoleColors.GREEN_BACKGROUND;
        } else {
            colorLine = ConsoleColors.RESET;
        }
        StringBuilder lineBuilder = new StringBuilder();
        lineBuilder
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format("%d.", index + 1), 6))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format("%d", drink.getIdDrink()), 10))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format("%s", drink.getDrink()), 16))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format("%s", drink.getAlcoholic()), 16))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format("%s", drink.getGlass()), 22))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.left(String.format(" %-70s", strIngredients), 70))
                .append(colorLineReset)
                .append("|")
                .append(System.lineSeparator());
        System.out.print(lineBuilder);
    }

    private String printFrameHorizontal() {
        return "+" + "-".repeat(LINE_LENGTH) + "+" + System.lineSeparator();

    }
}
