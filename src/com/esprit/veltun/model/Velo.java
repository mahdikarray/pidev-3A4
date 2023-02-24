
package com.esprit.veltun.model;

import com.esprit.veltun.model.base.BaseEntity;

public class Velo extends BaseEntity {
    private Fournisseur fournisseur;
    private String libellev;
    private String taillev;
    private String couleurv;

    public Velo() {
    }

    public Velo(Integer id, String libellev, String taillev, String couleurv, Fournisseur f) {
        this.setId(id);
        this.libellev = libellev;
        this.taillev = taillev;
        this.couleurv = couleurv;
        this.fournisseur = f;
    }

    public Velo(String libellev, String taillev, String couleurv, Fournisseur f) {
        this.libellev = libellev;
        this.taillev = taillev;
        this.couleurv = couleurv;
        this.fournisseur = f;
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

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public void setLibellev(String libellev) {
        this.libellev = libellev;
    }

    public void setTaillev(String taillev) {
        this.taillev = taillev;
    }

    public void setCouleurv(String couleurv) {
        this.couleurv = couleurv;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public String getLibellev() {
        return libellev;
    }

    public String getTaillev() {
        return taillev;
    }

    public String getCouleurv() {
        return couleurv;
    }

    public String toString() {
        return "Velo{**id=" + this.getId() + ", **ibelle=" + this.libellev + ", **taille=" + this.taillev + ", **couleur=" + this.couleurv + ", **Fournisseur: =" + this.fournisseur + '}';
    }
}
