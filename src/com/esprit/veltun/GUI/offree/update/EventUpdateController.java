package com.esprit.veltun.GUI.offree.update;

import com.esprit.veltun.GUI.offree.view.EventDetailsController;
import com.esprit.veltun.model.Offre;
import com.esprit.veltun.services.OffreService;
import com.esprit.veltun.services.impl.OffreServiceImpl;
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

public class EventUpdateController implements Initializable {
    public Button cancelbutton;
    private OffreService offreService = new OffreServiceImpl();

    private Offre offre;
    public TextField Fxrs;
    public TextField FxDescription2;
    public TextField fxPrix2;


    public void setFxDescription(String desc) {
        this.FxDescription2.setText(desc);
    }

    public void setFxPrix(String prix) {
        this.fxPrix2.setText(prix);
    }



    public void setOffre(Offre offre) {
        this.offre= offre;
        setFxDescription(offre.getDescription_of());
        setFxPrix(String.valueOf(offre.getPrix()));

    }
    public void updateEvent(ActionEvent actionEvent) {
        String desc= FxDescription2.getText();
        String prix=fxPrix2.getText();

        //Abonnement a= new Abonnement();
       // Offre offre = new Offre();
        offre.setDescription_of(desc);
        offre.setPrix(Float.parseFloat(prix));

        offre = offreService.update(offre);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/detailsof.fxml"));

        try {
            Parent root = fxmlLoader.load();

            EventDetailsController cont = fxmlLoader.getController();
            cont.setOffre(offre);

            fxPrix2.getScene().setRoot(root);
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../search/searchof.fxml"));

        try {
            Parent root = fxmlLoader.load();
            fxPrix2.getScene().setRoot(root);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void gencode(ActionEvent actionEvent){
       /* String f= Fxrs.getText();
        //fxrs=randomstring;
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVXWZ";
        StringBuilder sb= new StringBuilder();
        Random random=new Random();
        int lenght=7;
        for(int i=0;i<lenght;i++) {
            int index = random.nextInt(alphabet.length());
            char randomchar = alphabet.charAt(index);
            sb.append(randomchar);}
            String randomstring=sb.toString();
        System.out.println(" "+randomstring);*/
       /* if (f == randomstring) {

        double dis, amount, Prix, s;

        Prix = 1000;

        dis = 25;  // 25 mean 25%

        System.out.println("markedprice= " + offre.getPrix());

        System.out.println("discount rate=" + dis);

        s = 100 - dis;

        amount = (s * offre.getPrix()) / 100;

        System.out.println("amount after discount=" + amount);
    }*/}
}
