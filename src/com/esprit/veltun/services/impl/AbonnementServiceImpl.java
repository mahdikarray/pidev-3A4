//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.veltun.services.impl;

import com.esprit.veltun.model.Abonnement;
import com.esprit.veltun.model.User;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.AbonnementSearchCriteria;
import com.esprit.veltun.services.AbonnementService;
import com.esprit.veltun.util.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class AbonnementServiceImpl implements AbonnementService {


    public static int idA;
    public static Abonnement chosenAbonnement;
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
                ab.setDateDebut(RS.getDate("date_debut"));
                ab.setDateFin(RS.getDate("date_fin"));
                ab.setPrix_ab(RS.getFloat("Prix_ab"));
              //  ab.setId_offre(RS.getInt(1));
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
               // a.setDuree(RS.getString("Duree"));
                a.setDateDebut(RS.getDate("date_debut"));
                a.setDateFin(RS.getDate("date_fin"));
                a.setPrix_ab(RS.getFloat("Prix_ab"));
              //  a.setId_offre(RS.getInt(1));
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
            String req = "INSERT INTO `abonnement` ( Type_ab,date_debut,date_fin,Prix_ab,Id_offre) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setInt(1, a.getId_ab());
            ps.setString(1, a.getType_ab());
            ps.setDate(2, a.getDateDebut());
            ps.setDate(3, a.getDateFin());
            ps.setFloat(4, a.getPrix_ab());
            ps.setInt(5, a.getId_offre());
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
            String req = "UPDATE abonnement SET Type_ab = '" + a.getType_ab() + "', date_debut = '" + a.getDateDebut() +"', date_fin = '" + a.getDateFin() + "', Prix_ab = '" + a.getPrix_ab() + "' WHERE abonnement.Id_ab = " + a.getId_ab();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("abonnement updated !");
        } catch (SQLException var5) {
            System.out.println(var5.getMessage());
        }

        return a;
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
                //v.setDuree(RS.getString(3));
                v.setDateDebut(RS.getDate(3));
                v.setDateFin(RS.getDate(4));
                v.setPrix_ab(RS.getFloat(5));
                //v.setId_offre(RS.getInt(6));
                list.add(v);
            }
        } catch (SQLException var11) {
            System.out.println(var11.getMessage());
        }

        return list;
    }

    @Override
    public String veloDominante() {
        return null;
    }

    public static class DiscountCodeGenerator {
        private static String lastGeneratedCode;
        public static String generateCode() {
            String code = "";
            Random random = new Random();


            lastGeneratedCode = code; // store the generated code in the variable


            // Generate a random 6-character code
            for (int i = 0; i < 6; i++) {
                int rand = random.nextInt(10);
                code += Integer.toString(rand);
            }

            return code;
        }
        public static String getLastGeneratedCode() {
            return lastGeneratedCode;
        }
        public static float getDiscount(String code) {
            float discount = 0.0f;

            // Check if the code starts with an even number
            if (Character.getNumericValue(code.charAt(0)) % 2 == 0) {
                discount = 0.2f; // 20% discount
            } else {
                discount = 0.1f; // 10% discount
            }

            return discount;
        }
    }
    public static void updateEventPrice(int currentSubscriptionId, float newPrice) {
        try {
            // Create a connection to the database
            Connection conn = MyConnection.getInstance();

            // Prepare the SQL statement to update the event price
            PreparedStatement statement = conn.prepareStatement(
                    "UPDATE abonnement SET prix_ab = ? WHERE id_ab = ?");

            // Set the parameters for the SQL statement
            statement.setFloat(1, newPrice);
            statement.setInt(2, currentSubscriptionId);

            // Execute the SQL statement
            statement.executeUpdate();


        } catch (SQLException ex) {
            System.out.println("Error updating event price: " + ex.getMessage());
        }
    }
}
