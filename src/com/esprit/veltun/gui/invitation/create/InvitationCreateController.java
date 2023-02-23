package com.esprit.veltun.gui.invitation.create;

import com.esprit.veltun.gui.event.view.EventDetailsController;
import com.esprit.veltun.model.Adresse;
import com.esprit.veltun.model.Event;
import com.esprit.veltun.model.Invitation;
import com.esprit.veltun.model.User;
import com.esprit.veltun.search.dto.UserSearchCriteria;
import com.esprit.veltun.services.EventService;
import com.esprit.veltun.services.InvitationService;
import com.esprit.veltun.services.UserService;
import com.esprit.veltun.services.impl.EventServiceImpl;
import com.esprit.veltun.services.impl.InvitationServiceImpl;
import com.esprit.veltun.services.impl.UserServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class InvitationCreateController implements Initializable {

    public Button tfaddinvit;
    UserService userService = new UserServiceImpl();
    EventService eventService = EventServiceImpl.getInstance();
    InvitationService invitationService = InvitationServiceImpl.getInstance();

    public DatePicker invitstartdate;
    public DatePicker invitexpirationdate;
    public Button cancelbutton;
    public ComboBox<User> selectedinvitant;
    public ComboBox<User> selectedinvite;
    public ComboBox<Event> selectedevent;

    private Event event;

    public void setEvent(Event event) {
        this.event = event;
        if (this.event != null) {
            selectedevent.setValue(event);
        }
    }

    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        invitstartdate.setValue(LocalDate.now());
        ObservableList<Event> events = FXCollections.observableArrayList();
        events.addAll(eventService.list());

        selectedevent.getItems().addAll(events);

        selectedevent.setConverter(new StringConverter<Event>() {
            @Override
            public String toString(Event event) {
                return event != null ? event.getId().toString() : null;
            }

            @Override
            public Event fromString(String string) {
                Event event = eventService.findById(Integer.valueOf(string));
                return event;
            }
        });

        selectedevent.setCellFactory(cell -> new ListCell<Event>() {

            GridPane gridPane = new GridPane();
            Label part1 = new Label();
            Label part2 = new Label();
            {
                gridPane.getColumnConstraints().addAll(
                        new ColumnConstraints(100, 100, 100),
                        new ColumnConstraints(100, 100, 100)
                );
                gridPane.add(part1, 0, 1);
                gridPane.add(part2, 1, 1);
            }
            @Override
            protected void updateItem(Event event, boolean empty) {
                super.updateItem(event, empty);
                if (!empty && event != null) {
                    part1.setText(event.getTitre());
                    part2.setText(event.getDateDebut().toLocalDate().format(dateTimeFormatter));
                    setGraphic(gridPane);
                } else {
                    setGraphic(null);
                }
            }
        });

        ObservableList<User> users = FXCollections.observableArrayList();
        users.addAll(userService.list());

        selectedinvitant.setItems(users);
        selectedinvite.setItems(users);

        selectedinvitant.setConverter(new StringConverter<User>() {
            @Override
            public String toString(User user) {
                return user != null ? user.getCIN() : null;
            }

            @Override
            public User fromString(String string) {
                UserSearchCriteria userSearchCriteria = new UserSearchCriteria();
                userSearchCriteria.setCin(string);
                User user = userService.search(userSearchCriteria).stream().findFirst().orElse(null);
                return user;
            }
        });
        selectedinvite.setConverter(new StringConverter<User>() {
            @Override
            public String toString(User user) {
                return user != null ? user.getCIN() : null;
            }

            @Override
            public User fromString(String string) {
                UserSearchCriteria userSearchCriteria = new UserSearchCriteria();
                userSearchCriteria.setCin(string);
                User user = userService.search(userSearchCriteria).stream().findFirst().orElse(null);
                return user;
            }
        });

        selectedinvitant.setCellFactory(cell -> new ListCell<User>() {

            GridPane gridPane = new GridPane();
            Label firstName = new Label();
            Label lastName = new Label();
            {
                gridPane.getColumnConstraints().addAll(
                        new ColumnConstraints(100, 100, 100),
                        new ColumnConstraints(100, 100, 100)
                );
                gridPane.add(firstName, 0, 1);
                gridPane.add(lastName, 1, 1);
            }
            @Override
            protected void updateItem(User user, boolean empty) {
                super.updateItem(user, empty);
                if (!empty && user != null) {
                    firstName.setText(user.getNom());
                    lastName.setText(user.getPrenom());
                    setGraphic(gridPane);
                } else {
                    setGraphic(null);
                }
            }
        });
        selectedinvite.setCellFactory(cell -> new ListCell<User>() {

            GridPane gridPane = new GridPane();
            Label firstName = new Label();
            Label lastName = new Label();
            {
                gridPane.getColumnConstraints().addAll(
                        new ColumnConstraints(100, 100, 100),
                        new ColumnConstraints(100, 100, 100)
                );
                gridPane.add(firstName, 0, 1);
                gridPane.add(lastName, 1, 1);
            }
            @Override
            protected void updateItem(User user, boolean empty) {
                super.updateItem(user, empty);
                if (!empty && user != null) {
                    firstName.setText(user.getNom());
                    lastName.setText(user.getPrenom());
                    setGraphic(gridPane);
                } else {
                    setGraphic(null);
                }
            }
        });
    }

    private void showAlertWithHeaderText() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation!");
        alert.setHeaderText("Invitation");
        alert.setContentText("Invitation envoyé avec succes");

        alert.showAndWait();
    }
    public Invitation saveInvitation() {
        Invitation invitation = new Invitation();
        invitation.setDateInvitation(Date.valueOf(invitstartdate.getValue()));
        invitation.setDateExpiration(Date.valueOf(invitexpirationdate.getValue()));
        invitation.setInvitant(selectedinvitant.getValue());
        invitation.setInvite(selectedinvite.getValue());
        invitation.setEvenement(selectedevent.getValue());
        showAlertWithHeaderText();
        return invitationService.save(invitation);
    }

    public void cancel(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../event/search/search.fxml"));

        try {
            Parent root = fxmlLoader.load();
            invitstartdate.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    public void addinvit(ActionEvent actionEvent) {
        saveInvitation();
    }
}
