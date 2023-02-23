//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.veltun.services.impl;

import com.esprit.veltun.model.Abonnement;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.AbonnementSearchCriteria;
import com.esprit.veltun.services.AbonnementService;
import com.esprit.veltun.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class AbonnementServiceImpl implements AbonnementService {
    public AbonnementServiceImpl() {
    }

    public Abonnement findById(Integer id) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "SELECT * FROM `Abonnement` WHERE Id_ab = " + id;
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            if (RS.next()) {
                Abonnement ab = new Abonnement();
                ab.setType_ab(RS.getString("Type_ab"));
                ab.setDuree(RS.getInt("Duree"));
                ab.setPrix_ab(RS.getFloat("Prix_ab"));
                ab.setId_offre(RS.getInt(1));
                ab.setId_ab(RS.getInt(1));
                System.out.println("abonnement founded");
                return ab;
            }
        } catch (SQLException var7) {
            System.out.println(var7.getMessage());
        }

        return null;
    }

    public Collection<Abonnement> list() {
        ArrayList list = new ArrayList();

        try {
            Connection conn = MyConnection.getInstance();
            String req = "Select * from Abonnement";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);

            while(RS.next()) {
                Abonnement a = new Abonnement();
                a.setType_ab(RS.getString("Type_ab"));
                a.setDuree(RS.getInt("Duree"));
                a.setPrix_ab(RS.getFloat("Prix_ab"));
                a.setId_offre(RS.getInt(1));
                a.setId_ab(RS.getInt(1));
                list.add(a);
            }
        } catch (SQLException var8) {
            System.out.println(var8.getMessage());
        }

        return list;
    }

    public Abonnement save(Abonnement a) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "INSERT INTO `abonnement` ( Type_ab,Duree,Prix_ab,Id_offre) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, a.getId_ab());
            ps.setString(1, a.getType_ab());
            ps.setInt(2, a.getDuree());
            ps.setFloat(3, a.getPrix_ab());
            ps.setInt(4, a.getId_offre());
            Integer id = ps.executeUpdate();
            a.setId(id);
            System.out.println("abonnement ajouté!!!");
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return a;
    }

    public Abonnement update(Abonnement a) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "UPDATE abonnement SET Type_ab = '" + a.getType_ab() + "', Duree = '" + a.getDuree() + "', Prix_ab = '" + a.getPrix_ab() + "', Id_offre = '" + a.getId_offre() + "' WHERE abonnement.Id_ab = " + a.getId_ab();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("abonnement updated !");
        } catch (SQLException var5) {
            System.out.println(var5.getMessage());
        }

        return null;
    }

    public boolean remove(Integer id) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "DELETE FROM abonnement WHERE Id_ab = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("abonnement deleted !");
            return true;
        } catch (SQLException var5) {
            System.out.println(var5.getMessage());
            return false;
        }
    }

    public Collection<Abonnement> search(SearchCriteria<Abonnement> searchCriteria) {
        ArrayList list = new ArrayList();

        try {
            AbonnementSearchCriteria abonnementSearchCriteria = (AbonnementSearchCriteria)searchCriteria;
            Connection conn = MyConnection.getInstance();
            StringBuilder builder = new StringBuilder("Select * from Abonnement");
            StringBuilder whereBuilder = new StringBuilder();
            if (abonnementSearchCriteria.getType_ab() != null && !abonnementSearchCriteria.getType_ab().isEmpty()) {
                if (!whereBuilder.toString().isEmpty()) {
                    whereBuilder.append(" AND Type_ab=?");
                } else {
                    whereBuilder.append(" WHERE Type_ab=?");
                }
            }

            if (abonnementSearchCriteria.getId() != null) {
                if (!whereBuilder.toString().isEmpty()) {
                    whereBuilder.append(" AND id_ab=?");
                } else {
                    whereBuilder.append(" WHERE Id_ab=?");
                }
            }

            builder.append(whereBuilder);
            PreparedStatement st = conn.prepareStatement(builder.toString());
            int counter = 1;
            if (abonnementSearchCriteria.getType_ab() != null && !abonnementSearchCriteria.getType_ab().isEmpty()) {
                st.setString(counter, abonnementSearchCriteria.getType_ab());
                ++counter;
            }

            if (abonnementSearchCriteria.getId() != null) {
                st.setInt(counter, abonnementSearchCriteria.getId());
                ++counter;
            }

            ResultSet RS = st.executeQuery();

            while(RS.next()) {
                Abonnement v = new Abonnement();
                v.setType_ab(RS.getString(2));
                v.setId_ab(RS.getInt(1));
                v.setDuree(RS.getInt(3));
                v.setPrix_ab(RS.getFloat(4));
                v.setId_offre(RS.getInt(5));
                list.add(v);
            }
        } catch (SQLException var11) {
            System.out.println(var11.getMessage());
        }

        return list;
    }
}
