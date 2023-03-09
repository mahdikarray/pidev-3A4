package com.esprit.veltun.model;

import java.sql.Date;
import com.esprit.veltun.model.base.BaseEntity;

public class Maintenance extends BaseEntity {
    private int id_demande;
    private String description;
    private String status;
    private Date submission_date;
    private int rating ;


    private int id_reclamation;

    public Maintenance() {
    }
    public Maintenance(String description, String status,Date submission_date,int rating) {
        this.description = description;
        this.status = status;
        this.submission_date = submission_date;
        this.rating =rating;
    }
    public Maintenance(String description, String status,Date submission_date) {
        this.description = description;
        this.status = status;
        this.submission_date = submission_date;
    }

    public Maintenance(int id_demande ,String description, String status,Date submission_date,int id_reclamation) {
        this.id_demande = id_demande;
        this.description = description;
        this.status = status;
        this.submission_date = submission_date;
        this.id_reclamation= id_reclamation;
    }

    public int getId_demande() {
        return id_demande;
    }

    public void setId_demande(int id_demande) {
        this.id_demande = id_demande;
    }
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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

    @Override
    public String toString() {
        return "maintenance [ id_demande=" + id_demande + ", description=" + description
                + ", status=" + status + ", submission_date=" + submission_date + ",  id_reclamation=" + id_reclamation + ", rating=" + rating +"]";
    }


}