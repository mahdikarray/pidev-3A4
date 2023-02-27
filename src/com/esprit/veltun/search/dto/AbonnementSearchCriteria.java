

package com.esprit.veltun.search.dto;

import com.esprit.veltun.model.Abonnement;
import com.esprit.veltun.search.base.dto.SearchCriteria;

public class AbonnementSearchCriteria extends SearchCriteria<Abonnement> {
    private int Id_ab;
    private float Prix_ab;
    private String Type_ab;
    private int Id_offre;
    private String Duree;



    private String CIN;

    public AbonnementSearchCriteria() {
    }
    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }
    public String getDuree() {
        return this.Duree;
    }

    public void setDuree(String Duree) {
        this.Duree = Duree;
    }

    public String getType_ab() {
        return this.Type_ab;
    }

    public void setType_ab(String Type_ab) {
        this.Type_ab = Type_ab;
    }

    public int getId_offre() {
        return this.Id_offre;
    }

    public void setId_offre(int Id_offre) {
        this.Id_offre = Id_offre;
    }

    public int getId_ab() {
        return this.Id_ab;
    }

    public void setId_ab(int Id_ab) {
        this.Id_ab = Id_ab;
    }

    public float getPrix_ab() {
        return this.Prix_ab;
    }

    public void setPrix_ab(float Prix_ab) {
        this.Prix_ab = Prix_ab;
    }

    public String toString() {
        return "abonnement{Type_ab=" + this.Type_ab + ", Duree=" + this.Duree + ", Prix_ab=" + this.Prix_ab +", id_offre=" + this.getId_offre() +", CIN=" + this.CIN + '}';
    }
}
