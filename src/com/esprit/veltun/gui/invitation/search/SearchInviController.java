package com.esprit.veltun.gui.invitation.search;

import com.esprit.veltun.model.Event;
import com.esprit.veltun.model.Invitation;
import com.esprit.veltun.model.User;
import com.esprit.veltun.search.dto.InvitationSearchCriteria;
import com.esprit.veltun.search.dto.UserSearchCriteria;
import com.esprit.veltun.services.InvitationService;
import com.esprit.veltun.services.impl.InvitationServiceImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.ResourceBundle;

import static com.esprit.veltun.services.impl.UserServiceImpl.connectedUser;

public class SearchInviController implements Initializable {


    public ListView ftlistview;
    public TextField titletosearch;
    public Button searchbutton;
    public CheckBox fttous;
    public CheckBox ftenvoye;
    public CheckBox ftrecu;
    public Button deletebutton1;
    public Button cancelbutton11;
    private InvitationService invitationService = InvitationServiceImpl.getInstance();
    public ListView<Invitation> invitationlistview;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        ftlistview.setCellFactory(param -> new ListCell<Invitation>() {
                    public void updateItem(Invitation invi, boolean empty) {
                        super.updateItem(invi, empty);
                        if (empty || invi == null) {
                            setText(null);
                        } else {
                            setText(invi.getInvitant().getNom() + " " + invi.getInvitant().getPrenom() + "\t\t" + invi.getInvite().getNom() + " " + invi.getInvite().getPrenom() + "\t\t" + invi.getEvenement().getId() + "\t\t" + invi.getDateInvitation());
                        }
                    }
                });
             runSearch();
        }
        void runSearch() {
            InvitationSearchCriteria invitationSearchCriteria = new InvitationSearchCriteria();

                    if ( fttous.isSelected()) {

                    } else if (ftenvoye.isSelected()) {
                        invitationSearchCriteria.setInvitant(connectedUser.getCIN());
                    } else if (ftrecu.isSelected()) {
                        invitationSearchCriteria.setInvité(connectedUser.getCIN());
                    }
                    Collection<Invitation> invitation = invitationService.search(invitationSearchCriteria);
                    ftlistview.getItems().setAll(invitation);

                }


    public void search(ActionEvent actionEvent) {
        runSearch();
    }


    public void delete(ActionEvent actionEvent) {{
        Invitation invi = (Invitation) ftlistview.getSelectionModel().getSelectedItem();
        int selectionIndex = ftlistview.getSelectionModel().getSelectedIndex();
        invitationService.remove(invi.getId());
        ftlistview.getItems().remove(selectionIndex);


    }

    }

    public void cancel(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../event/search/search.fxml"));

        try {
            Parent root = fxmlLoader.load();
            ftlistview.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}


