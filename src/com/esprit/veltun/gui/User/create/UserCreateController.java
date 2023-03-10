package com.esprit.veltun.gui.User.create;

import com.esprit.veltun.gui.User.view.UserDetailsController;
import com.esprit.veltun.model.User;
import com.esprit.veltun.services.impl.UserServiceImpl;
import com.esprit.veltun.util.MyConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class UserCreateController implements Initializable {
    public Button cancelbutton;
    Connection conn= MyConnection.getInstance();
    public TextField cinTF;
    public TextField nomTF;
    public TextField prenomTF;
    public TextField emailTF;
    public DatePicker dateTF;
    public TextField codePostalTF;
    public TextField passwordTF;
    public void saveUser(ActionEvent actionEvent) {



        int cinInt;
        int codePostal;
        String cin = cinTF.getText();
        String nom = nomTF.getText();
        String prenom = prenomTF.getText();
        String email = emailTF.getText();
        Date dateNaiss ;
        String password = passwordTF.getText();



        try {
            dateNaiss=Date.valueOf(dateTF.getValue());
        }
        catch(Exception ex)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("La date doit etre valide");
            alert.showAndWait();

        }




        try
        {
            int cinNum=Integer.parseInt(cin);
        }
        catch (NumberFormatException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("CIN doit etre numerique");
            alert.showAndWait();

        }

        if(codePostalTF.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("champ requie.");
            alert.showAndWait();
            return;
        }
        else{
            codePostal = Integer.parseInt(codePostalTF.getText());
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        dateNaiss=Date.valueOf(dateTF.getValue());
        String strDate = dateFormat.format(dateNaiss);



        if (cin.isEmpty() || nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || strDate.isEmpty()|| codePostalTF.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs.");
            alert.showAndWait();
        }
        else if (cin.length()!=8) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("CIN invalide");
            alert.showAndWait();
        }

        else {
            User u = new User(cin, nom, prenom, dateNaiss, "user", codePostal, email,password);
            UserServiceImpl usi = new UserServiceImpl();
            usi.save(u);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/details.fxml"));

        try {
            Parent root = fxmlLoader.load();

            UserDetailsController cont = fxmlLoader.getController();
            cont.setUser (u);

            cinTF.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

        try {
            Parent root = Loader.load();

            UserDetailsController cont = fxmlLoader.getController();
            cont.setUser(u);

            cinTF.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        }    }

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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../LogIn/LogIn.fxml"));

        try {
            Parent root = fxmlLoader.load();
            cinTF.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
