
package com.esprit.veltun;

import com.esprit.veltun.model.*;
import com.esprit.veltun.search.dto.*;
import com.esprit.veltun.services.impl.*;
import com.esprit.veltun.util.MyConnection;
import com.esprit.veltun.model.base.BaseEntity;
import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;



import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
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
        //testEvent();

      /*  Connection conn= MyConnection.getInstance();
        String date="2004-09-25";
        Date dn= Date.valueOf(LocalDate.parse(date));
        User u1 = new User("14507464","Rezigui","alaa",dn, "User",6596,"alaa.rezigui@esprit.tn");
        UserServiceImpl us = new UserServiceImpl();
        WalletServiceImpl ws=new WalletServiceImpl();*/

   //     System.out.println(us.findByCin("1326").toString());

          //us.save(u1);


         //System.out.println( us.list().toString());
        // User u2 = new User("14507464","Rezigui","Alaa",dn,"Admin",30,"alaa.rezigui@esprit.tn");
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
        //WalletSearchCriteria wsc = new WalletSearchCriteria("88");
        //System.out.println(us.search(usc).toString());;


        ///////////////////MAHDI  ///////////////////
        //   Offre p1 = new Offre(162.5776f);
        //   OffreServiceImpl off= new OffreServiceImpl();
        //CRUD OFFRE
        //off.save(p1);
        //off.remove(24);
        //Offre p2= new Offre(24,(float)99.99);
        //off.update(p2);
        //System.out.println(off.findById(23));
        //   System.out.println( off.list());
        //////////////////////////////////////////////////
        //CRUD ABONNEMENT
        //  Abonnement b1=new Abonnement(13,"Standard",12,114.12f,23);
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

    }




    // public static void testAdresse() {

    // AdresseService adresseService = new AdresseServiceImpl();




    // Adresse adresse = new Adresse();

    // adresse.setId(2);

    // adresse.setLatitude(557425d);

    // adresse.setLongitude(582552d);

    // adresse.setRegion("tunis");

    // adresse.setRue("taieb mhiri");

    // adresseService.save(adresse);

    // adresseService.update(adresse);




    // adresseService.remove(2);

    // Adresse a = adresseService.findById(3);




    // System.out.println(a);

    // AdresseSearchCriteria searchCriteria = new AdresseSearchCriteria();

    // searchCriteria.setLatitude(557425d);




    // searchCriteria.setRue("taieb mhiri");




    // Collection<Adresse> result = adresseService.search(searchCriteria);

    // result.forEach(adr->System.out.println(adr));




    // adresseService.update(adresse);




    // adresseService.remove(2);

    // Adresse a = adresseService.findById(3);




    // System.out.println(a);

    // AdresseSearchCriteria searchCriteria = new AdresseSearchCriteria();

    // searchCriteria.setLatitude(557425d);




    // searchCriteria.setRue("taieb mhiri");




    // Collection<Adresse> result = adresseService.search(searchCriteria);

    // result.forEach(adr->System.out.println(adr));




    // }




    // public static void testInvitation() {

    // InvitationService inviService = new InvitationServiceImpl();




    // Invitation i = inviService.findById(6);

    // Collection<Invitation> is = inviService.list();




    // Invitation invi = new Invitation();

    // invi.setId(4);

    // invi.setReponse(Response.OUI);

    // invi.setDateInvitation(Date.valueOf("2025-12-01"));

    // invi.setDateExpiration(Date.valueOf("2023-12-01"));




    // User invite = new User();

    // invite.setId(3);

    // User invitant = new User();

    // invitant.setId(4);




    // inviService.save(invi);




    // inviService.update(invi);

    // Collection<Invitation> invitations = new ArrayList();

    // InvitationSearchCriteria invitationSearchCriteria = new

    // InvitationSearchCriteria();

    // invitationSearchCriteria.setDateInvitation(Date.valueOf("2028-12-31"));

    // invitationSearchCriteria.setReponse(Response.OUI);

    // System.out.println(invitations);




    /// invitations= inviService.search(invitationSearchCriteria);

    // System.out.println(invitations);




