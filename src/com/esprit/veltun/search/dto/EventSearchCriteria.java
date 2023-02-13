package com.esprit.veltun.search.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.esprit.veltun.model.Adresse;
import com.esprit.veltun.model.Event;
import com.esprit.veltun.model.Invitation;
import com.esprit.veltun.search.base.dto.SearchCriteria;

public class EventSearchCriteria extends SearchCriteria<Event> {
	private String titre;
	private String description;
	private Date dateDebut;
	private Date dateFin;
	private Adresse adresse;
	private List<Adresse> adresses = new ArrayList<>();
	private List<Invitation> invitations = new ArrayList<>();
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
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public List<Adresse> getAdresses() {
		return adresses;
	}
	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}
	public List<Invitation> getInvitations() {
		return invitations;
	}
	public void setInvitations(List<Invitation> invitations) {
		this.invitations = invitations;
	}
	@Override
	public String toString() {
		return "EventSearchCriteria [titre=" + titre + ", description=" + description + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", adresse=" + adresse + ", adresses=" + adresses + ", invitations="
				+ invitations + "]";
	}


	
	
	
}
