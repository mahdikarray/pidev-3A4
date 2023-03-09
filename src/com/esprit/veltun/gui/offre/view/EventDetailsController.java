package com.esprit.veltun.gui.offre.view;

import com.esprit.veltun.model.Offre;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EventDetailsController implements Initializable {
    public TextField fxdescription1;
    public TextField fxPrix1;

    public Button ftlistEvent;



    public void setFxDescription(String desc) {
        this.fxdescription1.setText(desc);
    }





    public void setOffre(Offre offre) {
        if (offre != null) {
            setFxDescription(offre.getDescription_of());

}
    }


    public void listEvent(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/searchof.fxml"));
        try {
            Parent root = fxmlLoader.load();
            ftlistEvent.getScene().setRoot(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}