package com.esprit.veltun.gui.event.jfxcalendar.model;


import java.time.Duration;
import java.time.LocalDateTime;

public class Reminder {
    private Integer eventId;
    private String title;
    private LocalDateTime dateTime;
    private String description;

    public Reminder(Integer eventId, String title, LocalDateTime dateTime, String description) {
        this.eventId = eventId;
        this.title = title;
        this.dateTime = dateTime;
        this.description = description;
    }

    public Reminder(Duration ofMinutes, String s) {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "title='" + title + '\'' +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }
}


