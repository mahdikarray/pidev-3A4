package com.esprit.veltun.model;

import com.esprit.veltun.model.base.BaseEntity;

import java.sql.Date;
import java.sql.Time;

public class Event extends BaseEntity {
	private String titre;
	private String description;
	private Date dateDebut;
	private Time heureDebut;
	private Date dateFin;
	private Time heureFin;
	private String adresse;


	public Event() {
	}

	public Event(String titre, String description, Date dateDebut, Time heureDebut, Date dateFin, Time heureFin,
			String adresse) {
		super();
		this.titre = titre;
		this.description = description;
		this.dateDebut = dateDebut;
		this.heureDebut = heureDebut;
		this.dateFin = dateFin;
		this.heureFin = heureFin;
		this.adresse = adresse;

	}





	public Event(Integer id, String titre, String description, Date dateDebut, Time heureDebut, Date dateFin,
			Time heureFin,String adresse) {
		super(id);
		this.titre = titre;
		this.description = description;
		this.dateDebut = dateDebut;
		this.heureDebut = heureDebut;
		this.dateFin = dateFin;
		this.heureFin = heureFin;
		this.adresse = adresse;


	}

	public Time getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(Time heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Time getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Time heureFin) {
		this.heureFin = heureFin;
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
		return "Event [id=" + getId() + ", Titre=" + this.titre + ", description=" + description + ", dateDebut="
				+ dateDebut + ", dateFin=" + dateFin + ", adresse=" + adresse + "]";
	}

	public int getPriority() {
		return 1;
	}
}
