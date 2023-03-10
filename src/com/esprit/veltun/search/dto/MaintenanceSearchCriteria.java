package com.esprit.veltun.search.dto;

import com.esprit.veltun.model.Maintenance;
import com.esprit.veltun.search.base.dto.SearchCriteria;

import java.sql.Date;


public class MaintenanceSearchCriteria extends SearchCriteria<Maintenance> {
    private int id_demande;
    private String description;
    private String status;
    private Date submission_date;

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
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Date getSubmission_date() {
        return submission_date;
    }

    public void setSubmission_date(Date submission_date) {
        this.submission_date = submission_date;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

}
