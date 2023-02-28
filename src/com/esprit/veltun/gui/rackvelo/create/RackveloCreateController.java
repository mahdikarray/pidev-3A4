package com.esprit.veltun.gui.rackvelo.create;
import com.esprit.veltun.gui.rackvelo.view.RackveloDetailsController;
import com.esprit.veltun.services.RackVeloService;
import com.esprit.veltun.services.impl.RackVeloImpl;
import com.esprit.veltun.model.RackVelo;
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

public class RackveloCreateController implements Initializable {
    public Button cancelbutton;
    private RackVeloService RackVeloService = new RackVeloImpl();

    public TextField fxrefRv;
    public TextField fxidS;
    public TextField fxCap;;

    public void saveRackvelo(ActionEvent actionEvent) {
        String idS= fxidS.getText();
        String refRV=fxrefRv.getText();
        String cap =fxCap.getText();


        RackVelo rv = new RackVelo();
        rv.setId_station(Integer.parseInt(idS));
        rv.setRefRack(Integer.parseInt(refRV));
        rv.setCapacite(Integer.parseInt(cap));


        rv = RackVeloService.save(rv);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/details.fxml"));

        try {
            Parent root = fxmlLoader.load();

            RackveloDetailsController cont = fxmlLoader.getController();
            cont.setRackvelo(rv);

            fxrefRv.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

        try {
            Parent root = Loader.load();

            RackveloDetailsController cont = fxmlLoader.getController();
            cont.setRackvelo(rv);

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
        //tfheurefin.setTextFormatter(formatter);

    }
    public void cancel(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

        try {
            Parent root = fxmlLoader.load();
            fxrefRv.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    } }