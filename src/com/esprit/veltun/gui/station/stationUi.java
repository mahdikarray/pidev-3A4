package com.esprit.veltun.gui.station;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class stationUi extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @FXML
    WebView mapFX ;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("station/create/create.fxml"));
        primaryStage.setTitle("Manage your stations ");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();


    }

}

