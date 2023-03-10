package com.esprit.veltun.gui.fournisseur.view;

import com.esprit.veltun.model.Fournisseur;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FournisseurDetailsController implements Initializable {
    public TextField ftnom;
    public TextField ftregion;
    public Button tflistFourniseur;


    public void setTextNom(String nomf) {
        this.ftnom.setText(nomf);
    }

    public void setTextRegion(String region) {
        this.ftregion.setText(region);
    }



    public void setFourniseur(Fournisseur fourniseur) {
        setTextNom(fourniseur.getNom());
        setTextRegion(fourniseur.getRegion());

    }


    public void listFourniseur (ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/search.fxml"));
        try{
            Parent root= fxmlLoader.load();
            tflistFourniseur.getScene().setRoot(root);

        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}