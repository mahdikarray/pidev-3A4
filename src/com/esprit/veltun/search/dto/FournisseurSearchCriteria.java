package com.esprit.veltun.search.dto;


import com.esprit.veltun.model.Fournisseur;
import com.esprit.veltun.search.base.dto.SearchCriteria;



public class FournisseurSearchCriteria extends SearchCriteria<Fournisseur> {
	private String nomf,regionf;

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
	
}
