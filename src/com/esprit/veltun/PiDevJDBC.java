/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.veltun;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;

import com.esprit.veltun.model.Event;
import com.esprit.veltun.services.EventService;
import com.esprit.veltun.services.impl.EventServiceImpl;
import com.esprit.veltun.util.MyConnection;

/**
 *
 * @author Asus
 */
public class PiDevJDBC {

	
	public static void main(String[] args) {
		Connection conn = MyConnection.getInstance();

		testEvent();
		// testInvitation();

	}

	public static void testEvent() {
		EventService eventService = EventServiceImpl.getInstance();

		Event event1 = new Event();
		//event1.setId(45);
		event1.setTitre("tour de hoa nnn");
		event1.setDescription("la dd est ...");
		event1.setDateDebut(Date.valueOf("2001-12-01"));
		event1.setHeureDebut(Time.valueOf("17:00:00"));

		event1.setDateFin(Date.valueOf("2026-12-01"));
		event1.setHeureFin(Time.valueOf("18:15:00"));
		// Adresse adresse = new Adresse();
		//adresse.setId(1);
		// event.setAdresse(adresse);
		 eventService.save(event1);
		 //eventService.update(event1);
		 //Event a = eventService.findById(44);
	    //eventService.remove(45);

		 
		//Collection<Event> events = new ArrayList();
		//EventSearchCriteria eventSearchCriteria = new EventSearchCriteria();
		// eventSearchCriteria.setTitre("tour de hoa");
		
    	//eventService.remove(45);
//
        //  events = eventService.search(eventSearchCriteria);
    	System.out.println(event1);
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
}
// inviService.update(invi);
