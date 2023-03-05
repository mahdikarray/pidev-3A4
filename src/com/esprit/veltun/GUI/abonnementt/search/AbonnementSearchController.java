package com.esprit.veltun.GUI.abonnementt.search;


//import com.esprit.veltun.gui.invitation.create.InvitationCreateController;
import com.esprit.veltun.model.Abonnement;
import com.esprit.veltun.search.dto.AbonnementSearchCriteria;
import com.esprit.veltun.services.AbonnementService;
import com.esprit.veltun.services.impl.AbonnementServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Optional;
import java.util.ResourceBundle;

public class AbonnementSearchController implements Initializable {
    public TextField titletosearch;
    public Button searchbutton;
    public Button tooffer;
    private AbonnementService abonnementService = new AbonnementServiceImpl();
    public ListView<Abonnement> eventlistview;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        eventlistview.setCellFactory(param -> {
            return new ListCell<Abonnement>(){
                public void updateItem(Abonnement abonnement, boolean empty) {
                    super.updateItem(abonnement, empty);
                    if (empty || abonnement == null) {
                        setText(null);
                    } else {
                        setText(abonnement.getType_ab() + "\t\t" + "\t\t"+ abonnement.getDateDebut() + "\t\t" + "\t\t"+abonnement.getDateFin() + "\t\t" +"\t\t"+ abonnement.getPrix_ab());
                    }
                }
            };
        });
        runSearch();

    }

    void runSearch() {
        String Type_ab = titletosearch.getText();
        AbonnementSearchCriteria abonnementSearchCriteria = new AbonnementSearchCriteria();
        if (Type_ab != null && !Type_ab.isEmpty()) {
            abonnementSearchCriteria.setType_ab(Type_ab);
        }
        Collection<Abonnement> abonnements = abonnementService.search(abonnementSearchCriteria);
        eventlistview.getItems().setAll(abonnements);
    }

    @FXML
    void removeEvent(ActionEvent mouseEvent) {
        Abonnement abonnement = eventlistview.getSelectionModel().getSelectedItem();
        int selectionIndex = eventlistview.getSelectionModel().getSelectedIndex();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure you want to remove this subscription?");
        alert.setContentText("Subscription Type: " + abonnement.getType_ab() + "\nSubscription Start Date: " + abonnement.getDateDebut().toString() + "\nSubscription End Date: " + abonnement.getDateFin().toString()+ "\nSubscription Price: " + abonnement.getPrix_ab());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            abonnementService.remove(abonnement.getId_ab());
            eventlistview.getItems().remove(selectionIndex);
        } else {
            // User clicked Cancel or closed the dialog
        }
    }

    @FXML
    void editEvent(ActionEvent mouseEvent) {
        Abonnement abonnement = eventlistview.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure you want to update this subscription?");
        alert.setContentText("Subscription Type: " + abonnement.getType_ab() + "\nSubscription Start Date: " + abonnement.getDateDebut().toString() + "\nSubscription End Date: " + abonnement.getDateFin().toString()+ "\nSubscription Price: " + abonnement.getPrix_ab());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../update/update.fxml"));

            try {
                Parent root = fxmlLoader.load();

                Stage thisStage = (Stage) searchbutton.getScene().getWindow();
                thisStage.setTitle("Update subscription");

                com.esprit.veltun.GUI.abonnementt.update.AbonnementUpdateController cont = fxmlLoader.getController();
                cont.setAbonnement(abonnement);

                eventlistview.getScene().setRoot(root);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else {
            // User clicked Cancel or closed the dialog
        }
    }

    @FXML
    void addEvent(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure you want to create a new subscription?");
        alert.setContentText("Ok to create.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../create/create.fxml"));

            Stage thisStage = (Stage) searchbutton.getScene().getWindow();
            thisStage.setTitle("creation of subscription");

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


    public void tooffer(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../offree/search/searchof.fxml"));
        try {
            Parent root = fxmlLoader.load();
            tooffer.getScene().setRoot(root);
        } catch (IOException ex)
        {
            System.out.println(ex);
        }

    }
}
