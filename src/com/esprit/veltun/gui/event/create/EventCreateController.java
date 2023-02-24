package com.esprit.veltun.gui.event.create;

import com.esprit.veltun.gui.event.view.EventDetailsController;
import com.esprit.veltun.model.Adresse;
import com.esprit.veltun.model.Event;
import com.esprit.veltun.services.EventService;
import com.esprit.veltun.services.impl.EventServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;


import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class EventCreateController implements Initializable {
    public Button cancelbutton;
    private EventService eventService = EventServiceImpl.getInstance();

    public TextField tftitre;
    public TextField tfdescription;
    public DatePicker tfdatedebut;
    public TextField tfheuredebut;
    public DatePicker tfdatefin;
    public TextField tfheurefin;
    public TextField tfadresserue;
    public TextField tfadresseregion;

    public void saveEvent(ActionEvent actionEvent) {
        String titre= tftitre.getText();
        String description=tfdescription.getText();
        Date dateDebut = Date.valueOf(tfdatedebut.getValue());
        Time heureDebut = Time.valueOf(tfheuredebut.getText());
        Date dateFin = Date.valueOf(tfdatefin.getValue());
        Time heurefin = Time.valueOf(tfheurefin.getText());
        //alerte controle de saisie
        if (titre.isEmpty() || description.isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("veuillez remplir tous les champs!!");
            alert.showAndWait();
            return;
        }
        if (dateDebut.after(dateFin)  ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("veuillez saisir une date de fin valide!!");
            alert.showAndWait();
            return;
        }


        Event e = new Event();
        e.setTitre(titre);
        e.setDescription(description);
        e.setDateDebut(dateDebut);
        e.setHeureDebut(heureDebut);

        e.setDateFin(dateFin);


        e.setHeureFin(heurefin);
        Adresse adresse = new Adresse();
        adresse.setRue(tfadresserue.getText());
        adresse.setRegion(tfadresseregion.getText());
        e.setAdresse(adresse);
        e = eventService.save(e);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/details.fxml"));

        try {
            Parent root = fxmlLoader.load();

            EventDetailsController cont = fxmlLoader.getController();
            cont.setEvent(e);

            tftitre.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

        try {
            Parent root = Loader.load();

            EventDetailsController cont = fxmlLoader.getController();
            cont.setEvent(e);

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
        //tfheurefin.setTextFormatter(formatter);

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
