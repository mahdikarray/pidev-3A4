package com.esprit.veltun.gui.event.jfxcalendar.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.esprit.veltun.model.Event;
import com.esprit.veltun.search.dto.EventSearchCriteria;
import com.esprit.veltun.services.EventService;
import com.esprit.veltun.services.impl.EventServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CalendarEventManager {

	EventService eventService = EventServiceImpl.getInstance();

	public void reloadEvents() {
		reloadEvents(null);
	}
	private void reloadEvents(LocalDate date) {

		EventSearchCriteria eventSearchCriteria = new EventSearchCriteria();
		if (date != null) {
			eventSearchCriteria.setDateDebut(Date.valueOf(date));
		}
		Collection<Event> events = eventService.search(eventSearchCriteria);

		List<CalendarEvent> calendarEvents = events.stream().map(event -> {
			CalendarEvent calendarEvent = new CalendarEvent(event.getTitre(), event.getPriority(),event.getDescription());
			calendarEvent.setId(event.getId());
			calendarEvent.setType(CalendarEvent.ONE_TIME_EVENT);
			calendarEvent.setDate(event.getDateDebut().toLocalDate());
			return calendarEvent;
		}).collect(Collectors.toList());
		eventList.setAll(calendarEvents);
	}

	private final ObservableList<CalendarEvent> eventList;

	public CalendarEventManager() {
		eventList = FXCollections.observableArrayList();
		reloadEvents();
	}

	public void addEvent(CalendarEvent event) {
		Event event1 = new Event(event.getTitle(), event.getDescription(), Date.valueOf(event.getDate()), null, null, null,null);
		eventService.save(event1);
		reloadEvents();
	}

	public void removeEvent(CalendarEvent event) {
		eventService.remove(event.getId());
		reloadEvents();
	}

	public ObservableList<CalendarEvent> getEventsOn(LocalDate localDate) {

		ObservableList<CalendarEvent> currentEventList = FXCollections
				.observableArrayList();
		reloadEvents();
		for (CalendarEvent event : eventList) {
			if (event.isOnDate(localDate)) {
				currentEventList.add(event);
			}
		}

		return currentEventList;
	}
}