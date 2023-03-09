package com.esprit.veltun.gui.event.weather;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherService {

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm").create();

    Request request;
    Response response;


    private static final String API_KEY = "b1b15e88fa797225412429c1c50c122a1";
    private static final String API_ENDPOINT = "https://api.open-meteo.com/v1/forecast?latitude=36.8992683&longitude=10.1894231&current_weather=true";

    private OkHttpClient client;

    public WeatherService() {
        client = new OkHttpClient();
    }

    public WeatherData getMeteoData() throws Exception {
        request = new Request.Builder()
                .url(API_ENDPOINT)
                .build();

        response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new Exception("API request failed");
        };
        WeatherData weatherData = gson.fromJson(response.body().string(), WeatherData.class);
        return weatherData;
    }
}
