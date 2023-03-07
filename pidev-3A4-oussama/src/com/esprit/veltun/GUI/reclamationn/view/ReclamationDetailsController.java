package com.esprit.veltun.GUI.reclamationn.view;

import com.esprit.veltun.model.Reclamation;

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

public class ReclamationDetailsController implements Initializable {
    public TextField fxstatus;

    public TextField fxobject;
    public DatePicker date_reclamation;

    public TextField fxdescription;
    public Button ftlistEvent;


    public void setFxStatus(String status) {
        this.fxstatus.setText(status);
    }

    public void setFxObject(String object) {
        this.fxobject.setText(object);
    }

    public void setFxDescription(String description) {
        this.fxdescription.setText(description);
    }

    public void setDate_reclamation(LocalDate date){this.date_reclamation.setValue(date);}



    public void setReclamation(Reclamation reclamation) {

        setFxObject(reclamation.getObject());
        setFxDescription(reclamation.getDescription());
        setFxStatus(reclamation.getStatus());
        setDate_reclamation(reclamation.getDate_reclamation().toLocalDate());

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