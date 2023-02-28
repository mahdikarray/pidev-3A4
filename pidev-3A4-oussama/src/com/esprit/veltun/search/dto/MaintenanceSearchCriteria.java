package com.esprit.veltun.search.dto;

import com.esprit.veltun.model.Maintenance;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.esprit.veltun.model.Reclamation;



public class MaintenanceSearchCriteria extends SearchCriteria<Maintenance> {
    private int id_demande;
    private String description;
    private String etat;
    private Date date_soumission;

    private int id_reclamation;

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

}
