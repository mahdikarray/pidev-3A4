

package com.esprit.veltun.model;

import com.esprit.veltun.model.base.BaseEntity;

public class Fournisseur extends BaseEntity {
    private String nomf;
    private String regionf;

    public Fournisseur() {
    }

    public Fournisseur(Integer idf, String nomf, String regionf) {
        this.setId(idf);
        this.nomf = nomf;
        this.regionf = regionf;
    }

    public Fournisseur(String nomf, String regionf) {
        this.nomf = nomf;
        this.regionf = regionf;
    }

    public String getNom() {
        return this.nomf;
    }

    public void setNom(String nomf) {
        this.nomf = nomf;
    }

    public String getRegion() {
        return this.regionf;
    }

    public void setRegion(String regionf) {
        this.regionf = regionf;
    }

    public String toString() {
        return "Fournisseur{idf=" + this.getId() + ", nomf=" + this.nomf + ", regionf=" + this.regionf + '}';
    }
}