*/
        /////////////////////////////////////VELO//////////////////////////////////////////
        //  MyConnection conn = MyConnection.getInstance();
        //VeloServiceImpl vel = new VeloServiceImpl();
       // VeloSearchCriteria searchCriteria = new VeloSearchCriteria();

        //Velo v9= new Velo("mms","2m","noir",3);

        //System.out.println( vel.findById(1).toString()); /*find by id*/
        //vel.update(v9); /*modifier*/
        //vel.save(v9); /*ajouter*/
        //vel.remove(3); /*supp*/
        // System.out.println( vel.list().toString()); /*afficher*/

        //searchCriteria.setCouleur("vert");
       // Collection<Velo> result = vel.search(searchCriteria);
       // result.forEach(v->System.out.println(v));

/////////////////////////////////////FOURNISSEUR//////////////////////////////////////////
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

        /////////////////////////////////////EVENT//////////////////////////////////////////
       // public static void testEvent() {

           // EventServiceImpl eventService = new EventServiceImpl();




            //Collection<Event> events2 = eventService.list();

           // Event event2 = eventService.findById(29);

           // Event event1 = new Event();

            //event1.setId(27);

            //event1.setTitre("bbbb");

            //event1.setDescription("ZZZZZZZZZZZ");

            //event1.setDateDebut(Date.valueOf("2002-12-01"));

            //event1.setHeureDebut(Time.valueOf("17:00:00"));




            //event1.setDateFin(Date.valueOf("2025-12-01"));

            //event1.setHeureFin(Time.valueOf("18:15:00"));
            //eventService.save(event1);*/ajout*/

           // eventService.update(event1);/*update*/
            // eventService.remove(45);/*remove*/
            //Event a = eventService.findById(1);


           // Collection<Event> events = new ArrayList();
            //EventSearchCriteria eventSearchCriteria = new EventSearchCriteria();
             //eventSearchCriteria.setTitre("tour de hoa");

           // events = eventService.search(eventSearchCriteria);
           // System.out.println(events);


           // System.out.println(event1);
            //System.out.println( eventService.list().toString()); /*afficher*/
            /////////////////////////////////////ADRESSE//////////////////////////////////////////
            // event.setAdresse(adresse);






            // eventService.remove(45);






            //Collection<Event> events = new ArrayList();

            //EventSearchCriteria eventSearchCriteria = new EventSearchCriteria();

            // eventSearchCriteria.setTitre("tour de hoa");



            //eventService.remove(45);

//

            //  events = eventService.search(eventSearchCriteria);



            // Adresse adresse = new Adresse();

            //adresse.setId(1);










        // public static void testAdresse() {

        // AdresseService adresseService = new AdresseServiceImpl();




        // Adresse adresse = new Adresse();

        // adresse.setId(2);

        // adresse.setLatitude(557425d);

        // adresse.setLongitude(582552d);

        // adresse.setRegion("tunis");

        // adresse.setRue("taieb mhiri");

        // adresseService.save(adresse);

        // adresseService.update(adresse);




        // adresseService.remove(2);

        // Adresse a = adresseService.findById(3);




        // System.out.println(a);

        // AdresseSearchCriteria searchCriteria = new AdresseSearchCriteria();

        // searchCriteria.setLatitude(557425d);




        // searchCriteria.setRue("taieb mhiri");




        // Collection<Adresse> result = adresseService.search(searchCriteria);

        // result.forEach(adr->System.out.println(adr));




        // adresseService.update(adresse);




        // adresseService.remove(2);

        // Adresse a = adresseService.findById(3);




        // System.out.println(a);

        // AdresseSearchCriteria searchCriteria = new AdresseSearchCriteria();

        // searchCriteria.setLatitude(557425d);




        // searchCriteria.setRue("taieb mhiri");




        // Collection<Adresse> result = adresseService.search(searchCriteria);

        // result.forEach(adr->System.out.println(adr));




        // }

