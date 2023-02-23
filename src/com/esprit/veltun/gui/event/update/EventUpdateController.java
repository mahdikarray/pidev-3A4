package com.esprit.veltun.gui.event.update;

import com.esprit.veltun.gui.event.view.EventDetailsController;
import com.esprit.veltun.model.Adresse;
import com.esprit.veltun.model.Event;
import com.esprit.veltun.services.AdresseService;
import com.esprit.veltun.services.EventService;
import com.esprit.veltun.services.impl.AdresseServiceImpl;
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

    private AdresseService adresseService = new AdresseServiceImpl();
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

    public void setAdresseRegion(String aresseregion) {
        this.tfadresseregion.setText(aresseregion);
    }

    public void setAdresseRue(String adresserue) {
        this.tfadresserue.setText(adresserue);
    }

    public void setEvent(Event event) {
        this.event= event;
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
    public void updateEvent(ActionEvent actionEvent) {
        String titre= tftitre.getText();
        String description=tfdescription.getText();
        Date dateDebut = Date.valueOf(tfdatedebut.getValue());
        Time heureDebut = Time.valueOf(tfheuredebut.getText());
        Date dateFin = Date.valueOf(tfdatefin.getValue());
        Time heurefin = Time.valueOf(tfheurefin.getText());

        event.setTitre(titre);
        event.setDescription(description);
        event.setDateDebut(dateDebut);
        event.setHeureDebut(heureDebut);
        event.setDateFin(dateFin);
        event.setHeureFin(heurefin);
        Adresse adresse;
        if (event.getAdresse() != null && event.getAdresse().getId() != null && event.getAdresse().getId()>0) {
            adresse = event.getAdresse();
        } else {
            adresse = new Adresse();
        }
        adresse.setRue(tfadresserue.getText());
        adresse.setRegion(tfadresseregion.getText());
        event.setAdresse(adresse.getId() != null ? adresseService.update(adresse) : adresseService.save(adresse));
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
