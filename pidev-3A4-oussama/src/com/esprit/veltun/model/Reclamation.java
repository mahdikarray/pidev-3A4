package com.esprit.veltun.model;

import java.sql.Date;
import com.esprit.veltun.model.base.BaseEntity;

public class Reclamation extends BaseEntity {
    private int id_reclamation;
    private String object;
    private String description;
    private String status;
    private Date date_reclamation;

    private int rating ;


    public Reclamation() {
    }

    public Reclamation(String object, String description, String status,Date date_reclamation) {
        this.object = object;
        this.description = description;
        this.status = status;
        this.date_reclamation = date_reclamation;
    }

    public Reclamation(int id_reclamation, String object, String description, String status,Date date_reclamation) {

        this.id_reclamation = id_reclamation;
        this.object = object;
        this.description = description;
        this.status = status;
        this.date_reclamation = date_reclamation;
    }



    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }


    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
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


    public Date getDate_reclamation() {
        return date_reclamation;
    }

    public void setDate_reclamation(Date date_reclamation) {
        this.date_reclamation = date_reclamation;
    }

    @Override
    public String toString() {
        return "reclamation [  id_reclamation=" + id_reclamation + ", object=" + object
                + ", description=" + description + ", status=" + status + ",date_reclamation=" + date_reclamation +"]";
    }

}


