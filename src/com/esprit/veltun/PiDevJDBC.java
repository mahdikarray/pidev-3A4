
package com.esprit.veltun;

import java.sql.Connection;
import java.util.Collection;

import com.esprit.veltun.model.RackVelo;
import com.esprit.veltun.model.Station;
import com.esprit.veltun.search.dto.StationSearchCriteria;
import com.esprit.veltun.services.impl.RackVeloImpl;
import com.esprit.veltun.services.impl.StationServiceImpl;
import com.esprit.veltun.util.MyConnection;

public class PiDevJDBC {

   
    public static void main(String[] args) {
    	
    	Connection conn = MyConnection.getInstance();
	    System.out.println("You're connected to your Database");
		
    	
    	//CRUD STATION//
			//CREATE
		//Station s10 = new Station("GHAZELLA", 8.5, 8.6);  
		//Station s3 = new Station(7,"TUNIS-BebAlioua" , 8.3 , 8.7 ); 
		//StationServiceImpl sta =  new StationServiceImpl() ;
		//sta.save(s10); 
    	
    		//READ 
    	//System.out.println(sta.list())  ; 
    	
			//DELETE 
		//sta.remove(10); 
    	
    		//SEARCH
		//StationSearchCriteria sc = new StationSearchCriteria() ;
		//System.out.println(sta.search(sc).toString()) ;
		//sc.setNom_station("ARIANA");
		//Collection<Station> result = sta.search(sc);
		//result.forEach(nom->System.out.println(nom));
    	
    		//UPDATE
		//sta.update(s3);   
		//System.out.println(sta.list()) ; 
		
    	
		//CRUD RACKVELO
			//CREATE
		//RackVelo rv2 = new RackVelo(111,50,7); 
		//RackVeloImpl rackv =  new RackVeloImpl() ;  
		//rackv.save(rv2); 
    	
    		//READ 
    	//System.out.println(rackv.list()) ; 
		
    		//UPDATE
		//rackv.update(rv2);
		//System.out.println(rackv.list()) ; 
    	
    		//DELETE
		//rackv.remove(1) ;
    }

}

