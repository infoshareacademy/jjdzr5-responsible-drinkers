package com.infoshareacademy;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintElement {

    private static final Logger LOGGER = Logger.getLogger(PrintElement.class.getName());

    public static void print(Drink drink) {
        if (drink != null) {
            printLine(100);
            System.out.print("ID: " + drink.getIdDrink() + ",\t");
            System.out.print("Name: " + drink.getDrink() + ",\t");
            System.out.print("Alcoholic: " + isAlcoholic(drink) + ",\t");
            System.out.println("Cathegory: " + drink.getCategory());
            System.out.println("Ingredients: " + ingredients(drink) + "\t");
            System.out.println("Instructions: " + printInstructions(drink, InstructionsLanguage.EN));
            System.out.println("Glass: " + drink.getGlass());
            printLine(100);
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
        System.out.println(line);
    }
}
