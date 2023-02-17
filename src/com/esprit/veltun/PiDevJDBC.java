/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.veltun;
import java.sql.Connection;
import java.util.Collection;
import com.esprit.veltun.services.impl.OffreServiceImpl;
import com.esprit.veltun.services.impl.AbonnementServiceImpl;
import com.esprit.veltun.util.MyConnection;
import com.esprit.veltun.model.Offre;
import com.esprit.veltun.model.Abonnement;
import com.esprit.veltun.search.dto.AbonnementSearchCriteria;
/**
 *
 * @author Asus
 */
public class PiDevJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	Connection conn = MyConnection.getInstance();
		//Offre p1 = new Offre(22,2.56f);
		//OffreServiceImpl off= new OffreServiceImpl();
		//CRUD OFFRE
		//off.save(p1);
		//off.remove(19);
//off.update(p1);
		//System.out.println(off.findById(18));
		//System.out.println( off.list());
		//////////////////////////////////////////////////
		//CRUD ABONNEMENT
		//Abonnement b1=new Abonnement(13,"Standard",12,114.12f,18);
		//Abonnement b2=new Abonnement(8,"Premium",6,1423.300f,18);
		//Abonnement b3=new Abonnement(8,"Premium",6,14.300f,18);
		//AbonnementServiceImpl abb =new AbonnementServiceImpl();
		//abb.save(b1);
		//abb.update(b1);
		//abb.remove(10);
		//System.out.println(abb.findById(7));
		//System.out.println( abb.list());
		//AbonnementSearchCriteria searchCriteria = new AbonnementSearchCriteria();
		//searchCriteria.setType_ab("Premium");
		//Collection<Abonnement> result = abb.search(searchCriteria);
		//result.forEach(type->System.out.println(type));
    }

}
// inviService.update(invi);
