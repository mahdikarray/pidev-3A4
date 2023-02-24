//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.veltun.services.impl;

import com.esprit.veltun.model.Fournisseur;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.FournisseurSearchCriteria;
import com.esprit.veltun.services.FournisseurService;
import com.esprit.veltun.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class FournisseurServiceImpl implements FournisseurService {
    public FournisseurServiceImpl() {
    }

    public Fournisseur save(Fournisseur f) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "INSERT INTO `fournisseur` (`nomf`, `regionf`) VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, f.getNom());
            ps.setString(2, f.getRegion());
            Integer idf = ps.executeUpdate();
            f.setId(idf);
            System.out.println("fournisseur ajouté!!!");
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return f;
    }

    public Fournisseur update(Fournisseur f) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "UPDATE `fournisseur` SET `nomf` = '" + f.getNom() + "', `regionf` = '" + f.getRegion() + "' WHERE `fournisseur`.`idf` = " + f.getId();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("fournisseur updated !");
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return f;
    }

    public boolean remove(Integer idf) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "DELETE FROM `fournisseur` WHERE idf = " + idf;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("fournisseur deleted !");
            return true;
        } catch (SQLException var5) {
            System.out.println(var5.getMessage());
            return false;
        }
    }

    public Collection<Fournisseur> list() {
        ArrayList list = new ArrayList();

        try {
            Connection conn = MyConnection.getInstance();
            String req = "Select * from fournisseur";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);

            while(RS.next()) {
                Fournisseur f = new Fournisseur();
                f.setNom(RS.getString(2));
                f.setId(RS.getInt(1));
                f.setRegion(RS.getString(3));
                list.add(f);
            }
        } catch (SQLException var7) {
            System.out.println(var7.getMessage());
        }

        return list;
    }

    public Fournisseur findById(Integer idf) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "SELECT * FROM fournisseur WHERE idf = " + idf;
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            if (RS.next()) {
                Fournisseur f = new Fournisseur();
                f.setId(RS.getInt(1));
                f.setNom(RS.getString("nomf"));
                f.setRegion(RS.getString(3));
              //  System.out.println("fournisseur founded");
                return f;
            }
        } catch (SQLException var7) {
            System.out.println(var7.getMessage());
        }

        return null;
    }

    public Collection<Fournisseur> search(SearchCriteria<Fournisseur> searchCriteria) {
        ArrayList list = new ArrayList();

        try {
            FournisseurSearchCriteria fournisseurSearchCriteria = (FournisseurSearchCriteria)searchCriteria;
            Connection conn = MyConnection.getInstance();
            StringBuilder builder = new StringBuilder("Select * from fournisseur");
            StringBuilder whereBuilder = new StringBuilder();
            if (fournisseurSearchCriteria.getNom() != null && !fournisseurSearchCriteria.getNom().isEmpty()) {
                if (!whereBuilder.toString().isEmpty()) {
                    whereBuilder.append(" AND nomf=?");
                } else {
                    whereBuilder.append(" WHERE nomf=?");
                }
            }

            if (fournisseurSearchCriteria.getId() != null) {
                if (!whereBuilder.toString().isEmpty()) {
                    whereBuilder.append(" AND idf=?");
                } else {
                    whereBuilder.append(" WHERE idf=?");
                }
            }

            if (fournisseurSearchCriteria.getRegion() != null) {
                if (!whereBuilder.toString().isEmpty()) {
                    whereBuilder.append(" AND regionf=?");
                } else {
                    whereBuilder.append(" WHERE regionf=?");
                }
            }

            builder.append(whereBuilder);
            PreparedStatement st = conn.prepareStatement(builder.toString());
            int counter = 1;
            if (fournisseurSearchCriteria.getNom() != null && !fournisseurSearchCriteria.getNom().isEmpty()) {
                st.setString(counter, fournisseurSearchCriteria.getNom());
                ++counter;
            }

            if (fournisseurSearchCriteria.getId() != null) {
                st.setInt(counter, fournisseurSearchCriteria.getId());
                ++counter;
            }

            if (fournisseurSearchCriteria.getRegion() != null) {
                st.setString(counter, fournisseurSearchCriteria.getRegion());
                ++counter;
            }

            ResultSet RS = st.executeQuery();

            while(RS.next()) {
                Fournisseur f = new Fournisseur();
                f.setNom(RS.getString(2));
                f.setId(RS.getInt(1));
                f.setRegion(RS.getString(3));
                list.add(f);
            }
        } catch (SQLException var11) {
            System.out.println(var11.getMessage());
        }

        return list;
    }
}
