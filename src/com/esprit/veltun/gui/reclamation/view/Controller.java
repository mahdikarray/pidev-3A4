package com.esprit.veltun.gui.reclamation.view;

import com.esprit.veltun.services.impl.MaintenanceServiceImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.controlsfx.control.Rating;

import java.net.URL;
import java.util.ResourceBundle;

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
                System.out.println(newT);
                MaintenanceServiceImpl.rating=newT;
                MaintenanceServiceImpl rsi= new MaintenanceServiceImpl();
                rsi.updateRating(rsi.findById(6));

            }



        });

    }










}



