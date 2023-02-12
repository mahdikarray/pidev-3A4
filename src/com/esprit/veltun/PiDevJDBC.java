/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.veltun;

import java.sql.Connection;

import com.esprit.veltun.model.Station;
import com.esprit.veltun.services.StationService;
import com.esprit.veltun.util.MyConnection;
import com.esprit.veltun.services.impl.StationServiceImpl;
import com.esprit.veltun.model.base.BaseEntity;




public class PiDevJDBC {

	
	public static void main(String[] args) {
		Connection conn = MyConnection.getInstance();
	    //	System.out.print("started");
		//Station s8 = new Station("ARIANA", 8.5, 8.6);  //ajout
		//Station s1 = new Station("Station 1" , 8.5 , 8.6 ); //ajout
		StationServiceImpl sta =  new StationServiceImpl() ; //ajout 
		//sta.save(s1); 
		 //sta.remove(5); //delete 
		
		//sta.update();  //update 
		
		
	
		

	}

}
