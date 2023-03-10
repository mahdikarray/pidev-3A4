package com.esprit.veltun.gui.rackStation.station.update;

import com.esprit.veltun.model.Station;
import com.esprit.veltun.services.StationService;
import com.esprit.veltun.services.impl.StationServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

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
        //setFxidStation(String.valueOf(station.getid_station()));
        setFxnomStation(station.getnom_station());
        setFxLongitude(String.valueOf(station.getlongitude()));
        setFxLatitude(String.valueOf(station.getlatitude()));

    }
    public void updateEvent(ActionEvent actionEvent) {
       // String idS= fxidStation.getText();
        String nomS=fxnomStation.getText();
        String longi=fxLongitude.getText();
        String lati=fxLatitude.getText();



//Les controles de saisies !!
        if (lati.isEmpty() || longi.isEmpty() || nomS.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the form .");
            alert.showAndWait();
            return;
        }

        if(!nomS.matches("[a-zA-Z]+"))  {
            // Si le nom contient autre chose que des lettres et des espaces, afficher un message d'erreur
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill the name field with letters only .");
            alert.showAndWait();
            return;
        }

        if(lati.matches("[a-zA-Z]+") || longi.matches("[a-zA-Z]+"))  {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill the longitude and latitude fields with numbers only .");
            alert.showAndWait();
            return;
        }

        Station s = new Station();
        //s.setid_station(Integer.parseInt(idS));
        StationServiceImpl.selectedStation.setnom_station(nomS);
        StationServiceImpl.selectedStation.setlongitude(Double.parseDouble(longi));
        StationServiceImpl.selectedStation.setlatitude(Double.parseDouble(lati));

        StationServiceImpl.selectedStation=stationService.update(StationServiceImpl.selectedStation);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/details.fxml"));

        try {
            Parent root = fxmlLoader.load();

            com.esprit.veltun.gui.rackStation.station.view.StationDetailsController cont = fxmlLoader.getController();
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
    private Stage stage ;
    private Scene scene ;

    private Parent root ;
    public void switchToRacksFromUpdate(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../../backend/stationsCRUDinterface.fxml")) ;
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }
}
