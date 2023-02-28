package com.esprit.veltun.search.dto;

import com.esprit.veltun.model.Reclamation;
import com.esprit.veltun.search.base.dto.SearchCriteria;

import java.sql.Date;

public class ReclamationSearchCriteria extends SearchCriteria<Reclamation> {
    private int id_reclamation;
    private String objet;
    private String description;
    private String type;
    private Date date_reclamation;

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
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Date getDate_reclamation() {
        return date_reclamation;
    }

    public void setDate_reclamation(Date date_reclamation) {
        this.date_reclamation = date_reclamation;
    }



}
