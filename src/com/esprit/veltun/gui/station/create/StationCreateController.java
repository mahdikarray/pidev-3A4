package com.esprit.veltun.gui.station.create;

import com.esprit.veltun.gui.station.view.StationDetailsController;
import com.esprit.veltun.services.StationService;
import com.esprit.veltun.services.impl.StationServiceImpl;
import com.esprit.veltun.model.Station;
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

public class StationCreateController implements Initializable {
    public Button cancelbutton;
    private StationService StationService = new StationServiceImpl();

    public TextField fxidStation;
    public TextField fxnomStation;
    public TextField fxLongitude;
    public TextField fxLatitude;

    public void saveStation(ActionEvent actionEvent) {

        String nomS=this.fxnomStation.getText();
        String longi=this.fxLongitude.getText();
        String lati=this.fxLatitude.getText();

        Station s = new Station();

        s.setnom_station(nomS);
        s.setlongitude(Double.parseDouble(longi));
        s.setlatitude(Double.parseDouble(lati));

        s = StationService.save(s);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/details.fxml"));

        try {
            Parent root = fxmlLoader.load();

            StationDetailsController cont = fxmlLoader.getController();
            cont.setStation(s);

            fxnomStation.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

        try {
            Parent root = Loader.load();

            StationDetailsController cont = fxmlLoader.getController();
            cont.setStation(s);

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
        //tfheurefin.setTextFormatter(formatter);

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
