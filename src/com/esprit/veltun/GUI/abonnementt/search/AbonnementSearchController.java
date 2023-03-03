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
        abonnementService.remove(abonnement.getId_ab());
        eventlistview.getItems().remove(selectionIndex);
    }

    @FXML
    void editEvent(ActionEvent mouseEvent) {
        Abonnement abonnement = eventlistview.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../update/update.fxml"));

        try {
            Parent root = fxmlLoader.load();

            Stage thisStage = (Stage) searchbutton.getScene().getWindow();
            thisStage.setTitle("Mise à jour d'un abonnement");

            com.esprit.veltun.GUI.abonnementt.update.AbonnementUpdateController cont = fxmlLoader.getController();
            cont.setAbonnement(abonnement);

            eventlistview.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    void addEvent(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../create/create.fxml"));

        Stage thisStage = (Stage) searchbutton.getScene().getWindow();
        thisStage.setTitle("Création d'un abonnement");

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
