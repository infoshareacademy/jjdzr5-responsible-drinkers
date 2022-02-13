package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<String> menuOptions = new ArrayList<>();

    public void run() {
        menuOptions = fillMenuOptions();
        displayMenu();
        int number = getMenuNumber();
        enterIntoMenuOptions(number);
    }

    private List<String> fillMenuOptions() {

        menuOptions.add("0. Wyjście z programu");
        menuOptions.add("1. Sprawdz stan barku. ");
        menuOptions.add("2. Dodaj drink.");
        menuOptions.add("3. Usuń drink.");
        menuOptions.add("4. Wprowadz drink do barku.");
        menuOptions.add("5. Wypij drinka.");
        menuOptions.add("6. Edytuj drinka.");
        menuOptions.add("7. Wyszukaj drinka.");

        return menuOptions;
    }

    private void displayMenu() {

//        1.text menu : - na bazie listy
        System.out.println("======================");

        for (String i : menuOptions) {
            System.out.println(i);
        }

        System.out.println("======================");

    }

    private int getMenuNumber() {

//        2. Pobieranie nr menu
        int result;
        boolean condition;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj nr menu gdzie chcesz wejsc: ");
            result = scanner.nextInt();
            condition = result > menuOptions.size() || result < 0;
            if (condition) {
                System.out.println("Brak takiego numeru w menu.");
            }
        } while (condition);
        return result;
    }

    private void enterIntoMenuOptions(int source) {

        switch (source) {
            case 0:
                System.out.println("Zamykam program");
                return;
            case 1:
                System.out.println("Sprawdzam stan barku...");


                break;

            case 2:
                System.out.println("Przechodzę do dodawania drinku...");

                break;
            case 3:
                System.out.println("Przechodzę do usuwania drinka...");
                break;
            case 4:
                System.out.println("Wprowadzam drinka do barku..");
                break;
            case 5:
                System.out.println("Wypijam Drinka.");
            case 6:
                System.out.println("Edytuje Drinka.");
                break;
            case 7:
                menuOptions.add("7. Wyszukaj drinka.");
                break;
        }
        returnToMenu();
    }

    private void returnToMenu() {
        displayMenu();
        enterIntoMenuOptions(getMenuNumber());
    }
}
