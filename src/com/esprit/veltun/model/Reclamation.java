package com.esprit.veltun.model;

import java.sql.Date;
import com.esprit.veltun.model.base.BaseEntity;

public class Reclamation extends BaseEntity {
    private int id_reclamation;
    private String objet;
    private String description;
    private String etat;
    private Date date_reclamation;



    public Reclamation() {
    }

    public Reclamation(int id_reclamation, String objet, String description, String etat,Date date_reclamation) {

        this.id_reclamation = id_reclamation;
        this.objet = objet;
        this.description = description;
        this.etat = etat;
        this.date_reclamation = date_reclamation;
    }



    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }


    public Date getDate_reclamation() {
        return date_reclamation;
    }

    public void setDate_reclamation(Date date_reclamation) {
        this.date_reclamation = date_reclamation;
    }

    @Override
    public String toString() {
        return "reclamation [  id_reclamation=" + id_reclamation + ", objet=" + objet
                + ", description=" + description + ", etat=" + etat + ",date_reclamation=" + date_reclamation +"]";
    }

}


