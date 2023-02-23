//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.veltun.search.dto;

import com.esprit.veltun.model.Adresse;
import com.esprit.veltun.model.Event;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import java.sql.Date;

public class EventSearchCriteria extends SearchCriteria<Event> {
    private String titre;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private Adresse adresse;

    public EventSearchCriteria() {
    }

    public EventSearchCriteria(String titre, String description, Date dateDebut, Date dateFin, Adresse adresse) {
        this.titre = titre;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.adresse = adresse;
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

    public String toString() {
        return "EventSearchCriteria [titre=" + this.titre + ", description=" + this.description + ", dateDebut=" + this.dateDebut + ", dateFin=" + this.dateFin + ", adresse=" + this.adresse + "]";
    }
}
