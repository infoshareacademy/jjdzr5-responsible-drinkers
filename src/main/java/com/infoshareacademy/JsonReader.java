package com.infoshareacademy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JsonReader {

    private Drinks drinks;
    private List<Drink> drinkList;

    public JsonReader() {
        Path path = Paths.get("src", "main", "java", "com", "infoshareacademy", "drinks.json");
        String json = null;
        try {
            json = Files.readString(path);
        } catch (IOException e) {
            System.out.println("File read Error.");
        }

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        try {
            drinks = gson.fromJson(json, Drinks.class);
            drinkList = drinks.getDrinks();
        } catch (JsonSyntaxException jsonSyntaxException) {
            System.out.println("Error parsing Json");
            drinkList = null;
            drinks = null;
        }
    }

    public Drinks getDrinks() {
        return drinks;
    }

    public void setDrinks(Drinks drinks) {
        this.drinks = drinks;
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }
}
