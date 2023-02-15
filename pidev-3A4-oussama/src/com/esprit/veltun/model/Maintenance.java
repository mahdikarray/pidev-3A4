package com.esprit.veltun.model;

import java.sql.Date;
import com.esprit.veltun.model.base.BaseEntity;

public class Maintenance extends BaseEntity {
    private int id_demande;
    private String description;
    private String etat;
    private Date date_soumission;



    public Maintenance() {
    }

    public Maintenance(Integer id,int id_demande ,String description, String etat,Date date_soumission) {
        this.setId(id);
        this.id_demande = id_demande;
        this.description = description;
        this.etat = etat;
        this.date_soumission = date_soumission;
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

    @Override
    public String toString() {
        return "Event [id=" + getId() + ",  id_demande=" + id_demande + ", description=" + description
                + ", etat=" + etat + ", date_soumission=" + date_soumission + "]";
    }

}