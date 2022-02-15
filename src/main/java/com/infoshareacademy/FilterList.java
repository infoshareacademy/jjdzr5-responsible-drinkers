package com.infoshareacademy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterList {

    private final List<Drink> drinkList;

    public FilterList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public List<Drink> getFilteredDrinkListSteam() {
        String noneAlcoholic = FilterElements.NON_ALCOHOL.getName();
        String ingredient = FilterElements.ORANGE_JIUCE.getName();
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
        //      return drinkList.stream().filter(byNoneAlcohol).filter(Objects::nonNull).collect(Collectors.toList());
        return drinkList.stream().filter(byOrangeJuice).filter(Objects::nonNull).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public List<Drink> getFilteredDrinkList() {
        String noneAlcoholic = FilterElements.NON_ALCOHOL.getName();
        String orangeJuice = FilterElements.ORANGE_JIUCE.getName();
        List<Drink> result = new ArrayList<>();

        for (Drink drink : drinkList) {
            if (!drink.getAlcoholic().isEmpty() && drink.getAlcoholic().equalsIgnoreCase(noneAlcoholic)) {
                result.add(drink);
            }
        }

        return result;
    }

    public List<Drink> getFilteredByAlcohol(Boolean isAlcoholFree) {
        List<Drink> result = new ArrayList<>();
        String filterType = "";
        if (isAlcoholFree) {
            filterType = FilterElements.NON_ALCOHOL.getName();
        } else {
            filterType = FilterElements.ALCOHOL.getName();
        }

        for (Drink drink : drinkList) {
            if (!drink.getAlcoholic().isEmpty() && drink.getAlcoholic().equalsIgnoreCase(filterType)) {
                result.add(drink);
            }
        }
        return result;
    }

    public List<Drink> getFilteredByIngredient(FilterElements ingredient) {
        List<Drink> result = new ArrayList<>();
        for (Drink drink : drinkList) {
            if (drink.getIngredient1() != null && drink.getIngredient1().equalsIgnoreCase(ingredient.getName()) ||
                    drink.getIngredient2() != null && drink.getIngredient2().equalsIgnoreCase(ingredient.getName()) ||
                    drink.getIngredient3() != null && drink.getIngredient3().equalsIgnoreCase(ingredient.getName()) ||
                    drink.getIngredient4() != null && drink.getIngredient4().equalsIgnoreCase(ingredient.getName()) ||
                    drink.getIngredient5() != null && drink.getIngredient5().equalsIgnoreCase(ingredient.getName()) ||
                    drink.getIngredient6() != null && drink.getIngredient6().equalsIgnoreCase(ingredient.getName()) ||
                    drink.getIngredient7() != null && drink.getIngredient7().equalsIgnoreCase(ingredient.getName()) ||
                    drink.getIngredient8() != null && drink.getIngredient8().equalsIgnoreCase(ingredient.getName()) ||
                    drink.getIngredient9() != null && drink.getIngredient9().equalsIgnoreCase(ingredient.getName()) ||
                    drink.getIngredient10() != null && drink.getIngredient10().equalsIgnoreCase(ingredient.getName()) ||
                    drink.getIngredient11() != null && drink.getIngredient11().equalsIgnoreCase(ingredient.getName()) ||
                    drink.getIngredient12() != null && drink.getIngredient12().equalsIgnoreCase(ingredient.getName()) ||
                    drink.getIngredient13() != null && drink.getIngredient13().equalsIgnoreCase(ingredient.getName()) ||
                    drink.getIngredient14() != null && drink.getIngredient14().equalsIgnoreCase(ingredient.getName()) ||
                    drink.getIngredient15() != null && drink.getIngredient15().equalsIgnoreCase(ingredient.getName())) {
                result.add(drink);
            }
        }
        return result;
    }

}
