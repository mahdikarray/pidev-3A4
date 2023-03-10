package com.esprit.veltun.gui.rackStation.rackvelo.search;


//import com.esprit.veltun.gui.invitation.create.InvitationCreateController;

import com.esprit.veltun.model.RackVelo;
import com.esprit.veltun.search.dto.RackveloSearchCriteria;
import com.esprit.veltun.services.impl.RackVeloImpl;
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

public class RackveloSearchController implements Initializable {
    public TextField titletosearch;
    public Button searchbutton;

    private RackVeloImpl rackService = new RackVeloImpl() ;
    public ListView<RackVelo> rackvelolistview;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rackvelolistview.setCellFactory(param -> new ListCell<RackVelo>(){
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
        String refRack = titletosearch.getText();
        RackveloSearchCriteria RackveloSearchCriteria = new RackveloSearchCriteria();
        if (refRack != null && !refRack.isEmpty()) {
            RackveloSearchCriteria.setRefRack(Integer.parseInt(refRack));
        }
        Collection<RackVelo> rackvelo = rackService.search(RackveloSearchCriteria);
        rackvelolistview.getItems().setAll(rackvelo);
    }

    @FXML
    void removeRackvelo(ActionEvent mouseEvent) {
        RackVelo rackvelo = rackvelolistview.getSelectionModel().getSelectedItem();
        int selectionIndex = rackvelolistview.getSelectionModel().getSelectedIndex();
        rackService.remove(rackvelo.getRefRack());
        rackvelolistview.getItems().remove(selectionIndex);
    }

    @FXML
    void editRackvelo(ActionEvent mouseEvent) {
        RackVelo rackvelo = rackvelolistview.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../update/update.fxml"));

        try {
            Parent root = fxmlLoader.load();

            Stage thisStage = (Stage) searchbutton.getScene().getWindow();
            thisStage.setTitle("Mise à jour d'une station");

            com.esprit.veltun.gui.rackStation.rackvelo.view.RackveloDetailsController cont = fxmlLoader.getController();
            cont.setRackvelo(rackvelo);

            rackvelolistview.getScene().setRoot(root);
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
            rackvelolistview.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void search(ActionEvent actionEvent) {
        runSearch();
    }
    private Stage stage ;
    private Scene scene ;

    private Parent root;

    public void switchToRacksFromList(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../../backend/racksCRUDinterface.fxml")) ;
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }
}
