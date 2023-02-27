package com.esprit.veltun.gui.rackvelo.view;

import com.esprit.veltun.model.RackVelo;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RackveloDetailsController implements Initializable {
    public TextField fxrefRv;
    public TextField fxidS;
    public TextField fxCap;;


    public void setFxrefRv(String refRV) {
        this.fxrefRv.setText(refRV);
    }

    public void setFxCap(String cap) {
        this.fxCap.setText(cap);
    }

    public void setFxidS(String idS) {
        this.fxidS.setText(idS);
    }


    public void setRackvelo(RackVelo rackvelo) {
        setFxrefRv(String.valueOf(rackvelo.getRefRack()));
        setFxCap(String.valueOf(rackvelo.getCapacite()));
        setFxidS(String.valueOf(rackvelo.getId_station()));
    }


    public void listRackvelo(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/search.fxml"));
        try {
            Parent root = fxmlLoader.load();
            JFXPanel ftlistRackvelo = new JFXPanel();
            ftlistRackvelo.getScene().setRoot(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}