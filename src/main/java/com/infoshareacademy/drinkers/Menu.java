package com.infoshareacademy.drinkers;

import com.infoshareacademy.drinkers.domain.drink.Drink;
import com.infoshareacademy.drinkers.domain.drink.DrinkBuilder;
import com.infoshareacademy.drinkers.service.console.ConsoleInput;
import com.infoshareacademy.drinkers.service.filtering.FilterElements;
import com.infoshareacademy.drinkers.service.filtering.FilterList;
import com.infoshareacademy.drinkers.service.gson.JsonReader;
import com.infoshareacademy.drinkers.service.manage.DrinkManager;
import com.infoshareacademy.drinkers.service.printing.PrintElement;
import com.infoshareacademy.drinkers.service.printing.PrintElements;
import com.infoshareacademy.drinkers.service.sorting.SortDrinks;
import com.infoshareacademy.drinkers.service.sorting.SortItems;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Menu {

    private static final Logger LOGGER = Logger.getLogger(Menu.class.getName());

    private List<String> menuOptions = new ArrayList<>();
    private List<Drink> drinkList;

    public Menu() {
        JsonReader jsonReader = new JsonReader();
        drinkList = jsonReader.getDrinkList();
    }

    public void run() {
        menuOptions = fillMenuOptions();
        displayMenu(menuOptions);
        int number = getMenuNumber(menuOptions);
        enterIntoMenuOptions(number);
    }

    private List<String> fillMenuOptions() {
        menuOptions.add("Wyjście z programu");
        menuOptions.add("Sprawdz stan barku. ");
        menuOptions.add("Dodaj drink.");
        menuOptions.add("Usuń drink.");
        menuOptions.add("Pokaż sortowaną liste drinkow.");
        menuOptions.add("Filtruj listę drinków.");
        menuOptions.add("Edytuj drinka.");
        menuOptions.add("Wyświetl drinka.");
        menuOptions.add("Wyszukaj drinka.");

        return menuOptions;
    }

    private void displayMenu(List<String> strings) {
        System.out.println("@======================@");
        int i = 0;
        for (String s : strings) {
            System.out.println(i++ + ". " + s);
        }
        System.out.println("@======================@");
    }

    private int getMenuNumber(List<String> strings) {
        int result;
        boolean condition;
        do {
//            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj nr menu gdzie chcesz wejsc: ");
            result = ConsoleInput.getInputUserInteger();
            condition = result > strings.size() || result < 0;
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
                option1();
                break;
            case 2:
                option2();
                break;
            case 3:
                option3();
                break;
            case 4:
                option4();
                break;
            case 5:
                option5();
            case 6:
                System.out.println("Edytuje Drinka.");
                break;
            case 7:
                option7();
                break;
            case 8:
                System.out.println("7. Wyszukaj drinka.");
                break;
        }
        returnToMenu();
    }

    private void returnToMenu() {
        displayMenu(menuOptions);
        enterIntoMenuOptions(getMenuNumber(menuOptions));
    }

    private void option7() {
        option1();
        int drinkIndex;
        do {
            System.out.print("Podaj nr drinka z listy: ");
            drinkIndex = ConsoleInput.getInputUserInteger();
        }
        while (drinkIndex < 1 || drinkIndex > drinkList.size());
        PrintElement.print(drinkList.get(drinkIndex - 1));
    }

    private void option1() {
        PrintElements printElements = new PrintElements(drinkList);
        printElements.print();
    }

    private void option2() {
        DrinkManager drinkManager = new DrinkManager(drinkList);
        System.out.println("Dodałem drinka:");
        Drink newDrink = addDrink();
        drinkManager.addDrinkToList(newDrink);
        PrintElement.print(newDrink);
    }

    private Drink addDrink() {
        boolean isNotValid = true;
        Drink drink = null;
        do {
            String input;
            DrinkBuilder drinkBuilder = new DrinkBuilder();
            System.out.print("Podaj ID: ");
            drinkBuilder.setID(ConsoleInput.getInputUserInteger());
            System.out.print("Podaj nazwe: ");
            drinkBuilder.setName(ConsoleInput.getInputUserString());
            System.out.print("Czy alkoholowy [Y/N]: ");
            drinkBuilder.setisAlcoholic(isAlcoholic());
            System.out.print("Podaj składnik 1: ");
            input = ConsoleInput.getInputUserString();
            drinkBuilder.setIngredient01(input);
            System.out.print("Podaj składnik 2: ");
            drinkBuilder.setIngredient02(ConsoleInput.getInputUserString());
            System.out.print("Podaj składnik 3: ");
            drinkBuilder.setIngredient03(ConsoleInput.getInputUserString());
            System.out.print("Podaj składnik 4: ");
            drinkBuilder.setIngredient04(ConsoleInput.getInputUserString());
            try {
                drink = drinkBuilder.build();
                isNotValid = false;
            } catch (IllegalStateException e) {
                System.out.println("Musisz podac conajmniej nazwę i ID");
            }
        } while (isNotValid);
        return drink;
    }

    private boolean isAlcoholic() {
        String s = ConsoleInput.getInputUserString();
        if (s.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }


    private void option3() {
        DrinkManager drinkManager = new DrinkManager(drinkList);
        int index;
        do {
            System.out.print("Podaj nr drinka z listy: ");
            index = ConsoleInput.getInputUserInteger();
        } while (index < 0 || index > drinkList.size() - 1);
        System.out.println("Usuwam drinka:");
        PrintElement.print(drinkList.get(index));
        drinkList = drinkManager.removeDrink(index);
    }

    private void option4() {
        int result = lowerMenu(new ArrayList<>(Arrays.asList("exit", "sort by ID", "sort by Date", "sort by Drink name", "sort by alcoholic")));
        enterSortMenuOptions(result);
    }

    private void option5() {
        int result = lowerMenu(new ArrayList<>(Arrays.asList("exit", "filter by Date", "sort by alcoholic", "by ingredients")));
        enterFilterMenuOption(result);
    }

    private void enterFilterMenuOption(int source) {
        List<Drink> list = new ArrayList<>();
        FilterList filterElements = new FilterList(drinkList);

        switch (source) {
            case 0:
                break;
            case 1:
                list = filterElements.getFilteredByIngredient(FilterElements.APPLE_JUICE).getResults();
                break;
            case 2:
                list = filterElements.getFilteredByAlcoholic(true).getResults();
                break;
            case 3 :
                list = filterElements.getFilteredByDate(LocalDate.of(2016,1,1).atStartOfDay(),
                        LocalDate.of(2017,1,1).atStartOfDay()).getResults();
            default:
                break;

        }

        PrintElements printElements = new PrintElements(list);
        printElements.print();

    }

    private int lowerMenu(List<String> list) {
        int input;
//        do {
//            displayMenu(list);
//            input = getMenuNumber(list);
//        } while (enterLowerMenuOptions(input));
        displayMenu(list);
        input = getMenuNumber(list);
        return input;
    }

    private boolean enterSortMenuOptions(int source) {
        SortDrinks sortDrinks = new SortDrinks(drinkList);
        PrintElements printElements;

        switch (source) {
            case 1:
                printElements = new PrintElements(sortDrinks.getSortedList(SortItems.ID));
                printElements.print();
                break;
            case 2:
                printElements = new PrintElements(sortDrinks.getSortedList(SortItems.DATE));
                printElements.print();
                break;
            case 3:
                printElements = new PrintElements(sortDrinks.getSortedList(SortItems.DRINK_NAME));
                printElements.print();
                break;
            case 4:
                printElements = new PrintElements(sortDrinks.getSortedList(SortItems.ALCOHOLIC));
                printElements.print();
                break;
            default:
                return false;
        }
        return true;
    }

}
