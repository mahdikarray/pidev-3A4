package com.esprit.veltun.search.base.dto;

import com.esprit.veltun.model.base.BaseEntity;

public abstract class SearchCriteria<T extends BaseEntity> {
	private Integer id;;
	private String libellev,taillev,couleurv;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
}
