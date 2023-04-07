package com.esprit.veltun.gui;

import com.esprit.veltun.model.RackVelo;
import com.esprit.veltun.services.impl.RackVeloImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RackVeloController implements Initializable {
    @FXML
    private Button RVaddFX ;
    @FXML
    private Button RVmodifyFX ;
    @FXML
    private Button RVdeleteFX ;
    @FXML
    private Label myLabel ;

    @FXML
    private TextField RVrefrackFX ,RVcapaciteFX , RVidstationFX ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    int capacite ;
    @FXML
    private void addrackvelo(ActionEvent event) {
        String refer= RVrefrackFX.getText();
        String idS= RVcapaciteFX.getText();
        String cap= RVidstationFX.getText();

        if (refer.isEmpty() || idS.isEmpty() || cap.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the form .");
            alert.showAndWait();
            return;
        }

        if(refer.matches("[a-zA-Z ]+") || cap.matches("[a-zA-Z ]+") || idS.matches("[a-zA-Z ]+")  ) {
            // Si le nom contient autre chose que des lettres et des espaces, afficher un message d'erreur
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter numbers");
            alert.showAndWait();
            return;
        }






        int id_station  = Integer.parseInt(RVidstationFX.getText());
        int ref  = Integer.parseInt(RVrefrackFX.getText());
        int capacite  = Integer.parseInt(RVcapaciteFX.getText());
        RackVelo rcv = new RackVelo(ref,capacite,id_station);
        RackVeloImpl rv = new RackVeloImpl();
        rv.save(rcv);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("rackveloGUI.fxml"));
        try {
            Parent root = loader.load();
            RackVeloController rvc = loader.getController();
          rvc.setRVrefrackFX(rcv.getRefRack());
            rvc.setRVcapaciteFX(rcv.getCapacite());
            rvc.setRVidstationFX(rcv.getId_station());

            RVrefrackFX.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void update(ActionEvent event) {
/*
       // int reference = Integer.parseInt( RVrefrackFX.getText());
        try {
           capacite = Integer.parseInt(RVcapaciteFX.getText());
        }
        catch(NumberFormatException e){
           myLabel.setText("Please enter a number ! ");
        }
        catch(Exception e){
            System.out.print(e);
        }*/
        int id_station  = Integer.parseInt(RVidstationFX.getText());
        int ref  = Integer.parseInt(RVrefrackFX.getText());
        int capacite  = Integer.parseInt(RVcapaciteFX.getText());
        RackVelo rcv = new RackVelo(ref,capacite,id_station);
        RackVeloImpl rv = new RackVeloImpl();
        rv.update(rcv);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("rackveloGUI.fxml"));
        try {
            Parent root = loader.load();
            RackVeloController rvc = loader.getController();
            rvc.setRVrefrackFX(rcv.getRefRack());
            rvc.setRVcapaciteFX(rcv.getCapacite());
            rvc.setRVidstationFX(rcv.getId_station());

            RVrefrackFX.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @FXML
    private void delet(ActionEvent event) {
/*
       // int reference = Integer.parseInt( RVrefrackFX.getText());
        try {
           capacite = Integer.parseInt(RVcapaciteFX.getText());
        }
        catch(NumberFormatException e){
           myLabel.setText("Please enter a number ! ");
        }
        catch(Exception e){
            System.out.print(e);
        }*/
      //  int id_station  = Integer.parseInt(RVidstationFX.getText());
        int ref  = Integer.parseInt(RVrefrackFX.getText());
        //int capacite  = Integer.parseInt(RVcapaciteFX.getText());
        RackVelo rcv = new RackVelo(ref);
        RackVeloImpl rv = new RackVeloImpl();
        rv.remove(ref);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("rackveloGUI.fxml"));
        try {
            Parent root = loader.load();
            RackVeloController rvc = loader.getController();
            rvc.setRVrefrackFX(rcv.getRefRack());
            //rvc.setRVcapaciteFX(rcv.getCapacite());
            //rvc.setRVidstationFX(rcv.getId_station());

            RVrefrackFX.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setRVrefrackFX(int refRack) {
    }

    public void setRVcapaciteFX(int capacitee) {
    }

    public void setRVidstationFX(int Id_Station) {
    }
}
