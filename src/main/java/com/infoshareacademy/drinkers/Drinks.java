package com.infoshareacademy.drinkers;

import java.util.List;
import java.util.Objects;

public class Drinks {
    private List<Drink> drinks;

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drinks drinks1 = (Drinks) o;
        return Objects.equals(drinks, drinks1.drinks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drinks);
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "drinks=" + drinks +
                '}';
    }
}
