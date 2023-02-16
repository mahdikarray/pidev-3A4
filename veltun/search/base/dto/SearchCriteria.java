package com.esprit.veltun.search.base.dto;

import com.esprit.veltun.model.base.BaseEntity;

public abstract class SearchCriteria<T extends BaseEntity> {
	private Integer id;
    public String getNom_station() {
		return nom_station;
	}

	public void setNom_station(String nom_station) {
		this.nom_station = nom_station;
	}

	private String nom_station ; 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
