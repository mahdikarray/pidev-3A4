package com.esprit.veltun.gui.reclamation.create;
import com.esprit.veltun.model.Reclamation;
import com.esprit.veltun.gui.reclamation.view.ReclamationDetailsController;
import com.esprit.veltun.services.ReclamationService;
import com.esprit.veltun.services.impl.ReclamationServiceImpl;
import com.esprit.veltun.services.impl.UserServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import com.esprit.veltun.gui.User.view.UserDetailsController;

public class ReclamationCreateController implements Initializable {
    public Button cancelbutton;
    public TextArea descriptionTA;
    private ReclamationService reclamationService = new ReclamationServiceImpl();
    public Button ratting;

    public String getDescription() {
        return descriptionTA.getText();
    }

    public void setDescription(String description) {
        this.descriptionTA.setText(description);
    }

    public TextField fxstatus;
    public DatePicker date_reclamation;

    public TextField fxobject;

    @FXML
    private Label discountedPriceLabel;
    private  Label errorA;
    @FXML
    private TextField discountCodeTextField;


    public void saveEvent(ActionEvent actionEvent) {

        String object= fxobject.getText();
        String description=descriptionTA.getText();
      //  String status= fxstatus.getText();
   // String date_reclamationn = String.valueOf(date_reclamation.getValue());


        if (description.length() < 10 || description.length() > 200 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Problem!");
            alert.setHeaderText(null);
            alert.setContentText("La description doit avoir entre 10 et 200 caractères");
            alert.showAndWait();
            return;
        }
        if (object.length() < 10 || object.length() > 100 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Problem!");
            alert.setHeaderText(null);
            alert.setContentText("L'objet doit avoir entre 10 et 200 caractères");
            alert.showAndWait();
            return;
        }

       /* if (!status.matches("en cours") && (!status.matches("resolu") )) {

            Alert alert = new Alert(Alert.AlertType.ERROR, "status must be either en cours or resolu ");
            alert.showAndWait();
            return;
        }*/
        UserServiceImpl usi= new UserServiceImpl();
        System.out.println(UserServiceImpl.connectedUser);


        Reclamation a= new Reclamation();

        a.setObject(object);
        a.setDescription(description);
       // a.setStatus(status);
        //a.setDate_reclamation(Date.valueOf(date_reclamationn));

        a = reclamationService.save(a);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/details.fxml"));

        try {
            Parent root = fxmlLoader.load();

            ReclamationDetailsController cont = fxmlLoader.getController();
            cont.setReclamation(a);

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

    }
    public void cancel(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../User/view/details.fxml"));
        UserDetailsController udc= new UserDetailsController();
     //   udc.setUser(UserServiceImpl.connectedUser);
        try {
            Parent root = fxmlLoader.load();
            cancelbutton.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void ra(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Scene.fxml"));

        try {
            Parent root = fxmlLoader.load();
            ratting.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
