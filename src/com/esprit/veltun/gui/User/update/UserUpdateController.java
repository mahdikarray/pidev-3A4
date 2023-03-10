package com.esprit.veltun.gui.User.update;

import com.esprit.veltun.gui.User.view.UserDetailsController;
import com.esprit.veltun.model.User;
import com.esprit.veltun.services.impl.UserServiceImpl;
import com.esprit.veltun.util.MyConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class UserUpdateController implements Initializable {
    public Button cancelbutton;
    Connection conn= MyConnection.getInstance();
    private User user;

    public TextField cinTF;
    public TextField nomTF;
    public TextField prenomTF;
    public TextField emailTF;
    public DatePicker dateTF;
    public TextField codePostalTF;
    public TextField passwordTF;

    public TextField getPasswordTF() {
        return passwordTF;
    }


    public void setPasswordTF(String passwordTF) {
        this.passwordTF.setText(passwordTF);
    }





    public TextField getCinTF() {
        return cinTF;
    }

    public TextField getNomTF() {
        return nomTF;
    }

    public TextField getPrenomTF() {
        return prenomTF;
    }

    public TextField getEmailTF() {
        return emailTF;
    }

    public DatePicker getDateTF() {
        return dateTF;
    }

    public TextField getCodePostalTF() {
        return codePostalTF;
    }

    public void setCinTF(String cinTF) {
        this.cinTF.setText(cinTF);
    }

    public void setNomTF(String nomTF) {
        this.nomTF.setText(nomTF);
    }

    public void setPrenomTF(String prenomTF) {
        this.prenomTF.setText(prenomTF);
    }

    public void setEmailTF(String emailTF) {
        this.emailTF.setText(emailTF);
    }

    public void setDateTF(Date dateTF) {
        this.dateTF.setValue(dateTF.toLocalDate());
    }

    public void setCodePostalTF(int codePostalTF) {
        this.codePostalTF.setText(String.valueOf(codePostalTF));
    }

    public void setUser(User user) {
        this.user= user;
        setCinTF(user.getCIN());
        setNomTF(user.getNom());
        setPrenomTF(user.getPrenom());
        setEmailTF(user.getEmail());
        setDateTF(user.getDateNaiss());
        setCodePostalTF(user.getCodePos());
        setPasswordTF(user.getPassword());

    }
    public void updateUser(ActionEvent actionEvent) {
        String cin= cinTF.getText();
        String nom=nomTF.getText();
        String prenom = prenomTF.getText();
        String email = emailTF.getText();
        Date dateNaiss = Date.valueOf(dateTF.getValue());
        int codePost= Integer.parseInt(codePostalTF.getText());
        String password = passwordTF.getText();

        User user = new User(cin,nom,prenom,dateNaiss,"user",codePost,email,password);
        System.out.println("form pwd" + password);
        UserServiceImpl usi= new UserServiceImpl();
        usi.update(user);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

        try {
            Parent root = fxmlLoader.load();

            //UserDetailsController cont = fxmlLoader.getController();
            //cont.setUser(user);

            cinTF.getScene().setRoot(root);
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

        //emailTF.setTextFormatter(formatter);
    }

    public void cancel(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

        try {
            Parent root = fxmlLoader.load();
            cinTF.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
