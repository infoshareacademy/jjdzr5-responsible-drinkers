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

    public Drink build() {
        Drink drink = new Drink();
        if (idDrink <= 0) {
            throw new IllegalStateException("ID cannot be empty");
        }
        if (strDrink.isEmpty()) {
            throw new IllegalStateException("Name cannot be empty");
        }
        drink.setIdDrink(idDrink);
        drink.setDrinkName(strDrink);
        drink.setDrinkAlternate(strDrinkAlternate);
        drink.setDateModified(LocalDateTime.now());
        return drink;
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

    public DrinkBuilder setIngredients(String... ingredient) {
        if (ingredient.length < 9) {
            if (!ingredient[0].isEmpty()) {
                this.strIngredient1 = ingredient[0];
            }
            if (!ingredient[1].isEmpty()) {
                this.strIngredient2 = ingredient[1];
            }
            if (!ingredient[2].isEmpty()) {
                this.strIngredient3 = ingredient[2];
            }
            if (!ingredient[3].isEmpty()) {
                this.strIngredient4 = ingredient[3];
            }
            if (!ingredient[4].isEmpty()) {
                this.strIngredient5 = ingredient[4];
            }
            if (!ingredient[5].isEmpty()) {
                this.strIngredient6 = ingredient[5];
            }
            if (!ingredient[6].isEmpty()) {
                this.strIngredient7 = ingredient[6];
            }
            if (!ingredient[7].isEmpty()) {
                this.strIngredient8 = ingredient[7];
            }
            if (!ingredient[8].isEmpty()) {
                this.strIngredient9 = ingredient[8];
            }
            if (!ingredient[9].isEmpty()) {
                this.strIngredient10 = ingredient[9];
            }
            return this;
        } else {
            LOGGER.log(Level.INFO, "Max 10 ingredients");
            return this;
        }
    }
}
