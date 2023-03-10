package com.esprit.veltun.gui.User.search;


import com.esprit.veltun.gui.User.update.UserUpdateController;
import com.esprit.veltun.model.User;
import com.esprit.veltun.search.dto.UserSearchCriteria;
import com.esprit.veltun.services.impl.UserServiceImpl;
import com.esprit.veltun.util.MyConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Collection;
import java.util.ResourceBundle;

public class UserSearchController implements Initializable {

    public TextField nameSearch;
    public Button searchbutton;
    public Button toWallet;
    public Button toAbonnement;
    public Button toOffre;
    public Button toBikes;
    public Button toEvent;
    public Button toReclamation;
    public Button toMaintenance;
    public Button toFour;
    Connection conn= MyConnection.getInstance();
    public ListView<User> userListView;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userListView.setCellFactory(param -> {
            return new ListCell<User>(){
                public void updateItem(User user, boolean empty) {
                    super.updateItem(user, empty);
                    if (empty || user == null) {
                        setText(null);
                    } else {
                        setText(user.getCIN() + "\t\t\t" + user.getNom() + "\t\t\t" + user.getPrenom() + "\t\t" + user.getEmail() + "\t\t" + user.getType() + "\t\t"+ user.getCodePos());
                    }
                }
            };
        });
        runSearch();
    }

    void runSearch() {
        String searchCriteria = nameSearch.getText();
        UserSearchCriteria usc = new UserSearchCriteria();
        if (searchCriteria != null && !searchCriteria.isEmpty()) {
            usc.setNom(searchCriteria);
            usc.setPrenom(searchCriteria);
            usc.setCin(searchCriteria);
            usc.setRole(searchCriteria);
        }
        UserServiceImpl usi=new UserServiceImpl();
        Collection<User> users = usi.search(usc);
        userListView.getItems().setAll(users);
    }

    @FXML
    void removeUser(ActionEvent mouseEvent) {
        UserServiceImpl usi= new UserServiceImpl();
        User user = userListView.getSelectionModel().getSelectedItem();
        int selectionIndex = userListView.getSelectionModel().getSelectedIndex();
        usi.remove(user.getCIN());
        userListView.getItems().remove(selectionIndex);
    }


    @FXML
    void editUser(ActionEvent mouseEvent) {
        User user = userListView.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../update/update.fxml"));

        try {
            Parent root = fxmlLoader.load();

            Stage thisStage = (Stage) searchbutton.getScene().getWindow();
            thisStage.setTitle("Mise à jour d'un eveneemnt");

            UserUpdateController cont = fxmlLoader.getController();
            cont.setUser(user);

            userListView.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    void addUser(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../create/create.fxml"));

        Stage thisStage = (Stage) searchbutton.getScene().getWindow();
        thisStage.setTitle("Ajout d'un utilisateur");

        try {
            Parent root = fxmlLoader.load();
            userListView.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void search(ActionEvent actionEvent) {
        runSearch();
    }

    public void toWallet(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../Wallet/search/search.fxml"));
        try {
            Parent root = fxmlLoader.load();
            toWallet.getScene().setRoot(root);
        } catch (IOException ex)
        {
            System.out.println(ex);
        }
    }

    public void toOffre(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../offre/search/searchof.fxml"));
        try {
            Parent root = fxmlLoader.load();
            toWallet.getScene().setRoot(root);
        } catch (IOException ex)
        {
            System.out.println(ex);
        }
    }

    public void toAbonnement(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../abonnement/search/search.fxml"));
        try {
            Parent root = fxmlLoader.load();
            toWallet.getScene().setRoot(root);
        } catch (IOException ex)
        {
            System.out.println(ex);
        }
    }

    public void toInvitation(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../invitation/search/searchInvi.fxml"));
        try {
            Parent root = fxmlLoader.load();
            toWallet.getScene().setRoot(root);
        } catch (IOException ex)
        {
            System.out.println(ex);
        }
    }

    public void toEvent(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../event/search/search.fxml"));
        try {
            Parent root = fxmlLoader.load();
            toEvent.getScene().setRoot(root);
        } catch (IOException ex)
        {
            System.out.println(ex);
        }
    }

    public void toStations(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../rackStation/backend/backendHome.fxml"));
        try {
            Parent root = fxmlLoader.load();
            toWallet.getScene().setRoot(root);
        } catch (IOException ex)
        {
            System.out.println(ex);
        }
    }

    public void toBikes(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../velo/search/search.fxml"));
        try {
            Parent root = fxmlLoader.load();
            toBikes.getScene().setRoot(root);
        } catch (IOException ex)
        {
            System.out.println(ex);
        }
    }

    public void toReclamation(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../reclamation/search/search.fxml"));
        try {
            Parent root = fxmlLoader.load();
            toReclamation.getScene().setRoot(root);
        } catch (IOException ex)
        {
            System.out.println(ex);
        }
    }

    public void toMaintenance(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../maintenancee/search/search.fxml"));
        try {
            Parent root = fxmlLoader.load();
            toMaintenance.getScene().setRoot(root);
        } catch (IOException ex)
        {
            System.out.println(ex);
        }

    }

    public void toFour(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../fournisseur/search/search.fxml"));
        try {
            Parent root = fxmlLoader.load();
            toFour.getScene().setRoot(root);
        } catch (IOException ex)
        {
            System.out.println(ex);
        }

    }
}
