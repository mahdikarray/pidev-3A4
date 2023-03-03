package com.esprit.veltun.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.esprit.veltun.model.Offre;
import com.esprit.veltun.services.impl.OffreServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class offreController implements Initializable {
    @FXML
    private TextField fxIdO;
    @FXML
    private TextField fxPrixO;
    @FXML
    private Button fxajouterOff;
    @FXML
    private Button fxModifOff;
    @FXML
    private Button fxDeleteOff;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private void addoffre(ActionEvent event) {

        int id = Integer.parseInt(fxIdO.getText());
        Float Prix = Float.valueOf(fxPrixO.getText());
        Offre p = new Offre(id,Prix);
        OffreServiceImpl pc = new OffreServiceImpl();
        pc.save(p);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Details.fxml"));
        try {
            Parent root = loader.load();
            detailsController dc = loader.getController();
            dc.setFxidO(p.getId_offre());
            dc.setFxPrixO(p.getPrix());

            fxIdO.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @FXML
    private void updateOff(ActionEvent event) {

        int id = Integer.parseInt(fxIdO.getText());
        Float Prix = Float.valueOf(fxPrixO.getText());
        Offre p = new Offre(id,Prix);
        OffreServiceImpl pc = new OffreServiceImpl();
        pc.update(p);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Details.fxml"));
        try {
            Parent root = loader.load();
            detailsController dc = loader.getController();
            dc.setFxidO(p.getId_offre());
            dc.setFxPrixO(p.getPrix());

            fxIdO.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @FXML
    private void DelOff(ActionEvent event) {

        int id = Integer.parseInt(fxIdO.getText());
        //Float Prix = Float.valueOf(fxPrixO.getText());
        Offre p = new Offre(id);
        OffreServiceImpl pc = new OffreServiceImpl();
        pc.remove(id);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Details.fxml"));
        try {
            Parent root = loader.load();
            detailsController dc = loader.getController();
            dc.setFxidO(p.getId_offre());
            //dc.setFxPrixO(p.getPrix());

            fxIdO.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
