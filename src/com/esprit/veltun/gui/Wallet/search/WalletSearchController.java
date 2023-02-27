package com.esprit.veltun.gui.Wallet.search;


import com.esprit.veltun.gui.User.update.UserUpdateController;
import com.esprit.veltun.gui.Wallet.update.WalletUpdateController;
import com.esprit.veltun.model.User;
import com.esprit.veltun.model.Wallet;
import com.esprit.veltun.search.dto.UserSearchCriteria;
import com.esprit.veltun.search.dto.WalletSearchCriteria;
import com.esprit.veltun.services.impl.UserServiceImpl;
import com.esprit.veltun.services.impl.WalletServiceImpl;
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

public class WalletSearchController implements Initializable {
    public TextField nameSearch;
    public Button walletsearchbutton;
    public ListView<Wallet> walletListView;
    public Button toUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        walletListView.setCellFactory(param -> {
            return new ListCell<Wallet>(){
                public void updateItem(Wallet wallet, boolean empty) {
                    super.updateItem(wallet, empty);
                    if (empty || wallet == null) {
                        setText(null);
                    } else {
                        setText(wallet.getOwner().getCIN() + "\t\t\t" +wallet.getOwner().getNom() + "\t\t\t" + wallet.getOwner().getPrenom()+ "\t\t\t" + wallet.getAccount() + "\t\t\t" );
                    }
                }
            };
        });
        runSearch();
    }


    void runSearch() {
        String searchCriteria = nameSearch.getText();
        WalletSearchCriteria wsc = new WalletSearchCriteria();
        if (searchCriteria != null && !searchCriteria.isEmpty()) {
            wsc.setCin(searchCriteria);
            //wsc.setId(Integer.parseInt(searchCriteria));
            }
        WalletServiceImpl wsi=new WalletServiceImpl();
        Collection<Wallet> wallets = wsi.search(wsc);
        walletListView.getItems().setAll(wallets);
    }

    @FXML
    void removeWallet(ActionEvent mouseEvent) {
        WalletServiceImpl wsi= new WalletServiceImpl();
        Wallet wallet = walletListView.getSelectionModel().getSelectedItem();
        int selectionIndex = walletListView.getSelectionModel().getSelectedIndex();
        wsi.remove(wallet.getOwner().getCIN());
        walletListView.getItems().remove(selectionIndex);
    }

    @FXML
    void editWallet(ActionEvent mouseEvent) {
        Wallet wallet = walletListView.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../update/update.fxml"));

        try {
            Parent root = fxmlLoader.load();

            Stage thisStage = (Stage) walletsearchbutton.getScene().getWindow();
            thisStage.setTitle("Mise à jour wallet");

            WalletUpdateController cont = fxmlLoader.getController();
            cont.setWallet(wallet);

            walletListView.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    void addWallet(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../create/create.fxml"));

        Stage thisStage = (Stage) walletsearchbutton.getScene().getWindow();
        thisStage.setTitle("Ajout wallet");

        try {
            Parent root = fxmlLoader.load();
            walletListView.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void search(ActionEvent actionEvent) {
        runSearch();
    }

    public void toUser(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../User/search/search.fxml"));
        try {
            Parent root = fxmlLoader.load();
            toUser.getScene().setRoot(root);
        } catch (IOException ex)
        {
            System.out.println(ex);
        }
    }
}
