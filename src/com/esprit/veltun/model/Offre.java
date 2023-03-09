package com.esprit.veltun.model;

import com.esprit.veltun.model.base.BaseEntity;

public class Offre extends BaseEntity {
    private int Id_offre;
   // private float Prix;

    public String getDescription_of(String descriptionOf) {
        return description_of;
    }
    public String getDescription_of() {
        return description_of;
    }
    public void setDescription_of(String description_of) {
        this.description_of = description_of;
    }

    private String description_of;

    public Offre(int i) {
        this.Id_offre = this.Id_offre;
    }

    public Offre() {
    }


    public Offre(int Id_offre, String description_of) {
        this.Id_offre = Id_offre;
      //  this.Prix = Prix;
        this.description_of = description_of;
    }

   /* public Offre(float prix)
    {
        this.Prix=prix;
    }*/

    public int getId_offre() {
        return this.Id_offre;
    }

    public void setId_offre(int Id_offre) {
        this.Id_offre = Id_offre;
    }

   /* public float getPrix() {
        return this.Prix;
    }*/

   /* public void setPrix(float Prix) {
        this.Prix = Prix;
    }*/

    public String toString() {
        return "offre{Id_offre=" + this.Id_offre + ", description_of=" + this.description_of + '}';
    }
}
