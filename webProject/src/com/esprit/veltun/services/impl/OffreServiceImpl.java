//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.veltun.services.impl;

import com.esprit.veltun.model.Offre;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.services.OffreService;
import com.esprit.veltun.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class OffreServiceImpl implements OffreService {
    public OffreServiceImpl() {
    }

    public Offre findById(Integer id) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "SELECT * FROM `offre` WHERE Id_offre = " + id;
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            if (RS.next()) {
                Offre s = new Offre();
                s.setPrix(RS.getFloat("Prix"));
                s.setId_offre(RS.getInt(1));
                System.out.println("offre founded");
                return s;
            }
        } catch (SQLException var7) {
            System.out.println(var7.getMessage());
        }

        return null;
    }

    public Collection<Offre> list() {
        ArrayList list = new ArrayList();

        try {
            Connection conn = MyConnection.getInstance();
            String req = "Select * from Offre";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);

            while(RS.next()) {
                Offre s = new Offre();
                s.setPrix(RS.getFloat("Prix"));
                s.setId_offre(RS.getInt(1));
                list.add(s);
            }
        } catch (SQLException var8) {
            System.out.println(var8.getMessage());
        }

        return list;
    }

    public Offre save(Offre s) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "INSERT INTO `offre` ( `Prix`) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(req);
            //ps.setInt(1, s.getId_offre());
            ps.setFloat(1, s.getPrix());
            Integer id = ps.executeUpdate();
            s.setId(id);
            System.out.println("Offre ajouté!!!");
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return s;
    }

    public Offre update(Offre s) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "UPDATE `offre` SET `Prix` = '" + s.getPrix() + "' WHERE `offre`.`Id_offre` =" + s.getId_offre();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Offre updated !");
        } catch (SQLException var5) {
            System.out.println(var5.getMessage());
        }

        return null;
    }

    public boolean remove(Integer id) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "DELETE FROM `offre` WHERE Id_offre = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Offre deleted !");
            return true;
        } catch (SQLException var5) {
            System.out.println(var5.getMessage());
            return false;
        }
    }

    public Collection<Offre> search(SearchCriteria<Offre> searchCriteria) {
        return null;
    }
}
