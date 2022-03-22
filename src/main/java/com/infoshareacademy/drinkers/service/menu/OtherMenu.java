package com.infoshareacademy.drinkers.service.menu;

import com.infoshareacademy.drinkers.domain.drink.Alcoholic;
import com.infoshareacademy.drinkers.domain.drink.Drink;
import com.infoshareacademy.drinkers.domain.drink.DrinkBuilder;
import com.infoshareacademy.drinkers.service.console.ConsoleInput;
import com.infoshareacademy.drinkers.service.filtering.FilterElements;
import com.infoshareacademy.drinkers.service.filtering.FilterList;
import com.infoshareacademy.drinkers.service.gson.JsonReader;
import com.infoshareacademy.drinkers.service.manage.DrinkManager;
import com.infoshareacademy.drinkers.service.printing.ConsoleColors;
import com.infoshareacademy.drinkers.service.printing.PrintElement;
import com.infoshareacademy.drinkers.service.printing.PrintElements;
import com.infoshareacademy.drinkers.service.searching.Search;
import com.infoshareacademy.drinkers.service.sorting.SortDrinks;
import com.infoshareacademy.drinkers.service.sorting.SortItems;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.infoshareacademy.drinkers.App.DATE_PATTERN;

public class OtherMenu {
    private static final String[] MAIN_MENU = {"Zamknij program", "Wyświetl listę drinków", "Dodaj drinka",
            "Usuń drinka", "Lista sortowana", "Lista filtrowana", "Wyświetl drinka", "Edytuj drinka", "Wyszukaj drinka"};
    private static final String[] LOWER_SORT_MENU = {"Wróć wyżej", "Sortuj po ID", "Sortuj po Dacie", "Sortuj po nazwie",
            "Sortuj po 'Alkoholic'"};
    private static final String[] LOWER_FILTER_MENU = {"Wróć wyżej", "filtruj po dacie", "Wyświetla drinki alkoholowe",
            "Wyświetla drinki bezalkoholowe", "Wyświetl drinki ze skladnikiem"};
    private static final String[] LOWER_EDIT_MENU = {"Zapisz i wróć wyżej", "Zmien nazwę", "Zmien ID",
            "Zmien alko / bezalko", "Odrzuć zmiany"};

    private final List<Drink> drinkList;

    public OtherMenu() {
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
        String textToGoodBye = ConsoleColors.BLACK_BOLD + ConsoleColors.RED_BACKGROUND + " ~ ~ ~  Do zobaczenia!  ~ ~ ~ " +
                ConsoleColors.RESET + System.lineSeparator();
        System.out.print(StringUtils.center(textToGoodBye, 30));
    }

