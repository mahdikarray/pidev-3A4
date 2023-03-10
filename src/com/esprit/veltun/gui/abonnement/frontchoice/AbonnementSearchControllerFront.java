package com.esprit.veltun.gui.abonnement.frontchoice;


//import com.esprit.veltun.gui.invitation.create.InvitationCreateController;

import com.esprit.veltun.gui.User.view.UserDetailsController;
import com.esprit.veltun.model.Abonnement;
import com.esprit.veltun.model.Offre;
import com.esprit.veltun.search.dto.AbonnementSearchCriteria;
import com.esprit.veltun.search.dto.OffreSearchCriteria;
import com.esprit.veltun.services.AbonnementService;
import com.esprit.veltun.services.OffreService;
import com.esprit.veltun.services.impl.AbonnementServiceImpl;
import com.esprit.veltun.services.impl.OffreServiceImpl;
import com.esprit.veltun.services.impl.UserServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.esprit.veltun.services.impl.UserServiceImpl.connectedUser;

public class AbonnementSearchControllerFront implements Initializable {
    public TextField titletosearch;
    public Button searchbutton;
    public Button tooffer;
    public Button toHome;
    private AbonnementService abonnementService = new AbonnementServiceImpl();
    private OffreService offreService = new OffreServiceImpl();
    public ListView<Abonnement> eventlistview;
    @FXML
    private HBox buttonsContainer;
    @FXML
    private VBox buttonsContainer1;
    @FXML
    private ScrollPane eventsScrollPane;
    @FXML
    private ScrollPane eventsScrollPane1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            runSearch();
}

    void runSearch() {
       // String Type_ab = titletosearch.getText();
        AbonnementSearchCriteria abonnementSearchCriteria = new AbonnementSearchCriteria();
 OffreSearchCriteria offreSearchCriteria=new OffreSearchCriteria();
        Collection<Abonnement> abonnements = abonnementService.search(abonnementSearchCriteria);
        Collection<Offre> offres = offreService.search(offreSearchCriteria);
// Create a VBox to hold the buttons
        HBox buttonsContainer = new HBox();
        buttonsContainer.setSpacing(10);
        VBox buttonsContainer1 = new VBox();
        buttonsContainer1.setSpacing(10);

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
                    AbonnementServiceImpl.chosenAbonnement=abonnement;
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


    public void toHome(ActionEvent actionEvent) {

        if(UserServiceImpl.connectedUser==null || Objects.equals(connectedUser.getType(), "admin"))
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../User/search/search.fxml"));
            try {
                Parent root = fxmlLoader.load();
                toHome.getScene().setRoot(root);
            } catch (IOException ex)
            {
                System.out.println(ex);
            }
        }
        else
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../User/view/details.fxml"));
            try {

                Parent root = fxmlLoader.load();
                toHome.getScene().setRoot(root);
                UserDetailsController cont = fxmlLoader.getController();
                cont.setUser(UserServiceImpl.connectedUser);
            } catch (IOException ex)
            {
                System.out.println(ex);
            }
        }



    }
}

