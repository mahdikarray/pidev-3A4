//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.veltun.services.impl;

import com.esprit.veltun.model.Offre;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.OffreSearchCriteria;
import com.esprit.veltun.services.OffreService;
import com.esprit.veltun.util.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class OffreServiceImpl implements OffreService {
    public OffreServiceImpl() {
    }
    public static int L;

    public Offre findById(Integer id) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "SELECT * FROM `offre` WHERE Id_offre = " + id;
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            if (RS.next()) {
                Offre s = new Offre();
               // s.setPrix(RS.getFloat("Prix"));
                s.getDescription_of(RS.getString("description_of"));
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
               // s.setPrix(RS.getFloat("Prix"));
                s.getDescription_of(RS.getString("description_of"));
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
            String req = "INSERT INTO `offre` ( `description_of`) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(req);
           // ps.setInt(1, s.getId_offre());
           // ps.setFloat(1, s.getPrix());
            ps.setString(1,s.getDescription_of());
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
            String req = "UPDATE `offre` SET `description_of` = '" + s.getDescription_of() + "' WHERE `offre`.`Id_offre` =" + s.getId_offre();
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

        ArrayList list = new ArrayList();

        try {
            OffreSearchCriteria offreSearchCriteria = (OffreSearchCriteria)searchCriteria;
            Connection conn = MyConnection.getInstance();
            StringBuilder builder = new StringBuilder("Select * from offre");
            StringBuilder whereBuilder = new StringBuilder();

            if (offreSearchCriteria.getDescription_of() != null && !offreSearchCriteria.getDescription_of().isEmpty()) {
                if (!whereBuilder.toString().isEmpty()) {
                    whereBuilder.append(" AND description_of=?");
                } else {
                    whereBuilder.append(" WHERE description_of=?");
                }
            }

            if (offreSearchCriteria.getId() != null) {
                if (!whereBuilder.toString().isEmpty()) {
                    whereBuilder.append(" AND id_offre=?");
                } else {
                    whereBuilder.append(" WHERE id_offre=?");
                }
            }

            builder.append(whereBuilder);
            PreparedStatement st = conn.prepareStatement(builder.toString());
            int counter = 1;
            if (offreSearchCriteria.getDescription_of() != null ) {
                st.setString(counter, String.valueOf(offreSearchCriteria.getDescription_of()));
                ++counter;
            }

            if (offreSearchCriteria.getId() != null) {
                st.setInt(counter, offreSearchCriteria.getId());
                ++counter;
            }

            ResultSet RS = st.executeQuery();

            while(RS.next()) {
                Offre v = new Offre();
                v.setDescription_of(RS.getString(2));
               // v.setPrix(RS.getFloat(2));
                v.setId_offre(RS.getInt(1));
                list.add(v);
            }
        } catch (SQLException var11) {
            System.out.println(var11.getMessage());
        }

        return list;
    }

    }

