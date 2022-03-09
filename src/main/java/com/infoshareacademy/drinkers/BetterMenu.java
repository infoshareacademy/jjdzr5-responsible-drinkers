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
import com.infoshareacademy.drinkers.service.searching.Search;
import com.infoshareacademy.drinkers.service.sorting.SortDrinks;
import com.infoshareacademy.drinkers.service.sorting.SortItems;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.util.*;

public class BetterMenu {
    private final static String[] MAIN_MENU = {"Zamknij program", "Wyświetl listę drinków", "Dodaj drinka",
            "Usuń drinka", "Lista sortowana", "Lista filtrowana", "Wyświetl drinka", "Edytuj drinka", "Wyszukaj drinka"};
    private final static String[] LOWER_SORT_MENU = {"Wróć wyżej", "by ID", "by Date", "by Name", "by Alkoholic"};
    private final static String[] LOWER_FILTER_MENU = {"Wróć wyżej", "by Date", "by alcoholic", "by Ingredients"};

    final static Logger logger = Logger.getLogger(BetterMenu.class.getName());

    private List<Drink> drinkList;

    public BetterMenu() {
        JsonReader jsonReader = new JsonReader();
        drinkList = jsonReader.getDrinkList();
    }

    public void start() {
        int menuOption;
        do {
            menuOption = readInput(MAIN_MENU);
            if (menuOption < 0) {
                break;
            }
            inputSwitcherMainManu(menuOption);
            if (menuOption == MAIN_MENU.length - 1) {
                System.out.println(MAIN_MENU[menuOption]);
            }
        } while (menuOption != 0);
    }

    private void printMenu(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            System.out.println(i + ". " + strings[i]);
        }
    }

    private int readInput(String[] menu) {
        int result = 0;
        boolean isValid;

        do {
            if (menu.length == 0) {
                result = -1;
                break;
            }
            printMenu(menu);

            Scanner scanner = new Scanner(System.in);
            try {
                String line = scanner.nextLine();
                if (line.isEmpty() || line.isBlank() || line.equals("\n")) {
                    throw new InputMismatchException("Empty string");
                }
                result = Integer.parseInt(line);
                if ((result + 1 > menu.length) || (result < 0)) {
                    throw new NumberFormatException();
                }
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Podaj właściwą liczbę!");
                isValid = false;
            } catch (InputMismatchException e) {
                isValid = false;
            }
        } while (!isValid);
        return result;
    }

    private void printObject(Object object) {
        System.out.println(object + " -> " + object.getClass().getSimpleName());
    }

    private void inputSwitcherMainManu(int menuOption) {
        int lowerMenuOption1, lowerMenuOption2;
        switch (menuOption) {
            case 4: {
                sortOption();
                break;
            }
            case 1: {
                checkAllDrinksOption();
                break;
            }
            case 2: {
                addDrinkOption();
                break;
            }
            case 3: {
                removeDrinkOption();
                break;
            }
            case 5: {
                filterOption();
                break;
            }
            case 6: {
                printDrinkOption();
                break;
            }
            case 7: {
                System.out.println("Edytuje Drinka.");
                break;
            }
            case 8: {
                searchForDrink();

                break;
            }
        }
    }

    private void searchForDrink() {
        String searchText;
        do {
            System.out.print("Podaj tekst do wyszukania [min. 3 znaki]: ");
            searchText = ConsoleInput.getInputUserString();
        }
        while (searchText.length() < 3);

        List<Drink> searchDrink = new Search(drinkList)
                .searchByName(searchText)
                .getResults();
        PrintElements printElements = new PrintElements(searchDrink);
        printElements.print();


    }

    private void inputSortMenu(int lowerMenuOption) {
        SortDrinks sortDrinks = new SortDrinks(drinkList);
        PrintElements printElements;
        switch (lowerMenuOption) {
            case 3: {
                printElements = new PrintElements(sortDrinks.getSortedList(SortItems.DRINK_NAME));
                printElements.print();
                break;
            }
            case 1: {
                printElements = new PrintElements(sortDrinks.getSortedList(SortItems.ID));
                printElements.print();
                break;
            }
            case 2: {
                printElements = new PrintElements(sortDrinks.getSortedList(SortItems.DATE));
                printElements.print();
                break;
            }
            case 4: {
                printElements = new PrintElements(sortDrinks.getSortedList(SortItems.ALCOHOLIC));
                printElements.print();
                break;
            }
        }
    }

    private void inputFilterMenu(int lowerMenuOption) {
        List<Drink> list = new ArrayList<>();
        FilterList filterElements = new FilterList(drinkList);
        switch (lowerMenuOption) {
            case 3: {
                list = filterElements.getFilteredByIngredient(FilterElements.VODKA).getResults();
                PrintElements printElements = new PrintElements(list);
                printElements.print();
                break;
            }
            case 2: {
                list = filterElements.getFilteredByAlcoholic(true).getResults();
                PrintElements printElements = new PrintElements(list);
                printElements.print();
                break;
            }
            case 1: {
                list = filterElements.getFilteredByDate(LocalDate.of(2016, 1, 1).atStartOfDay(),
                        LocalDate.of(2017, 1, 1).atStartOfDay()).getResults();
                PrintElements printElements = new PrintElements(list);
                printElements.print();
                break;
            }
        }
    }

    private void checkAllDrinksOption() {
        PrintElements printElements = new PrintElements(drinkList);
        printElements.print();
    }

    private void addDrinkOption() {
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

    private void removeDrinkOption() {
        checkAllDrinksOption();
        DrinkManager drinkManager = new DrinkManager(drinkList);
        int index;
        do {
            System.out.print("Podaj nr drinka z listy: ");
            index = ConsoleInput.getInputUserInteger() - 1;
        } while (index < 0 || index > drinkList.size() - 1);
        System.out.println("Usuwam drinka:");
        PrintElement.print(drinkList.get(index));
        drinkList = drinkManager.removeDrink(index);
    }

    private void sortOption() {
        int lowerMenuOption;
        do {
            lowerMenuOption = readInput(LOWER_SORT_MENU);
            inputSortMenu(lowerMenuOption);
        } while (lowerMenuOption != 0);
    }

    private void filterOption() {
        int lowerMenuOption;
        do {
            lowerMenuOption = readInput(LOWER_FILTER_MENU);
            inputFilterMenu(lowerMenuOption);
        } while (lowerMenuOption != 0);
    }

    private void printDrinkOption() {
        checkAllDrinksOption();
        int drinkIndex;
        do {
            System.out.print("Podaj nr drinka z listy: ");
            drinkIndex = ConsoleInput.getInputUserInteger();
        }
        while (drinkIndex < 1 || drinkIndex > drinkList.size());
        PrintElement.print(drinkList.get(drinkIndex - 1));
    }
}
