package com.infoshareacademy.drinkers.service.url;

import com.google.gson.Gson;
import com.infoshareacademy.drinkers.domain.drink.Drink;
import com.infoshareacademy.drinkers.domain.drink.Drinks;
import com.infoshareacademy.drinkers.service.gson.GsonCreator;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ConnectToApi {

    private static final URI API_ADDRESS_A = URI.create("https://www.thecocktaildb.com/api/json/v1/1/search.php?f=a");
    private static final URI API_ADDRESS_M = URI.create("https://www.thecocktaildb.com/api/json/v1/1/search.php?f=m");
    private static final URI API_ADDRESS_T = URI.create("https://www.thecocktaildb.com/api/json/v1/1/search.php?f=t");
    private static final URI API_ADDRESS_J = URI.create("https://www.thecocktaildb.com/api/json/v1/1/search.php?f=j");
    private static final URI API_ADDRESS_S = URI.create("https://www.thecocktaildb.com/api/json/v1/1/search.php?f=s");

    private List<Drink> drinkListConcat;

    public ConnectToApi() {
        String jsonData0 = getJsonData(API_ADDRESS_A);
        String jsonData1 = getJsonData(API_ADDRESS_M);
        String jsonData2 = getJsonData(API_ADDRESS_T);
        String jsonData3 = getJsonData(API_ADDRESS_J);
        String jsonData4 = getJsonData(API_ADDRESS_S);

        drinkListConcat = drinksConcat(getDrinks(jsonData0),getDrinks(jsonData1));
        drinkListConcat = drinksConcat(drinkListConcat,getDrinks(jsonData2));
        drinkListConcat = drinksConcat(drinkListConcat,getDrinks(jsonData3));
        drinkListConcat = drinksConcat(drinkListConcat,getDrinks(jsonData4));

    }

    private String getJsonData(URI uri) {
        GetDataFromApi getDataFromApi = new GetDataFromApi();
        return getDataFromApi.getData(uri);
    }

    private List<Drink> drinksConcat(List<Drink> listFirst, List<Drink> listSecond) {
        return Stream.concat(listFirst.stream(), listSecond.stream()).toList();
    }

    private List<Drink> getDrinks(String jsonData) {
        Gson gson = GsonCreator.getGson();
        return gson.fromJson(jsonData, Drinks.class).getDrinks();
    }

    public Optional<List<Drink>> getAllDrinks() {
        return Optional.of(Optional.ofNullable(drinkListConcat).orElse(new ArrayList<>()));
    }

}
