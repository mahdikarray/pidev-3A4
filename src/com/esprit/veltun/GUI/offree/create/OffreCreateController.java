package com.esprit.veltun.GUI.offree.create;

import com.esprit.veltun.GUI.offree.view.EventDetailsController;
import com.esprit.veltun.model.Offre;
import com.esprit.veltun.services.OffreService;
import com.esprit.veltun.services.impl.OffreServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;


import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class OffreCreateController implements Initializable {
    public Button cancelbutton;
    private OffreService offreService = new OffreServiceImpl();

    public TextField fxdescription;
    public TextField fxprix;

    public void saveEvent(ActionEvent actionEvent) {
        String description = fxdescription.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure you want to add this offer?");
        alert.setContentText("Click OK to confirm.");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            Offre a = new Offre();
            a.setDescription_of(description);
            a = offreService.save(a);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/detailsof.fxml"));

            try {
                Parent root = fxmlLoader.load();

                EventDetailsController cont = fxmlLoader.getController();
                cont.setOffre(a);

                fxdescription.getScene().setRoot(root);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            FXMLLoader Loader = new FXMLLoader(getClass().getResource("../search/searchof.fxml"));

            try {
                Parent root = Loader.load();

                EventDetailsController cont = fxmlLoader.getController();
                cont.setOffre(a);

                fxdescription.getScene().setRoot(root);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
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


    }
    public void cancel(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/searchof.fxml"));

        try {
            Parent root = fxmlLoader.load();
            fxdescription.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
