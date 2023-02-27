package com.esprit.veltun.gui.rackvelo.update;

import com.esprit.veltun.services.RackVeloService;
import com.esprit.veltun.services.impl.RackVeloImpl;
import com.esprit.veltun.model.RackVelo ;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

    public class RackveloUpdateController implements Initializable {
    public Button cancelbutton;
    private RackVeloService rackVeloService = new RackVeloImpl();

    private RackVelo rackVelo;

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





    public void setRackVelo(RackVelo rackVelo) {
        this.rackVelo = rackVelo;
        setFxrefRv(String.valueOf(rackVelo.getRefRack()));
        setFxCap(String.valueOf(rackVelo.getCapacite()));
        setFxidS(String.valueOf(rackVelo.getId_station()));


    }
    public void updateRackvelo(ActionEvent actionEvent) {
        String refRV = fxrefRv.getText();
        String cap=fxCap.getText();
        String idS=fxidS.getText();



        RackVelo rv = new RackVelo();
        rv.setRefRack(Integer.parseInt(refRV));
        rv.setId_station(Integer.parseInt(idS));
        rv.setCapacite(Integer.parseInt(cap));


        rackVelo = rackVeloService.update(rackVelo);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/details.fxml"));

        try {
            Parent root = fxmlLoader.load();

            com.esprit.veltun.gui.rackvelo.view.RackveloDetailsController cont = fxmlLoader.getController();
            cont.setRackvelo(rackVelo);

            fxrefRv.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
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

        //tfheuredebut.setTextFormatter(formatter);
    }

    public void cancel(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

        try {
            Parent root = fxmlLoader.load();
            fxrefRv.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
