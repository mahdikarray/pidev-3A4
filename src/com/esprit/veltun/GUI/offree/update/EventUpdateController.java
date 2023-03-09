package com.esprit.veltun.GUI.offree.update;

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

public class EventUpdateController implements Initializable {
    public Button cancelbutton;
    private OffreService offreService = new OffreServiceImpl();

    private Offre offre;
    public TextField Fxrs;
    public TextField FxDescription2;
    public TextField fxPrix2;


    public void setFxDescription(String desc) {
        this.FxDescription2.setText(desc);
    }





    public void setOffre(Offre offre) {
        this.offre= offre;
        setFxDescription(offre.getDescription_of());


    }
    public void updateEvent(ActionEvent actionEvent) {
        String desc= FxDescription2.getText();

        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Confirmation");
        confirmation.setHeaderText("Are you sure you want to update this offer?");
        confirmation.setContentText("Click OK to confirm.");

        Optional<ButtonType> result = confirmation.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {

            offre.setDescription_of(desc);


            offre = offreService.update(offre);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/detailsof.fxml"));

            try {
                Parent root = fxmlLoader.load();

                EventDetailsController cont = fxmlLoader.getController();
                cont.setOffre(offre);

                FxDescription2.getScene().setRoot(root);
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
            FxDescription2.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
