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
        //MyConnection conn = MyConnection.getInstance();
       Reclamation r1 = new Reclamation( 1,"reclamation","uuuuuuuuuu","en cours",dn);
        ReclamationServiceImpl us = new ReclamationServiceImpl();

        us.save(r1);


        System.out.println( us.list().toString());
        Reclamation r2 = new Reclamation( 1,"iluluiu","khukhkuhh","en cours",dn);
        us.update(r2);
        System.out.println(us.list().toString());
        //us.remove(2);
        System.out.println(us.list().toString());
        ReclamationSearchCriteria rsc=new ReclamationSearchCriteria();
        rsc.setId_reclamation(3);
        System.out.println("******************************* Search: *******************************");
        System.out.println(us.search(rsc).toString());

/*
        Maintenance m1 = new Maintenance( 1,10,"uuuuuuuuuu","en cours",dn);
        MaintenanceServiceImpl us = new MaintenanceServiceImpl();

        us.save(m1);

        System.out.println( us.list().toString());
        Maintenance m2 = new Maintenance( 1,9,"uuuuuuuuuu","en cours",dn);
        us.update(m2);
        System.out.println(us.list().toString());
        us.remove(2);
        System.out.println(us.list().toString());
        MaintenanceSearchCriteria rsc=new MaintenanceSearchCriteria();
        rsc.setId_demande(3);
        System.out.println("******************************* Search: *******************************");
         System.out.println(us.search(rsc).toString());



*/



    }

}
