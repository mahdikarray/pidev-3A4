package com.esprit.veltun.search.dto;

import com.esprit.veltun.model.Station;
import com.esprit.veltun.search.base.dto.SearchCriteria;

public class StationSearchCriteria extends SearchCriteria<Station> {
	private int id_station;
	private String nom_station ; 

	public StationSearchCriteria(String nom_station) {
		this.nom_station = nom_station;
	}

	public String getNom_station() {
		return nom_station;
	}

	public void setNom_station(String nom_station) {
		this.nom_station = nom_station;
	}

	public int getId_station() {
		return id_station;
	}

	public void setId_station(int id_station) {
		this.id_station = id_station;
	}

	public StationSearchCriteria(int id_station) {
		
		this.id_station = id_station;
	}

	public StationSearchCriteria() {
	
	}

	@Override
	public String toString() {
		return "StationSearchCriteria [id_station=" + id_station + ", nom_station=" + nom_station + "]";
	}

	public StationSearchCriteria(int id_station, String nom_station) {
		super();
		this.id_station = id_station;
		this.nom_station = nom_station;
	}
	
	

	
}
