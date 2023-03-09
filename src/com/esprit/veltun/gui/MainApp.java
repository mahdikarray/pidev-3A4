package com.esprit.veltun.gui;

import com.esprit.veltun.model.Velo;
import com.esprit.veltun.util.MyConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;



public class MainApp extends Application {



        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws Exception {

            Parent root = FXMLLoader.load(getClass().getResource("velo/frontv/frontv.fxml"));
            primaryStage.setTitle("BIKE");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }
    }
