package com.infoshareacademy.drinkers.domain.drink;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DrinkBuilder {

    private static final Logger LOGGER = Logger.getLogger(DrinkBuilder.class.getName());

    private int idDrink;
    private String strDrink;
    private String strDrinkAlternate;
    private String strTags;
    private String strVideo;
    private String strCategory;
    private String strIBA;
    private String strAlcoholic;
    private String strNoAlcoholic;
    private String strGlass;
    private String strInstructions;
    private String strInstructionsES;
    private String strInstructionsDE;
    private String strInstructionsFR;
    private String strInstructionsIT;
    private String strInstructionsZH_HANS;
    private String strInstructionsZH_HANT;
    private URI strDrinkThumb;
    private String strIngredient1;
    private String strIngredient2;
    private String strIngredient3;
    private String strIngredient4;
    private String strIngredient5;
    private String strIngredient6;
    private String strIngredient7;
    private String strIngredient8;
    private String strIngredient9;
    private String strIngredient10;
    private String strIngredient11;
    private String strIngredient12;
    private String strIngredient13;
    private String strIngredient14;
    private String strIngredient15;
    private String strMeasure1;
    private String strMeasure2;
    private String strMeasure3;
    private String strMeasure4;
    private String strMeasure5;
    private String strMeasure6;
    private String strMeasure7;
    private String strMeasure8;
    private String strMeasure9;
    private String strMeasure10;
    private String strMeasure11;
    private String strMeasure12;
    private String strMeasure13;
    private String strMeasure14;
    private String strMeasure15;
    private URI strImageSource;
    private String strImageAttribution;
    private String strCreativeCommonsConfirmed;
    private LocalDateTime dateModified;

    public Drink build() throws IllegalStateException {
        Drink drink = new Drink();
        if (idDrink <= 0) {
//            LOGGER.log(Level.INFO, "ID cannot be empty");
            throw new IllegalStateException("ID cannot be empty");
        } else if (strDrink.isEmpty()) {
//            LOGGER.log(Level.INFO, "Name cannot be empty");
            throw new IllegalStateException("Name cannot be empty");
        } else {
            drink.setIdDrink(idDrink);
            drink.setDrinkName(strDrink);
            drink.setDrinkAlternate(strDrinkAlternate);
            drink.setDateModified(LocalDateTime.now());
            drink.setAlcoholic(strAlcoholic);
            drink.setIngredient1(strIngredient1);
            drink.setIngredient2(strIngredient2);
            drink.setIngredient3(strIngredient3);
            drink.setIngredient4(strIngredient4);
            drink.setIngredient5(strIngredient5);
            drink.setIngredient6(strIngredient6);
            drink.setIngredient7(strIngredient7);
            drink.setIngredient8(strIngredient8);
            return drink;
        }
    }

    public DrinkBuilder setID(Integer ID) {
        this.idDrink = ID;
        return this;
    }

    public DrinkBuilder setName(String drinkName) {
        this.strDrink = drinkName;
        return this;
    }

    public DrinkBuilder setDrinkAlternate(String drinkAlternate) {
        this.strDrinkAlternate = drinkAlternate;
        return this;
    }

    public DrinkBuilder setisAlcoholic(boolean isAlcoholic) {
        if (isAlcoholic) {
            this.strAlcoholic = Alcoholic.ALCOHOLIC.getName();
            return this;
        } else {
            this.strAlcoholic = Alcoholic.NON_ALCOHOLIC.getName();
            return this;
        }
    }

    public DrinkBuilder setisNonAlcoholic(boolean isAlcoholic) {
        if (isAlcoholic) {
            this.strAlcoholic = Alcoholic.NON_ALCOHOLIC.getName();
            return this;
        } else {
            this.strAlcoholic = Alcoholic.ALCOHOLIC.getName();
            return this;
        }
    }

    public DrinkBuilder setIngredient01(String ingredient) {
        this.strIngredient1 = ingredient;
        return this;
    }

    public DrinkBuilder setIngredient02(String ingredient) {
        this.strIngredient2 = ingredient;
        return this;
    }

    public DrinkBuilder setIngredient03(String ingredient) {
        this.strIngredient3 = ingredient;
        return this;
    }

    public DrinkBuilder setIngredient04(String ingredient) {
        this.strIngredient4 = ingredient;
        return this;
    }

    public DrinkBuilder setIngredient05(String ingredient) {
        this.strIngredient5 = ingredient;
        return this;
    }

    public DrinkBuilder setIngredient06(String ingredient) {
        this.strIngredient6 = ingredient;
        return this;
    }

    public DrinkBuilder setIngredient07(String ingredient) {
        this.strIngredient7 = ingredient;
        return this;
    }

    public DrinkBuilder setIngredient08(String ingredient) {
        this.strIngredient8 = ingredient;
        return this;
    }
}
