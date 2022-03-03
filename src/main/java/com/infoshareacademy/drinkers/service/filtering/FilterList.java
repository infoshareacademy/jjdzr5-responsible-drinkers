package com.infoshareacademy.drinkers.service.filtering;

import com.infoshareacademy.drinkers.domain.drink.Drink;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilterList {

    private static final Logger LOGGER = Logger.getLogger(FilterList.class.getName());

    private List<Drink> resultDinkList;

    public FilterList(List<Drink> drinkList) {
        this.resultDinkList = drinkList;
    }

/*    private List<Drink> getFilteredDrinkListStream() {
        String noneAlcoholic = FilterElements.NON_ALCOHOL.getName();
        String ingredient = FilterElements.ORANGE_JUICE.getName();
        Predicate<Drink> byNoneAlcohol = new Predicate<Drink>() {
            @Override
            public boolean test(Drink drink) {
                return !drink.getAlcoholic().isEmpty() && drink.getAlcoholic().equalsIgnoreCase(noneAlcoholic);
            }
        };
        Predicate<Drink> byOrangeJuice = new Predicate<Drink>() {
            @Override
            public boolean test(Drink drink) {
                return drink.getIngredient1() != null && drink.getIngredient1().equalsIgnoreCase(ingredient) ||
                        drink.getIngredient2() != null && drink.getIngredient2().equalsIgnoreCase(ingredient) ||
                        drink.getIngredient3() != null && drink.getIngredient3().equalsIgnoreCase(ingredient) ||
                        drink.getIngredient4() != null && drink.getIngredient4().equalsIgnoreCase(ingredient) ||
                        drink.getIngredient5() != null && drink.getIngredient5().equalsIgnoreCase(ingredient) ||
                        drink.getIngredient6() != null && drink.getIngredient6().equalsIgnoreCase(ingredient) ||
                        drink.getIngredient7() != null && drink.getIngredient7().equalsIgnoreCase(ingredient) ||
                        drink.getIngredient8() != null && drink.getIngredient8().equalsIgnoreCase(ingredient) ||
                        drink.getIngredient9() != null && drink.getIngredient9().equalsIgnoreCase(ingredient) ||
                        drink.getIngredient10() != null && drink.getIngredient10().equalsIgnoreCase(ingredient) ||
                        drink.getIngredient11() != null && drink.getIngredient11().equalsIgnoreCase(ingredient) ||
                        drink.getIngredient12() != null && drink.getIngredient12().equalsIgnoreCase(ingredient) ||
                        drink.getIngredient13() != null && drink.getIngredient13().equalsIgnoreCase(ingredient) ||
                        drink.getIngredient14() != null && drink.getIngredient14().equalsIgnoreCase(ingredient) ||
                        drink.getIngredient15() != null && drink.getIngredient15().equalsIgnoreCase(ingredient);
            }
        };
        return drinkList.stream().filter(byOrangeJuice).filter(Objects::nonNull).filter(Objects::nonNull).collect(Collectors.toList());
    }*/

/*    public List<Drink> getFilteredDrinkList() {
        String noneAlcoholic = FilterElements.NON_ALCOHOL.getName();
        String orangeJuice = FilterElements.ORANGE_JUICE.getName();
        List<Drink> result = new ArrayList<>();

        for (Drink drink : drinkList) {
            if (!drink.getAlcoholic().isEmpty() && drink.getAlcoholic().equalsIgnoreCase(noneAlcoholic)) {
                result.add(drink);
            }
        }
        return result;
    }*/

    public FilterList getFilteredByAlcoholic(Boolean isAlcoholic) {
        List<Drink> result = new ArrayList<>();

        FilterElements filterElements;
        if (isAlcoholic) {
            filterElements = FilterElements.ALCOHOL;
        } else {
            filterElements = FilterElements.NON_ALCOHOL;
        }

        for (Drink drink : resultDinkList) {
            if (!drink.getAlcoholic().isEmpty() && drink.getAlcoholic().equalsIgnoreCase(filterElements.getName())) {
                result.add(drink);
            }
        }
        this.resultDinkList = result;
        return this;
    }

    public FilterList getFilteredByIngredient(FilterElements ingredient) {
        List<Drink> result = new ArrayList<>();
        for (Drink drink : resultDinkList) {
            if (drink.getIngredient1() != null && drink.getIngredient1().toLowerCase().contains((ingredient.getName().toLowerCase())) ||
                    drink.getIngredient2() != null && drink.getIngredient2().toLowerCase().contains(ingredient.getName().toLowerCase()) ||
                    drink.getIngredient3() != null && drink.getIngredient3().toLowerCase().contains(ingredient.getName().toLowerCase()) ||
                    drink.getIngredient4() != null && drink.getIngredient4().toLowerCase().contains(ingredient.getName().toLowerCase()) ||
                    drink.getIngredient5() != null && drink.getIngredient5().toLowerCase().contains(ingredient.getName().toLowerCase()) ||
                    drink.getIngredient6() != null && drink.getIngredient6().toLowerCase().contains(ingredient.getName().toLowerCase()) ||
                    drink.getIngredient7() != null && drink.getIngredient7().toLowerCase().contains(ingredient.getName().toLowerCase()) ||
                    drink.getIngredient8() != null && drink.getIngredient8().toLowerCase().contains(ingredient.getName().toLowerCase()) ||
                    drink.getIngredient9() != null && drink.getIngredient9().toLowerCase().contains(ingredient.getName().toLowerCase()) ||
                    drink.getIngredient10() != null && drink.getIngredient10().toLowerCase().contains(ingredient.getName().toLowerCase()) ||
                    drink.getIngredient11() != null && drink.getIngredient11().toLowerCase().contains(ingredient.getName().toLowerCase()) ||
                    drink.getIngredient12() != null && drink.getIngredient12().toLowerCase().contains(ingredient.getName().toLowerCase()) ||
                    drink.getIngredient13() != null && drink.getIngredient13().toLowerCase().contains(ingredient.getName().toLowerCase()) ||
                    drink.getIngredient14() != null && drink.getIngredient14().toLowerCase().contains(ingredient.getName().toLowerCase()) ||
                    drink.getIngredient15() != null && drink.getIngredient15().toLowerCase().contains(ingredient.getName().toLowerCase())
            ) {
                result.add(drink);
            }
        }
        this.resultDinkList = result;
        return this;
    }

    public void printResults(List<Drink> drinks) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ID: " + "Name" + "\t|\t")
                .append("Alcohol" + "\t|\t")
                .append("Ingredients" + "\t|\t")
                .append(System.lineSeparator());
        System.out.print(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        for (Drink drink : drinks) {
            stringBuilder.append(drink.getIdDrink() + ": " + drink.getDrink() + "\t|\t")
                    .append(checkStringIsNull(drink.getAlcoholic()) + "\t|\t")
                    .append(checkStringIsNull(drink.getIngredient1()) + ", ")
                    .append(checkStringIsNull(drink.getIngredient2()) + ", ")
                    .append(checkStringIsNull(drink.getIngredient3()) + ", ")
                    .append(checkStringIsNull(drink.getIngredient4()) + ", ")
                    .append(checkStringIsNull(drink.getIngredient5()))
                    .append(System.lineSeparator());
        }
        System.out.print(stringBuilder);
        System.out.println("Size: " + drinks.size());
    }

//    public List<Drink> getDrinkListFiltered(FilterElements... filterElements) {
//
//        for (FilterElements elements : filterElements) {
//            if (elements.equals(FilterElements.NON_ALCOHOL) || elements.equals(FilterElements.ALCOHOL)) {
//                this.drinkList = getFilteredByAlcohol(elements);
//            } else {
//                this.drinkList = getFilteredByIngredient(elements);
//            }
//        }
//        return this.drinkList;
//    }

    private String checkStringIsNull(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public FilterList getFilteredByDate(Date start, Date finish) {
        List<Drink> result = new ArrayList<>();
        for (Drink drink : resultDinkList) {
            try {
                if (drink.getDateModified().after(start) && drink.getDateModified().before(finish)) {
                    result.add(drink);
                }
            } catch (NullPointerException e) {
                LOGGER.log(Level.INFO, "Can't compare date", e);
            }
        }
        this.resultDinkList = result;
        return this;
    }

    public List<Drink> run() {
        return this.resultDinkList;
    }

}
