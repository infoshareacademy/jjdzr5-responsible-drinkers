package com.infoshareacademy.drinkers.service.printing;

import com.infoshareacademy.drinkers.domain.drink.Drink;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.logging.Logger;

public class PrintElements {

    private static final Logger LOGGER = Logger.getLogger(PrintElements.class.getName());
    private static final int COL_1_WIDTH = 6;
    private static final int COL_2_WIDTH = 10;
    private static final int COL_3_WIDTH = 16;
    private static final int COL_4_WIDTH = 16;
    private static final int COL_5_WIDTH = 22;
    private static final int COL_6_WIDTH = 20;
    private static final int COL_7_WIDTH = 70;
    private static final int LINE_LENGTH = COL_1_WIDTH + COL_2_WIDTH + COL_3_WIDTH + COL_4_WIDTH + COL_5_WIDTH +
            COL_6_WIDTH + COL_7_WIDTH + 6;

    private final List<Drink> drinkList;

    public PrintElements(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public void print() {
        System.out.print(FrameHorizontal());
        System.out.print(Title());
        System.out.print(FrameHorizontal());
        int index = 0;
        for (Drink drink : drinkList) {
            printElement(drink, index);
            index++;
        }
        System.out.print(FrameHorizontal());

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
                .append(StringUtils.center(String.format("%d.", index + 1), COL_1_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format("%d", drink.getIdDrink()), COL_2_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format("%s", drink.getDrink()), COL_3_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format("%s", drink.getAlcoholic()), COL_4_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format("%s", drink.getGlass()), COL_5_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format(" %s", drink.getCategory()), COL_6_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.left(String.format(" %-70s", strIngredients), COL_7_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(System.lineSeparator());
        System.out.print(lineBuilder);
    }

    private String FrameHorizontal() {
        return "+" + "-".repeat(LINE_LENGTH) + "+" + System.lineSeparator();
    }

    private String Title() {
        StringBuilder titleBuilder = new StringBuilder();
        String colorLine = ConsoleColors.WHITE_BOLD;
        String colorLineReset = ConsoleColors.RESET;
        titleBuilder
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format("%s", "NO."), COL_1_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format("%s", "ID"), COL_2_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format("%s", "DRINK NAME"), COL_3_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format("%s", "ALCOHOLIC"), COL_4_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format("%s", "GLASS TYPE"), COL_5_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format(" %s", "DRINK CATEGORY"), COL_6_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format(" %s", "INGREDIENTS"), COL_7_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(System.lineSeparator());
        return titleBuilder.toString();
    }
}
