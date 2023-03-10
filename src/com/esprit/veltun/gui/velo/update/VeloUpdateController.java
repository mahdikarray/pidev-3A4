package com.esprit.veltun.gui.velo.update;

import com.esprit.veltun.model.Velo;
import com.esprit.veltun.services.impl.VeloServiceImpl;
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

public class VeloUpdateController<VeloDetailsController> implements Initializable {
    public Button cancelbutton;



    private Velo velo;

    public TextField tflibelle;
    public TextField tftaille;
    public TextField tfcouleur;

    public TextField tffournisseur;

    public void setTextNom(String libelle) {
        this.tflibelle.setText(libelle);
    }

    public void setTextDescription(String taille) {
        this.tftaille.setText(taille);
    }

    public void setTextCouleur(String couleur) {
        this.tfcouleur.setText(couleur);
    }
    public void setTextFournisseur(Integer idf) {
        this.tffournisseur.setText(String.valueOf(idf));
    }


    public void setVelo(Velo velo) {
        this.velo= velo;
        setTextNom(velo.getLibelle());
        setTextDescription(velo.getTaille());
        setTextCouleur(velo.getCouleur());
        setTextFournisseur(velo.getIdf());
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

    }

    public void cancel(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

        try {
            Parent root = fxmlLoader.load();
            tflibelle.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void updateVelo(ActionEvent actionEvent) {{
        String libellev = tflibelle.getText() ;
        String taillev = tftaille.getText();
        String couleurv = tfcouleur.getText();
        int idf =Integer.parseInt(tffournisseur.getText());

        velo.setLibelle(libellev);
        velo.setTaille(taillev);
        velo.setCouleur(couleurv);
        velo.setIdf(idf);

VeloServiceImpl veloService=new VeloServiceImpl();
        velo = veloService.update(velo);




        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/details.fxml"));







        try {
            Parent root = fxmlLoader.load();

            com.esprit.veltun.gui.velo.view.VeloDetailsController cont = fxmlLoader.getController();
            cont.setVelo(velo);

            tflibelle.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    }
}
