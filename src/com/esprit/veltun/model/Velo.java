package com.esprit.veltun.model;

import com.esprit.veltun.model.base.BaseEntity;

public class Velo extends BaseEntity {
	 private String libellev,taillev,couleurv,fournisseur;


public Velo() {
}


/**
 * @param id
 * @param libellev
 * @param taillev
 * @param couleurv
 * @param fournisseur
 */
public Velo(Integer id, String libellev, String taillev, String couleurv, String fournisseur) {
	this.setId(id);
    this.libellev = libellev;
    this.taillev = taillev;
    this.couleurv = couleurv;
    this.fournisseur = fournisseur;

}

public Velo(String libellev, String taillev, String couleurv, String fournisseur) {
    this.libellev = libellev;
    this.taillev = taillev;
    this.couleurv = couleurv;
    this.fournisseur = fournisseur;

}



public String getLibelle() {
    return libellev;
}

public void setLibelle(String libellev) {
    this.libellev = libellev;
}

public String getTaille() {
    return taillev;
}

public void setTaille(String taillev) {
    this.taillev = taillev;
}
 public String getCouleur() {
    return couleurv;
}

public void setCouleur(String couleurv) {
    this.couleurv = couleurv;
}
 public String getFournisseur() {
    return fournisseur;
}

public void setFournisseur(String fournisseur) {
    this.fournisseur = fournisseur;
}

@Override
public String toString() {
    return "Velo{" + "**id=" + getId() + ", **ibelle=" + libellev + ", **taille=" + taillev + ", **couleur=" + couleurv + ", **fournisseur=" + fournisseur + '}';
}




}

