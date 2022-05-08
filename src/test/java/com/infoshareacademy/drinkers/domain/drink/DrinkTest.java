package com.infoshareacademy.drinkers.domain.drink;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    @Test
    void getIngredients_returnsEmptyList_dueToNullFields() {
        // given
        Drink drink = new Drink();
        // when
        List<String> ingredients = drink.getIngredients();
        // then
        assertThat(ingredients).isEmpty();
    }

    @Test
    void getIngredients_returnsNonEmptyList_withAllStringIngredients() {
        // given
        Drink drink = createDrink();
        String ingr1 = "ingr1";
        String ingr2 = "ingr2";
        drink.setIngredient1(ingr1);
        drink.setIngredient2(ingr2);
//        ...
        // when
        List<String> ingredients = drink.getIngredients();
        // then
        assertThat(ingredients)
                .isNotEmpty()
                .hasSize(2)
                .contains(ingr1, ingr2);
    }

    private Drink createDrink() {
        return null;
    }

    @Test
    void getInstructionList() {
    }

    @Test
    void getStringIntredientrs() {
    }
}
