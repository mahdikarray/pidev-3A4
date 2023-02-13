/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.veltun;

import java.sql.Connection;

import com.esprit.veltun.model.RackVelo;
import com.esprit.veltun.model.Station;
import com.esprit.veltun.services.StationService;
import com.esprit.veltun.util.MyConnection;
import com.esprit.veltun.services.impl.RackVeloImpl;
import com.esprit.veltun.services.impl.StationServiceImpl;
import com.esprit.veltun.model.base.BaseEntity;




public class PiDevJDBC {

	
	public static void main(String[] args) {
		Connection conn = MyConnection.getInstance();
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
		RackVelo rv2 = new RackVelo(1,50,6 ); //ajout
		RackVeloImpl rackv =  new RackVeloImpl() ; //ajout 
		//rackv.save(rv2); 
		//Update
		//rackv.update(rv2);
		//System.out.println(rackv.list()) ; 
		rackv.remove(1) ;
		
	
		

	}

}
