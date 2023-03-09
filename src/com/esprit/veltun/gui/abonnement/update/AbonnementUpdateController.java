package com.esprit.veltun.gui.abonnement.update;

import com.esprit.veltun.gui.abonnement.view.EventDetailsController;
import com.esprit.veltun.model.Abonnement;
import com.esprit.veltun.services.AbonnementService;
import com.esprit.veltun.services.impl.AbonnementServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class AbonnementUpdateController implements Initializable {
    public Button cancelbutton;
    private AbonnementService abonnementService = new AbonnementServiceImpl();

    private Abonnement abonnement;

    public TextField fxTypeab;
    //public TextField fxDureeab;
    public TextField fxPrixAb;
    public DatePicker AbdateDebut;
    public DatePicker AbdateFin;
    public TextField fxidO;
    public void setAbdateDebut(LocalDate date){this.AbdateDebut.setValue(date);}
    public void setAbdateFin(LocalDate date){this.AbdateFin.setValue(date);}

    public void setFxTypeab(String Type_ab) {
        this.fxTypeab.setText(Type_ab);
    }

   /* public void setFxDureeab(String Dure) {
        this.fxDureeab.setText(Dure);
    }*/

    public void setFxPrixAb(String prixAb) {
        this.fxPrixAb.setText(prixAb);
    }

   /* public void setFxidO(String idO) {
        this.fxidO.setText(idO);
    }*/




    public void setAbonnement(Abonnement abonnement) {
        this.abonnement= abonnement;
        setFxTypeab(abonnement.getType_ab());
        setAbdateDebut(abonnement.getDateDebut().toLocalDate());
        setAbdateFin(abonnement.getDateFin().toLocalDate());
       // setFxDureeab(abonnement.getDuree());
        setFxPrixAb(String.valueOf(abonnement.getPrix_ab()));
       // setFxidO(String.valueOf(abonnement.getId_offre()));


    }
    public void updateEvent(ActionEvent actionEvent) {
        String Type_ab= fxTypeab.getText();
        Date dateDebut = Date.valueOf(AbdateDebut.getValue());
        Date dateFin = Date.valueOf(AbdateFin.getValue());
        String PrixAb=fxPrixAb.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Are you sure you want to update this subscription?");
        alert.setContentText("Type: " + Type_ab + "\nDebut date: " + dateDebut.toString() + "\nexpiration date: " + dateFin.toString() + "\nSubscription price: " + PrixAb);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            abonnement.setType_ab(Type_ab);
            abonnement.setDateDebut(dateDebut);
            abonnement.setDateFin(dateFin);
            abonnement.setPrix_ab(Float.parseFloat(PrixAb));
            abonnement = abonnementService.update(abonnement);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/details.fxml"));

            try {
                Parent root = fxmlLoader.load();

                EventDetailsController cont = fxmlLoader.getController();
                cont.setAbonnement(abonnement);

                fxTypeab.getScene().setRoot(root);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }}
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
            fxTypeab.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
