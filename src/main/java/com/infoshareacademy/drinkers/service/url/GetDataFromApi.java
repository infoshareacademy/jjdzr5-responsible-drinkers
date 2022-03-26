package com.infoshareacademy.drinkers.service.url;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetDataFromApi {

    private static final Logger LOGGER = Logger.getLogger(GetDataFromApi.class.getName());

    public String getData(URI uri) {
        HttpResponse<String> httpResponse;
        HttpClient client = HttpClient.newHttpClient();
        String result = "";

        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (httpResponse.statusCode() == 200) {
                result = httpResponse.body();
            }
        } catch (IOException e) {
            LOGGER.log(Level.INFO, "Error", e);
        } catch (InterruptedException e) {
            LOGGER.log(Level.INFO, "Error", e);
        }
        return result;
    }
}
