package com.esprit.veltun.gui.invitation.search;

import com.esprit.veltun.gui.User.view.UserDetailsController;
import com.esprit.veltun.model.Invitation;
import com.esprit.veltun.search.dto.InvitationSearchCriteria;
import com.esprit.veltun.services.InvitationService;
import com.esprit.veltun.services.impl.InvitationServiceImpl;
import com.esprit.veltun.services.impl.UserServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Objects;
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
    public Button toHome;
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


                    if (ftenvoye.isSelected() && connectedUser!=null) {
                        invitationSearchCriteria.setInvitant(connectedUser.getCIN());
                    } else if (ftrecu.isSelected() && connectedUser!=null) {
                        invitationSearchCriteria.setInvité(connectedUser.getCIN());
                    }
                    else if (connectedUser!=null)
                    {
                        invitationSearchCriteria.setInvitant(connectedUser.getCIN());
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


