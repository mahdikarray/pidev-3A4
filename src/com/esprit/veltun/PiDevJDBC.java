/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.veltun;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

import com.esprit.veltun.model.Event;
import com.esprit.veltun.search.dto.EventSearchCriteria;
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
		/////EVENT//////



		Event e = new Event();
        EventService eventservice =   EventServiceImpl.getInstance();
        // System.out.println(eventservice.findById(50));
        //EventSearchCriteria searchCriteria = new EventSearchCriteria();
		// searchCriteria.setTitre("zzzz");
		//Collection<Event> result = eventservice.search(searchCriteria);

		//result.forEach(f->System.out.println(f));

       // event1.setId(50);

        e.setTitre("tour de  nnn");

		e.setDescription("la dd est ...");
		e.setDateDebut(Date.valueOf("2001-12-01"));
		e.setHeureDebut(Time.valueOf("17:00:00"));




		e.setDateFin(Date.valueOf("2026-12-01"));

		e.setHeureFin(Time.valueOf("18:15:00"));

		e.setAdresse("la dd est ...");





		eventservice.save(e);
		System.out.println(e);
		//eventservice.update(event1);
		//eventService.remove(45);

        //Event a = eventservice.findById(50);












	}}




