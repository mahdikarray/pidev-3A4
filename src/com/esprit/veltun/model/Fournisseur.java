
package com.esprit.veltun.model;
import com.esprit.veltun.model.base.BaseEntity;


public class  Fournisseur extends BaseEntity{
	private String nomf,regionf;

public Fournisseur() {
}

//constructur parametre 

public Fournisseur(Integer id, String nomf, String regionf) {
	this.setId(id);
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
    return "Fournisseur{" + "id=" + getId() + ", nom=" + nomf + ", regionf=" + regionf + '}';
}




}
