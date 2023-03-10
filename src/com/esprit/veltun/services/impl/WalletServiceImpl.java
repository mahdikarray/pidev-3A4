package com.esprit.veltun.services.impl;

import com.esprit.veltun.model.User;
import com.esprit.veltun.model.Wallet;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.UserSearchCriteria;
import com.esprit.veltun.search.dto.WalletSearchCriteria;
import com.esprit.veltun.services.UserService;
import com.esprit.veltun.services.WalletService;
import com.esprit.veltun.util.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WalletServiceImpl implements WalletService {
    @Override
    public Wallet findById(Integer id) {
        return null;
    }

    @Override
    public Collection<Wallet> list() {
        List<Wallet> list = new ArrayList<>();
        try {
            Connection conn = MyConnection.getInstance();
            String req = "Select * from wallet";
            UserServiceImpl usi = new UserServiceImpl();
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Wallet w = new Wallet();

                w.setIdWallet(RS.getInt(1));
                w.setOwner(usi.findByCin(RS.getString(2)));
                w.setAccount(RS.getInt(3));
                list.add(w);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public Wallet save(Wallet w) {

        try {
            Connection conn = MyConnection.getInstance();
            String req = "INSERT INTO `wallet`(`cin`, `account`)"
                    + "VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, w.getOwner().getCIN());
            ps.setInt(2, w.getAccount());
            Integer id = ps.executeUpdate();
            w.setId(id);
            System.out.println("Wallet ajouté!!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return w;
    }

    @Override
    public Wallet update(Wallet w) {
        try {
            Connection conn = MyConnection.getInstance();
            Statement ste;

            String req = "UPDATE `wallet` SET `account` = " + w.getAccount() + " WHERE `wallet`.`id` LIKE " + w.getIdWallet();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Wallet updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return w;
    }

    @Override
    public boolean remove(Integer id) {
        try {
            Connection conn = MyConnection.getInstance();
            String req = "DELETE FROM `wallet` WHERE id = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Wallet deleted !");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Collection<Wallet> search(SearchCriteria<Wallet> searchCriteria) {
        List<Wallet> list = new ArrayList<>();
        try {
            WalletSearchCriteria walletSearchCriteria = (WalletSearchCriteria) searchCriteria;
            Connection conn = MyConnection.getInstance();

            StringBuilder builder = new StringBuilder("Select * from wallet");
            StringBuilder whereBuilder = new StringBuilder();

            if (walletSearchCriteria.getCin() != null && !walletSearchCriteria.getCin().isEmpty()) {
                if (!whereBuilder.toString().isEmpty()) {
                    whereBuilder.append(" OR cin = ?");

                } else {
                    whereBuilder.append(" WHERE cin = ?");
                }
            }



            PreparedStatement st = conn.prepareStatement(builder.toString());
            int counter = 1;
            if (walletSearchCriteria.getCin() != null && !walletSearchCriteria.getCin().isEmpty()) {
                st.setString(counter, walletSearchCriteria.getCin());
                counter++;
            }



            ResultSet RS = st.executeQuery();
            while (RS.next()) {
                Wallet w = new Wallet();
                User u = new User();
                UserServiceImpl usi= new UserServiceImpl();
                w.setOwner(usi.findByCin(RS.getString(2)));
                w.setAccount(RS.getInt(3));

                list.add(w);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public String veloDominante() {
        return null;
    }

    @Override
    public boolean remove(String cin) {

        try {
            Connection conn = MyConnection.getInstance();
            String req = "DELETE FROM `wallet` WHERE cin LIKE " + cin;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("Wallet deleted !");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }    }

    public Wallet findByCin(String cin) {
        Wallet w=new Wallet();
        try {
            UserServiceImpl usi= new UserServiceImpl();
            Connection conn=MyConnection.getInstance();
            String req = "SELECT * FROM `wallet` WHERE cin LIKE " + cin;
            Statement st= conn.createStatement();
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                w.setIdWallet(RS.getInt(1));
                w.setOwner(usi.findByCin(cin));
                w.setAccount(RS.getInt(3));
            }

            return w;
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }









}
