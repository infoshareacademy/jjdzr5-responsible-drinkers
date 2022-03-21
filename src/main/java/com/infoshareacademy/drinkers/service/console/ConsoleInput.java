package com.infoshareacademy.drinkers.service.console;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.infoshareacademy.drinkers.App.DATE_PATTERN;

public class ConsoleInput {

    private final static String TEXT_IF_WRONG_INPUT = "Wprowadzono złe dane";

    public static String getInputUserString() {
        boolean inputIsNotValid;
        String input = "";
        do {
            try {
                input = new Scanner(System.in).nextLine();
                inputIsNotValid = input.trim().isEmpty();
            } catch (InputMismatchException e) {
                System.out.println(TEXT_IF_WRONG_INPUT);
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
                System.out.println(TEXT_IF_WRONG_INPUT);
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
                System.out.println(TEXT_IF_WRONG_INPUT);
                inputIsNotValid = true;
            }
        } while (inputIsNotValid);
        return result;
    }

    public static LocalDateTime getInputUserDateTime() {
        boolean inputIsNotValid;
        LocalDate result;
        do {
            try {
                result = LocalDate.parse(new Scanner(System.in).nextLine(), DateTimeFormatter.ofPattern(DATE_PATTERN));
                inputIsNotValid = false;
            } catch (DateTimeParseException e) {
                inputIsNotValid = true;
                System.out.println(TEXT_IF_WRONG_INPUT);
                result = LocalDate.now();
            }
        } while (inputIsNotValid);
        return result.atStartOfDay();
    }

}
