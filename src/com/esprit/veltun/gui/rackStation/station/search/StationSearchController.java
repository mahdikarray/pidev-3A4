package com.esprit.veltun.gui.rackStation.station.search;


//import com.esprit.veltun.gui.invitation.create.InvitationCreateController;

import com.esprit.veltun.model.Station;
import com.esprit.veltun.search.dto.StationSearchCriteria;
import com.esprit.veltun.services.impl.StationServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class StationSearchController implements Initializable {
    public TextField titletosearch;
    public Button searchbutton;
    private StationServiceImpl stationService = new StationServiceImpl();
    public ListView<Station> stationlistview;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stationlistview.setCellFactory(param -> new ListCell<Station>(){
                public void updateItem(Station station, boolean empty) {
                super.updateItem(station, empty);
                if (empty || station == null) {
                    setText(null);
                } else {
                    setText(station.getid_station() + "\t\t" + "\t\t"+ station.getnom_station() + "\t\t" +"\t\t"+ station.getlongitude() + "\t\t" +"\t\t" + station.getlatitude());
                }
            }
        });
        runSearch();
    }

    void runSearch() {
        String id_station = titletosearch.getText();
        StationSearchCriteria StationSearchCriteria = new StationSearchCriteria();
        if (id_station != null && !id_station.isEmpty()) {
            StationSearchCriteria.setId_station(Integer.parseInt(id_station));
        }
        Collection<Station> station = stationService.search(StationSearchCriteria);
        stationlistview.getItems().setAll(station);

    }

    @FXML
    void removeStation(ActionEvent mouseEvent) {
        Station station = stationlistview.getSelectionModel().getSelectedItem();
        int selectionIndex = stationlistview.getSelectionModel().getSelectedIndex();
        stationService.remove(station.getid_station());
        stationlistview.getItems().remove(selectionIndex);
    }

    @FXML
    void editStation(ActionEvent mouseEvent) {
        Station station = stationlistview.getSelectionModel().getSelectedItem();
        StationServiceImpl.selectedStation=station;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../update/update.fxml"));

        try {
            Parent root = fxmlLoader.load();

            Stage thisStage = (Stage) searchbutton.getScene().getWindow();
            thisStage.setTitle("Update your stations");

            com.esprit.veltun.gui.rackStation.station.update.StationUpdateController cont = fxmlLoader.getController();
            cont.setStation(station);

            stationlistview.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    void addStation(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../create/create.fxml"));

        Stage thisStage = (Stage) searchbutton.getScene().getWindow();
        thisStage.setTitle("Add a station");

        try {
            Parent root = fxmlLoader.load();
            stationlistview.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void search(ActionEvent actionEvent) {
        runSearch();
    }

    private Stage stage ;
    private Scene scene ;

    private Parent root ;
    public void switchToRacksFromList(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../../backend/stationsCRUDinterface.fxml")) ;
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();

    }
}
