package com.esprit.veltun.GUI.abonnementt.frontchoice;


//import com.esprit.veltun.gui.invitation.create.InvitationCreateController;
import com.esprit.veltun.model.Abonnement;
import com.esprit.veltun.search.dto.AbonnementSearchCriteria;
import com.esprit.veltun.services.AbonnementService;
import com.esprit.veltun.services.impl.AbonnementServiceImpl;
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
    public ListView<Abonnement> eventlistview;
    @FXML
    private HBox buttonsContainer;
    @FXML
    private ScrollPane eventsScrollPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
            runSearch();
}

    void runSearch() {
       // String Type_ab = titletosearch.getText();
        AbonnementSearchCriteria abonnementSearchCriteria = new AbonnementSearchCriteria();

        Collection<Abonnement> abonnements = abonnementService.search(abonnementSearchCriteria);

// Create a VBox to hold the buttons
        HBox buttonsContainer = new HBox();
        buttonsContainer.setSpacing(10);

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
        }



    @FXML
    void editEvent(ActionEvent mouseEvent) {
        Abonnement abonnement = eventlistview.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("second.fxml"));

        try {
            Parent root = fxmlLoader.load();

            Stage thisStage = (Stage) searchbutton.getScene().getWindow();
            thisStage.setTitle("Mise à jour d'un abonnement");

            com.esprit.veltun.GUI.abonnementt.frontchoice.SecondFXMLController cont = fxmlLoader.getController();
            cont.setAbonnement(abonnement);

            eventlistview.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
