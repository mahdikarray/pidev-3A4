package com.esprit.veltun.gui.rackStation.station.frontend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.web.WebView;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class frontendController implements Initializable {
    
    
    
    @FXML
    public ChoiceBox<String> departureStation;
    @FXML
    public ChoiceBox<String> arrivalStation;
    public WebView map;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String mapUrl = "https://goo.gl/maps/E92HAwWS5119EqEo8";
        map.getEngine().load(mapUrl);




        listStationDeparture();
    listStationArrival();

        // String idS= fxidStation.getText();
        String chDep = departureStation.getItems().toString();
        String chArr = arrivalStation.getItems().toString();



//Les controles de saisies !!
        if (chDep.isEmpty() || chArr.isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please choose the departure and destination.");
            alert.showAndWait();
            return;
        }

    }
    public void listStationDeparture() {
        Connection conn=null;
        try {
            ObservableList<String> listStation= FXCollections.observableArrayList();
            String consulta = "SELECT `Nom_station` from station";
            conn = DriverManager.getConnection("jdbc:mysql://localhost/veltun", "root", "");
            PreparedStatement ps =conn.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            while ( rs.next() )
            {
                listStation.add(rs.getString("Nom_station"));


            }

            departureStation.setItems(listStation);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void listStationArrival() {
        Connection conn=null;
        try {
            ObservableList<String> listStation= FXCollections.observableArrayList();
            String consulta = "SELECT `Nom_station` from station";
            conn = DriverManager.getConnection("jdbc:mysql://localhost/veltun", "root", "");
            PreparedStatement ps =conn.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            while ( rs.next() )
            {
                listStation.add(rs.getString("Nom_station"));


            }

            arrivalStation.setItems(listStation);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
