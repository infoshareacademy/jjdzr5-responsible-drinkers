package com.infoshareacademy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintElement {

    private static final Logger LOGGER = Logger.getLogger(PrintElement.class.getName());

    public static void print(Drink drink) {
        final int LINE_LENGTH = 113;
        if (drink != null) {
            printLine(LINE_LENGTH);
            System.out.print(ConsoleColors.BLUE_BOLD + "\tID: " + ConsoleColors.YELLOW + drink.getIdDrink() + ", ");
            System.out.print(ConsoleColors.BLUE_BOLD + "Name: " + ConsoleColors.YELLOW + drink.getDrink() + ", ");
            System.out.print(ConsoleColors.BLUE_BOLD + "Alcoholic: " + ConsoleColors.YELLOW + isAlcoholic(drink) + ", ");
            System.out.print(ConsoleColors.BLUE_BOLD + "Glass: " + ConsoleColors.YELLOW + drink.getGlass() + ", ");
            System.out.println(ConsoleColors.BLUE_BOLD + "Category: " + ConsoleColors.YELLOW + drink.getCategory());
            System.out.println(ConsoleColors.BLUE_BOLD + "\tIngredients: " + ConsoleColors.YELLOW + getIngredients(drink) + " ");
            System.out.println(ConsoleColors.BLUE_BOLD + "\tInstructions: " + ConsoleColors.YELLOW + printInstructions(drink, InstructionsLanguage.EN));
            printLine(LINE_LENGTH);
        } else {
            LOGGER.log(Level.INFO, "Nothing to print!");
        }
    }

    private static String isAlcoholic(Drink drink) {
        if (drink.getAlcoholic().equalsIgnoreCase("alcoholic")) {
            return "YES";
        } else {
            return "NO";
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
        switch (instructionsLanguage) {
            case DE -> {
                if (drink.getInstructionsDE() != null) {
                    return drink.getInstructionsDE();
                }
            }
            case EN -> {
                if (drink.getInstructions() != null) {
                    return drink.getInstructions();
                }
            }
            case ES -> {
                if (drink.getInstructionsES() != null) {
                    return drink.getInstructionsES();
                }
            }
            case FR -> {
                if (drink.getInstructionsFR() != null) {
                    return drink.getInstructionsFR();
                }
            }
            case IT -> {
                if (drink.getInstructionsIT() != null) {
                    return drink.getInstructionsIT();
                }
            }
            case ZH_HANS -> {
                if (drink.getInstructionsZH_HANS() != null) {
                    return drink.getInstructionsZH_HANS();
                }
            }
            case ZH_HANT -> {
                if (drink.getInstructionsZH_HANT() != null) {
                    return drink.getInstructionsZH_HANT();
                }
            }
        }
        return result;
    }

    private static void printLine(int width) {
        String line = "+";
        for (int i = 0; i < width; i++) {
            line = line + "-";
        }
        line = line + "+";
        System.out.println(ConsoleColors.RED + line + ConsoleColors.RESET);
    }

    private static String getIngredients(Drink drink) {
        Method[] methods = Drink.class.getMethods();
        StringBuilder result = new StringBuilder();
        for (Method m : methods) {
            if (m.getName().contains("getIngredient")) {
                try {
                    if (m.invoke(drink) != null) {
                        if (result.toString().equals("")) {
                            result = new StringBuilder((String) m.invoke(drink));
                        } else {
                            result.append(", ").append(m.invoke(drink));
                        }
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    LOGGER.log(Level.INFO, e.toString());
                }
            }
        }
        return result.toString();
    }
}
