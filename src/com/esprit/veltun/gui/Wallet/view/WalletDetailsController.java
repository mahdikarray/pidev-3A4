package com.esprit.veltun.gui.Wallet.view;

import com.esprit.veltun.model.Wallet;
import com.esprit.veltun.util.MyConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class WalletDetailsController implements Initializable {
    public TextField cinTF;
    public TextField MontantTF;
    public Button ftlistEvent;
    Connection conn= MyConnection.getInstance();

    
    
    
    

    public void setCinTF(String cin) {
        this.cinTF.setText(cin);
    }

    public void setMontantTF(int Montant) {
        this.MontantTF.setText(String.valueOf(Montant));
    }


    public void setWallet(Wallet wallet) {
        setCinTF(wallet.getOwner().getCIN());
        setMontantTF(wallet.getAccount());
    }


    public void listEvent(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/search.fxml"));
        try {
            Parent root = fxmlLoader.load();
            ftlistEvent.getScene().setRoot(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}