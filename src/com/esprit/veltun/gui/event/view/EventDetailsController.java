package com.esprit.veltun.gui.event.view;

import com.esprit.veltun.model.Event;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EventDetailsController implements Initializable {
    public TextField fttitre;
    public TextField ftdescription;
    public DatePicker tfdatedebut;
    public TextField tfheuredebut;
    public DatePicker tfdatefin;
    public TextField tfheurefin;
    public Button ftlistEvent;
    public TextField tfadresserue;
    public TextField tfadresseregion;


    public void setTextTitre(String titre) {
        this.fttitre.setText(titre);
    }

    public void setTextDescription(String description) {
        this.ftdescription.setText(description);
    }

    public void setTextDateDebut(LocalDate date) {
        this.tfdatedebut.setValue(date);
    }

    public void setHeuredebut(String heure) {
        this.tfheuredebut.setText(heure);
    }

    public void setTextDateFin(LocalDate date) {
        this.tfdatefin.setValue(date);
    }

    public void setHeureFin(String heure) {
        this.tfheurefin.setText(heure);
    }

    public void setAdresseRegion(String aresseregion) {
        this.tfadresseregion.setText(aresseregion);
    }

    public void setAdresseRue(String adresserue) {
        this.tfadresserue.setText(adresserue);
    }

    public void setEvent(Event event) {
        setTextTitre(event.getTitre());
        setTextDescription(event.getDescription());
        setTextDateDebut(event.getDateDebut().toLocalDate());
        setTextDateFin(event.getDateFin().toLocalDate());
        setHeuredebut(event.getHeureDebut().toString());
        setHeureFin(event.getHeureFin().toString());
        if (event.getAdresse() != null) {
            setAdresseRegion(event.getAdresse().getRegion());
            setAdresseRue(event.getAdresse().getRue());
        }
    }


    public void listEvent(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/search.fxml"));
        try {
            Parent root = fxmlLoader.load();
            ftlistEvent.getScene().setRoot(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}