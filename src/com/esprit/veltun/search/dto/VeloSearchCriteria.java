package com.esprit.veltun.search.dto;

import com.esprit.veltun.model.Velo;

import com.esprit.veltun.search.base.dto.SearchCriteria;

public class VeloSearchCriteria extends SearchCriteria<Velo> {
	private String libellev,taillev,couleurv;
	private int idf;


	

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
