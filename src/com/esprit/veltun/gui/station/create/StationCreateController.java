package com.esprit.veltun.gui.station.create;

import com.esprit.veltun.gui.station.view.StationDetailsController;
import com.esprit.veltun.services.StationService;
import com.esprit.veltun.services.impl.StationServiceImpl;
import com.esprit.veltun.model.Station;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import static com.sun.javafx.robot.impl.FXRobotHelper.getChildren;

public class StationCreateController implements Initializable {
    public Button cancelbutton, mapFX;
    private StationService StationService = new StationServiceImpl();

    @FXML
    public TextField fxidStation;
    @FXML
    public WebView mapfx;

    @FXML
    public TextField fxnomStation;
    @FXML
    public TextField fxLongitude;
    @FXML
    public TextField fxLatitude;
    @FXML
    private Button buttonRv;
    @FXML
    public ChoiceBox<String> gouv;
    private String[] gouvernorat = {"Ariana Ville", "Ettadhamen", "Kalâat el-Andalous", "La Soukra", "Mnihla", "Raoued", "Sidi Thabet"};


    public void saveStation(ActionEvent actionEvent) {
        // String idS= fxidStation.getText();
        String lat = fxLatitude.getText();
        String longi = fxLongitude.getText();
        String nomS = fxnomStation.getText();

//Les controles de saisies !!
        if (lat.isEmpty() || longi.isEmpty() || nomS.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the form .");
            alert.showAndWait();
            return;
        }

        if (!nomS.matches("[a-zA-Z]+")) {
            // Si le nom contient autre chose que des lettres et des espaces, afficher un message d'erreur
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill the name field with letters only .");
            alert.showAndWait();
            return;
        }

        if (lat.matches("[a-zA-Z]+") || longi.matches("[a-zA-Z]+")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill the longitude and latitude fields with numbers only .");
            alert.showAndWait();
            return;
        }
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to save the data?");
        Optional<ButtonType> result = confirm.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {

        Station s = new Station();
        s.setnom_station(nomS);
        s.setlongitude(Double.parseDouble(longi));
        s.setlatitude(Double.parseDouble(lat));
        s.setGouvernorat(gouv.getValue());
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

}
    private void getChoice(ChoiceBox<String> choiceBox) {
        String gouvernorat = choiceBox.getValue() ;
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
        gouv.getItems().addAll(gouvernorat);


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

    public void openMap (ActionEvent actionEvent){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../map/map.fxml"));
            Stage primaryStage =new Stage() ;
            primaryStage.setTitle("Find you localisation !");
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }


    private Stage stage ;
    private Scene scene ;

    private Parent root ;


//To switch from my manage stations interface to the manage the racks interface
    public void switchToRackVelo(ActionEvent event) throws IOException {
         root = FXMLLoader.load(getClass().getResource("../../rackvelo/create/create.fxml")) ;
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();

    }

    public void switchToRacksFromAdd(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../../backend/stationsCRUDinterface.fxml")) ;
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }
}
