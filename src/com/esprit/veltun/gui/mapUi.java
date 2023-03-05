package com.esprit.veltun.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class mapUi extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a WebView to display the map
        WebView webView = new WebView();

        // Create a WebEngine to manage the map content
        WebEngine webEngine = webView.getEngine();

        // Load the Google Maps URL with the desired location
        String location = "Paris, France";
        webEngine.load("https://www.google.com/maps/embed/v1/place?q=" + location);

        // Create a stack pane to hold the map
        StackPane root = new StackPane();
        root.getChildren().add(webView);

        // Create the scene and set the root node
        Scene scene = new Scene(root, 800, 600);

        // Set the stage title and scene, then show the stage
        primaryStage.setTitle("Map Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}