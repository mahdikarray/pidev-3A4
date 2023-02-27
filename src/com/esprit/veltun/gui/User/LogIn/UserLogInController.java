package com.esprit.veltun.gui.User.LogIn;

import com.esprit.veltun.model.User;
import com.esprit.veltun.search.dto.UserSearchCriteria;
import com.esprit.veltun.services.impl.UserServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

public class UserLogInController {
    public TextField emailLogin;
    public TextField pwdLogin;
    public Button loginButton;

    public void setEmailLogin(String emailLogin) {
        this.emailLogin.setText(emailLogin);
    }

    public void setPwdLogin(String pwdLogin) {
        this.pwdLogin.setText(pwdLogin);
    }

    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }

    public String getEmailLogin() {
        return emailLogin.getText();
    }

    public String getPwdLogin() {
        return pwdLogin.getText();
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public void logIn(ActionEvent actionEvent) {
        String userEmail= emailLogin.getText();
        String pwdlogin = pwdLogin.getText();
        UserServiceImpl usi= new UserServiceImpl();
        User u = usi.findByEmail(userEmail);
        if(Objects.equals(userEmail, "admin") && Objects.equals(pwdlogin, "admin"))
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/search.fxml"));

            try {
                Parent root = fxmlLoader.load();
                loginButton.getScene().setRoot(root);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(u==null || !Objects.equals(u.getPassword(), pwdlogin))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("wrong password or email");
            alert.setHeaderText(null);
            alert.setContentText("reenter your coordinations");
            alert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Welcome");
            alert.setHeaderText(null);
            alert.setContentText("Welcome " + u.getPrenom() + u.getNom());
            alert.showAndWait();
        }


    }

    public void createAccount(ActionEvent actionEvent) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../create/create.fxml"));

        try {
            Parent root = fxmlLoader.load();
            loginButton.getScene().setRoot(root);

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void forgotPwd(ActionEvent actionEvent) {
    }
}
