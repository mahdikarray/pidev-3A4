package com.esprit.veltun.gui.fournisseur.create;

import com.esprit.veltun.gui.fournisseur.view.FournisseurDetailsController;
import com.esprit.veltun.model.Fournisseur;
import com.esprit.veltun.services.FournisseurService;
import com.esprit.veltun.services.impl.FournisseurServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;


public class FournisseurCreateController implements Initializable {
    public Button cancelbutton;
    private FournisseurService fournisseurService = new FournisseurServiceImpl();

    public TextField tfnom;
    public TextField tfregion;




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
        //tfheurefin.setTextFormatter(formatter);

    }
    public void saveFournisseur(ActionEvent actionEvent) {
        String nomf = tfnom.getText() ;
        String regionf = tfregion.getText();
        if (nomf.isEmpty() || regionf.isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("veuillez remplir tous les champs!!");
            alert.showAndWait();
            return;
        }
        Fournisseur fournisseur =new Fournisseur();
        fournisseur.setNom(nomf);
        fournisseur.setRegion(regionf);

        FournisseurService fourniseurService=new FournisseurServiceImpl();
        fournisseur = fourniseurService.save(fournisseur);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/details.fxml"));
        addNotifications("Succes", "Fournisseur ajouté");

        try {
            Parent root = fxmlLoader.load();

            FournisseurDetailsController cont = fxmlLoader.getController();
            cont.setFourniseur(fournisseur);
            tfnom.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

        try {
            Parent root = Loader.load();

            FournisseurDetailsController cont = fxmlLoader.getController();
            cont.setFourniseur(fournisseur);

            tfregion.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void cancel(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

        try {
            Parent root = fxmlLoader.load();
            tfnom.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void addNotifications(String title, String content) {

        if (null != content) {
            if (content.length() > 50) {
                content = content.substring(0, 49) + "......";
            }
        }
        Notifications notificationBuilder = Notifications.create()
                .title(title)
                .text(content)
                .hideAfter(Duration.seconds(360))
                .position(Pos.BOTTOM_RIGHT);

        notificationBuilder.showInformation();
    }

}
