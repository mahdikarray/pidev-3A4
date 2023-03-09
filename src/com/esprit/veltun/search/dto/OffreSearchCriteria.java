//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.veltun.search.dto;

import com.esprit.veltun.model.Offre;
import com.esprit.veltun.search.base.dto.SearchCriteria;

public class OffreSearchCriteria extends SearchCriteria<Offre> {
    private int Id_offre;
    private float Prix;

    public String getDescription_of() {
        return description_of;
    }

    public void setDescription_of(String description_of) {
        this.description_of = description_of;
    }

    private String description_of;

    public OffreSearchCriteria() {
    }

    public int getId_offre() {
        return this.Id_offre;
    }

    public void setId_offre(int Id_offre) {
        this.Id_offre = Id_offre;
    }

    public float getPrix() {
        return this.Prix;
    }

    public void setPrix(float Prix) {
        this.Prix = Prix;
    }

    public String toString() {
        return "offre{Id_offre=" + this.Id_offre + ", Prix=" + this.Prix +", description_of=" + this.description_of + '}';
    }
}
