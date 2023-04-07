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
import com.esprit.veltun.search.dto.ReclamationSearchCriteria;
import com.esprit.veltun.services.MaintenanceService;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.MaintenanceSearchCriteria;
import com.esprit.veltun.util.MyConnection;

public class MaintenanceServiceImpl implements MaintenanceService {

    @Override
    public Maintenance save(Maintenance m) {

        try {
            Connection conn = MyConnection.getInstance();
            String req = "INSERT INTO `maintenance`( `id_demande`, `description`, `etat`, "
                    + "`date_soumission` ) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, m.getId_demande());
            ps.setString(2, m.getDescription());
            ps.setString(3, m.getEtat());
            ps.setDate(4, m.getDate_soumission());
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
            Statement ste;

            String req = "UPDATE `reclamation` SET `description` = '" + m.getDescription() + "', `etat` = '" + m.getEtat() + "'"
                    + ", `date_soumission` = '" + m.getDate_soumission() + "'"
                    + " WHERE `maintenance`.`id_demande` LIKE " + m.getId_demande();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("reclamation updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return m;
    }

    @Override
    public boolean remove(Integer id) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "DELETE FROM `maintenance` WHERE id_demande = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Maintenance deleted !");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Maintenance> list() {
        List<Maintenance> list = new ArrayList<>();
        try {
            Connection conn = MyConnection.getInstance();
            Statement ste;
            String req = "Select * from maintenance";
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Maintenance m = new Maintenance();

                m.setId_demande(RS.getInt(1));
                m.setDescription(RS.getString(2));
                m.setEtat(RS.getString(3));
                m.setDate_soumission(RS.getDate(4));
                list.add(m);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public Maintenance findById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<Maintenance> search(SearchCriteria<Maintenance> searchCriteria) {
        List<Maintenance> list = new ArrayList<>();
        try {
            MaintenanceSearchCriteria maintenanceSearchCriteria = (MaintenanceSearchCriteria) searchCriteria;
            Connection conn = MyConnection.getInstance();
            Statement ste;
            String req = "Select * from maintenance";
            StringBuilder builder = new StringBuilder("Select * from maintenance");
            StringBuilder whereBuilder = new StringBuilder();

            if (((MaintenanceSearchCriteria) searchCriteria).getId_demande() != 0) {
                if (!whereBuilder.toString().isEmpty()) {
                    whereBuilder.append(" AND id_demande=?");

                } else {
                    whereBuilder.append(" WHERE id_demande=?");
                }
            }

            builder.append(whereBuilder);
            PreparedStatement st = conn.prepareStatement(builder.toString());
            st.setInt(1, maintenanceSearchCriteria.getId_demande());
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Maintenance m = new Maintenance();
                m.setId_demande(RS.getInt(1));
                m.setDescription(RS.getString(2));
                m.setEtat(RS.getString(3));
                m.setDate_soumission(RS.getDate(4));
                list.add(m);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }



}
