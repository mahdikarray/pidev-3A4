package com.esprit.veltun.gui.User.view;

import com.esprit.veltun.model.User;
import com.esprit.veltun.model.Wallet;
import com.esprit.veltun.services.impl.WalletServiceImpl;
import com.esprit.veltun.util.MyConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.util.ResourceBundle;
public class UserDetailsController implements Initializable {
    public TextField cinTF;
    public TextField nomTF;
    public TextField prenomTF;
    public TextField emailTF;
    public TextField dateTF;
    public TextField codePostalTF;
    public Button ftlistEvent;
    public Button sub;
    public TextField walletAccount;
    public Button toVelo;
    public Button toReclamation;
    public Button toStationFront;

    Connection conn= MyConnection.getInstance();


    public void setWalletAccount(String walletAccount) {
        this.walletAccount.setText(walletAccount);
    }

    public void setCinTF(String cin) {
        this.cinTF.setText(cin);
    }

    public void setNomTF(String nom) {
        this.nomTF.setText(nom);
    }

    public void setPrenomTF(String prenom) {
        this.prenomTF.setText(prenom);
    }

    public void setEmailTF(String email) {
        this.emailTF.setText(email);
    }

    public void setDateTF(Date dateTF) {
        this.dateTF.setText(dateTF.toString());
    }

    public void setCodePostalTF(int codePostal) {
        this.codePostalTF.setText(String.valueOf(codePostal));
    }


    public void setUser(User user) {
        setCinTF(user.getCIN());
        setNomTF(user.getNom());
        setPrenomTF(user.getPrenom());
        setEmailTF(user.getEmail());
        setDateTF(user.getDateNaiss());
        setCodePostalTF(user.getCodePos());
        WalletServiceImpl wsi = new WalletServiceImpl();
        setWalletAccount(Integer.toString(wsi.findByCin(user.getCIN()).getAccount()));

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setWallet(Wallet w) {
    }

    public void toSub(ActionEvent actionEvent) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../abonnement/frontchoice/searchfront.fxml"));
        try {
            Parent root = fxmlLoader.load();
            sub.getScene().setRoot(root);
        } catch (IOException ex)
        {
            System.out.println(ex);
        }
    }


    public void event(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../event/search/search.fxml"));
        try {
            Parent root = fxmlLoader.load();
            sub.getScene().setRoot(root);
        } catch (IOException ex)
        {
            System.out.println(ex);
        }
    }


    private static void runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines(command + " stdout:", pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
    }
    private static void printLines(String cmd, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
                new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(cmd + " " + line);
        }
    }

    public void toVelo(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../velo/frontv/frontv.fxml"));
        try {
            Parent root = fxmlLoader.load();
            toVelo.getScene().setRoot(root);
        } catch (IOException ex)
        {
            System.out.println(ex);
        }
    }

    public void toReclamation(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../reclamation/create/create.fxml"));
        try {
            Parent root = fxmlLoader.load();
            toVelo.getScene().setRoot(root);
        } catch (IOException ex)
        {
            System.out.println(ex);
        }
    }

    public void toStationFront(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../rackStation/frontend/frontend.fxml"));
        try {
            Parent root = fxmlLoader.load();
            toStationFront.getScene().setRoot(root);
        } catch (IOException ex)
        {
            System.out.println(ex);
        }
    }
}
