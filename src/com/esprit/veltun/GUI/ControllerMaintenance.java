package com.esprit.veltun.GUI;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.esprit.veltun.model.Maintenance;
import com.esprit.veltun.model.Reclamation;
import com.esprit.veltun.search.dto.MaintenanceSearchCriteria;
import com.esprit.veltun.services.MaintenanceService;
import com.esprit.veltun.services.impl.MaintenanceServiceImpl;
import com.esprit.veltun.util.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class ControllerMaintenance implements Initializable {


    private ObservableList<String> items = FXCollections.observableArrayList();
    //ObservableList<String> TypeabList= FXCollections.observableArrayList("Standard","Premium");
    //ObservableList<String> dureeabList= FXCollections.observableArrayList("1","3","6","12");
   /* @FXML
    ListView<String> list;

    ObservableList<String> items = FXCollections.observableArrayList();*/


    @FXML
    AnchorPane pane1,pane2 ;

    @FXML
    private Button button1  ;

    @FXML
    private Label label_id_demande,label_description,label_etat,label_date_soumission,label_id_reclamation;
    @FXML
    private TextField fxid_demande;
    @FXML
    private TextField fxid_reclamation;
    @FXML
    private TextField fxdescription;
    @FXML
    private TextField fxetat;
    @FXML
    private DatePicker fxdate_soumission;

    @FXML
    private Button fxajouterMain;
    @FXML
    private Button fxModifMain;
    @FXML
    private Button fxDeleteMain;
    @FXML
    private Button fxafficheMain;
    @FXML
    private Button fxRecherchMain;

    @FXML
    private AnchorPane opacityPane,drawerPane;

    @FXML
    private Label Menu;

    @FXML
    private Label MenuClose;

    @FXML
    private AnchorPane slider;
    @FXML
    public ListView<Maintenance> list;
    //private AbonnementService abonnementService = AbonnementService.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
/*fxTypeab.setValue("Standard");
fxTypeab.setItems(TypeabList);
        fxDureeab.setValue("1");
        fxDureeab.setItems(dureeabList);
       // list.setItems(items);*/
        //list.setItems(items);
        try {
            Connection conn = MyConnection.getInstance();
            String req = "Select * from maintenance";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);

            while(RS.next()) {
                Maintenance p1 = new Maintenance();
                p1.setDescription(RS.getString("description"));
                p1.setEtat(RS.getString("etat"));
                p1.setDate_soumission(RS.getDate("date_soumission"));
                p1.setId_demande(RS.getInt(1));
                p1.setId_reclamation(RS.getInt(1));

                items.add(RS.getString(1));
                items.add(RS.getString(2));
                items.add(RS.getString(3));
                items.add(RS.getString(4));
                items.add(String.valueOf(RS.getDate(5)));
            }
        } catch (SQLException var8) {
            System.out.println(var8.getMessage());
        }
    }

    @FXML
    private void addMain(ActionEvent event) {
       /* String objet= fxobjet.getText();
        String description= fxdescription.getText();
        String etat= fxetat.getText();
        String id_reclamation= fxid_reclamation.getText();
        DatePicker date_reclamation = fxdate_reclamation;
        if (objet.isEmpty() || description.isEmpty() || etat.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs.");
            alert.showAndWait();
            return;
        }
        if (!type.matches("Standard") && (!type.matches("Premium"))) {
            // Affichage d'un message d'erreur si le champ n'est pas du bon format
            Alert alert = new Alert(Alert.AlertType.ERROR, "Type must be either Standard or Premium.");
            alert.showAndWait();
            return;
        }
        if (!Dure.equals("1") && (!Dure.equals("3")) && (!Dure.equals("6")) && (!Dure.equals("12"))) {
            // Affichage d'un message d'erreur si le champ n'est pas du bon format
            Alert alert = new Alert(Alert.AlertType.ERROR, "Duree must be either 1 month,3months,6months or 12months.");
            alert.showAndWait();
            return;
        }
        if (!Prix.matches("\\d+(\\.\\d+)?")) {
            // Affichage d'un message d'erreur si le champ n'est pas du bon format
            Alert alert = new Alert(Alert.AlertType.ERROR, "Le prix doit Ãªtre un nombre dÃ©cimal.");
            alert.showAndWait();
            return;
        }*/

        int id_demande = Integer.parseInt(fxid_demande.getText());
        String description = String.valueOf(fxdescription.getText());
        String etat = String.valueOf(fxetat.getText());
        Date date_soumission = Date.valueOf(fxdate_soumission.getValue());
        int id_reclamation = Integer.parseInt(fxid_demande.getText());
        Maintenance p1 = new Maintenance(id_demande,description,etat,date_soumission,id_reclamation);
        MaintenanceServiceImpl pc1 = new MaintenanceServiceImpl();
        pc1.save(p1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("maintenance.fxml"));
        try {
            Parent root = loader.load();
            ControllerMaintenance dc = loader.getController();
            dc.setFxid_demande(p1.getId_demande());
            dc.setFxdescription(p1.getDescription());
            dc.setFxetat(p1.getEtat());
            dc.setFxdate_soumission(p1.getDate_soumission());
            // dc.setFxIdAb(p.getId_ab());

            fxetat.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // void setFxCIN(String cin) {


    @FXML
    private void ModifMain(ActionEvent event) {

        int id_demande = Integer.parseInt(fxid_demande.getText());
        String description = String.valueOf(fxdescription.getText());
        String etat = String.valueOf(fxetat.getText());
        Date date_soumission = Date.valueOf(fxdate_soumission.getValue());
        int id_reclamation = Integer.parseInt(fxid_reclamation.getText());
        Maintenance p1 = new Maintenance(id_demande,description,etat,date_soumission,id_reclamation);
        MaintenanceServiceImpl pc1 = new MaintenanceServiceImpl();
        pc1.update(p1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("maintenance.fxml"));
        try {
            Parent root = loader.load();
            ControllerMaintenance dc = loader.getController();
            dc.setFxid_demande(p1.getId_demande());
            dc.setFxdescription(p1.getDescription());
            dc.setFxetat(p1.getEtat());
            dc.setFxdate_soumission(p1.getDate_soumission());
            dc.setFxid_reclamation(p1.getId_reclamation());
            fxetat.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @FXML
    private void DeleteMain(ActionEvent event) {

        int id_demande = Integer.parseInt(fxid_demande.getText());
        String description = String.valueOf(fxdescription.getText());
        String etat = String.valueOf(fxetat.getText());
        Date date_soumission = Date.valueOf(fxdate_soumission.getValue());
        int id_reclamation = Integer.parseInt(fxid_reclamation.getText());
        Maintenance p1 = new Maintenance(id_demande,description,etat,date_soumission,id_reclamation);
        MaintenanceServiceImpl pc1 = new MaintenanceServiceImpl();
        pc1.remove(id_demande);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("maintenance.fxml"));
        try {
            Parent root = loader.load();
            ControllerMaintenance dc = loader.getController();
            dc.setFxid_demande(p1.getId_demande());
            dc.setFxdescription(p1.getDescription());
            dc.setFxetat(p1.getEtat());
            dc.setFxdate_soumission(p1.getDate_soumission());

            fxetat.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @FXML
    private void RechMain(ActionEvent event) {

        // list.setItems(items);
        // int id_ab = Integer.parseInt(fxrech.getText());
        // String Type_ab = String.valueOf(fxTypeab.getText());
        //String Duree = String.valueOf(fxDureeab.getText());
        //Float Prix_ab = Float.valueOf(fxPrixAb.getText());
        // int id_offre = Integer.parseInt(fxidO.getText());
        try {
            Connection conn = MyConnection.getInstance();
            String req = "Select * from maintenance where etat";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);

            while(RS.next()) {
                MaintenanceSearchCriteria searchCriteria = new MaintenanceSearchCriteria();
                //searchCriteria.setType_ab(RS.getString("Type_ab"));
                //searchCriteria.setDuree(RS.getString("Duree"));
                //searchCriteria.setPrix_ab(RS.getFloat("Prix_ab"));
                //searchCriteria.setId_offre(RS.getInt(1));
                // searchCriteria.setId_ab(RS.getInt(1));
                // items.add(RS.getString(1));
                items.add(RS.getString(2));
                //items.add(RS.getString(3));
                //items.add(RS.getString(4));
                //items.add(RS.getString(5));
            }
        } catch (SQLException var8) {
            System.out.println(var8.getMessage());
        }


    }
    public void setFxid_demande(int id_demande) {
    }
    public void setFxid_reclamation(int id_reclamation) {
    }
    public void setFxdescription(String description) {
    }
    public void setFxetat(String etat) {
    }
    public void setFxdate_soumission(Date date_soumission) {
    }


}