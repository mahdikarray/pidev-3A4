package com.esprit.veltun.gui;
import com.esprit.veltun.model.RackVelo;
import com.esprit.veltun.model.Station;
import com.esprit.veltun.services.impl.RackVeloImpl;
import com.esprit.veltun.services.impl.StationServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Double.parseDouble;

public class stationController  implements Initializable {
    @FXML
    private TextField idstationFX , idstationFX12 , nomstationFX , longitudeFX ,latitudeFX,idstationFX1 , nomstationFX1 , longitudeFX1 ,latitudeFX1,idstationFX11 , nomstationFX11 , longitudeFX11 ,latitudeFX11 ;

    public TextField getIdstationFX() {
        return idstationFX;
    }

    public TextField getNomstationFX() {
        return nomstationFX;
    }
    @FXML
    private Label myLabel ;

    public Button getAddstationFX() {
        return addstationFX;
    }

    public void setNomstationFX(TextField nomstationFX) {
        this.nomstationFX = nomstationFX;
    }

    public void setLongitudeFX(TextField longitudeFX) {
        this.longitudeFX = longitudeFX;
    }

    public void setAddstationFX(Button addstationFX) {
        this.addstationFX = addstationFX;
    }

    public void setLatitudeFX(TextField latitudeFX) {
        this.latitudeFX = latitudeFX;
    }

    public void setIdstationFX(TextField idstationFX) {
        this.idstationFX = idstationFX;
    }

    public TextField getLatitudeFX() {
        return latitudeFX;
    }

    public TextField getLongitudeFX() {
        return longitudeFX;
    }

    @FXML
    private Button addstationFX ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
     private void addstation(ActionEvent event) {
        String idS= idstationFX.getText();
        String lat= latitudeFX.getText();
        String longi= longitudeFX.getText();
        String nomS= nomstationFX.getText();

        if (idS.isEmpty() || lat.isEmpty() || longi.isEmpty() || nomS.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the form .");
            alert.showAndWait();
            return;
        }

        if(nomS.equals("[a-zA-Z ]+") ) {
            // Si le nom contient autre chose que des lettres et des espaces, afficher un message d'erreur
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter numbers");
            alert.showAndWait();
            return;
        }


    String nom_station= String.valueOf(nomstationFX1.getText());
    Double longitude= parseDouble(longitudeFX.getText());
    Double latitude= parseDouble(latitudeFX.getText());


        Station s = new Station(nom_station,longitude,latitude);
        StationServiceImpl ss = new StationServiceImpl();

        ss.save(s);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("stationGUI.fxml"));
        try {
            Parent root = loader.load();
            stationController sc = loader.getController();
            sc.setIdstationFX(sc.getIdstationFX());
            sc.setNomstationFX(sc.getNomstationFX());
            sc.setLatitudeFX(sc.getLatitudeFX());
            sc.setLongitudeFX(sc.getLongitudeFX());

            nomstationFX1.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @FXML
    private void updatestation(ActionEvent event) {
        try {
            String nom_station =String.join(nomstationFX11.getText());
        }
        catch(NumberFormatException nfe){
            myLabel.setText("Please enter a name !");
        }
        catch(Exception e){
            myLabel.setText("Error");
        }
        int idstation=Integer.parseInt(idstationFX11.getText());
        String nom_station = String.valueOf(nomstationFX11.getText());
        Double longitude  = parseDouble(longitudeFX11.getText());
        Double latitude  = parseDouble(latitudeFX11.getText());

        Station s = new Station(idstation,nom_station,longitude,latitude);
        StationServiceImpl ss = new StationServiceImpl();

        ss.update(s);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("stationGUI.fxml"));
        try {
            Parent root = loader.load();
            stationController sc = loader.getController();
            sc.setIdstationFX(sc.getIdstationFX());
            sc.setNomstationFX(sc.getNomstationFX());
            sc.setLatitudeFX(sc.getLatitudeFX());
            sc.setLongitudeFX(sc.getLongitudeFX());

            idstationFX11.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @FXML
    private void deletstat(ActionEvent event) {

            String nom_station =String.join(nomstationFX11.getText());
            int idstation=Integer.parseInt(idstationFX12.getText());
       // String nom_station = String.valueOf(nomstationFX.getText());
       // Double longitude  = Double.parseDouble(longitudeFX.getText());
        //Double latitude  = Double.parseDouble(latitudeFX.getText());

        Station s = new Station(idstation);
        StationServiceImpl ss = new StationServiceImpl();

        ss.remove(idstation);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("stationGUI.fxml"));
        try {
            Parent root = loader.load();
            stationController sc = loader.getController();
            sc.setIdstationFX(sc.getIdstationFX());
            sc.setNomstationFX(sc.getNomstationFX());
            sc.setLatitudeFX(sc.getLatitudeFX());
            sc.setLongitudeFX(sc.getLongitudeFX());

            idstationFX12.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
