/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.veltun;

import com.esprit.veltun.model.User;
import com.esprit.veltun.util.MyConnection;
import com.esprit.veltun.services.impl.UserServiceImpl;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;

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
        String date="2001-08-07";
        Date dn= Date.valueOf(LocalDate.parse(date));
        // MyConnection conn = MyConnection.getInstance();
        User u1 = new User("88","Rezigui","Alaa",dn, "Admin",1000,"alaa.rezigui@esprit.tn");
        UserServiceImpl us = new UserServiceImpl();

        //us.save(u1);


        System.out.println( us.list().toString());
        User u2 = new User("800","Rezigui","Alaa",dn,"Admin",30,"alaa.rezigui@esprit.tn");
        us.update(u2);
        //System.out.println(us.list().toString());
        //us.remove(u1.getCIN());
        //System.out.println(us.list().toString());


    }
    
}
