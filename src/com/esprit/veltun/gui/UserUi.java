package com.esprit.veltun.gui;

import com.esprit.veltun.services.InvitationService;
import com.esprit.veltun.services.impl.InvitationServiceImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserUi extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       //Parent root = FXMLLoader.load(getClass().getResource("User/search/search.fxml"));
 //      Parent root = FXMLLoader.load(getClass().getResource("Wallet/search/search.fxml"));
       Parent root = FXMLLoader.load(getClass().getResource("User/LogIn/LogIn.fxml"));
//       //p//rimaryStage.setTitle("Gestion des wallets");
   //     Parent root = FXMLLoader.load(getClass().getResource("reclamationn/search/search.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
