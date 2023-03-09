package com.esprit.veltun.GUI.offree.search;


//import com.esprit.veltun.gui.invitation.create.InvitationCreateController;
import com.esprit.veltun.model.Offre;
import com.esprit.veltun.model.Event;
import com.esprit.veltun.search.dto.AbonnementSearchCriteria;
import com.esprit.veltun.search.dto.EventSearchCriteria;
import com.esprit.veltun.search.dto.OffreSearchCriteria;
import com.esprit.veltun.services.AbonnementService;
import com.esprit.veltun.services.EventService;
import com.esprit.veltun.services.OffreService;
import com.esprit.veltun.services.impl.AbonnementServiceImpl;
import com.esprit.veltun.services.impl.EventServiceImpl;
import com.esprit.veltun.services.impl.OffreServiceImpl;
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
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;

public class OffreSearchController implements Initializable {
    public TextField titletosearch;
    public Label fxrs;
    public Button searchbutton;
<<<<<<< HEAD
    public Button aS;
=======
>>>>>>> 63d3b7b43f9286d0ef9f6e147e0afbee11949b26
    private OffreService offreService = new OffreServiceImpl();
    public ListView<Offre> eventlistview;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        eventlistview.setCellFactory(param -> {
            return new ListCell<Offre>(){
                public void updateItem(Offre abonnement, boolean empty) {
                    super.updateItem(abonnement, empty);
                    if (empty || abonnement == null) {
                        setText(null);
                    } else {
                        setText(abonnement.getDescription_of());
                    }
                }
            };
        });
        runSearch();
    }

    void runSearch() {
        String desc = titletosearch.getText();
        OffreSearchCriteria offreSearchCriteria = new OffreSearchCriteria();
        if (desc != null && !desc.isEmpty()) {
            offreSearchCriteria.setDescription_of(String.valueOf(desc));
        }
        Collection<Offre> offres = offreService.search(offreSearchCriteria);
        eventlistview.getItems().setAll(offres);
    }

    @FXML
    void removeEvent(ActionEvent mouseEvent) {
        Offre offre = eventlistview.getSelectionModel().getSelectedItem();
        int selectionIndex = eventlistview.getSelectionModel().getSelectedIndex();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure you want to delete this offer?");
        alert.setContentText("Click OK to confirm.");


        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK){
            offreService.remove(offre.getId_offre());
            eventlistview.getItems().remove(selectionIndex);

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Delete");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Offer deleted");
            successAlert.showAndWait();
        }
    }

    @FXML
    void editEvent(ActionEvent mouseEvent) {
        Offre offre = eventlistview.getSelectionModel().getSelectedItem();


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure you want to update this offer?");
        alert.setContentText("Click OK to confirm.");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../update/updateof.fxml"));

            try {
                Parent root = fxmlLoader.load();

                Stage thisStage = (Stage) searchbutton.getScene().getWindow();
                thisStage.setTitle("Update Offer");

                com.esprit.veltun.GUI.offree.update.EventUpdateController cont = fxmlLoader.getController();
                cont.setOffre(offre);

                eventlistview.getScene().setRoot(root);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @FXML
    void addEvent(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure you want to create a new offer?");
        alert.setContentText("Click OK to confirm.");


        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../create/creatof.fxml"));

            Stage thisStage = (Stage) searchbutton.getScene().getWindow();
            thisStage.setTitle("Offer creation");

            try {
                Parent root = fxmlLoader.load();
                eventlistview.getScene().setRoot(root);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }}
    }

    public void search(ActionEvent actionEvent) {
        runSearch();
    }

<<<<<<< HEAD
    @FXML
    void R(ActionEvent actionEvent) {
        Offre offre = eventlistview.getSelectionModel().getSelectedItem();
        OffreServiceImpl.l=offre.getId_offre();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure you want to create a new offer?");
        alert.setContentText("Click OK to confirm.");


        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../abonnementt/create/Create.fxml"));

            Stage thisStage = (Stage) searchbutton.getScene().getWindow();
            thisStage.setTitle("Offer creation");

            try {
                Parent root = fxmlLoader.load();
                eventlistview.getScene().setRoot(root);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }}
    }
=======

>>>>>>> 63d3b7b43f9286d0ef9f6e147e0afbee11949b26
}
