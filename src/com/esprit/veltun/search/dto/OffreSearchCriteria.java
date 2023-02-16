package com.esprit.veltun.search.dto;

public abstract class OffreSearchCriteria {
	private int Id_offre;
	private float Prix;

	public int getId_offre() {
		return Id_offre;
	}

	public void setId_offre(int Id_offre) {
		this.Id_offre = Id_offre;
	}

	public float getPrix() {
		return Prix;
	}

	public void setPrix(float Prix) {
		this.Prix = Prix;
	}

	@Override
	public String toString() {
		return "offre{" + "Id_offre=" + Id_offre + ", Prix=" + Prix + '}';
	}

}
