package com.esprit.veltun.GUI.abonnementt.frontchoice;


//import com.esprit.veltun.gui.invitation.create.InvitationCreateController;
import com.esprit.veltun.model.Abonnement;
import com.esprit.veltun.search.dto.AbonnementSearchCriteria;
import com.esprit.veltun.services.AbonnementService;
import com.esprit.veltun.services.impl.AbonnementServiceImpl;
<<<<<<< HEAD
=======
<<<<<<< Updated upstream
=======
>>>>>>> 63d3b7b43f9286d0ef9f6e147e0afbee11949b26
import com.esprit.veltun.search.dto.OffreSearchCriteria;
import com.esprit.veltun.model.Offre;
import com.esprit.veltun.services.OffreService;
import com.esprit.veltun.services.impl.OffreServiceImpl;
<<<<<<< HEAD
=======
>>>>>>> Stashed changes
>>>>>>> 63d3b7b43f9286d0ef9f6e147e0afbee11949b26
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class AbonnementSearchControllerFront implements Initializable {
    public TextField titletosearch;
    public Button searchbutton;
    public Button tooffer;
    private AbonnementService abonnementService = new AbonnementServiceImpl();
<<<<<<< HEAD
    private OffreService offreService = new OffreServiceImpl();
=======
<<<<<<< Updated upstream
=======
    private OffreService offreService = new OffreServiceImpl();
>>>>>>> Stashed changes
>>>>>>> 63d3b7b43f9286d0ef9f6e147e0afbee11949b26
    public ListView<Abonnement> eventlistview;
    @FXML
    private HBox buttonsContainer;
    @FXML
<<<<<<< HEAD
=======
<<<<<<< Updated upstream
    private ScrollPane eventsScrollPane;

=======
>>>>>>> 63d3b7b43f9286d0ef9f6e147e0afbee11949b26
    private VBox buttonsContainer1;
    @FXML
    private ScrollPane eventsScrollPane;
    @FXML
    private ScrollPane eventsScrollPane1;
<<<<<<< HEAD
=======
>>>>>>> Stashed changes
>>>>>>> 63d3b7b43f9286d0ef9f6e147e0afbee11949b26

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            runSearch();
}

    void runSearch() {
       // String Type_ab = titletosearch.getText();
        AbonnementSearchCriteria abonnementSearchCriteria = new AbonnementSearchCriteria();
<<<<<<< HEAD
=======
<<<<<<< Updated upstream

        Collection<Abonnement> abonnements = abonnementService.search(abonnementSearchCriteria);

// Create a VBox to hold the buttons
        HBox buttonsContainer = new HBox();
        buttonsContainer.setSpacing(10);
=======
>>>>>>> 63d3b7b43f9286d0ef9f6e147e0afbee11949b26
 OffreSearchCriteria offreSearchCriteria=new OffreSearchCriteria();
        Collection<Abonnement> abonnements = abonnementService.search(abonnementSearchCriteria);
        Collection<Offre> offres = offreService.search(offreSearchCriteria);
// Create a VBox to hold the buttons
        HBox buttonsContainer = new HBox();
        buttonsContainer.setSpacing(10);
        VBox buttonsContainer1 = new VBox();
        buttonsContainer1.setSpacing(10);
<<<<<<< HEAD
=======
>>>>>>> Stashed changes
>>>>>>> 63d3b7b43f9286d0ef9f6e147e0afbee11949b26

// Create a button for each abonnement
        for (Abonnement abonnement : abonnements) {
            Button button = new Button(abonnement.getType_ab());
            button.setOnAction(event -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Second.fxml"));
                    Parent root = loader.load();

                    // Get the controller for the second FXML
                    SecondFXMLController controller = loader.getController();

                    // Set the abonnement in the controller
                    controller.setAbonnement(abonnement);

                    // Show the second FXML
                /*    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();*/
                    button.getScene().setRoot(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            // Add the button to the VBox
            buttonsContainer.getChildren().add(button);
        }

// Set the VBox as the content of the ScrollPane
        if (eventsScrollPane != null) {
            eventsScrollPane.setContent(buttonsContainer);
        }
<<<<<<< HEAD
=======
<<<<<<< Updated upstream
        }
=======
>>>>>>> 63d3b7b43f9286d0ef9f6e147e0afbee11949b26
        for (Offre offre : offres) {
            Label label = new Label(offre.getDescription_of());
            label.setWrapText(true);
            label.setOnMouseClicked(event -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Second.fxml"));
                    Parent root = loader.load();

                    // Get the controller for the second FXML
                    SecondFXMLController controller = loader.getController();

                    // Set the abonnement in the controller
                    controller.setOffre(offre);

                    // Show the second FXML
            /*    Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();*/
                    label.getScene().setRoot(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            // Add the label to the VBox
            buttonsContainer1.getChildren().add(label);
        }
        if (eventsScrollPane1 != null) {
            eventsScrollPane1.setContent(buttonsContainer1);
        }

    }
<<<<<<< HEAD
=======
>>>>>>> Stashed changes
>>>>>>> 63d3b7b43f9286d0ef9f6e147e0afbee11949b26



    @FXML
    void editEvent(ActionEvent mouseEvent) {
        Abonnement abonnement = eventlistview.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("second.fxml"));

        try {
            Parent root = fxmlLoader.load();

            Stage thisStage = (Stage) searchbutton.getScene().getWindow();
<<<<<<< HEAD
            thisStage.setTitle("Subscription update successfully ");
=======
<<<<<<< Updated upstream
            thisStage.setTitle("Mise à jour d'un abonnement");
=======
            thisStage.setTitle("Subscription update successfully ");
>>>>>>> Stashed changes
>>>>>>> 63d3b7b43f9286d0ef9f6e147e0afbee11949b26

            com.esprit.veltun.GUI.abonnementt.frontchoice.SecondFXMLController cont = fxmlLoader.getController();
            cont.setAbonnement(abonnement);

            eventlistview.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
