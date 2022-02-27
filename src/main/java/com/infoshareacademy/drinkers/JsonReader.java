package com.infoshareacademy.drinkers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonReader {

    private static final Logger LOGGER = Logger.getLogger(JsonReader.class.getName());
    private static final Path FILE_JSON = Paths.get("src", "main", "resources", "drinks.json");

    private Drinks drinks;
    private List<Drink> drinkList;

    public JsonReader() {
        String json;
        try {
            json = Files.readString(FILE_JSON);
            Gson gson = GsonCreator.getGson();

            drinks = gson.fromJson(json, Drinks.class);
            drinkList = drinks.getDrinks();
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "File read Error");
            LOGGER.log(Level.INFO, FILE_JSON.toString());
        } catch (InvalidPathException e) {
            LOGGER.log(Level.WARNING, "Path not found");
        } catch (JsonSyntaxException jsonSyntaxException) {
            LOGGER.log(Level.WARNING, "Error parsing Json");
            drinkList = new ArrayList<>();
            drinks = new Drinks();
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

    public String getJson(List<Drink> drinkList) {
        Drinks drinks = new Drinks();
        if (drinkList != null) {
            drinks.setDrinks(drinkList);
            Gson gson = GsonCreator.getGson();

            return gson.toJson(drinks);
        } else {
            throw new RuntimeException("Empty entry class");
        }
    }
}
