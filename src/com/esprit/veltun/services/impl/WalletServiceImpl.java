package com.esprit.veltun.services.impl;

import com.esprit.veltun.model.Wallet;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.WalletSearchCriteria;
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
            Statement st = conn.createStatement();

            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Wallet w = new Wallet();

                w.setIdWallet(RS.getInt(1));
                w.setCin(RS.getString(2));
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
            ps.setString(1, w.getCin());
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
            Statement ste;
            String req = "select * from wallet where `cin` like "+ walletSearchCriteria.getCin();
            PreparedStatement st = conn.prepareStatement(req);
            ResultSet RS = st.executeQuery(req);
            while (RS.next()) {
                Wallet w = new Wallet();
                w.setIdWallet(RS.getInt(1));
                w.setCin(RS.getString(2));
                w.setAccount(RS.getInt(3));
                list.add(w);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
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
}