    private void printMenu(String[] strings) {
        System.out.println(ConsoleColors.WHITE_BOLD + ConsoleColors.WHITE_BRIGHT + "@-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-@" + ConsoleColors.RESET);

        for (int i = 0; i < strings.length; i++) {
            System.out.println(ConsoleColors.WHITE_BOLD + ConsoleColors.WHITE_BRIGHT + i + ". " + ConsoleColors.RESET + strings[i]);
        }
        System.out.println(ConsoleColors.WHITE_BOLD + ConsoleColors.WHITE_BRIGHT + "@-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-@" + ConsoleColors.RESET);
        System.out.print("Wybierz opcję: ");
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

    private void inputSwitcherMainManu(int menuOption) {
        switch (menuOption) {
            case 4: {
                sortOption();
                break;
            }
            case 1: {
                printAllDrinksOption();
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
                editDrinkOption();
                break;
            }
            case 8: {
                searchForDrink();
                break;
            }

        }
    }

    private void editDrinkOption() {
        printAllDrinksOption();
        System.out.println("Podaj nr drinka do edycji");
        int number = ConsoleInput.getInputUserInteger() - 1;
        PrintElement.print(drinkList.get(number));
        Drink copyOfDrink = drinkList.get(number);
        int lowerMenuOption;
        Drink drink;
        do {
            lowerMenuOption = readInput(LOWER_EDIT_MENU);
            drink = inputEditMenu(lowerMenuOption, number);
        } while (lowerMenuOption != 0 && lowerMenuOption != 4);
        if (lowerMenuOption != 4) {
            drinkList.set(number, copyOfDrink);
        } else {
            drinkList.set(number, drink);
        }
    }


    private Drink inputEditMenu(int lowerMenuOption, int drinkToBeEditedIndex) {

        Drink drinkToEdit = drinkList.get(drinkToBeEditedIndex);
        switch (lowerMenuOption) {

            case 1: {
                System.out.print("Stara nazwa: ");
                System.out.println(drinkToEdit.getDrink());
                System.out.print("Podaj nową: ");
                String name = ConsoleInput.getInputUserString();
                drinkToEdit.setDrinkName(name);
                PrintElement.print(drinkToEdit);
                break;
            }
            case 2: {
                System.out.print("Stare ID: ");
                System.out.println(drinkToEdit.getIdDrink());
                int index;
                do {
                    System.out.print("Podaj nowe ID: ");
                    index = ConsoleInput.getInputUserInteger();
                } while (index == -1);
                drinkToEdit.setIdDrink(index);
                PrintElement.print(drinkToEdit);
                break;
            }
            case 3: {
                System.out.print("Stare alco: ");
                System.out.println(drinkToEdit.getAlcoholic());
                String string;
                do {
                    System.out.print("Podaj nowe alko [y/n]: ");
                    string = ConsoleInput.getInputUserString();
                } while (!string.equalsIgnoreCase("Y") && !string.equalsIgnoreCase("N"));
                if (string.equalsIgnoreCase("y")) {
                    drinkToEdit.setAlcoholic(Alcoholic.ALCOHOLIC.getName());
                } else {
                    drinkToEdit.setAlcoholic(Alcoholic.NON_ALCOHOLIC.getName());
                }
                PrintElement.print(drinkToEdit);
                break;
            }
            case 4: {
                return drinkToEdit;
                //  break;
            }
        }
        drinkToEdit.setDateModified(LocalDateTime.now());
        return drinkToEdit;
    }

    private void searchForDrink() {
        String searchText;
        do {
            System.out.print("Podaj tekst lub numer ID do wyszukania [min. 3 znaki]: ");
            searchText = ConsoleInput.getInputUserString();
        }
        while (searchText.length() < 3);
        Integer id;
        try {
            id = Integer.parseInt(searchText);
        } catch (NumberFormatException e) {
            id = null;
        }

        List<Drink> searchDrink = new Search(drinkList)
                .searchByName(searchText)
                .searchByID(id)
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
        List<Drink> list;
        FilterList filterElements = new FilterList(drinkList);
        switch (lowerMenuOption) {
            case 4: {
                list = filterElements.getFilteredByIngredient(FilterElements.VODKA).getResults();
                System.out.println("Filter: " + FilterElements.VODKA.getName());
                PrintElements printElements = new PrintElements(list);
                printElements.print();
                break;
            }
            case 3: {
                list = filterElements.getFilteredByAlcoholic(false).getResults();
                System.out.println("Filter: " + Alcoholic.NON_ALCOHOLIC.getName());

                PrintElements printElements = new PrintElements(list);
                printElements.print();
                break;
            }
            case 2: {
                list = filterElements.getFilteredByAlcoholic(true).getResults();
                System.out.println("Filter: " + Alcoholic.ALCOHOLIC.getName());
                PrintElements printElements = new PrintElements(list);
                printElements.print();
                break;
            }
            case 1: {
                LocalDateTime startDate;
                LocalDateTime endDate;
                boolean datePeriodNotValid = true;
                do {
                    System.out.print("Podaj datę początkową [" + DATE_PATTERN + "]: ");
                    startDate = ConsoleInput.getInputUserDateTime();
                    System.out.print("Podaj datę końcową [" + DATE_PATTERN + "]: ");
                    endDate = ConsoleInput.getInputUserDateTime();
                    if (startDate.isBefore(endDate)) {
                        datePeriodNotValid = false;
                    } else {
                        System.out.println("Przedział daty niepoprawny");
                    }
                } while (datePeriodNotValid);
                list = filterElements.getFilteredByDate(startDate, endDate).getResults();
                System.out.println("Filter: od " + startDate.format(DateTimeFormatter.ofPattern(DATE_PATTERN)) +
                        " -> do " + endDate.format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
                PrintElements printElements = new PrintElements(list);
                printElements.print();
                break;
            }
        }
    }

    private void printAllDrinksOption() {
        PrintElements printElements = new PrintElements(drinkList);
        printElements.print();
    }

    private void addDrinkOption() {
        DrinkManager drinkManager = new DrinkManager(drinkList);
        Drink newDrink = addDrink();
        drinkManager.addDrinkToList(newDrink);
        PrintElement.print(newDrink);
    }

    private boolean checkIfIDExist(int checkID) {
        for (Drink drink : drinkList) {
            if (drink.getIdDrink() == checkID) {
                System.out.println("Podane ID istnieje!");
                return true;
            }
        }
        return false;
    }

    private Drink addDrink() {
        boolean isNotValid = true;
        Drink drink = null;
        do {
            DrinkBuilder drinkBuilder = new DrinkBuilder();
            int id;
            do {
                System.out.print("Podaj id: ");
                id = ConsoleInput.getInputUserInteger();
            } while (checkIfIDExist(id));
            drinkBuilder.setID(id);
            System.out.print("Podaj nazwe: ");
            drinkBuilder.setName(ConsoleInput.getInputUserString());
            System.out.print("Czy alkoholowy [Y/N]: ");

            boolean inputNotCorrect = false;
            do {

                String result = ConsoleInput.getInputUserString();
                if (result.equals("y") || result.equals("Y")) {
                    inputNotCorrect = false;
                    drinkBuilder.setisAlcoholic(isAlcoholic(result));
                } else if (result.equals("n") || result.equals("N")) {
                    inputNotCorrect = false;
                    boolean isAlcoholFree = true;
                    drinkBuilder.setisNonAlcoholic(isAlcoholFree);
                } else {
                    System.out.println("Musisz wpisac Y lub N. Wszelki inny input nie jest rejestrowany przez system.");
                    inputNotCorrect = true;

                }
            } while (inputNotCorrect);

            System.out.print("Podaj składnik 1: ");
            drinkBuilder.setIngredient01(ConsoleInput.getInputUserString());
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
                System.out.println("Musisz podac conajmniej nazwę i id");
            }
        } while (isNotValid);
        return drink;
    }

    private boolean isAlcoholic(String input) {
        //   String s = ConsoleInput.getInputUserString();
        return input.equalsIgnoreCase("y");
    }

//    private boolean isNonAlcoholic(String input) {
//   //     String s = ConsoleInput.getInputUserString();
//        return input.equalsIgnoreCase("n");
//    }

    private void removeDrinkOption() {
        printAllDrinksOption();
        DrinkManager drinkManager = new DrinkManager(drinkList);
        int index;
        do {
            System.out.print("Podaj nr drinka z listy: ");
            index = ConsoleInput.getInputUserInteger() - 1;
            // inputNotCorrect =index < 0 || index > drinkList.size() - 1;
            if (index < 0 || index > drinkList.size() - 1) {
                System.out.println("Podaj nr ID istniejace w bazie.");
            } else {
            }
        } while (index < 0 || index > drinkList.size() - 1);
        System.out.println("Usuwam drinka:");
        PrintElement.print(drinkList.get(index));
        drinkManager.removeDrink(index);
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
        printAllDrinksOption();
        int drinkIndex;
        do {
            System.out.print("Podaj nr drinka z listy: ");
            drinkIndex = ConsoleInput.getInputUserInteger();
        }
        while (drinkIndex < 1 || drinkIndex > drinkList.size());
        PrintElement.print(drinkList.get(drinkIndex - 1));
    }
}
