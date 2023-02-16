/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.veltun;
import com.esprit.veltun.model.User;
import com.esprit.veltun.util.MyConnection;
import com.esprit.veltun.services.impl.UserServiceImpl;
import com.esprit.veltun.model.User;
import com.esprit.veltun.util.MyConnection;
import com.esprit.veltun.services.impl.UserServiceImpl;

import com.esprit.veltun.model.User;
import com.esprit.veltun.util.MyConnection;
import com.esprit.veltun.services.impl.UserServiceImpl;


import com.esprit.veltun.model.User;
import com.esprit.veltun.util.MyConnection;
import com.esprit.veltun.services.impl.UserServiceImpl;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;

import com.esprit.veltun.model.RackVelo;
import com.esprit.veltun.model.Station;
import com.esprit.veltun.services.StationService;
import com.esprit.veltun.util.MyConnection;
import com.esprit.veltun.services.impl.RackVeloImpl;
import com.esprit.veltun.services.impl.StationServiceImpl;
import com.esprit.veltun.services.impl.UserServiceImpl;
import com.esprit.veltun.model.base.BaseEntity;
import com.esprit.veltun.search.dto.StationSearchCriteria;

/**
 *
 * @author Asus
 */
public class PiDevJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // Connection conn= MyConnection.getInstance();
       // String date="2001-08-07";
        //Date dn= Date.valueOf(LocalDate.parse(date));
        // MyConnection conn = MyConnection.getInstance();
       // User u1 = new User("88","Rezigui","Alaa",dn, "Admin",1000,"alaa.rezigui@esprit.tn");
       //UserServiceImpl us = new UserServiceImpl();

        //us.save(u1);


      //  System.out.println( us.list().toString());
        //User u2 = new User("800","Rezigui","Alaa",dn,"Admin",30,"alaa.rezigui@esprit.tn");
       // us.update(u2);
        //System.out.println(us.list().toString());
        //us.remove(u1.getCIN());
        //System.out.println(us.list().toString());

        
    	//Connection conn = MyConnection.getInstance();
	    //System.out.print("started");
		//CRUD STATION
		//AJOUT
		//Station s8 = new Station("ARIANA", 8.5, 8.6);  
		//Station s3 = new Station(10,"TUNIS" , 8.3 , 8.7 ); 
		//StationServiceImpl sta =  new StationServiceImpl() ;  
		//sta.save(s3); 
		//delete 
		 //sta.remove(5); 
		//StationSearchCriteria sc = new StationSearchCriteria(7) ;
		//System.out.println(sta.search(sc).toString()) ; 
		//sta.update(s1);  //update 
		//System.out.println(sta.list()) ; 
		
		//CRUD RACKVELO
		//AJOUT
		//RackVelo rv2 = new RackVelo(1,50,6 ); //ajout
		//RackVeloImpl rackv =  new RackVeloImpl() ; //ajout 
		//rackv.save(rv2); 
		//Update
		//rackv.update(rv2);
		//System.out.println(rackv.list()) ; 
		//rackv.remove(1) ;
		


    }

}
