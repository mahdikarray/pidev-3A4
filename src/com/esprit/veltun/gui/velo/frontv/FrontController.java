package com.esprit.veltun.gui.velo.frontv;

import com.esprit.veltun.model.Velo;
import com.esprit.veltun.services.VeloService;
import com.esprit.veltun.services.impl.VeloServiceImpl;
import com.esprit.veltun.util.MyConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.controlsfx.control.Rating;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

public class FrontController implements Initializable {

    private VeloServiceImpl veloService = new VeloServiceImpl();
    @FXML
    private HBox hbox;
    public ListView<Velo> velolistvie;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        velolistvie.setCellFactory(param -> {
            return new ListCell<Velo>() {
                @Override
                protected void updateItem(Velo velo, boolean empty) {
                    super.updateItem(velo, empty);

                    if (empty || velo == null) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        Image image = velo.getImage();
                        ImageView imageView = new ImageView(image);
                        imageView.setFitHeight(100);
                        imageView.setFitWidth(100);

                        // Ajouter l'image et la note à un VBox
                        VBox vbox = new VBox(imageView);
                        setText(velo.getLibelle() + "\t\t" + velo.getTaille() + "\t\t" + velo.getCouleur());

                        Rating rating = new Rating();
                        rating.setRating(velo.getRating());
                        vbox.getChildren().add(rating);

                        // Mettre à jour la note dans la base de données lorsqu'elle est modifiée
                        rating.ratingProperty().addListener((observable, oldValue, newValue) -> {
                            int newRating = newValue.intValue();
                            int id = velo.getId();
                            String updateQuery = "UPDATE velo SET rating = " + newRating + " WHERE idv = " + id;
                            try {
                                Connection conn = MyConnection.getInstance();
                                Statement st = conn.createStatement();
                                int rowsAffected = st.executeUpdate(updateQuery);
                                System.out.println(rowsAffected + " enregistrement(s) mis à jour.");

                            } catch (SQLException e) {
                                System.out.println("Failed to update rating in database.");
                                e.printStackTrace();
                            }
                        });

                        setGraphic(vbox);
                    }
                }
            };
        });

        try {
            List<Velo> velos = veloService.getAllVelos();
            velolistvie.getItems().addAll(velos);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}