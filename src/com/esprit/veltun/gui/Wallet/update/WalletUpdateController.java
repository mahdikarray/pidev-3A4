package com.esprit.veltun.gui.Wallet.update;

import com.esprit.veltun.gui.Wallet.view.WalletDetailsController;
import com.esprit.veltun.model.User;
import com.esprit.veltun.model.Wallet;
import com.esprit.veltun.services.impl.UserServiceImpl;
import com.esprit.veltun.services.impl.WalletServiceImpl;
import com.esprit.veltun.util.MyConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class WalletUpdateController implements Initializable {
    public Button cancelbutton;
    Connection conn= MyConnection.getInstance();
    private Wallet wallet;

    public TextField cinTF;
    public TextField montantTF;

    public TextField getCinTF() {
        return cinTF;
    }

    public TextField getmontantTF() {
        return montantTF;
    }

    public void setCinTF(String cinTF) {
        this.cinTF.setText(cinTF);
    }



    public void setmontantTF(int montantTF) {
        this.montantTF.setText(String.valueOf(montantTF));
    }

    public void setWallet(Wallet wallet) {
        this.wallet= wallet;
        setCinTF(wallet.getOwner().getCIN());
        setmontantTF(wallet.getAccount());
    }
    public void updateWallet(ActionEvent actionEvent) {
        String cin= cinTF.getText();
        int montant= Integer.parseInt(montantTF.getText());

        UserServiceImpl usi= new UserServiceImpl();
        User u = usi.findByCin(cin);
        Wallet wallet = new Wallet(u,montant);
        WalletServiceImpl wsi= new WalletServiceImpl();
        wsi.update(wallet);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/details.fxml"));

        try {
            Parent root = fxmlLoader.load();

            WalletDetailsController cont = fxmlLoader.getController();
            cont.setWallet(wallet);

            cinTF.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final Pattern pattern = Pattern.compile("\\d{2}\\:\\d{2}\\:\\d{2}");
        TextFormatter<?> formatter = new TextFormatter<>(change -> {
            if (pattern.matcher(change.getControlNewText()).matches()) {
                // todo: remove error message/markup
                return change; // allow this change to happen
            } else {
                // todo: add error message/markup
                return null; // prevent change
            }
        });

        //emailTF.setTextFormatter(formatter);
    }

    public void cancel(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

        try {
            Parent root = fxmlLoader.load();
            cinTF.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
