package com.esprit.veltun.GUI.reclamationn.update;

import com.esprit.veltun.GUI.reclamationn.view.ReclamationDetailsController;

import com.esprit.veltun.model.Reclamation;
import com.esprit.veltun.services.ReclamationService;

import com.esprit.veltun.services.impl.ReclamationServiceImpl;

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
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class ReclamationUpdateController implements Initializable {
    public Button cancelbutton;
    private ReclamationService reclamationService = new ReclamationServiceImpl();

    private Reclamation reclamation;

    public TextField fxstatus;

    public TextField fxobject;
    public DatePicker date_reclamationn;

    public TextField fxdescription;



    public void setFxStatus(String status) {
        this.fxstatus.setText(status);
    }

    public void setFxobject(String object) {
        this.fxobject.setText(object);
    }

    public void setFxdescription(String description) {
        this.fxdescription.setText(description);
    }

    public void setDate_reclamationn(LocalDate date){this.date_reclamationn.setValue(date);}



    public void setReclamation(Reclamation reclamation) {
        this.reclamation= reclamation;
        setFxobject(reclamation.getObject());
        setFxdescription(reclamation.getDescription());
        setFxStatus(reclamation.getStatus());
        setDate_reclamationn(reclamation.getDate_reclamation().toLocalDate());


    }
    public void updateEvent(ActionEvent actionEvent) {
        String object=fxobject.getText();
        String description=fxdescription.getText();
        String status= fxstatus.getText();
        Date date_reclamation = Date.valueOf(date_reclamationn.getValue());

        Reclamation a= new Reclamation();

        reclamation.setObject(object);
        reclamation.setDescription(description);
        reclamation.setStatus(status);
        reclamation.setDate_reclamation(date_reclamation);




        reclamation = reclamationService.update(reclamation);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/details.fxml"));

       /* try {
            Parent root = fxmlLoader.load();

            ReclamationDetailsController cont = fxmlLoader.getController();
            cont.setReclamation(reclamation);

            fxtype.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }*/
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
            fxstatus.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
