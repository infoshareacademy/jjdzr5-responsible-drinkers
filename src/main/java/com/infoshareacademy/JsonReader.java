package com.infoshareacademy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonReader {

    private Drinks drinks;
    private List<Drink> drinkList;

    private static final String JSON_FILE_NAME = "drinks.json";

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public JsonReader() {
        String json = null;

        try {
        Path path = Paths.get(Objects.requireNonNull(App.class.getClassLoader().getResource(JSON_FILE_NAME)).getPath());
       //     Path path = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "drinks.json");
            json = Files.readString(path);
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "File read Error");
        } catch (InvalidPathException e) {
            LOGGER.log(Level.WARNING, "Path not found");
        }

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        try {
            drinks = gson.fromJson(json, Drinks.class);
            drinkList = drinks.getDrinks();
        } catch (JsonSyntaxException jsonSyntaxException) {
            LOGGER.log(Level.WARNING, "Error parsing Json");
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
