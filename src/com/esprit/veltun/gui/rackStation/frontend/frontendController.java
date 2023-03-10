package com.esprit.veltun.gui.rackStation.frontend;

import com.esprit.veltun.gui.User.view.UserDetailsController;
import com.esprit.veltun.services.impl.UserServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class frontendController implements Initializable {

    @FXML
    public ChoiceBox<String> departureStation;
    @FXML
    public ChoiceBox<String> arrivalStation;
    public Button toHome;
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

    public void toHome(ActionEvent actionEvent) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../User/view/details.fxml"));

        try {
            Parent root = fxmlLoader.load();

            UserDetailsController cont = fxmlLoader.getController();
            cont.setUser(UserServiceImpl.connectedUser);
            toHome.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
