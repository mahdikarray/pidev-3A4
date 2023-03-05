package com.esprit.veltun.gui.event.update;

import com.esprit.veltun.gui.event.view.EventDetailsController;
import com.esprit.veltun.model.Event;
import com.esprit.veltun.services.EventService;
import com.esprit.veltun.services.impl.EventServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class EventUpdateController implements Initializable {
    public Button cancelbutton;
    private EventService eventService = EventServiceImpl.getInstance();

    private Event event;

    public TextField tftitre;
    public TextField tfdescription;
    public DatePicker tfdatedebut;
    public TextField tfheuredebut;
    public DatePicker tfdatefin;
    public TextField tfheurefin;
    public TextField tfadresserue;
    public TextField tfadresseregion;

    public void setTextTitre(String titre) {
        this.tftitre.setText(titre);
    }

    public void setTextDescription(String description) {
        this.tfdescription.setText(description);
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


    public void setTextAdresse(String adresse) {
        this.tfadresserue.setText(adresse);
    }

    public void setEvent(Event event) {
        this.event= event;
        setTextTitre(event.getTitre());
        setTextDescription(event.getDescription());
        setTextDateDebut(event.getDateDebut() != null ?event.getDateDebut().toLocalDate() : null);
        setTextDateFin(event.getDateFin() != null ? event.getDateFin().toLocalDate() : null);
        setHeuredebut(event.getHeureDebut() != null ? event.getHeureDebut().toString():null);
        setHeureFin(event.getHeureFin() != null ? event.getHeureFin().toString():null);
        setTextAdresse(event.getAdresse() != null ? event.getAdresse().toString() : null);

    }
    public void updateEvent(ActionEvent actionEvent) {
        String titre= tftitre.getText();
        String description=tfdescription.getText();
        Date dateDebut = Date.valueOf(tfdatedebut.getValue());
        Time heureDebut = Time.valueOf(tfheuredebut.getText());
        Date dateFin = Date.valueOf(tfdatefin.getValue());
        Time heurefin = Time.valueOf(tfheurefin.getText());
        String adresse=tfadresserue.getText();

        event.setTitre(titre);
        event.setDescription(description);
        event.setDateDebut(dateDebut);
        event.setHeureDebut(heureDebut);
        event.setDateFin(dateFin);
        event.setHeureFin(heurefin);
        event.setAdresse(adresse);

        event = eventService.update(event);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/details.fxml"));

        try {
            Parent root = fxmlLoader.load();

            EventDetailsController cont = fxmlLoader.getController();
            cont.setEvent(event);

            tftitre.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
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
            tftitre.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
