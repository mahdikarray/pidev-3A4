/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.veltun;

//import com.esprit.veltun.model.User;
import com.esprit.veltun.model.Velo;
import com.esprit.veltun.util.MyConnection;
import com.esprit.veltun.services.VeloService;
import com.esprit.veltun.services.base.BaseService;
import com.esprit.veltun.services.impl.VeloServiceImpl;
import com.esprit.veltun.model.Fournisseur;
import com.esprit.veltun.search.dto.VeloSearchCriteria;
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
       // Connection conn= MyConnection.getInstance();
       // String date="2001-08-07";
       // Date dn= Date.valueOf(LocalDate.parse(date));
        // MyConnection conn = MyConnection.getInstance();
       // User u1 = new User("88","Rezigui","Alaa",dn, "Admin",1000,"alaa.rezigui@esprit.tn");
        

        //us.save(u1);


       // System.out.println( vel.list().toString());
       // User u2 = new User("800","Rezigui","Alaa",dn,"Admin",30,"alaa.rezigui@esprit.tn");
       // us.update(u2);
        //System.out.println(us.list().toString());
        //us.remove(u1.getCIN());
       // System.out.println(us.list().toString());

///////////////////////////////////////////////////////////////////////////////
    	//  MyConnection conn = MyConnection.getInstance();
    	//VeloServiceImpl vel = new VeloServiceImpl();
    	 //Velo v9= new Velo("mms","1m","vert",2);
    	
    	
    	//VeloSearchCriteria searchCriteria = new VeloSearchCriteria();
    	
 
      
       //System.out.println( vel.findById(1).toString()); /*find by id*/
        //vel.update(v9); /*modifier*/
    	//vel.save(v9); /*ajouter*/
    	//vel.remove(3);
       // System.out.println( vel.list().toString()); /*afficher*/
       // searchCriteria.setCouleur("noir");
        
                    
          //  Collection<Velo> result = vel.search(searchCriteria);
           // result.forEach(taille->System.out.println(taille));


       // System.out.println(vel.search(velo).toString());    /*search*/
        
       /* BaseService<Velo> veloService = null;
		Velo v = veloService.findById(3);*/
}
}
