
package com.esprit.veltun.model;

import com.esprit.veltun.model.base.BaseEntity;

public class Velo extends BaseEntity {
    private int idf;
    private String libellev;
    private String taillev;
    private String couleurv;

    public Velo() {
    }

    public Velo(Integer id, String libellev, String taillev, String couleurv, Integer idf) {
        this.setId(id);
        this.libellev = libellev;
        this.taillev = taillev;
        this.couleurv = couleurv;
        this.idf = idf;
    }

    public Velo(String libellev, String taillev, String couleurv, Integer idf) {
        this.libellev = libellev;
        this.taillev = taillev;
        this.couleurv = couleurv;
        this.idf = idf;
    }

    public String getLibelle() {
        return this.libellev;
    }

    public void setLibelle(String libellev) {
        this.libellev = libellev;
    }

    public String getTaille() {
        return this.taillev;
    }

    public void setTaille(String taillev) {
        this.taillev = taillev;
    }

    public String getCouleur() {
        return this.couleurv;
    }

    public void setCouleur(String couleurv) {
        this.couleurv = couleurv;
    }

    public Integer getIdf() {
        return this.idf;
    }

    public void setIdf(Integer idf) {
        this.idf = idf;
    }

    public String toString() {
        return "Velo{**id=" + this.getId() + ", **ibelle=" + this.libellev + ", **taille=" + this.taillev + ", **couleur=" + this.couleurv + ", **idf=" + this.idf + '}';
    }
}
