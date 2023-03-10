package com.esprit.veltun.gui.fournisseur.update;

import com.esprit.veltun.gui.fournisseur.view.FournisseurDetailsController;
import com.esprit.veltun.model.Fournisseur;
import com.esprit.veltun.services.FournisseurService;
import com.esprit.veltun.services.impl.FournisseurServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class FournisseurUpdateController<FourniseurDetailsController> implements Initializable {
    public Button cancelbutton;



    private Fournisseur fournisseur;

    public TextField tfnom;
    public TextField tfregion;

    public void setTextNom(String nom) {
        this.tfnom.setText(nom);
    }

    public void setTextDescription(String region) {
        this.tfregion.setText(region);
    }


    public void setFourniseur(Fournisseur fourniseur) {
        this.fournisseur= fourniseur;
        setTextNom(fourniseur.getNom());
        setTextDescription(fourniseur.getRegion());

        }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final Pattern pattern = Pattern.compile("\\d{2}\\:\\d{2}\\:\\d{2}");
        TextFormatter<?> formatter = new TextFormatter<>(change -> {
            if (pattern.matcher(change.getControlNewText()).matches()) {
                // todo: remove error message/markup
                return change; // allow this change to happen
            } else {
                // todo: add error message/markup
                return null; // prevent change
            }
        });

        //tfheuredebut.setTextFormatter(formatter);
    }

    public void cancel(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

        try {
            Parent root = fxmlLoader.load();
            tfnom.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void updateFourniseur(ActionEvent actionEvent) {{
        String nomf = tfnom.getText() ;
        String regionf = tfregion.getText();
        fournisseur.setNom(nomf);
        fournisseur.setRegion(regionf);

FournisseurService fourniseurService=new FournisseurServiceImpl();
        fournisseur = fourniseurService.update(fournisseur);




        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/details.fxml"));







        try {
            Parent root = fxmlLoader.load();

            FournisseurDetailsController cont = fxmlLoader.getController();
            cont.setFourniseur(fournisseur);

            tfnom.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    }


}
