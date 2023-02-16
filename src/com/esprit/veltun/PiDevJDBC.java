/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.veltun;

import com.esprit.veltun.enums.Response;
import com.esprit.veltun.model.Adresse;
import com.esprit.veltun.model.Event;
import com.esprit.veltun.model.Invitation;
import com.esprit.veltun.model.User;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.AdresseSearchCriteria;
import com.esprit.veltun.search.dto.EventSearchCriteria;
import com.esprit.veltun.search.dto.InvitationSearchCriteria;
import com.esprit.veltun.util.MyConnection;
import com.esprit.veltun.services.AdresseService;
import com.esprit.veltun.services.EventService;
import com.esprit.veltun.services.InvitationService;
import com.esprit.veltun.services.impl.AdresseServiceImpl;
import com.esprit.veltun.services.impl.EventServiceImpl;
import com.esprit.veltun.services.impl.InvitationServiceImpl;
import com.esprit.veltun.services.impl.UserServiceImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        Connection conn= MyConnection.getInstance();
        String date="2001-08-07";
        Date dn= Date.valueOf(LocalDate.parse(date));
        // MyConnection conn = MyConnection.getInstance();
       // User u1 = new User("88","Rezigui","Alaa",dn, "Admin",1000,"alaa.rezigui@esprit.tn");
        UserServiceImpl us = new UserServiceImpl();

        //us.save(u1);


        System.out.println( us.list().toString());
        User u2 = new User("800","Rezigui","Alaa",dn,"Admin",30,"alaa.rezigui@esprit.tn");
        us.update(u2);
        //System.out.println(us.list().toString());
        //us.remove(u1.getCIN());
        //System.out.println(us.list().toString());

        //testEvent();
        testInvitation();
        
        
        
        
        
        
        
    }
    
    
    
    
    public static void testEvent() {
    	EventService eventService = new EventServiceImpl();
    	
    	Collection<Event> events1 = eventService.list();
    	Event event1 = eventService.findById(29);
    	Event event = new Event();
    	event.setTitre("tour de sud");
    	event.setDescription("la sud de tunisie est djghhhhh");
    	event.setDateDebut(Date.valueOf("2022-12-01"));
    	event.setHeureDebut(Time.valueOf("16:00:00"));
    	
    	event.setDateFin(Date.valueOf("2022-12-01"));
    	event.setHeureFin(Time.valueOf("17:15:00"));
    	Adresse adresse = new Adresse();
    	adresse.setId(3);
    	event.setAdresse(adresse);
    	eventService.save(event);
    	Collection<Event> events = new ArrayList();
    	EventSearchCriteria eventSearchCriteria = new EventSearchCriteria();
    	//eventSearchCriteria.setTitre("ok");
    	//eventSearchCriteria.setDescription("ok");

    	eventSearchCriteria.setId(4);
    	events = eventService.search(eventSearchCriteria);
    	System.out.println(events);
    	
//    	eventService.remove(3);
//
//    	events = eventService.search(eventSearchCriteria);
//    	System.out.println(events);
    }
    
    public static void testAdresse() {
    	//AdresseService adresseService = new AdresseServiceImpl();
    	
    	//Adresse adresse = new Adresse();
    	//adresse.setId(2);
    	//adresse.setLatitude(557425d);
    	//adresse.setLongitude(582552d);
    	//adresse.setRegion("tunis");
    	//adresse.setRue("taieb mhiri");
    	//adresseService.save(adresse);
    	//adresseService.update(adresse);    	
    	
    	//adresseService.remove(2);
    	//Adresse a = adresseService.findById(3);

    	//System.out.println(a);
    	//AdresseSearchCriteria searchCriteria = new AdresseSearchCriteria(); 
    	//searchCriteria.setLatitude(557425d);
    	
    //	searchCriteria.setRue("taieb mhiri");
    	
    	//Collection<Adresse> result = adresseService.search(searchCriteria);
    //	result.forEach(adr->System.out.println(adr));


    	//adresseService.update(adresse);    	
    	
    	//adresseService.remove(2);
    	//Adresse a = adresseService.findById(3);

    	//System.out.println(a);
    	//AdresseSearchCriteria searchCriteria = new AdresseSearchCriteria(); 
    	//searchCriteria.setLatitude(557425d);
    	
    	//searchCriteria.setRue("taieb mhiri");
    	
    	//Collection<Adresse> result = adresseService.search(searchCriteria);
    //	result.forEach(adr->System.out.println(adr));
    	
    }
    
    
    
    public static void testInvitation() {
    	InvitationService inviService = new InvitationServiceImpl();
    	
    	Invitation i = inviService.findById(6);
    	Collection<Invitation> is = inviService.list();
    	
    	Invitation invi = new Invitation();
    	invi.setId(4);
    	invi.setReponse(Response.OUI);
    	invi.setDateInvitation(Date.valueOf("2025-12-01"));
    	invi.setDateExpiration(Date.valueOf("2023-12-01"));
    	
    	//User invite = new User();
    //	invite.setId(3);
    	//User invitant = new User();
    	//invitant.setId(4);
      
    	//inviService.save(invi);

        inviService.update(invi); 
    	Collection<Invitation> invitations = new ArrayList();
    	InvitationSearchCriteria invitationSearchCriteria = new InvitationSearchCriteria();
    	//invitationSearchCriteria.setDateInvitation(Date.valueOf("2028-12-31"));
    	invitationSearchCriteria.setReponse(Response.OUI);
    	System.out.println(invitations);
    	
    	invitations= inviService.search(invitationSearchCriteria);
    	System.out.println(invitations);
    }
    //    inviService.update(invi); 
    
    
}
