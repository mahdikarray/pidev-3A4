package com.esprit.veltun.gui.station.update;

import com.esprit.veltun.services.StationService;
import com.esprit.veltun.services.impl.StationServiceImpl;
import com.esprit.veltun.model.Station ;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class StationUpdateController implements Initializable {
    public Button cancelbutton;
    private StationService stationService = new StationServiceImpl();

    private Station station;

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
        this.station = station;
        setFxidStation(String.valueOf(station.getid_station()));
        setFxnomStation(station.getnom_station());
        setFxLongitude(String.valueOf(station.getlongitude()));
        setFxLatitude(String.valueOf(station.getlatitude()));

    }
    public void updateEvent(ActionEvent actionEvent) {
        String idS= fxidStation.getText();
        String nomS=fxnomStation.getText();
        String longi=fxLongitude.getText();
        String lati=fxLatitude.getText();


        Station s = new Station();
        s.setid_station(Integer.parseInt(idS));
        s.setnom_station(nomS);
        s.setlongitude(Double.parseDouble(longi));
        s.setlatitude(Double.parseDouble(lati));

        station = stationService.update(station);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/details.fxml"));

        try {
            Parent root = fxmlLoader.load();

            com.esprit.veltun.gui.station.view.StationDetailsController cont = fxmlLoader.getController();
            cont.setStation(station);

            fxnomStation.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
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

        //tfheuredebut.setTextFormatter(formatter);
    }

    public void cancel(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

        try {
            Parent root = fxmlLoader.load();
            fxnomStation.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