/////////////////////////////////////INVITATION//////////////////////////////////////////


        // public static void testInvitation() {

        // InvitationService inviService = new InvitationServiceImpl();




        // Invitation i = inviService.findById(6);

        // Collection<Invitation> is = inviService.list();




        // Invitation invi = new Invitation();

        // invi.setId(4);

        // invi.setReponse(Response.OUI);

        // invi.setDateInvitation(Date.valueOf("2025-12-01"));

        // invi.setDateExpiration(Date.valueOf("2023-12-01"));




        // User invite = new User();

        // invite.setId(3);

        // User invitant = new User();

        // invitant.setId(4);




        // inviService.save(invi);




        // inviService.update(invi);

        // Collection<Invitation> invitations = new ArrayList();

        // InvitationSearchCriteria invitationSearchCriteria = new

        // InvitationSearchCriteria();

        // invitationSearchCriteria.setDateInvitation(Date.valueOf("2028-12-31"));

        // invitationSearchCriteria.setReponse(Response.OUI);

        // System.out.println(invitations);




        /// invitations= inviService.search(invitationSearchCriteria);

        // System.out.println(invitations);



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


        ///////reclamation et maintenance

/*
        String date="2001-08-07";
        String date1="2009-09-09";
        Date dn1= Date.valueOf(LocalDate.parse(date1));
        Date dn= Date.valueOf(LocalDate.parse(date));

        Reclamation r1 = new Reclamation( 3,"reclamation1","reclamation probleme1","non declare",dn);
        ReclamationServiceImpl us = new ReclamationServiceImpl();
       // us.save(r1);
        Reclamation r2 = new Reclamation( 3,"reclamation2","reclamation probleme2","declare",dn1);
        //System.out.println( us.list().toString());
        //us.update(r2);
        //System.out.println(us.list().toString());
        //us.remove(3);
        //us.remove(38);
        System.out.println(us.list().toString());
        //System.out.println(us.findById(43));
*/



        /*Maintenance m1 = new Maintenance( 1,"maintenance1","en cours",dn,44);
        MaintenanceServiceImpl us1 = new MaintenanceServiceImpl();
       us1.save(m1);
        Maintenance m2 = new Maintenance( 2,"maintenance2","resolu",dn1,45);
        System.out.println(us1.list().toString());
        us1.update(m2);
        System.out.println(us1.list().toString());
        //us.remove(11);
        //System.out.println(us.findById());

*/

        //CRUD STATION//
        //CREATE
       // Station s10 = new Station("GHAZELLA", 8.5, 8.6);
       // Station s3 = new Station(7," TUNIS-BebAlioua " , 8.3 , 8.7 );
       // StationServiceImpl sta =  new StationServiceImpl() ;
     //   sta.save(s10);

        //READ
//        System.out.println(sta.list())  ;

        //DELETE
        //sta.remove(10);
/*
        //SEARCH
        StationSearchCriteria sc = new StationSearchCriteria() ;
        System.out.println(sta.search(sc).toString()) ;
        //sc.setNom_station("ARIANA");
        Collection<Station> result = sta.search(sc);
        result.forEach(nom->System.out.println(nom));*/

        //UPDATE
        //sta.update(s3);
        //System.out.println(sta.list()) ;


        //CRUD RACKVELO
        //CREATE
    //    RackVelo rv2 = new RackVelo(111,50,7);
      //  RackVeloImpl rackv =  new RackVeloImpl() ;
//        rackv.save(rv2);

        //READ
        //System.out.println(rackv.list()) ;

        //UPDATE
        //rackv.update(rv2);
        //System.out.println(rackv.list()) ;

        //DELETE
        //rackv.remove(1) ;



}

    
}
