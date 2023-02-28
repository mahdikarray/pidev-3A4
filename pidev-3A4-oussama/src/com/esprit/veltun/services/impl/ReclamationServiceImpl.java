package com.esprit.veltun.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.esprit.veltun.model.Reclamation;
import com.esprit.veltun.services.ReclamationService;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.ReclamationSearchCriteria;
import com.esprit.veltun.util.MyConnection;

public class ReclamationServiceImpl implements ReclamationService {

    @Override
    public List<Reclamation> list() {
        List<Reclamation> list = new ArrayList<>();
        try {
            Connection conn = MyConnection.getInstance();
            Statement ste;
            String req = "Select * from reclamation";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Reclamation r = new Reclamation();

                r.setId_reclamation(RS.getInt("id_reclamation"));
                r.setObjet(RS.getString("objet"));
                r.setDescription(RS.getString("description"));
                r.setType(RS.getString("type"));
                r.setDate_reclamation(RS.getDate("date_reclamation"));
                list.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    @Override
    public Reclamation save(Reclamation r) {

        try {
            Connection conn = MyConnection.getInstance();
            String req = "INSERT INTO `reclamation`(objet, description, type,date_reclamation) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
           // ps.setInt(1, r.getId_reclamation());
            ps.setString(1, r.getObjet());
            ps.setString(2, r.getDescription());
            ps.setString(3, r.getType());
            ps.setDate(4, r.getDate_reclamation());
            Integer id = ps.executeUpdate();
           r.setId(id);
            System.out.println("reclamation ajouté!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return r;
    }

    @Override

    public Reclamation update(Reclamation r ) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "UPDATE reclamation SET `objet` = '" + r.getObjet() +"', `description` = '" + r.getDescription() +"', `type` = '" + r.getType() + "', `date_reclamation` = '" + r.getDate_reclamation() +"' WHERE `id_reclamation` = " + r.getId_reclamation();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("reclamation updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean remove(Integer id) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "DELETE FROM `reclamation` WHERE id_reclamation = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Reclamation deleted !");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }



    @Override
    public Reclamation findById(Integer id) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "SELECT * FROM `reclamation` WHERE id_reclamation = " + id;
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Reclamation r = new Reclamation();
                r.setId_reclamation(RS.getInt("id_reclamation"));
                r.setObjet(RS.getString("objet"));
                r.setDescription(RS.getString("description"));
                r.setType(RS.getString("type"));
                r.setDate_reclamation(RS.getDate("date_reclamation"));
                System.out.println("reclamation founded");
                return r;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public Collection<Reclamation> search(SearchCriteria<Reclamation> searchCriteria) {
        List<Reclamation> list = new ArrayList<>();
        try {
            ReclamationSearchCriteria reclamationSearchCriteria =  (ReclamationSearchCriteria) searchCriteria;
            Connection conn = MyConnection.getInstance();

            StringBuilder builder = new StringBuilder("Select * from reclamation");
            StringBuilder whereBuilder = new StringBuilder();

            if (reclamationSearchCriteria.getType() != null && !reclamationSearchCriteria.getType().isEmpty()) {
                if (!whereBuilder.toString().isEmpty()) {
                    whereBuilder.append(" AND type=?");

                } else {
                    whereBuilder.append(" WHERE type=?");
                }
            }

            if (reclamationSearchCriteria.getId() != null) {
                if (!whereBuilder.toString().isEmpty()) {
                    whereBuilder.append(" AND id_reclamation=?");

                } else {
                    whereBuilder.append(" WHERE id_reclamation=?");
                }
            }
            builder.append(whereBuilder);



            PreparedStatement st = conn.prepareStatement(builder.toString());
            int counter = 1;
            if (reclamationSearchCriteria.getType() != null && !reclamationSearchCriteria.getType().isEmpty()) {
                st.setString(counter, reclamationSearchCriteria.getType());
                counter++;
            }


            if (reclamationSearchCriteria.getId() != null) {
                st.setInt(counter,reclamationSearchCriteria.getId());
                counter++;
            }
            ResultSet RS = st.executeQuery();
            while (RS.next()) {
                Reclamation k = new Reclamation();


                k.setId_reclamation(RS.getInt("id_reclamation"));
                k.setObjet(RS.getString("objet"));
                k.setDescription(RS.getString("description"));
                k.setType(RS.getString("type"));
                k.setDate_reclamation(RS.getDate("date_reclamation"));
                list.add(k);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }



}
