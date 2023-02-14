/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.veltun;

import java.sql.Connection;

//import com.esprit.veltun.model.RackVelo;
import com.esprit.veltun.services.impl.OffreServiceImpl;
import com.esprit.veltun.services.impl.AbonnementServiceImpl;
import com.esprit.veltun.util.MyConnection;
import com.esprit.veltun.model.Offre;
import com.esprit.veltun.model.Abonnement;


public class PiDevJDBC {

	
	public static void main(String[] args) {
		Connection conn = MyConnection.getInstance();
		Offre p1 = new Offre(19,2.2f);
		OffreServiceImpl off= new OffreServiceImpl();
		//CRUD OFFRE
		//off.save(p1);
		//off.remove(19);
//off.update(p1);
		//off.findById(12);
		System.out.println( off.list());
		//////////////////////////////////////////////////
		//CRUD ABONNEMENT
		Abonnement b1=new Abonnement(11,"Premium",1,114.12f,19);
		Abonnement b2=new Abonnement(8,"Premium",6,14.300f,18);
		Abonnement b3=new Abonnement(8,"Premium",6,14.300f,18);
		AbonnementServiceImpl abb =new AbonnementServiceImpl();
		//abb.save(b1);
		//abb.update(b1);
		//abb.remove(10);
		//abb.findById(7);
		System.out.println( abb.list());
	    /////////////////////////////////////////////////////////
		//	System.out.print("started");
		//CRUD STATION
		//ajout
		//Station s8 = new Station("ARIANA", 8.5, 8.6);  
		//Station s1 = new Station(6,"ARIANA" , 8.3 , 8.7 ); 
		//StationServiceImpl sta =  new StationServiceImpl() ;  
		//sta.save(s1); 
		//delete 
		 //sta.remove(5); 
		
		//sta.update(s1);  //update 
		//System.out.println(sta.list()) ; 

		//CRUD RACKVéLO
		//Ajout
		//RackVelo rv2 = new RackVelo(1,50,6 ); //ajout
		//RackVeloImpl rackv =  new RackVeloImpl() ; //ajout
		//rackv.save(rv2); 
		//Update
		//rackv.update(rv2);
		//System.out.println(rackv.list()) ; 
		//rackv.remove(1) ;
		
	
		

	}

}
