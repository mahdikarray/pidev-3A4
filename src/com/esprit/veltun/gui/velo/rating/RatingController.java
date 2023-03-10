package com.esprit.veltun.gui.velo.rating;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.controlsfx.control.Rating;

import java.net.URL;
import java.util.ResourceBundle;

public class RatingController implements Initializable {
    @FXML
    public Rating rating;
    @FXML
    public Label msg;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rating.ratingProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                msg.setText("Rating: "+newValue);
            }
        });

    }
}