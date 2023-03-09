package com.esprit.veltun.GUI.abonnementt.view;

import com.esprit.veltun.model.Abonnement;
import com.esprit.veltun.model.Offre;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EventDetailsController implements Initializable {
    public TextField fxTypeabb;
    //public TextField fxDureeabb;
    public TextField fxPrixAbb;
    public DatePicker AbbdateDebut;
    public DatePicker AbbdateFin;
    public TextField fxidOO;
    public Button ftlistEvent;


    public void setFxTypeab(String Type_ab) {
        this.fxTypeabb.setText(Type_ab);
    }

   /* public void setFxDureeab(String Duree) {
        this.fxDureeabb.setText(Duree);
    }*/
   public void setAbdateDebut(LocalDate date){this.AbbdateDebut.setValue(date);}
    public void setAbdateFin(LocalDate date){this.AbbdateFin.setValue(date);}
    public void setFxPrixAb(String PrixAbb) {
        this.fxPrixAbb.setText(PrixAbb);
    }





    public void setAbonnement(Abonnement abonnement) {
        setFxTypeab(abonnement.getType_ab());
        setAbdateDebut(abonnement.getDateDebut().toLocalDate());
        setAbdateFin(abonnement.getDateFin().toLocalDate());
        //setFxDureeab(abonnement.getDuree());
        setFxPrixAb(String.valueOf(abonnement.getPrix_ab()));


    }


    public void listEvent(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/search.fxml"));
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

    public void setOffre(Offre offre) {
    }
}