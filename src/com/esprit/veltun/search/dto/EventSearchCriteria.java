package com.esprit.veltun.search.dto;

import java.sql.Date;

import com.esprit.veltun.model.Event;
import com.esprit.veltun.search.base.dto.SearchCriteria;

public class EventSearchCriteria extends SearchCriteria<Event> {
	private String titre;
	private String description;
	private Date dateDebut;
	private Date dateFin;
	private String adresse;

	public EventSearchCriteria() {
		super();
	}
	
	public EventSearchCriteria(String titre, String description, Date dateDebut, Date dateFin, String adresse) {
		super();
		this.titre = titre;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.adresse = adresse;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "EventSearchCriteria [titre=" + titre + ", description=" + description + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", adresse=" + adresse + "]";
	}

}
