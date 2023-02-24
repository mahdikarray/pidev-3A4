package GUI;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerRec implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        private void DeleteaB(ActionEvent event) {

            int id_ab = Integer.parseInt(fxIdAb.getText());
            String Type_ab = String.valueOf(fxTypeab.getText());
            String Duree = String.valueOf(fxDureeab.getText());
            Float Prix_ab = Float.valueOf(fxPrixAb.getText());
            int id_offre = Integer.parseInt(fxidO.getText());
            Abonnement p = new Abonnement(id_ab,Type_ab,Duree,Prix_ab,id_offre);
            AbonnementServiceImpl pc = new AbonnementServiceImpl();
            pc.remove(id_ab);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("reclamation.fxml"));
            try {
                Parent root = loader.load();
                AbonnementController dc = loader.getController();
                dc.setFxidO(p.getId_offre());
                dc.setFxType_ab(p.getType_ab());
                dc.setFxdureeab(p.getDuree());
                dc.setFxPrixAb(p.getPrix_ab());
                dc.setFxIdAb(p.getId_ab());

                fxIdAb.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        @FXML
        private void addaB(ActionEvent event) {

            int id_ab = Integer.parseInt(fxIdAb.getText());
            String Type_ab = String.valueOf(fxTypeab.getText());
            String Duree = String.valueOf(fxDureeab.getText());
            Float Prix_ab = Float.valueOf(fxPrixAb.getText());
            int id_offre = Integer.parseInt(fxidO.getText());
            Abonnement p = new Abonnement(id_ab,Type_ab,Duree,Prix_ab,id_offre);
            AbonnementServiceImpl pc = new AbonnementServiceImpl();
            pc.save(p);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("abonnement.fxml"));
            try {
                Parent root = loader.load();
                AbonnementController dc = loader.getController();
                dc.setFxidO(p.getId_offre());
                dc.setFxType_ab(p.getType_ab());
                dc.setFxdureeab(p.getDuree());
                dc.setFxPrixAb(p.getPrix_ab());
                dc.setFxIdAb(p.getId_ab());

                fxIdAb.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        @FXML
        private void Modifab(ActionEvent event) {

            int id_ab = Integer.parseInt(fxIdAb.getText());
            String Type_ab = String.valueOf(fxTypeab.getText());
            String Duree = String.valueOf(fxDureeab.getText());
            Float Prix_ab = Float.valueOf(fxPrixAb.getText());
            int id_offre = Integer.parseInt(fxidO.getText());
            Abonnement p = new Abonnement(id_ab,Type_ab,Duree,Prix_ab,id_offre);
            AbonnementServiceImpl pc = new AbonnementServiceImpl();
            pc.update(p);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("abonnement.fxml"));
            try {
                Parent root = loader.load();
                AbonnementController dc = loader.getController();
                dc.setFxidO(p.getId_offre());
                dc.setFxType_ab(p.getType_ab());
                dc.setFxdureeab(p.getDuree());
                dc.setFxPrixAb(p.getPrix_ab());
                dc.setFxIdAb(p.getId_ab());

                fxIdAb.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        @FXML
        private void DeleteaB(ActionEvent event) {

            int id_ab = Integer.parseInt(fxIdAb.getText());
            String Type_ab = String.valueOf(fxTypeab.getText());
            String Duree = String.valueOf(fxDureeab.getText());
            Float Prix_ab = Float.valueOf(fxPrixAb.getText());
            int id_offre = Integer.parseInt(fxidO.getText());
            Abonnement p = new Abonnement(id_ab,Type_ab,Duree,Prix_ab,id_offre);
            AbonnementServiceImpl pc = new AbonnementServiceImpl();
            pc.remove(id_ab);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("abonnement.fxml"));
            try {
                Parent root = loader.load();
                AbonnementController dc = loader.getController();
                dc.setFxidO(p.getId_offre());
                dc.setFxType_ab(p.getType_ab());
                dc.setFxdureeab(p.getDuree());
                dc.setFxPrixAb(p.getPrix_ab());
                dc.setFxIdAb(p.getId_ab());

                fxIdAb.getScene().setRoot(root);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}
