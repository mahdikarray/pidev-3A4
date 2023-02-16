package com.esprit.veltun.model;

import com.esprit.veltun.model.base.BaseEntity;

public class Velo extends BaseEntity {
	private int idf;
	 private String libellev,taillev,couleurv;


public Velo() {
}


/**
 * @param id
 * @param libellev
 * @param taillev
 * @param couleurv
 * @param idf
 */
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
 public Integer getIdf() {
    return idf;
}

public void setIdf(Integer idf) {
    this.idf = idf;
}

@Override
public String toString() {
    return "Velo{" + "**id=" + getId() + ", **ibelle=" + libellev + ", **taille=" + taillev + ", **couleur=" + couleurv + ", **idf=" + idf + '}';
}




}

