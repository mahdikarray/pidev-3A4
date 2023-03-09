package com.esprit.veltun.gui.velo.create;

import com.esprit.veltun.gui.velo.view.*;

import com.esprit.veltun.model.Velo;
import com.esprit.veltun.services.VeloService;
import com.esprit.veltun.services.impl.VeloServiceImpl;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;

import javafx.stage.FileChooser;

import java.io.*;
import javax.imageio.ImageIO;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import javax.imageio.ImageIO;


public class VeloCreateController implements Initializable {
    public Button cancelbutton;
    private VeloService veloService = new VeloServiceImpl();

    public TextField tflibelle;
    public TextField tftaille;
    public TextField tfcouleur;
    @FXML
    private Button selectImageButton;
    private ImageView imageView;

    public TextField tffournisseur;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageView = new ImageView();

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
    public void saveVelo(ActionEvent actionEvent) {
        String libellev = tflibelle.getText();
        String taillev = tftaille.getText();
        String couleurv = tfcouleur.getText();
        int idf = Integer.parseInt(tffournisseur.getText());

        if (libellev.isEmpty() || taillev.isEmpty() || couleurv.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs!!");
            alert.showAndWait();
            return;
        }

        Velo velo = new Velo();
        velo.setLibelle(libellev);
        velo.setTaille(taillev);
        velo.setCouleur(couleurv);
        velo.setIdf(idf);

        // Get the image from the image view and convert it to a byte array
        Image image = imageView.getImage();
        byte[] imageBytes = null;
        if (image != null) {
            try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", byteArrayOutputStream);
                imageBytes = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        VeloServiceImpl veloService = new VeloServiceImpl();

        veloService.savee(velo, imageBytes);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/details.fxml"));
        addNotifications("Succes", "Velo ajouté");

        try {
            Parent root = fxmlLoader.load();

            VeloDetailsController cont = fxmlLoader.getController();
            cont.setVelo(velo);
            tflibelle.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void cancel(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

        try {
            Parent root = fxmlLoader.load();
            tflibelle.getScene().setRoot(root);
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

    public void selectImage(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(selectImageButton.getScene().getWindow());
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);
        }
    }
}
