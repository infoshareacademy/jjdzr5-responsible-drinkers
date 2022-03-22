package com.infoshareacademy.drinkers.service.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;

public class GsonCreator {
    public static Gson getGson () {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder
                .registerTypeAdapter(LocalDateTime.class,new LocalDateTimeDeserializer())
                .registerTypeAdapter(LocalDateTime.class,new LocalDateTimeSerializer())
                .setPrettyPrinting()
                .create();
    }
}
