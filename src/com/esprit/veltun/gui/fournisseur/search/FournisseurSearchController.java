package com.esprit.veltun.gui.fournisseur.search;


//import com.esprit.veltun.gui.;
//import com.esprit.veltun.gui.fournisseur.view.FournisseurDetailsControllerview;
//import com.esprit.veltun.gui.invitation.create.InvitationCreateController;
import com.esprit.veltun.gui.fournisseur.update.FournisseurUpdateController;
import com.esprit.veltun.model.Fournisseur;
import com.esprit.veltun.search.dto.FournisseurSearchCriteria;
import com.esprit.veltun.services.FournisseurService;
import com.esprit.veltun.services.impl.FournisseurServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class FournisseurSearchController implements Initializable {
    public TextField titletosearch;
    public Button searchbutton;
    public Button editeventbutton;
    public Button toHome;
    private FournisseurService fournisseurService = new FournisseurServiceImpl();
    public ListView<Fournisseur> fournisseurlistview;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fournisseurlistview.setCellFactory(param -> {
            return new ListCell<Fournisseur>(){
                public void updateItem(Fournisseur fournisseur, boolean empty) {
                    super.updateItem(fournisseur, empty);
                    if (empty || fournisseur == null) {
                        setText(null);
                    } else {
                        setText(fournisseur.getNom() + "\t\t" + fournisseur.getRegion());
                    }
                }
            };
        });
        runSearch();
    }

    void runSearch() {
        String nomf = titletosearch.getText();
        FournisseurSearchCriteria fournisseurSearchCriteria = new FournisseurSearchCriteria();
        if (nomf != null && !nomf.isEmpty()) {
            fournisseurSearchCriteria.setNom(nomf);
        }
        Collection<Fournisseur> fournisseurs = fournisseurService.search(fournisseurSearchCriteria);
        fournisseurlistview.getItems().setAll(fournisseurs);
    }

    @FXML
    void removeEvent(ActionEvent mouseEvent) {
        Fournisseur fournisseurs = fournisseurlistview.getSelectionModel().getSelectedItem();
        int selectionIndex = fournisseurlistview.getSelectionModel().getSelectedIndex();
        fournisseurService.remove(fournisseurs.getId());
        fournisseurlistview.getItems().remove(selectionIndex);
        addNotifications("Succes", "Fournisseur supprimé");

    }

    @FXML
    void editEvent(ActionEvent mouseEvent) {

    }

    @FXML
    void addFournisseur (ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../create/create.fxml"));

        Stage thisStage = (Stage) searchbutton.getScene().getWindow();
        thisStage.setTitle("Création d'un fournisseur");

        try {
            Parent root = fxmlLoader.load();
            fournisseurlistview.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    public void search(ActionEvent actionEvent) { runSearch();
    }

    public void editFourniseur(ActionEvent actionEvent) {
        Fournisseur fournisseur = fournisseurlistview.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../update/update.fxml"));

        try {
            Parent root = fxmlLoader.load();

            Stage thisStage = (Stage) searchbutton.getScene().getWindow();
            thisStage.setTitle("Mise à jour d'un fournisseur");

            FournisseurUpdateController cont = fxmlLoader.getController();
            cont.setFourniseur(fournisseur);

            fournisseurlistview.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
    private void addNotifications(String title, String content) {

        if (null != content) {
            if (content.length() > 50) {
                content = content.substring(0, 49) + "......";
            }
        }
        Notifications notificationBuilder = Notifications.create()
                .title(title)
                .text(content)
                .hideAfter(Duration.seconds(360))
                .position(Pos.BOTTOM_RIGHT);

        notificationBuilder.showInformation();
    }

    public void toHome(ActionEvent actionEvent) {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../User/search/search.fxml"));
        try {
            Parent root = fxmlLoader.load();
            toHome.getScene().setRoot(root);
        } catch (IOException ex)
        {
            System.out.println(ex);
        }


    }
}
