package com.esprit.veltun.GUI.maintenancee.update;

import com.esprit.veltun.GUI.maintenancee.view.MaintenanceDetailsController;

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



    public TextField fxetat;
    public DatePicker date_soumissionn;

    public TextField fxdescription;





    public void setFxetat(String etat) {
        this.fxetat.setText(etat);
    }

    public void setFxdescription(String description) {
        this.fxdescription.setText(description);
    }

    public void setDate_soumissionn(LocalDate date){this.date_soumissionn.setValue(date);}



    public void setMaintenance(Maintenance maintenance) {
        this.maintenance= maintenance;
        setFxdescription(maintenance.getDescription());
        setFxetat(maintenance.getEtat());
        setDate_soumissionn(maintenance.getDate_soumission().toLocalDate());


    }
    public void updateEvent(ActionEvent actionEvent) {
        String description=fxdescription.getText();
        String etat= fxetat.getText();
        Date date_soumission = Date.valueOf(date_soumissionn.getValue());

        Maintenance a1= new Maintenance();

        maintenance.setDescription(description);
        maintenance.setEtat(etat);
        maintenance.setDate_soumission(date_soumission);




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
            fxetat.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
