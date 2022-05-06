package com.infoshareacademy.drinkers.service.filtering;

import com.infoshareacademy.drinkers.domain.drink.Alcoholic;
import com.infoshareacademy.drinkers.domain.drink.Drink;
import com.infoshareacademy.drinkers.domain.drink.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

        Alcoholic filterElements;
        if (Boolean.TRUE.equals(isAlcoholic)) {
            filterElements = Alcoholic.ALCOHOLIC;
        } else {
            filterElements = Alcoholic.NON_ALCOHOLIC;
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

    public FilterList getFilteredByDate(LocalDateTime start, LocalDateTime finish) {
        List<Drink> result = new ArrayList<>();

        for (Drink drink : resultDinkList) {
            Optional<LocalDateTime> optional = Optional.ofNullable(drink.getDateModified());
            if (optional.isPresent()) {
                try {
                    if (drink.getDateModified().isAfter(start) && drink.getDateModified().isBefore(finish)) {
                        result.add(drink);
                    }
                } catch (NullPointerException e) {
                    LOGGER.log(Level.INFO, "Can't compare date", e);
                }
            }
        }
        this.resultDinkList = result;
        return this;
    }

    public FilterList getFilteredByStatus(Status status) {
        List<Drink> result = new ArrayList<>();
        result = resultDinkList.stream().filter(drink -> drink.getStatus().equals(status)).toList();
        this.resultDinkList = result;
        return this;
    }

    public List<Drink> getResults() {
        Optional<List<Drink>> optionalDrinkList = Optional.ofNullable(this.resultDinkList);
        return optionalDrinkList.orElseGet(() -> optionalDrinkList.orElse(new ArrayList<>()));
    }

}
