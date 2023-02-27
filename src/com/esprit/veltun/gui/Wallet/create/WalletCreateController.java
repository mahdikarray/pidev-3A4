package com.esprit.veltun.gui.Wallet.create;

import com.esprit.veltun.gui.User.view.UserDetailsController;
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
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class WalletCreateController implements Initializable {
    public Button cancelbutton;
    Connection conn= MyConnection.getInstance();
    public TextField cinTF;
    public TextField MontantTF;
    public void saveWallet(ActionEvent actionEvent) {



        int cinInt;
        String cin = cinTF.getText();
        int account=Integer.parseInt(MontantTF.getText());

        try
        {
            int cinNum=Integer.parseInt(cin);
        }
        catch (NumberFormatException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("CIN doit etre numerique");
            alert.showAndWait();

        }



        if (cin.isEmpty() || MontantTF.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs.");
            alert.showAndWait();
        }
        /*else if (cin.length()!=8) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("CIN invalide");
            alert.showAndWait();
        }*/

        else {
            UserServiceImpl usi= new UserServiceImpl();
            User u = usi.findByCin(cin);
            Wallet w = new Wallet(u,account);
            WalletServiceImpl wsi= new WalletServiceImpl();
            wsi.save(w);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/details.fxml"));

        try {
            Parent root = fxmlLoader.load();

            WalletDetailsController cont = fxmlLoader.getController();
            cont.setWallet(w);

            cinTF.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

        try {
            Parent root = Loader.load();

            WalletDetailsController cont = fxmlLoader.getController();
            cont.setWallet(w);

            cinTF.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        }    }

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
