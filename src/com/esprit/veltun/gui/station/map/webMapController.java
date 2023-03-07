package com.esprit.veltun.gui.station.map;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class webMapController {

    @FXML
    private ImageView mapView;

    private final String API_KEY = "pk.eyJ1IjoibWFsZWt6YWlkaSIsImEiOiJjbGVvamRjOGYwMnhwM3ZvMXNnamc0MHVzIn0.eLHD_XEu1Wev8OUfe4eD-Q";

    @FXML
    public void onSharePositionClicked() {
        try {
            // Obtenir la position géographique à partir de l'adresse IP de l'utilisateur
            URL url = new URL("https://ipinfo.io/json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                Scanner scanner = new Scanner(connection.getInputStream());
                String response = scanner.useDelimiter("\\A").next();
                scanner.close();
                JSONObject json = new JSONObject(response);
                String loc = json.getString("loc");
                String[] parts = loc.split(",");
                double lat = Double.parseDouble(parts[0]);
                double lon = Double.parseDouble(parts[1]);

                // Récupère l'image de la carte statique centrée sur la position de l'utilisateur
                String imageUrl = "https://api.mapbox.com/styles/v1/mapbox/streets-v11/static/" +
                        "pin-s+9ed4bd(" + lon + "," + lat + ")/" + lon + "," + lat + ",14/600x400" +
                        "?access_token=" + API_KEY;

                url = new URL(imageUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    scanner = new Scanner(connection.getInputStream());
                    response = scanner.useDelimiter("\\A").next();
                    scanner.close();
                    Image image = new Image(imageUrl);
                    mapView.setImage(image);
                } else {
                    System.out.println("Erreur lors de la récupération de l'image de la carte.");
                }
            } else {
                System.out.println("Erreur lors de la récupération de la position de l'utilisateur.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}