package com.esprit.veltun.gui.backend;

import com.esprit.veltun.gui.statsUi;
import com.esprit.veltun.model.RackVelo;
import com.esprit.veltun.model.Station;
import com.esprit.veltun.services.impl.RackVeloImpl;
import com.esprit.veltun.services.impl.StationServiceImpl;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

public class backendController implements Initializable {
    @FXML
    Button manageStationsButton , manageRacksButton ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    public TextField fxnomStation;
    private Stage stage ;
    private Scene scene ;

    private Parent root ;
    public void switchToStations(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("stationsCRUDinterface.fxml")) ;
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }

    public void switchToRacks(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("racksCRUDinterface.fxml")) ;
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAdd(ActionEvent event) throws IOException  {
        root = FXMLLoader.load(getClass().getResource("../station/create/create.fxml")) ;
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }

    public void switchToUpdate(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../station/update/update.fxml")) ;
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }

    public void switchToList(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../station/search/search.fxml")) ;
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDelete(ActionEvent event)throws IOException  {

    }

    public void switchToAddR(ActionEvent event)throws IOException  {
        root = FXMLLoader.load(getClass().getResource("../rackvelo/create/create.fxml")) ;
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }

    public void switchToUpdateR(ActionEvent event)throws IOException  {
        root = FXMLLoader.load(getClass().getResource("../rackvelo/update/update.fxml")) ;
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }

    public void switchToListR(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../rackvelo/view/details.fxml")) ;
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDeleteR(ActionEvent event)throws IOException  {
    }

    public void switchToHomefromCRUDStation(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("backendHome.fxml")) ;
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }

    public void switchToHomefromCRUDRacks(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("backendHome.fxml")) ;
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }


    public void goToStatistics(ActionEvent event) {
    }
}
