package com.esprit.veltun.services.impl;

import com.esprit.veltun.model.Velo;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.VeloSearchCriteria;
import com.esprit.veltun.services.VeloService;
import com.esprit.veltun.util.MyConnection;
import javafx.scene.image.Image;

import java.io.ByteArrayInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VeloServiceImpl implements VeloService {
    public VeloServiceImpl() {
    }

    public Velo savee(Velo v, byte[] imageBytes) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "INSERT INTO velo (libellev, taillev, couleurv, idf, image) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, v.getLibelle());
            ps.setString(2, v.getTaille());
            ps.setString(3, v.getCouleur());
            ps.setInt(4, v.getIdf());

            // Set image as a Blob parameter
            Blob imageBlob = conn.createBlob();
            imageBlob.setBytes(1, imageBytes);
            ps.setBlob(5, imageBlob);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Failed to save velo.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    v.setId(id);
                    System.out.println("velo ajouté!!!");
                } else {
                    throw new SQLException("Failed to retrieve generated keys.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return v;
    }


    public Velo update(Velo v) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "UPDATE velo SET libellev = '" + v.getLibelle() + "', taillev = '" + v.getTaille() + "', couleurv =  '" + v.getCouleur() + "', image =  '" + v.getImage() + "', idf = " + v.getIdf() + "  WHERE  `velo`.`idv` = " + v.getId();
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

            while (RS.next()) {
                Velo v = new Velo();
                v.setLibelle(RS.getString(2));
                v.setId(RS.getInt(1));
                v.setTaille(RS.getString(3));
                v.setCouleur(RS.getString(4));
                v.setIdf(RS.getInt(5));
                byte[] imageData = RS.getBytes("image");
                Image image = new Image(new ByteArrayInputStream(imageData));
                list.add(v);
            }
        } catch (SQLException var7) {
            System.out.println(var7.getMessage());
        }

        return list;
    }

    @Override
    public Velo save(Velo entity) {
        return null;
    }

    public Velo findById(Integer id) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "SELECT * FROM velo WHERE idv = " + id;
            Statement st = conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            if (RS.next()) {
                Velo v = new Velo();
                v.setLibelle(RS.getString(2));
                v.setId(RS.getInt(1));
                v.setTaille(RS.getString(3));
                v.setCouleur(RS.getString(4));
                v.setIdf(RS.getInt(5));


                System.out.println("velo founded");
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
            VeloSearchCriteria veloSearchCriteria = (VeloSearchCriteria) searchCriteria;
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

            while (RS.next()) {
                Velo v = new Velo();
                v.setLibelle(RS.getString(2));
                v.setId(RS.getInt(1));
                v.setTaille(RS.getString(3));
                v.setCouleur(RS.getString(4));
                v.setIdf(RS.getInt(5));
                list.add(v);
            }
        } catch (SQLException var11) {
            System.out.println(var11.getMessage());
        }

        return list;
    }

    @Override
    public String veloDominante() {
        String color = null;
        try {
            Connection conn = MyConnection.getInstance();
            String sql = "SELECT idv, libellev, taillev, couleurv, rating\n" +
                    "FROM velo\n" +
                    "WHERE rating = (SELECT MAX(rating) FROM velo);;";
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                color = rs.getString("libellev");
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }

        return color;

    }



    public List<Velo> getAllVelos() throws SQLException {
        Connection conn = MyConnection.getInstance();
        String selectQuery = "SELECT * FROM velo";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(selectQuery);

        List<Velo> velos = new ArrayList<>();

        while (rs.next()) {
            int idv = rs.getInt("idv");
            String libellev = rs.getString("libellev");
            String taillev = rs.getString("taillev");
            String couleurv = rs.getString("couleurv");
            int idf = rs.getInt("idf");
            int rating = rs.getInt("rating");
            byte[] imageData = rs.getBytes("image");
            Image image = new Image(new ByteArrayInputStream(imageData));

            Velo velo = new Velo(idv, libellev, taillev, couleurv, idf, rating, image);
            velos.add(velo);
        }

        return velos;
    }

}
