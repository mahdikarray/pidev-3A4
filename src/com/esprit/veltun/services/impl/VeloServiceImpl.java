//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.veltun.services.impl;

import com.esprit.veltun.model.Velo;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.VeloSearchCriteria;
import com.esprit.veltun.services.VeloService;
import com.esprit.veltun.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class VeloServiceImpl implements VeloService {
    public VeloServiceImpl() {
    }

    public Velo save(Velo v) {
        try {
            Connection conn = MyConnection.getInstance();
            FournisseurServiceImpl fsi = new FournisseurServiceImpl();
            String req = "INSERT INTO velo (libellev, taillev, couleurv, idf) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, v.getLibelle());
            ps.setString(2, v.getTaille());
            ps.setString(3, v.getCouleur());
            ps.setInt(4, v.getFournisseur().getId());
            Integer id = ps.executeUpdate();
            v.setId(id);
            System.out.println("velo ajouté!!!");
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return v;
    }

    public Velo update(Velo v) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "UPDATE velo SET libellev = '" + v.getLibelle() + ", taillev = " + v.getTaille() + ", couleurv = " + v.getCouleur() + ", idf = " + v.getFournisseur().getId() + "' WHERE velo.id = " + v.getId();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("velo updated !");
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return v;
    }

    public boolean remove(Integer id) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "DELETE FROM velo WHERE idv = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("velo deleted !");
            return true;
        } catch (SQLException var5) {
            System.out.println(var5.getMessage());
            return false;
        }
    }

    public Collection<Velo> list() {
        ArrayList list = new ArrayList();

        try {
            Connection conn = MyConnection.getInstance();
            String req = "Select * from velo";
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            FournisseurServiceImpl fsi = new FournisseurServiceImpl();

            while(RS.next()) {
                Velo v = new Velo();
                v.setLibelle(RS.getString(2));
                v.setId(RS.getInt(1));
                v.setTaille(RS.getString(3));
                v.setCouleur(RS.getString(4));
                v.setFournisseur(fsi.findById(RS.getInt(5)));
                list.add(v);
            }
        } catch (SQLException var7) {
            System.out.println(var7.getMessage());
        }

        return list;
    }

    public Velo findById(Integer id) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "SELECT * FROM velo WHERE idv = " + id;
            Statement st = conn.createStatement();
            FournisseurServiceImpl fsi = new FournisseurServiceImpl();
            ResultSet RS = st.executeQuery(req);
            if (RS.next()) {
                Velo v = new Velo();
                v.setLibelle(RS.getString(2));
                v.setId(RS.getInt(1));
                v.setTaille(RS.getString(3));
                v.setCouleur(RS.getString(4));
                v.setFournisseur(fsi.findById(RS.getInt(5)));
                System.out.println("velo found");
                return v;
            }
        } catch (SQLException var7) {
            System.out.println(var7.getMessage());
        }

        return null;
    }

    public Collection<Velo> search(SearchCriteria<Velo> searchCriteria) {
        ArrayList list = new ArrayList();

        try {
            VeloSearchCriteria veloSearchCriteria = (VeloSearchCriteria)searchCriteria;
            Connection conn = MyConnection.getInstance();
            StringBuilder builder = new StringBuilder("Select * from velo");
            StringBuilder whereBuilder = new StringBuilder();
            if (veloSearchCriteria.getLibelle() != null && !veloSearchCriteria.getLibelle().isEmpty()) {
                if (!whereBuilder.toString().isEmpty()) {
                    whereBuilder.append(" AND libellev=?");
                } else {
                    whereBuilder.append(" WHERE libellev=?");
                }
            }

            if (veloSearchCriteria.getId() != null) {
                if (!whereBuilder.toString().isEmpty()) {
                    whereBuilder.append(" AND idv=?");
                } else {
                    whereBuilder.append(" WHERE idv=?");
                }
            }

            if (veloSearchCriteria.getTaille() != null) {
                if (!whereBuilder.toString().isEmpty()) {
                    whereBuilder.append(" AND taillev=?");
                } else {
                    whereBuilder.append(" WHERE taillev=?");
                }
            }

            if (veloSearchCriteria.getCouleur() != null) {
                if (!whereBuilder.toString().isEmpty()) {
                    whereBuilder.append(" AND couleurv=?");
                } else {
                    whereBuilder.append(" WHERE couleurv=?");
                }
            }

            builder.append(whereBuilder);
            PreparedStatement st = conn.prepareStatement(builder.toString());
            int counter = 1;
            if (veloSearchCriteria.getLibelle() != null && !veloSearchCriteria.getLibelle().isEmpty()) {
                st.setString(counter, veloSearchCriteria.getLibelle());
                ++counter;
            }

            if (veloSearchCriteria.getId() != null) {
                st.setInt(counter, veloSearchCriteria.getId());
                ++counter;
            }

            if (veloSearchCriteria.getTaille() != null) {
                st.setString(counter, veloSearchCriteria.getTaille());
                ++counter;
            }

            if (veloSearchCriteria.getCouleur() != null) {
                st.setString(counter, veloSearchCriteria.getCouleur());
                ++counter;
            }

            ResultSet RS = st.executeQuery();
            FournisseurServiceImpl fsi = new FournisseurServiceImpl();

            while(RS.next()) {
                Velo v = new Velo();
                v.setLibelle(RS.getString(2));
                v.setId(RS.getInt(1));
                v.setTaille(RS.getString(3));
                v.setCouleur(RS.getString(4));
                v.setFournisseur(fsi.findById(RS.getInt(5)));
                list.add(v);
            }
        } catch (SQLException var11) {
            System.out.println(var11.getMessage());
        }

        return list;
    }
}
