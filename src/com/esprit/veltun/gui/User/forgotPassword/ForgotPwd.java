package com.esprit.veltun.gui.User.forgotPassword;

import com.esprit.veltun.model.User;
import com.esprit.veltun.services.impl.UserServiceImpl;
import com.esprit.veltun.util.JavaMail;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ForgotPwd {
    public TextField emailUser;
    public Button forgotPwdButton;

    public void confirmPwd(ActionEvent actionEvent) {
        String email = emailUser.getText();
        UserServiceImpl usi= new UserServiceImpl();
        User u= usi.findByEmail(email);
        System.out.println(u.toString());
        if(u.getEmail()!=null){
            try {
                JavaMail.sendMail(u.getEmail(),"Greetings; \n this is an automated password recovery Email, please do not reply to it\n Your password is:\n "+u.getPassword());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Email not fount");
            alert.setHeaderText(null);
            alert.setContentText("No such account exists, please ma");
            alert.showAndWait();
        }



    }
}
