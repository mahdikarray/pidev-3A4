package com.esprit.veltun.gui.event.search;


import com.esprit.veltun.gui.event.update.EventUpdateController;
import com.esprit.veltun.gui.event.view.EventDetailsController;
import com.esprit.veltun.gui.invitation.create.InvitationCreateController;
import com.esprit.veltun.model.Event;
import com.esprit.veltun.search.dto.EventSearchCriteria;
import com.esprit.veltun.services.EventService;
import com.esprit.veltun.services.impl.EventServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class EventSearchController implements Initializable {
    public TextField titletosearch;
    public Button searchbutton;
    private EventService eventService = EventServiceImpl.getInstance();
    public ListView<Event> eventlistview;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        eventlistview.setCellFactory(param -> {
            return new ListCell<Event>(){
                public void updateItem(Event event, boolean empty) {
                    super.updateItem(event, empty);
                    if (empty || event == null) {
                        setText(null);
                    } else {
                        setText(event.getTitre() + "\t\t" + event.getDescription() + "\t\t" + event.getDateDebut() + "\t\t" + event.getDateFin());
                    }
                }
            };
        });
        runSearch();
    }

    void runSearch() {
        String titre = titletosearch.getText();
        EventSearchCriteria eventSearchCriteria = new EventSearchCriteria();
        if (titre != null && !titre.isEmpty()) {
            eventSearchCriteria.setTitre(titre);
        }
        Collection<Event> events = eventService.search(eventSearchCriteria);
        eventlistview.getItems().setAll(events);
    }
    private void showAlertWithHeaderText() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation!");
        alert.setHeaderText("Evenement");
        alert.setContentText("Evenement supprimée!!");

        alert.showAndWait();
    }
    @FXML
    void removeEvent(ActionEvent mouseEvent) {
        Event event = eventlistview.getSelectionModel().getSelectedItem();
        int selectionIndex = eventlistview.getSelectionModel().getSelectedIndex();
        eventService.remove(event.getId());
        eventlistview.getItems().remove(selectionIndex);
        showAlertWithHeaderText();

    }




    @FXML
    void editEvent(ActionEvent mouseEvent) {
        Event event = eventlistview.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../update/update.fxml"));

        try {
            Parent root = fxmlLoader.load();

            Stage thisStage = (Stage) searchbutton.getScene().getWindow();
            thisStage.setTitle("Mise à jour d'un eveneemnt");

            EventUpdateController cont = fxmlLoader.getController();
            cont.setEvent(event);

            eventlistview.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    void addEvent(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../create/create.fxml"));

        Stage thisStage = (Stage) searchbutton.getScene().getWindow();
        thisStage.setTitle("Création d'un eveneemnt");

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

    public void inviter(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../invitation/create/create.fxml"));
        Event event = eventlistview.getSelectionModel().getSelectedItem();

        Stage thisStage = (Stage) searchbutton.getScene().getWindow();
        thisStage.setTitle("Invitation à un eveneemnt");
        try {
            Parent root = fxmlLoader.load();
            InvitationCreateController controller = fxmlLoader.getController();
            controller.setEvent(event);
            eventlistview.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
