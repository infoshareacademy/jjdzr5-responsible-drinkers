package com.infoshareacademy.drinkers;

import com.infoshareacademy.drinkers.domain.drink.Alcoholic;
import com.infoshareacademy.drinkers.domain.drink.Drink;
import com.infoshareacademy.drinkers.domain.drink.DrinkBuilder;
import com.infoshareacademy.drinkers.service.console.ConsoleInput;
import com.infoshareacademy.drinkers.service.gson.JsonReader;
import com.infoshareacademy.drinkers.service.manage.DrinkManager;
import com.infoshareacademy.drinkers.service.printing.PrintElement;
import com.infoshareacademy.drinkers.service.printing.PrintElements;
import com.infoshareacademy.drinkers.service.searching.Search;
import com.infoshareacademy.drinkers.service.sorting.SortDrinks;
import com.infoshareacademy.drinkers.service.sorting.SortItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<String> menuOptions = new ArrayList<>();
    private List<Drink> drinkList;

    public Menu() {
        JsonReader jsonReader = new JsonReader();
        drinkList = jsonReader.getDrinkList();
    }

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
        menuOptions.add("4. Sortuj liste drinkow.");
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
            result = ConsoleInput.getInputUserInteger();
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
                option1();
                break;
            case 2:
                System.out.println("Przechodzę do dodawania drinku...");
                option2();
                break;
            case 3:
                System.out.println("Przechodzę do usuwania drinka...");
                option3();
                break;
            case 4:
                System.out.println("Sortuj listę drinków");
                option4();
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

    private void option1() {
        PrintElements printElements = new PrintElements(drinkList);
        printElements.print();
    }

    private void option2() {
        DrinkManager drinkManager = new DrinkManager(drinkList);
        Drink newDrink = new DrinkBuilder()
                .setID(1111)
                .setName("Mohito")
                .setisAlcoholic(true)
                .setIngredient01("Orange juice")
                .setIngredient02("White rum")
                .build();
        drinkManager.addDrinkToList(newDrink);
    }

    private void option3() {
        DrinkManager drinkManager = new DrinkManager(drinkList);
        int index;
        do {
            System.out.print("Podaj nr drinka: ");
            index = ConsoleInput.getInputUserInteger();
        } while (index < 0 || index > drinkList.size() - 1);
        System.out.println("Usuwam drinka:");
        PrintElement.print(drinkList.get(index));
        drinkList = drinkManager.removeDrink(index);
    }

    private void option4() {
        SortDrinks sortDrinks = new SortDrinks(drinkList);
        PrintElements printElements = new PrintElements(sortDrinks.getSortedList(SortItems.ID));
        printElements.print();
    }

}
