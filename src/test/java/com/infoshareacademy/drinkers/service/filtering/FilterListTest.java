package com.infoshareacademy.drinkers.service.filtering;

import com.infoshareacademy.drinkers.domain.drink.Drink;
import com.infoshareacademy.drinkers.domain.drink.DrinkBuilder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.list;

class FilterListTest {

    @ParameterizedTest
    @EnumSource(FilterElements.class)
    void getFilteredByIngredient(FilterElements filterElement) {
        // given
        Drink drink1 = new DrinkBuilder().setID(1).setName("ignorable").setIngredient01(filterElement.getName()).build();
        Drink drink2 = new DrinkBuilder().setID(2).setName("ignorable").setIngredient02("ignorable").build();
        Drink drink3 = new DrinkBuilder().setID(3).setName("ignorable").setIngredient03("ignorable").build();
        List<Drink> drunkList = new ArrayList<>();
        drunkList.add(drink1);
        drunkList.add(drink2);
        drunkList.add(drink3);
        FilterList filterList = new FilterList(drunkList);
        // when
        FilterList filteredByIngredient = filterList.getFilteredByIngredient(filterElement);
        // then
        assertThat(filteredByIngredient)
                .extracting(FilterList::getResults, list(Drink.class))
                .hasSize(1)
                .containsExactly(drink1);
    }
}