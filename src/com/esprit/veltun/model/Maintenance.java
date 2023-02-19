package com.esprit.veltun.model;

import java.sql.Date;
import com.esprit.veltun.model.base.BaseEntity;

public class Maintenance extends BaseEntity {
    private int id_demande;
    private String description;
    private String etat;
    private Date date_soumission;

    private int id_reclamation;

    public Maintenance() {
    }

    public Maintenance(int id_demande ,String description, String etat,Date date_soumission,int id_reclamation) {
        this.id_demande = id_demande;
        this.description = description;
        this.etat = etat;
        this.date_soumission = date_soumission;
        this.id_reclamation= id_reclamation;
    }

    public int getId_demande() {
        return id_demande;
    }

    public void setId_demande(int id_demande) {
        this.id_demande = id_demande;
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
    public Date getDate_soumission() {
        return date_soumission;
    }

    public void setDate_soumission(Date date_soumission) {
        this.date_soumission = date_soumission;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    @Override
    public String toString() {
        return "maintenance [ id_demande=" + id_demande + ", description=" + description
                + ", etat=" + etat + ", date_soumission=" + date_soumission + ",  id_reclamation=" + id_reclamation + "]";
    }


}