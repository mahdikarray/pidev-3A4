package com.esprit.veltun.gui.velo.view;

import com.esprit.veltun.model.Velo;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VeloDetailsController implements Initializable {
    public TextField ftlibelle;
    public TextField fttaille;
    public TextField ftcouleur;
    public TextField ftfournisseur;

    public Button tflistVelo;


    public void setTextNom(String livellev) {
        this.ftlibelle.setText(livellev);
    }

    public void setTextRegion(String taillev) {
        this.fttaille.setText(taillev);
    }

    public void setTextCouleur(String couleurv) {
        this.ftcouleur.setText(couleurv);
    }

    public void setTextFournisseur(Integer idf) {
        this.ftfournisseur.setText(String.valueOf(idf));
    }


    public void setVelo(Velo velo) {
        setTextNom(velo.getLibelle());
        setTextRegion(velo.getTaille());
        setTextCouleur(velo.getCouleur());
        setTextFournisseur(velo.getIdf());
        

    }


    public void listVelo (ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/search.fxml"));
        try{
            Parent root= fxmlLoader.load();
            tflistVelo.getScene().setRoot(root);

        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}