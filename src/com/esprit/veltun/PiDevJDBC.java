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
import com.esprit.veltun.services.impl.FournisseurServiceImpl;
import com.esprit.veltun.services.impl.VeloServiceImpl;
import com.esprit.veltun.model.Fournisseur;
import com.esprit.veltun.search.dto.FournisseurSearchCriteria;
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
      

/////////////////////////////////////VELO//////////////////////////////////////////
    	//  MyConnection conn = MyConnection.getInstance();
    	//VeloServiceImpl vel = new VeloServiceImpl();
        //VeloSearchCriteria searchCriteria = new VeloSearchCriteria();
    	
        //Velo v9= new Velo("mms","1m","vert",2);
      
        //System.out.println( vel.findById(1).toString()); /*find by id*/
        //vel.update(v9); /*modifier*/
    	//vel.save(v9); /*ajouter*/
    	//vel.remove(3); /*supp*/
        // System.out.println( vel.list().toString()); /*afficher*/
       
    	//searchCriteria.setId(4);
        //Collection<Velo> result = vel.search(searchCriteria);
        //result.forEach(v->System.out.println(v));


    	
/////////////////////////////////////VELO//////////////////////////////////////////
        //MyConnection conn = MyConnection.getInstance();
    	//FournisseurServiceImpl four = new FournisseurServiceImpl();
        //FournisseurSearchCriteria searchCriteria = new FournisseurSearchCriteria();
    	
        //Fournisseur f9= new Fournisseur("rym","jerjis");
      
        //System.out.println( four.findById(4).toString()); /*find by id*/
        //four.update(f9); /*modifier*/
    	//four.save(f9); /*ajouter*/
    	//four.remove(3); /*supp*/
        //System.out.println( four.list().toString()); /*afficher*/
       
    	//searchCriteria.setRegion("jerjis");
        //Collection<Fournisseur> result = four.search(searchCriteria);
        //result.forEach(f->System.out.println(f));
       
}
}
