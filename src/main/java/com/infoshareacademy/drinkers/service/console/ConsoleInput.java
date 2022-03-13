package com.infoshareacademy.drinkers.service.console;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleInput {

    public static String getInputUserString() {
        boolean inputIsNotValid = true;
        String input = "";
        do {
            try {
                input = new Scanner(System.in).nextLine();
                if (input.equals("")) {
                    return "";
                }
                inputIsNotValid = input.trim().isEmpty();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input.");
                inputIsNotValid = true;
            }
        } while (inputIsNotValid);
        return input;
    }

    public static Double getInputUserDouble() {

        boolean inputIsNotValid = true;
        Double input = 0.0;
        do {
            try {
                input = new Scanner(System.in).nextDouble();
                inputIsNotValid = false;

            } catch (InputMismatchException e) {
                System.out.println("Wrong input.");
                inputIsNotValid = true;
            }
        } while (inputIsNotValid);
        return input;
    }

    public static Integer getInputUserInteger() {
        boolean inputIsNotValid;
        int result = 0;
        do {
            try {

                result = new Scanner(System.in).nextInt();
                inputIsNotValid = false;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input.");
                inputIsNotValid = true;
            }
        } while (inputIsNotValid);
        return result;
    }


}
