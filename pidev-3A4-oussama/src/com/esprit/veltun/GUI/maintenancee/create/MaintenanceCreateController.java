package com.esprit.veltun.GUI.maintenancee.create;
import com.esprit.veltun.model.Maintenance;
import com.esprit.veltun.GUI.maintenancee.view.MaintenanceDetailsController;
import com.esprit.veltun.services.MaintenanceService;
import com.esprit.veltun.services.impl.MaintenanceServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import static java.sql.Date.valueOf;
public class MaintenanceCreateController implements Initializable {
    public Button cancelbutton;
    private MaintenanceService maintenanceService = new MaintenanceServiceImpl();

    public TextField fxdescription;
    public DatePicker submission_date;

    public TextField fxstatus;
    @FXML
    private Label discountedPriceLabel;
    private  Label errorA;
    @FXML
    private TextField discountCodeTextField;

    public void saveEvent(ActionEvent actionEvent) {
        String description= fxdescription.getText();
        String status= fxstatus.getText();
        String submission_datee = String.valueOf(submission_date.getValue());
        if (description.length() < 10 || description.length() > 200 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Problem!");
            alert.setHeaderText(null);
            alert.setContentText("La description doit avoir entre 10 et 200 caractères");
            alert.showAndWait();
            return;
        }

        if (!status.matches("en cours") && (!status.matches("resolu") )) {

            Alert alert = new Alert(Alert.AlertType.ERROR, "status must be either en cours or resolu ");
            alert.showAndWait();
            return;
        }



        Maintenance a1= new Maintenance();
        a1.setDescription(description);
        a1.setStatus(status);
        a1.setSubmission_date(Date.valueOf(submission_datee));

        a1 = maintenanceService.save(a1);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/details.fxml"));

        try {
            Parent root = fxmlLoader.load();

            MaintenanceDetailsController cont = fxmlLoader.getController();
            cont.setMaintenance(a1);

            fxstatus.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

       /* try {
            Parent root = Loader.load();

            ReclamationDetailsController cont = fxmlLoader.getController();
            cont.setReclamation(a);

           fxtype.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }*/
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
            fxstatus.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
