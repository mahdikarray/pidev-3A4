package com.esprit.veltun.gui.station.view;

import com.esprit.veltun.model.RackVelo;
import com.esprit.veltun.model.Station;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StationDetailsController implements Initializable {
    public TextField fxidStation;
    public TextField fxnomStation;
    public TextField fxLongitude;
    public TextField fxLatitude;


    public void setFxidStation(String idS) {
        this.fxidStation.setText(idS);
    }

    public void setFxnomStation(String nomS) {
        this.fxnomStation.setText(nomS);
    }

    public void setFxLongitude(String longi) {
        this.fxLongitude.setText(longi);
    }

    public void setFxLatitude(String lati) {this.fxLatitude.setText(lati);}



    public void setStation(Station station) {
        //setFxidStation(String.valueOf(station.getid_station()));
        setFxnomStation(station.getnom_station());
        setFxLongitude(String.valueOf(station.getlongitude()));
       setFxLatitude(String.valueOf(station.getlatitude()));
    }


    public void listStation(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/search.fxml"));
        try {
            Parent root = fxmlLoader.load();
            JFXPanel ftlistStation = new JFXPanel();
            ftlistStation.getScene().setRoot(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}

