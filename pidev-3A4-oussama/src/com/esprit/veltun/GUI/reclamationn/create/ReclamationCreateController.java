package com.esprit.veltun.GUI.reclamationn.create;

import com.esprit.veltun.model.Reclamation;
import com.esprit.veltun.GUI.reclamationn.view.ReclamationDetailsController;

import com.esprit.veltun.services.ReclamationService;
import com.esprit.veltun.services.impl.ReclamationServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;


import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;


public class ReclamationCreateController implements Initializable {
    public Button cancelbutton;
    private ReclamationService reclamationService = new ReclamationServiceImpl();

    public TextField fxstatus;
    public TextField fxdescription;
    public DatePicker date_reclamation;

    public TextField fxobject;

    @FXML
    private Label discountedPriceLabel;
    private  Label errorA;
    @FXML
    private TextField discountCodeTextField;


    public void saveEvent(ActionEvent actionEvent) {

        String object= fxobject.getText();
        String description= fxdescription.getText();
        String status= fxstatus.getText();
    String date_reclamationn = String.valueOf(date_reclamation.getValue());


        if (description.length() < 10 || description.length() > 200 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Problem!");
            alert.setHeaderText(null);
            alert.setContentText("La description doit avoir entre 10 et 200 caractères");
            alert.showAndWait();
            return;
        }
        if (object.length() < 10 || object.length() > 100 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Problem!");
            alert.setHeaderText(null);
            alert.setContentText("L'objet doit avoir entre 10 et 200 caractères");
            alert.showAndWait();
            return;
        }

        if (!status.matches("en cours") && (!status.matches("resolu") )) {

            Alert alert = new Alert(Alert.AlertType.ERROR, "status must be either en cours or resolu ");
            alert.showAndWait();
            return;
        }



        Reclamation a= new Reclamation();

        a.setObject(object);
        a.setDescription(description);
        a.setStatus(status);
        a.setDate_reclamation(Date.valueOf(date_reclamationn));

        a = reclamationService.save(a);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/details.fxml"));

        try {
            Parent root = fxmlLoader.load();

            ReclamationDetailsController cont = fxmlLoader.getController();
            cont.setReclamation(a);

            fxstatus.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

       /* try {
            Parent root = Loader.load();

            ReclamationDetailsController cont = fxmlLoader.getController();
            cont.setReclamation(a);

           fxtype.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }*/
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

        try {
            Parent root = fxmlLoader.load();
            fxstatus.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
