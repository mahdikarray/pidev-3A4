package com.esprit.veltun.GUI.maintenancee.view;

import com.esprit.veltun.model.Maintenance;

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

public class MaintenanceDetailsController implements Initializable {
    public TextField fxstatus;

    public DatePicker submission_date;

    public TextField fxdescription;
    public Button ftlistEvent;


    public void setFxStatus(String status) {
        this.fxstatus.setText(status);
    }

    public void setFxDescription(String description) {
        this.fxdescription.setText(description);
    }

    public void setSubmission_datee(LocalDate date){this.submission_date.setValue(date);}



    public void setMaintenance(Maintenance maintenance) {


        setFxDescription(maintenance.getDescription());
        setFxStatus(maintenance.getStatus());
        setSubmission_datee(maintenance.getSubmission_date().toLocalDate());

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