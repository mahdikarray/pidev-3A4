package com.esprit.veltun.gui.invitation.view;

import com.esprit.veltun.gui.invitation.search.SearchInviController;
import com.esprit.veltun.model.Event;
import com.esprit.veltun.model.Invitation;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class DetaillInvitationController  implements Initializable {
    public TextField ftdateinvi;
    public TextField ftdateex;
    public TextField ftinvitant;
    public TextField ftinvitéé;
    public TextField ftevenement;
    public Button ftbuttonlistinvi;
    static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");


    public void setDateInvitation(LocalDate date) {
        this.ftdateinvi.setText(date.format(dateTimeFormatter));
    }
    public void setDateExpiration(LocalDate date) {
        this.ftdateex.setText(date.format(dateTimeFormatter));
    }

    public void setTextInvitant(String invitant) {
        this.ftinvitant.setText(invitant);
    }

    public void setTextInvité(String invité) {
        this.ftinvitéé.setText(invité);
    }

    public void setEvenement(String evenement) {
        this.ftevenement.setText(evenement);
    }


    public void setEvent(Invitation invi) {
        setDateInvitation(invi.getDateInvitation().toLocalDate());
        setDateExpiration(invi.getDateExpiration().toLocalDate());
        setTextInvitant(invi.getInvitant().getCIN());
        setTextInvité(invi.getInvite().getCIN());
        setEvenement(invi.getEvenement().getTitre());

    }


    public void List(ActionEvent actionEvent) {{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/searchInvi.fxml"));
        try {
            Parent root = fxmlLoader.load();
            ftbuttonlistinvi.getScene().setRoot(root);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
