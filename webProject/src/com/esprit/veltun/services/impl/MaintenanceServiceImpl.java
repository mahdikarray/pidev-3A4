package com.esprit.veltun.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.esprit.veltun.model.Maintenance;
import com.esprit.veltun.model.Reclamation;
import com.esprit.veltun.search.dto.MaintenanceSearchCriteria;
import com.esprit.veltun.services.MaintenanceService;
import com.esprit.veltun.services.ReclamationService;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.ReclamationSearchCriteria;
import com.esprit.veltun.util.MyConnection;

public class MaintenanceServiceImpl implements MaintenanceService {

    @Override
    public Collection<Maintenance> list() {

        List<Maintenance> list = new ArrayList<>();
        try {
            Connection conn = MyConnection.getInstance();
            Statement ste;
            String req = "Select * from maintenance";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Maintenance m = new Maintenance();
                m.setDescription(RS.getString("description"));
                m.setEtat(RS.getString("etat"));
                m.setDate_soumission(RS.getDate("date_soumission"));
                m.setId_reclamation(RS.getInt(1));
                m.setId_demande(RS.getInt(1));

                list.add(m);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;

    }

    @Override
    public Maintenance save(Maintenance m) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "INSERT INTO `maintenance` ( description,etat,date_soumission,Id_reclamation) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, m.getId_demande());
            ps.setString(1, m.getDescription());
            ps.setString(2, m.getEtat());
            ps.setDate(3, m.getDate_soumission());
            ps.setInt(4, m.getId_reclamation());



            Integer id = ps.executeUpdate();
            m.setId(id);
            System.out.println("maintenance ajouté!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return m;

    }

    @Override
    public Maintenance update(Maintenance m) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "UPDATE maintenance SET description = '" + m.getDescription() +"', etat = '" + m.getEtat() +"', date_soumission = '" + m.getDate_soumission() + "', id_reclamation = '" + m.getId_reclamation() +"' WHERE maintenance.Id_demande = " + m.getId_demande();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Maintenance updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean remove(Integer id) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "DELETE FROM `maintenance` WHERE id_demande = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("maintenance deleted !");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }



    @Override
    public Maintenance findById(Integer id) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "SELECT * FROM `maintenance` WHERE id_demande = " + id;
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Maintenance m = new Maintenance();
                m.setId_demande(RS.getInt("id_demande"));
                m.setDescription(RS.getString("description"));
                m.setEtat(RS.getString("etat"));
                m.setDate_soumission(RS.getDate("date_soumission"));
                m.setId_reclamation(RS.getInt("id_reclamation"));
                System.out.println("Maintenance founded");
                return m;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }


    @Override
    public Collection<Maintenance> search(SearchCriteria<Maintenance> searchCriteria) {
        List<Maintenance> list = new ArrayList<>();
        try {
            MaintenanceSearchCriteria maintenanceSearchCriteria =  (MaintenanceSearchCriteria) searchCriteria;
            Connection conn = MyConnection.getInstance();

            StringBuilder builder = new StringBuilder("Select * from maintenance");
            StringBuilder whereBuilder = new StringBuilder();

            if (maintenanceSearchCriteria.getEtat() != null && !maintenanceSearchCriteria.getEtat().isEmpty()) {
                if (!whereBuilder.toString().isEmpty()) {
                    whereBuilder.append(" AND etat=?");

                } else {
                    whereBuilder.append(" WHERE etat=?");
                }
            }

            if (maintenanceSearchCriteria.getId() != null) {
                if (!whereBuilder.toString().isEmpty()) {
                    whereBuilder.append(" AND id_demande=?");

                } else {
                    whereBuilder.append(" WHERE id_demande=?");
                }
            }
            builder.append(whereBuilder);



            PreparedStatement st = conn.prepareStatement(builder.toString());
            int counter = 1;
            if (maintenanceSearchCriteria.getEtat() != null && !maintenanceSearchCriteria.getEtat().isEmpty()) {
                st.setString(counter, maintenanceSearchCriteria.getEtat());
                counter++;
            }


            if (maintenanceSearchCriteria.getId() != null) {
                st.setInt(counter,maintenanceSearchCriteria.getId());
                counter++;
            }
            ResultSet RS = st.executeQuery();
            while (RS.next()) {

                Maintenance m = new Maintenance();
                m.setId_demande(RS.getInt("id_demande"));
                m.setDescription(RS.getString("description"));
                m.setEtat(RS.getString("etat"));
                m.setDate_soumission(RS.getDate("date_soumission"));
                m.setId_reclamation(RS.getInt("id_reclamation"));
                list.add(m);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }



}

