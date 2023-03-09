/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.veltun;

import com.esprit.veltun.model.Maintenance;
import com.esprit.veltun.model.Reclamation;
import com.esprit.veltun.search.dto.ReclamationSearchCriteria;
import com.esprit.veltun.util.MyConnection;
import com.esprit.veltun.services.impl.ReclamationServiceImpl;
import com.esprit.veltun.services.impl.MaintenanceServiceImpl;
import com.esprit.veltun.search.dto.MaintenanceSearchCriteria;
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
        String date="2001-08-07";
        String date1="2009-09-09";
        Date dn1= Date.valueOf(LocalDate.parse(date1));
        Date dn= Date.valueOf(LocalDate.parse(date));

    /*Reclamation r1 = new Reclamation( 3,"reclamation1","reclamation probleme1","non declare",dn);
       ReclamationServiceImpl us = new ReclamationServiceImpl();
        us.save(r1);
        Reclamation r2 = new Reclamation( 3,"reclamation2","reclamation probleme2","declare",dn1);
       System.out.println( us.list().toString());
        us.update(r2);
        System.out.println(us.list().toString());
        us.remove(3);
        System.out.println(us.findById(43));




        Maintenance m1 = new Maintenance( 1,"maintenance1","en cours",dn,44);
        MaintenanceServiceImpl us1 = new MaintenanceServiceImpl();
       us1.save(m1);
        Maintenance m2 = new Maintenance( 2,"maintenance2","resolu",dn1,45);
        System.out.println(us1.list().toString());
        us1.update(m2);
        System.out.println(us1.list().toString());
        //us.remove(11);
        //System.out.println(us.findById());








*/
    }

}
