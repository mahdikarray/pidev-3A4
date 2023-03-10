package com.esprit.veltun.gui.maintenancee.update;

import com.esprit.veltun.gui.maintenancee.view.MaintenanceDetailsController;

import com.esprit.veltun.model.Maintenance;
import com.esprit.veltun.services.MaintenanceService;

import com.esprit.veltun.services.impl.MaintenanceServiceImpl;

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

public class MaintenanceUpdateController implements Initializable {
    public Button cancelbutton;
    private MaintenanceService maintenanceService = new MaintenanceServiceImpl();

    private Maintenance maintenance;



    public TextField fxstatus;
    public DatePicker submission_datee;

    public TextField fxdescription;





    public void setFxStatus(String status) {
        this.fxstatus.setText(status);
    }

    public void setFxdescription(String description) {
        this.fxdescription.setText(description);
    }

    public void setSubmission_datee(LocalDate date){this.submission_datee.setValue(date);}



    public void setMaintenance(Maintenance maintenance) {
        this.maintenance= maintenance;
        setFxdescription(maintenance.getDescription());
        setFxStatus(maintenance.getStatus());
        setSubmission_datee(maintenance.getSubmission_date().toLocalDate());


    }
    public void updateEvent(ActionEvent actionEvent) {
        String description=fxdescription.getText();
        String status= fxstatus.getText();
        Date submission_date = Date.valueOf(submission_datee.getValue());

        Maintenance a1= new Maintenance();

        maintenance.setDescription(description);
        maintenance.setStatus(status);
        maintenance.setSubmission_date(submission_date);




        maintenance = maintenanceService.update(maintenance);

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
