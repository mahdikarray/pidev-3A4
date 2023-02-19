

package com.esprit.veltun.model;

import com.esprit.veltun.model.base.BaseEntity;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Event extends BaseEntity {
    private String titre;
    private String description;
    private Date dateDebut;
    private Time heureDebut;
    private Date dateFin;
    private Time heureFin;
    private Adresse adresse;
    private List<Adresse> adresses = new ArrayList();
    private List<Invitation> invitations = new ArrayList();

    public Event() {
    }

    public Event(String titre, String description, Date dateDebut, Time heureDebut, Date dateFin, Time heureFin, Adresse adresse, List<Adresse> adresses) {
        this.titre = titre;
        this.description = description;
        this.dateDebut = dateDebut;
        this.heureDebut = heureDebut;
        this.dateFin = dateFin;
        this.heureFin = heureFin;
        this.adresse = adresse;
        this.adresses = adresses;
    }

    public Event(String titre, String description, Date dateDebut, Time heureDebut, Date dateFin, Time heureFin, Adresse adresse, List<Adresse> adresses, List<Invitation> invitations) {
        this.titre = titre;
        this.description = description;
        this.dateDebut = dateDebut;
        this.heureDebut = heureDebut;
        this.dateFin = dateFin;
        this.heureFin = heureFin;
        this.adresse = adresse;
        this.adresses = adresses;
        this.invitations = invitations;
    }

    public Event(Integer id, String titre, String description, Date dateDebut, Time heureDebut, Date dateFin, Time heureFin, Adresse adresse, List<Adresse> adresses) {
        super(id);
        this.titre = titre;
        this.description = description;
        this.dateDebut = dateDebut;
        this.heureDebut = heureDebut;
        this.dateFin = dateFin;
        this.heureFin = heureFin;
        this.adresse = adresse;
        this.adresses = adresses;
    }

    public Event(Integer id, String titre, String description, Date dateDebut, Time heureDebut, Date dateFin, Time heureFin, Adresse adresse, List<Adresse> adresses, List<Invitation> invitations) {
        super(id);
        this.titre = titre;
        this.description = description;
        this.dateDebut = dateDebut;
        this.heureDebut = heureDebut;
        this.dateFin = dateFin;
        this.heureFin = heureFin;
        this.adresse = adresse;
        this.adresses = adresses;
        this.invitations = invitations;
    }

    public Time getHeureDebut() {
        return this.heureDebut;
    }

    public void setHeureDebut(Time heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Time getHeureFin() {
        return this.heureFin;
    }

    public void setHeureFin(Time heureFin) {
        this.heureFin = heureFin;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return this.dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return this.dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Adresse getAdresse() {
        return this.adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<Invitation> getInvitations() {
        return this.invitations;
    }

    public void setInvitations(List<Invitation> invitations) {
        this.invitations = invitations;
    }

    public List<Adresse> getAdresses() {
        return this.adresses;
    }

    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
    }

    public String toString() {
        return "Event [id=" + this.getId() + ", Titre=" + this.titre + ", description=" + this.description + ", dateDebut=" + this.dateDebut + ", dateFin=" + this.dateFin + ", adresse=" + this.adresse + "]";
    }
}
