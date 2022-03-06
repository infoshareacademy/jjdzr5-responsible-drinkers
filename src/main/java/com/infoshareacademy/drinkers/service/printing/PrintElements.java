package com.infoshareacademy.drinkers.service.printing;

import com.infoshareacademy.drinkers.domain.drink.Drink;
import com.infoshareacademy.drinkers.service.properties.ApplicationProperties;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Logger;

import static com.infoshareacademy.drinkers.App.DATE_PATTERN;

public class PrintElements {

    private static final Logger LOGGER = Logger.getLogger(PrintElements.class.getName());


    private static final int COL_1_WIDTH = 6;
    private static final int COL_2_WIDTH = 10;
    private static final int COL_3_WIDTH = 16;
    private static final int COL_4_WIDTH = 16;
    private static final int COL_5_WIDTH = 22;
    private static final int COL_6_WIDTH = 20;
    private static final int COL_7_WIDTH = 70;
    private static final int COL_8_WIDTH = 18;
    private static final int LINE_LENGTH = COL_1_WIDTH + COL_2_WIDTH + COL_3_WIDTH + COL_4_WIDTH + COL_5_WIDTH +
            COL_6_WIDTH + COL_7_WIDTH + COL_8_WIDTH + 7;
    private static final String COL_1_TITLE = "NO";
    private static final String COL_2_TITLE = "ID";
    private static final String COL_3_TITLE = "DRINK NAME";
    private static final String COL_4_TITLE = "ALCOHOLIC";
    private static final String COL_5_TITLE = "GLASS TYPE";
    private static final String COL_6_TITLE = "DRINK CATEGORY";
    private static final String COL_7_TITLE = "INGREDIENTS";
    private static final String COL_8_TITLE = "DATE MODIFIED";

    private final List<Drink> drinkList;

    public PrintElements(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public void print() {
        printFrameHorizontal();
        printTitle();
        printFrameHorizontal();
        int index = 0;
        for (Drink drink : drinkList) {
            printElement(drink, index);
            index++;
        }
        printFrameHorizontal();

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
                .append(colorLine)
                .append(StringUtils.center(String.format(" %s", new SimpleDateFormat(DATE_PATTERN).format(drink.getDateModified())), COL_8_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(System.lineSeparator());
        System.out.print(lineBuilder);
    }

    private void printFrameHorizontal() {
        System.out.print("+" + "-".repeat(LINE_LENGTH) + "+" + System.lineSeparator());
    }

    private void printTitle() {
        StringBuilder titleBuilder = new StringBuilder();
        String colorLine = ConsoleColors.WHITE_BOLD;
        String colorLineReset = ConsoleColors.RESET;
        titleBuilder
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format("%s", COL_1_TITLE), COL_1_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format("%s", COL_2_TITLE), COL_2_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format("%s", COL_3_TITLE), COL_3_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format("%s", COL_4_TITLE), COL_4_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format("%s", COL_5_TITLE), COL_5_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format(" %s", COL_6_TITLE), COL_6_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format(" %s", COL_7_TITLE), COL_7_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(colorLine)
                .append(StringUtils.center(String.format(" %s", COL_8_TITLE), COL_8_WIDTH))
                .append(colorLineReset)
                .append("|")
                .append(System.lineSeparator());
        System.out.print(titleBuilder);
    }
}
