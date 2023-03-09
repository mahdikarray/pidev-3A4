package com.esprit.veltun.GUI.abonnementt.create;

import com.esprit.veltun.model.Abonnement;
import com.esprit.veltun.GUI.abonnementt.view.EventDetailsController;
import com.esprit.veltun.model.Adresse;
import com.esprit.veltun.services.AbonnementService;
import com.esprit.veltun.services.impl.AbonnementServiceImpl;
//import com.google.zxing.common.ByteMatrix;
import com.esprit.veltun.services.impl.OffreServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;


import java.io.IOException;
import java.net.URL;

import java.sql.Date;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class AbonnementCreateController implements Initializable {
    public Button cancelbutton;
    private AbonnementService abonnementService = new AbonnementServiceImpl();

    public TextField fxType_ab;
    public TextField fxDureeab;
    public DatePicker Adatedebut;
    public DatePicker Adatefin;
    public TextField fxPrixAb;
    public TextField fxCIN;
    public TextField fxidO;
    @FXML
    private Label codeLabel;
    @FXML
    private TextField priceField;

    @FXML
    private Label discountedPriceLabel;
    private  Label errorA;
    @FXML
    private TextField discountCodeTextField;
    @FXML
    private ImageView qrCodeImageView;


    public void saveEvent(ActionEvent actionEvent) {
        String type = fxType_ab.getText();

        Date dateDebut = new Date(System.currentTimeMillis());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateDebut);

        if (type.equalsIgnoreCase("Standard")) {
            calendar.add(Calendar.MONTH, 1);
        } else if (type.equalsIgnoreCase("Premium")) {
            calendar.add(Calendar.MONTH, 3);
        } else if (type.equalsIgnoreCase("Premium+")) {
            calendar.add(Calendar.MONTH, 12);
        }

        Date dateFin = new Date(calendar.getTimeInMillis());

        String prix = fxPrixAb.getText();

        if (type.isEmpty() || prix.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Problem!");
            alert.setHeaderText(null);
            alert.setContentText("Enter valid type and Price");
            alert.showAndWait();
            return;
        }

        if (dateDebut.after(dateFin)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Enter a valid date!!");
            alert.showAndWait();
            return;
        }

        if (!type.matches("Standard") && (!type.matches("Premium") && (!type.matches("Premium\\+")))) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Type must be either Standard or Premium or Premium+");
            alert.showAndWait();
            return;
        }

        if (!prix.matches("\\d+(\\.\\d+)?")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Price must be a decimal number.");
            alert.showAndWait();
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to save the data?");
        Optional<ButtonType> result = confirm.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {

            Abonnement a = new Abonnement();
            a.setType_ab(type);
            a.setDateDebut(dateDebut);
            a.setDateFin(dateFin);
            a.setPrix_ab(Float.parseFloat(prix));
            a.setId_offre(OffreServiceImpl.l);

            a = abonnementService.save(a);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/details.fxml"));

            try {
                Parent root = fxmlLoader.load();

                EventDetailsController cont = fxmlLoader.getController();
                cont.setAbonnement(a);

                fxType_ab.getScene().setRoot(root);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            FXMLLoader Loader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

            try {
                Parent root = Loader.load();

                EventDetailsController cont = fxmlLoader.getController();
                cont.setAbonnement(a);

                fxType_ab.getScene().setRoot(root);
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

        try {
            Parent root = fxmlLoader.load();
            fxType_ab.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


}

