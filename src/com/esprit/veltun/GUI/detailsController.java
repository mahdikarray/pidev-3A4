package com.esprit.veltun.GUI;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.esprit.veltun.model.Offre;
import com.esprit.veltun.services.impl.OffreServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import static java.lang.Integer.parseInt;

public class detailsController implements Initializable {
    public void setFxidO(TextField fxidO) {
        this.fxidO = fxidO;
    }

    @FXML
    private TextField fxidO;
    @FXML
    private Button fxenrOff;
    @FXML
    private Button fxshoOff;

    public void setFxPrixO(TextField fxPrixO) {
        this.fxPrixO = fxPrixO;
    }

    @FXML
    private TextField fxPrixO;
    @FXML
    private TableColumn<offre, Float> fxPrixOf;


    @FXML
    private TableColumn<offre, Integer> fxidOf;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void save(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Offre enregisté!");
        alert.show();
    }

    public void setFxidO(int idOffre) {
    }


    public void setFxPrixO(float prix) {
    }


}
