/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.veltun;

import com.esprit.veltun.model.User;
import com.esprit.veltun.model.Wallet;
import com.esprit.veltun.search.dto.UserSearchCriteria;
import com.esprit.veltun.search.dto.WalletSearchCriteria;
import com.esprit.veltun.services.impl.WalletServiceImpl;
import com.esprit.veltun.util.MyConnection;
import com.esprit.veltun.services.impl.UserServiceImpl;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;

/**
 *
 * @author Asus
 */
public class PiDevJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conn= MyConnection.getInstance();
        String date="2004-09-02";
        Date dn= Date.valueOf(LocalDate.parse(date));
        User u1 = new User("1326","Rezigui","Rayen",dn, "User",1000,"alaa.rezigui@esprit.tn");
        UserServiceImpl us = new UserServiceImpl();
        WalletServiceImpl ws=new WalletServiceImpl();

      //  us.save(u1);


        // System.out.println( us.list().toString());
       // User u2 = new User("800","Rezigui","Alaa",dn,"Admin",30,"alaa.rezigui@esprit.tn");
        //us.update(u2);
        //System.out.println(us.list().toString());
        //us.remove(u1.getCIN());
        //System.out.println(us.list().toString());
       // System.out.println(us.list().toString());
        UserSearchCriteria usc= new UserSearchCriteria();
        usc.setPrenom("alaa");
        System.out.println("search result");
        System.out.println(us.search(usc).toString());
        //Wallet w1 = new Wallet("1326",88);
        //ws.save(w1);
        //ws.remove("88");
        //System.out.println(ws.list().toString());
        //WalletSearchCriteria wsc= new WalletSearchCriteria("1326");


        //System.out.println(ws.search(wsc));



//        WalletSearchCriteria wsc = new WalletSearchCriteria("88");
//        System.out.println(us.search(usc).toString());;

    }
    
}
