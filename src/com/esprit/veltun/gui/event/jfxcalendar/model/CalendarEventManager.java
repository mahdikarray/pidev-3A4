package com.esprit.veltun.gui.event.jfxcalendar.model;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

import com.esprit.veltun.model.Event;
import com.esprit.veltun.search.dto.EventSearchCriteria;
import com.esprit.veltun.services.EventService;
import com.esprit.veltun.services.impl.EventServiceImpl;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.control.Alert;
import org.controlsfx.control.Notifications;

public class CalendarEventManager {
	private static List<Reminder> reminders = new ArrayList<>();
	private static Set<Integer> shown = new HashSet<>();

	static {

		Task<Void> task = new Task<Void>() {
			boolean ruuning = false;

			public boolean isRuuning() {
				return ruuning;
			}

			public void setRuuning(boolean ruuning) {
				this.ruuning = ruuning;
			}

			@Override
			protected Void call() throws Exception {
				while (true) {

					try {
						Thread.sleep(10000);
						if (!isRuuning()) {
							setRuuning(true);
							Reminder reminder = CalendarEventManager.reminders.stream().filter(rem->{
								boolean inProgress = rem.getDateTime().isAfter(LocalDate.now().atStartOfDay()) &&
										rem.getDateTime().isBefore(LocalDate.now().atTime(23,59,59));
								return !CalendarEventManager.shown.contains(rem.getEventId()) && inProgress;
							}).findFirst().orElse(null);
							if (reminder != null) {
								Platform.runLater(new Runnable() {
									@Override
									public void run() {
										CalendarEventManager.shown.add(reminder.getEventId());
										Alert alert = new Alert(Alert.AlertType.WARNING);
										alert.setTitle("You have an event today!");
										alert.setHeaderText(reminder.getTitle());
										alert.setContentText(reminder.getDescription());
										alert.showAndWait();
										setRuuning(false);
									}
								});
							} else {
								setRuuning(false);
							}
						}
						if (!isRuuning()) {
							setRuuning(true);
							Reminder reminder2 = CalendarEventManager.reminders.stream().filter(rem->{
								boolean inProgress = rem.getDateTime().isAfter(LocalDate.now().plusDays(1).atStartOfDay()) &&
										rem.getDateTime().isBefore(LocalDate.now().plusDays(1).atTime(23,59,59));
								return !CalendarEventManager.shown.contains(rem.getEventId()) && inProgress;
							}).findFirst().orElse(null);
							if (reminder2 != null) {
								Platform.runLater(new Runnable() {
									@Override
									public void run() {
										CalendarEventManager.shown.add(reminder2.getEventId());
										Alert alert = new Alert(Alert.AlertType.INFORMATION);
										alert.setTitle("You have an event tomorrow!");
										alert.setHeaderText(reminder2.getTitle());
										alert.setContentText(reminder2.getDescription());
										alert.showAndWait();
										setRuuning(false);
									}
								});
							} else {
								setRuuning(false);
							}
						}
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}
		};
		new Thread(task).start();
	}
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
		reminders.addAll(events.stream().map(e -> new Reminder(e.getId(), e.getTitre(),e.getDateDebut().toLocalDate().atStartOfDay().plusSeconds(1),
				e.getDescription())).collect(Collectors.toList()));
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
	public void addReminder(Reminder reminder) {
		reminders.add(reminder);
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