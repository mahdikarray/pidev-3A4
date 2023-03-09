package com.esprit.veltun.GUI;
import javafx.event.ActionEvent;
import org.controlsfx.control.Rating;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
public class Controller implements Initializable {
    @FXML
    private Rating rating;

    @FXML
    private Label msg;

    @Override
    public  void initialize (URL arg0,ResourceBundle arg1) {
        rating.ratingProperty().addListener(new ChangeListener<Number>(){

            @Override
            public void changed(ObservableValue<? extends Number> ov,Number old , Number newT){

                msg.setText("Rating:" +newT);
            }



        });

    }










}



