package com.esprit.veltun.gui;
import com.esprit.veltun.model.Station;
import com.esprit.veltun.services.impl.StationServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

    String nom_station ;
    @FXML
     private void addstation(ActionEvent event) {
        try {
           nom_station =String.join(nomstationFX1.getText());
        }
        catch(NumberFormatException nfe){
            myLabel.setText("Please enter a name !");
        }
        catch(Exception e){
            myLabel.setText("Error");
        }
        String nom_station= String.valueOf(nomstationFX1.getText());
        Double longitude  = Double.parseDouble(longitudeFX1.getText());
        Double latitude  = Double.parseDouble(latitudeFX1.getText());

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
            nom_station =String.join(nomstationFX11.getText());
        }
        catch(NumberFormatException nfe){
            myLabel.setText("Please enter a name !");
        }
        catch(Exception e){
            myLabel.setText("Error");
        }
        int idstation=Integer.parseInt(idstationFX11.getText());
        String nom_station = String.valueOf(nomstationFX11.getText());
        Double longitude  = Double.parseDouble(longitudeFX11.getText());
        Double latitude  = Double.parseDouble(latitudeFX11.getText());

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
        try {
            nom_station =String.join(nomstationFX11.getText());
        }
        catch(NumberFormatException nfe){
            myLabel.setText("Please enter a name !");
        }
        catch(Exception e){
            myLabel.setText("Error");
        }
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
    /*private void deletestation(ActionEvent event) {

        int id_station = Integer.parseInt(idstationFX.getText());
        StationServiceImpl ss = new StationServiceImpl();
        ss.remove();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("stationGUI.fxml"));
        try {
            Parent root = loader.load();
            stationController sc = loader.getController();
            sc.setIdstationFX(sc.getIdstationFX());
            sc.setNomstationFX(sc.getNomstationFX());
            sc.setLatitudeFX(sc.getLatitudeFX());
            sc.setLongitudeFX(sc.getLongitudeFX());

            idstationFX.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }*/
}
