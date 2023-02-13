package com.esprit.veltun.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.esprit.veltun.model.base.BaseEntity;

public class Event extends BaseEntity {
	private String titre;
	private String description;
	private Date dateDebut;
	private Date dateFin;
	private Adresse adresse;
	private List<Adresse> adresses = new ArrayList<>();
	private List<Invitation> invitations = new ArrayList<>();

	public Event() {
	}

	public Event(Integer id, String Titre, String description, Date dateDébut, Date dateFin, Adresse adresse) {
		this.setId(id);
		;
		this.titre = Titre;
		this.description = description;
		this.dateDebut = dateDébut;
		this.dateFin = dateFin;
		this.adresse = adresse;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre  = titre;
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

	public void setDateDébut(Date dateDebut) {
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

	public List<Invitation> getInvitations() {
		return invitations;
	}

	public void setInvitations(List<Invitation> invitations) {
		this.invitations = invitations;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	@Override
	public String toString() {
		return "Event [id=" + getId() + ", Titre=" + this.titre + ", description=" + description + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", adresse=" + adresse + "]";
	}

}
