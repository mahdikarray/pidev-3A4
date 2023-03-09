package com.esprit.veltun.gui.rackStation.rackvelo.search;


//import com.esprit.veltun.gui.invitation.create.InvitationCreateController;

import com.esprit.veltun.model.RackVelo;
import com.esprit.veltun.search.dto.RackveloSearchCriteria;
import com.esprit.veltun.services.impl.RackVeloImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class RackveloSearchController implements Initializable {
    public TextField titletosearch;
    public Button searchbutton;

    private RackVeloImpl rackService = new RackVeloImpl() ;
    public ListView<RackVelo> rackVeloListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rackVeloListView.setCellFactory(param -> new ListCell<RackVelo>(){
            public void updateItem(RackVelo rackVelo, boolean empty) {
                super.updateItem(rackVelo, empty);
                if (empty || rackVelo == null) {
                    setText(null);
                } else {
                    setText(rackVelo.getRefRack() + "\t\t" + "\t\t"+ rackVelo.getCapacite() + "\t\t" +"\t\t"+ rackVelo.getId_station());
                }
            }
        });
        runSearch();
    }

    void runSearch() {
        String id_station = titletosearch.getText();
        RackveloSearchCriteria rackveloSearchCriteria = new RackveloSearchCriteria();
        if (id_station != null && !id_station.isEmpty()) {
            rackveloSearchCriteria.setRefRack(Integer.parseInt(id_station));
        }
        Collection<RackVelo> rackvelo = rackService.list();
        rackVeloListView.getItems().setAll(rackvelo);
    }

    @FXML
    void removeRackvelo(ActionEvent mouseEvent) {
        RackVelo rackvelo = rackVeloListView.getSelectionModel().getSelectedItem();
        int selectionIndex = rackVeloListView.getSelectionModel().getSelectedIndex();
        rackService.remove(rackvelo.getRefRack());
        rackVeloListView.getItems().remove(selectionIndex);
    }

    @FXML
    void editRackvelo(ActionEvent mouseEvent) {
        RackVelo rackvelo = rackVeloListView.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../update/update.fxml"));

        try {
            Parent root = fxmlLoader.load();

            Stage thisStage = (Stage) searchbutton.getScene().getWindow();
            thisStage.setTitle("Mise à jour d'une station");

            com.esprit.veltun.gui.rackStation.rackvelo.view.RackveloDetailsController cont = fxmlLoader.getController();
            cont.setRackvelo(rackvelo);

            rackVeloListView.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    void addStation(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../create/create.fxml"));

        Stage thisStage = (Stage) searchbutton.getScene().getWindow();
        thisStage.setTitle("Création d'un rack");

        try {
            Parent root = fxmlLoader.load();
            rackVeloListView.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void search(ActionEvent actionEvent) {
        //runSearch();
    }


}
