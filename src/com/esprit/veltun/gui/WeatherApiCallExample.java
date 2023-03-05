package com.esprit.veltun.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApiCallExample {
    public static void main(String[] args) throws IOException {
        String city = "Tunis";
        String countryCode = "tn";
        String apiKey = "ca767bbf2af863b8366f0fa2f7a31bb2"; // Replace with your actual API key

        // Create the API endpoint URL
        String apiUrl = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s,%s&appid=%s", city, countryCode, apiKey);

        // Create an HTTP connection to the API endpoint
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Read the API response
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Print the API response
        System.out.println(response.toString());
    }
}

