
package com.esprit.veltun.GUI.maintenancee.search;


//import com.esprit.veltun.gui.invitation.create.InvitationCreateController;
import com.esprit.veltun.model.Maintenance;

import com.esprit.veltun.search.dto.MaintenanceSearchCriteria;
import com.esprit.veltun.services.MaintenanceService;
import com.esprit.veltun.services.impl.MaintenanceServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Comparator;
import java.util.ResourceBundle;

public class MaintenanceSearchController implements Initializable {
    public TextField titletosearch;
    public Button searchbutton;
    public Button tributton;
    private MaintenanceService maintenanceService = new MaintenanceServiceImpl();
    public ListView<Maintenance> eventlistview;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        eventlistview.setCellFactory(param -> {
            return new ListCell<Maintenance>(){
                public void updateItem(Maintenance maintenance, boolean empty) {
                    super.updateItem(maintenance, empty);
                    if (empty || maintenance == null) {
                        setText(null);
                    } else {
                        setText( maintenance.getDescription() + "\t\t" + "\t\t"+maintenance.getStatus() + "\t\t" +"\t\t"+ maintenance.getSubmission_date() );
                    }
                }
            };
        });
        runSearch();
    }

    void runSearch() {
        String status = titletosearch.getText();
        MaintenanceSearchCriteria maintenanceSearchCriteria = new MaintenanceSearchCriteria();
        if (status != null && !status.isEmpty()) {
            maintenanceSearchCriteria.setStatus(status);
        }
        Collection<Maintenance> maintenances = maintenanceService.search(maintenanceSearchCriteria);
        eventlistview.getItems().setAll(maintenances);
    }

    @FXML
    void removeEvent(ActionEvent mouseEvent) {
        Maintenance maintenance = eventlistview.getSelectionModel().getSelectedItem();
        int selectionIndex = eventlistview.getSelectionModel().getSelectedIndex();
        maintenanceService.remove(maintenance.getId_demande());
        eventlistview.getItems().remove(selectionIndex);
    }

    @FXML
    void editEvent(ActionEvent mouseEvent) {
        Maintenance maintenance = eventlistview.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../update/update.fxml"));

        try {
            Parent root = fxmlLoader.load();

            Stage thisStage = (Stage) searchbutton.getScene().getWindow();
            thisStage.setTitle("Mise à jour d'un Maintenance");

            com.esprit.veltun.GUI.maintenancee.update.MaintenanceUpdateController cont = fxmlLoader.getController();
            cont.setMaintenance(maintenance);

            eventlistview.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    void addEvent(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../create/create.fxml"));

        Stage thisStage = (Stage) searchbutton.getScene().getWindow();
        thisStage.setTitle("Création d'un Maintenance");

        try {
            Parent root = fxmlLoader.load();
            eventlistview.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void search(ActionEvent actionEvent) {
        runSearch();
    }
    void runtri() {
        eventlistview.getItems().sort(Comparator.comparing(Maintenance::getSubmission_date));
    }
    public void tri(ActionEvent actionEvent) {
        runtri();
    }
}
