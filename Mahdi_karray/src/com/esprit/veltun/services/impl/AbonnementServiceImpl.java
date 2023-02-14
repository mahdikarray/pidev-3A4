package com.esprit.veltun.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.esprit.veltun.model.Abonnement;
import com.esprit.veltun.services.AbonnementService;
import com.esprit.veltun.util.MyConnection;

public class AbonnementServiceImpl implements AbonnementService {

    @Override
    public Abonnement findById(Integer id) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "SELECT * FROM `Abonnement` WHERE Id_ab = " + id;
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Abonnement ab = new Abonnement();
                ab.setType_ab(RS.getString("Type_ab"));
                ab.setDuree(RS.getInt("Duree"));
                ab.setPrix_ab(RS.getFloat("Prix_ab"));
                ab.setId_offre(RS.getInt(1));
                ab.setId_ab(RS.getInt(1));

                System.out.println("abonnement founded");
                return ab;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public Collection<Abonnement> list() {

        List<Abonnement> list = new ArrayList<>();
        try {
            Connection conn = MyConnection.getInstance();
            Statement ste;
            String req = "Select * from Abonnement";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Abonnement a = new Abonnement();
                a.setType_ab(RS.getString("Type_ab"));
                a.setDuree(RS.getInt("Duree"));
                a.setPrix_ab(RS.getFloat("Prix_ab"));
                a.setId_offre(RS.getInt(1));
                a.setId_ab(RS.getInt(1));
                list.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;

    }

    @Override
    public Abonnement save(Abonnement a) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "INSERT INTO `abonnement` ( `Type_ab`,`Duree`,`Prix_ab`,`Id_offre`) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, a.getId_ab());
            ps.setString(1, a.getType_ab());
            ps.setInt(2, a.getDuree());
            ps.setFloat(3, a.getPrix_ab());
            ps.setInt(4, a.getId_offre());



            Integer id = ps.executeUpdate();
            a.setId(id);
            System.out.println("abonnement ajouté!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;

    }

    @Override
    public Abonnement update(Abonnement a) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "UPDATE `abonnement` SET `Type_ab` = '" + a.getType_ab() +"', `Duree` = '" + a.getDuree() +"', `Prix_ab` = '" + a.getPrix_ab() + "', `Id_offre` = '" + a.getId_offre() +"' WHERE `abonnement`.`Id_ab` = " + a.getId_ab();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("abonnement updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean remove(Integer id) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "DELETE FROM `abonnement` WHERE Id_ab = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("abonnement deleted !");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }

}
