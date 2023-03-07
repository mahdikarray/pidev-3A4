package com.esprit.veltun.GUI.reclamationn.search;


//import com.esprit.veltun.gui.invitation.create.InvitationCreateController;
import com.esprit.veltun.model.Reclamation;

import com.esprit.veltun.search.dto.ReclamationSearchCriteria;
import com.esprit.veltun.search.dto.ReclamationSearchCriteria;
import com.esprit.veltun.services.ReclamationService;
import com.esprit.veltun.services.impl.ReclamationServiceImpl;
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
import java.util.ResourceBundle;

public class ReclamationSearchController implements Initializable {
    public TextField titletosearch;
    public Button searchbutton;
    private ReclamationService reclamationService = new ReclamationServiceImpl();
    public ListView<Reclamation> eventlistview;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        eventlistview.setCellFactory(param -> {
            return new ListCell<Reclamation>(){
                public void updateItem(Reclamation reclamation, boolean empty) {
                    super.updateItem(reclamation, empty);
                    if (empty || reclamation == null) {
                        setText(null);
                    } else {
                        setText(reclamation.getObject() + "\t\t" + "\t\t"+ reclamation.getDescription() + "\t\t" + "\t\t"+reclamation.getStatus() + "\t\t" +"\t\t"+ reclamation.getDate_reclamation() );
                    }
                }
            };
        });
        runSearch();
    }

    void runSearch() {
        String status = titletosearch.getText();
        ReclamationSearchCriteria reclamationSearchCriteria = new ReclamationSearchCriteria();
        if (status != null && !status.isEmpty()) {
            reclamationSearchCriteria.setStatus(status);
        }
        Collection<Reclamation> reclamations = reclamationService.search(reclamationSearchCriteria);
        eventlistview.getItems().setAll(reclamations);
    }

    @FXML
    void removeEvent(ActionEvent mouseEvent) {
        Reclamation reclamation = eventlistview.getSelectionModel().getSelectedItem();
        int selectionIndex = eventlistview.getSelectionModel().getSelectedIndex();
        reclamationService.remove(reclamation.getId_reclamation());
        eventlistview.getItems().remove(selectionIndex);
    }

    @FXML
    void editEvent(ActionEvent mouseEvent) {
        Reclamation reclamation = eventlistview.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../update/update.fxml"));

        try {
            Parent root = fxmlLoader.load();

            Stage thisStage = (Stage) searchbutton.getScene().getWindow();
            thisStage.setTitle("Mise à jour d'un reclamation");

            com.esprit.veltun.GUI.reclamationn.update.ReclamationUpdateController cont = fxmlLoader.getController();
            cont.setReclamation(reclamation);

            eventlistview.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    void addEvent(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../create/create.fxml"));

        Stage thisStage = (Stage) searchbutton.getScene().getWindow();
        thisStage.setTitle("Création d'un reclamation");

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


}
