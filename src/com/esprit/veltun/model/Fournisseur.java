
package com.esprit.veltun.model;
import com.esprit.veltun.model.base.BaseEntity;


public class  Fournisseur extends BaseEntity{
	private String nomf,regionf;

public Fournisseur() {
}

//constructur parametre 

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
    return nomf;
}

public void setNom(String nomf) {
    this.nomf = nomf;
}

public String getRegion() {
    return regionf;
}

public void setRegion(String regionf) {
    this.regionf = regionf;
}

@Override
public String toString() {
    return "Fournisseur{" + "idf=" + getId() + ", nomf=" + nomf + ", regionf=" + regionf + '}';
}




}
