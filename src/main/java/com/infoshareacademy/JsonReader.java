package com.infoshareacademy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
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


    private Drinks drinks;
    private List<Drink> drinkList;

    private static final Path FILE_JSON = Paths.get("src", "main", "resources", "drinks.json");

    public JsonReader() {
        String json;
        try {
            json = Files.readString(FILE_JSON);
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .create();
            drinks = gson.fromJson(json, Drinks.class);
            drinkList = drinks.getDrinks();
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "File read Error");
            LOGGER.log(Level.INFO, FILE_JSON.toString());
        } catch (InvalidPathException e) {
            LOGGER.log(Level.WARNING, "Path not found");
        } catch (JsonSyntaxException jsonSyntaxException) {
            LOGGER.log(Level.WARNING, "Error parsing Json");
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
