package com.infoshareacademy.drinkers.service.printing;

import com.infoshareacademy.drinkers.domain.drink.Drink;
import com.infoshareacademy.drinkers.domain.drink.Instruction;
import com.infoshareacademy.drinkers.domain.drink.InstructionsLanguage;

import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.infoshareacademy.drinkers.App.DATE_PATTERN;

public class PrintElement {

    private static final Logger LOGGER = Logger.getLogger(PrintElement.class.getName());
    final static int FRAME_LENGTH = 113;
    final static int MAX_LINE_LENGTH = 75;

    public static void print(Drink drink) {
        if (drink != null) {
            printLine();
            System.out.print(ConsoleColors.BLUE_BOLD + "\tID: " + ConsoleColors.YELLOW + drink.getIdDrink() + "\t");
            System.out.print(ConsoleColors.BLUE_BOLD + "Name: " + ConsoleColors.YELLOW + drink.getDrink() + "\t");
            System.out.print(ConsoleColors.BLUE_BOLD + "Alcoholic: " + ConsoleColors.YELLOW + isAlcoholic(drink) + "\t");
            System.out.print(ConsoleColors.BLUE_BOLD + "Glass: " + ConsoleColors.YELLOW + drink.getGlass() + "\t");
            System.out.println(ConsoleColors.BLUE_BOLD + "Category: " + ConsoleColors.YELLOW + drink.getCategory());
            System.out.println(ConsoleColors.BLUE_BOLD + "\tIngredients: " + ConsoleColors.YELLOW + drink.getStringIntredientrs() + " ");
            System.out.println(ConsoleColors.BLUE_BOLD + "\tInstructions: " + ConsoleColors.YELLOW + printInstructions(drink, InstructionsLanguage.FR));
            System.out.println(ConsoleColors.BLUE_BOLD + "\tDate modified: " + ConsoleColors.YELLOW + drink.getDateModified().format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
            printLine();
        } else {
            LOGGER.log(Level.INFO, "Nothing to print!");
        }
    }

    private static String isAlcoholic(Drink drink) {
        if (drink.getAlcoholic().equalsIgnoreCase("alcoholic")) {
            return "YES";
        }  else if (drink.getAlcoholic().equalsIgnoreCase("non alcoholic")) {
            return "NO";
        } else {
            return null;
        }
    }

    private static String ingredients(Drink drink) {
        String result = "";
        if (drink.getIngredient1() != null) {
            result = result + drink.getIngredient1();
        }
        if (drink.getIngredient2() != null) {
            result = result + ", " + drink.getIngredient2();
        }
        if (drink.getIngredient3() != null) {
            result = result + ", " + drink.getIngredient3();
        }
        if (drink.getIngredient4() != null) {
            result = result + ", " + drink.getIngredient4();
        }
        if (drink.getIngredient5() != null) {
            result = result + ", " + drink.getIngredient5();
        }
        if (drink.getIngredient6() != null) {
            result = result + ", " + drink.getIngredient6();
        }
        if (drink.getIngredient7() != null) {
            result = result + ", " + drink.getIngredient7();
        }
        if (drink.getIngredient8() != null) {
            result = result + ", " + drink.getIngredient8();
        }
        if (drink.getIngredient9() != null) {
            result = result + ", " + drink.getIngredient9();
        }
        if (drink.getIngredient10() != null) {
            result = result + ", " + drink.getIngredient10();
        }
        if (drink.getIngredient11() != null) {
            result = result + ", " + drink.getIngredient11();
        }
        if (drink.getIngredient12() != null) {
            result = result + ", " + drink.getIngredient12();
        }
        if (drink.getIngredient13() != null) {
            result = result + ", " + drink.getIngredient13();
        }
        if (drink.getIngredient14() != null) {
            result = result + ", " + drink.getIngredient14();
        }
        if (drink.getIngredient15() != null) {
            result = result + ", " + drink.getIngredient15();
        }
        return result;
    }

    private static String printInstructions(Drink drink, InstructionsLanguage instructionsLanguage) {
        String result = "-";
        for (Instruction instruction : drink.getInstructionList()) {
            if (instruction.getInstructionsLanguage() != null &&
                    instruction.getInstructionsLanguage() == instructionsLanguage) {
                result = instruction.getInstruction();
            }
        }
        result = wrapLine(result);
        return result;
    }

    private static void printLine() {
        String line = "+" + "-".repeat(Math.max(0, FRAME_LENGTH)) + "+";
        System.out.println(ConsoleColors.RED + line + ConsoleColors.RESET);
    }


    private static String wrapLine(String line) {
        StringBuilder result = new StringBuilder();
        int counter = 0;
        if (line.length() > 0) {
            String[] strings = line.split(" ");
            for (String s : strings) {
                counter += s.length();
                if (counter < MAX_LINE_LENGTH) {
                    result.append(s).append(" ");
                } else {
                    result.append(System.lineSeparator())
                            .append("\t")
                            .append(s)
                            .append(" ");
                    counter = 0;
                }
            }
        }
        return result.toString();
    }
}
