package com.esprit.veltun.GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Reclamation extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("reclamation.fxml"));
            Scene scene = new Scene(root);

            primaryStage.setTitle("reclamation");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }


    }


    public void DeleteRec(ActionEvent actionEvent) {
    }

    public void ModifRec(ActionEvent actionEvent) {
    }

    public void addRec(ActionEvent actionEvent) {
    }
}

