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
<<<<<<< Updated upstream
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
=======
        //testEvent();

        Connection conn= MyConnection.getInstance();
        String date="2004-09-25";
        Date dn= Date.valueOf(LocalDate.parse(date));
        User u1 = new User("14507464","Rezigui","alaa",dn, "User",6596,"alaa.rezigui@esprit.tn");
        UserServiceImpl us = new UserServiceImpl();
        WalletServiceImpl ws=new WalletServiceImpl();

   //     System.out.println(us.findByCin("1326").toString());

          //us.save(u1);


         System.out.println( us.list().toString());
         User u2 = new User("14507464","Rezigui","Alaa",dn,"Admin",30,"alaa.rezigui@esprit.tn");
       // us.update(u2);
        //System.out.println(us.list().toString());
      //  us.remove(u1.getCIN());
        //System.out.println(us.list().toString());
        // System.out.println(us.list().toString());
        /*UserSearchCriteria usc= new UserSearchCriteria();
        usc.setPrenom("alaa");
        System.out.println("search result");
        System.out.println(us.search(usc).toString());
        *///Wallet w1 = new Wallet("1326",88);
        //ws.save(w1);
        //ws.remove("88");
        //System.out.println(ws.list().toString());
        //WalletSearchCriteria wsc= new WalletSearchCriteria("1326");
        //System.out.println(ws.search(wsc));
//        WalletSearchCriteria wsc = new WalletSearchCriteria("88");
//        System.out.println(us.search(usc).toString());;


       /* String alphabet="ABCDEFGHIJKLMNOPQRSTUVXWZ";
        StringBuilder sb= new StringBuilder();
        Random random=new Random();
        int lenght=7;
        for(int i=0;i<lenght;i++){
            int index= random.nextInt(alphabet.length());
            char randomchar=alphabet.charAt(index);
            sb.append(randomchar);
        }
        String randomstring=sb.toString();
        //System.out.println("hi"+randomstring);*/
        ///////////////////MAHDI  ///////////////////
       // Offre offre=new Offre();
         //Offre p1 = new Offre(18,162.5776f,"hah");
        //OffreServiceImpl off= new OffreServiceImpl();

        //CRUD OFFRE
        //off.save(p1);
        //off.remove(21);
        //Offre p2= new Offre(24,(float)99.99);
        //off.update(p2);
        //System.out.println(off.findById(23));
        //   System.out.println( off.list());
        //////////////////////////////////////////////////
        //CRUD ABONNEMENT
       /* String datee="2001-08-07";
        String date1="2009-09-09";
        Date dn1= Date.valueOf(LocalDate.parse(date1));
        Date dn3= Date.valueOf(LocalDate.parse(datee));
        Abonnement b1=new Abonnement(60,"Standard",dn1,dn3,23,36);
        //Abonnement b2=new Abonnement("Premium","6",1423.300f,18);
        //Abonnement b3=new Abonnement("Premium","6",14.300f,18);
        AbonnementServiceImpl abb =new AbonnementServiceImpl();
        Abonnement a=new Abonnement();*/

       // Reclamation r1 = new Reclamation( 3,"reclamation1","reclamation probleme1","non declare",dn);
       // a.setDateDebut(Date.valueOf("2025-12-01"));
        //a.setDateFin(Date.valueOf("2026-12-01"));
       // abb.save(b1);
        //abb.update(b1);
        //abb.remove(5);
        //System.out.println(abb.findById(7));
        //System.out.println( abb.list());
        //AbonnementSearchCriteria searchCriteria = new AbonnementSearchCriteria();
        //searchCriteria.setType_ab("Premium");
        //Collection<Abonnement> result = abb.search(searchCriteria);
        //result.forEach(type->System.out.println(type));


        /////EVENT//////

        //Event e=new Event();


        /*EventServiceImpl event2 = new EventServiceImpl();
        System.out.println(event2.findById(29));
        */
        /*
        Event event1 = new Event();

        event1.setId(45);

        event1.setTitre("tour de hoa nnn");

        event1.setDescription("la dd est ...");

        event1.setDateDebut(Date.valueOf("2001-12-01"));

        event1.setHeureDebut(Time.valueOf("17:00:00"));




        event1.setDateFin(Date.valueOf("2026-12-01"));

        event1.setHeureFin(Time.valueOf("18:15:00"));

        // Adresse adresse = new Adresse();

        //adresse.setId(1);

        // event.setAdresse(adresse);

        // eventService.save(event1);

        //eventService.update(event1);

        //Event a = eventService.findById(44);

        // eventService.remove(45);






        //Collection<Event> events = new ArrayList();

        //EventSearchCriteria eventSearchCriteria = new EventSearchCriteria();

        // eventSearchCriteria.setTitre("tour de hoa");



        //eventService.remove(45);

//

        //  events = eventService.search(eventSearchCriteria);

        //System.out.println(events);

>>>>>>> Stashed changes
    }

}
// inviService.update(invi);
