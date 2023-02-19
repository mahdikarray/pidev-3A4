//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.veltun.search.dto;

import com.esprit.veltun.model.Velo;
import com.esprit.veltun.search.base.dto.SearchCriteria;

public class VeloSearchCriteria extends SearchCriteria<Velo> {
    private String libellev;
    private String taillev;
    private String couleurv;
    private int idf;

    public VeloSearchCriteria() {
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
