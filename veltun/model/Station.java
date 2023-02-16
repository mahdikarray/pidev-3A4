/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.veltun.model;

import com.esprit.veltun.model.base.BaseEntity;


public class Station extends BaseEntity {
	private int id_station;
	private String nom_station;
	private double longitude;
	private double latitude;

	public int getid_station() {
		return id_station;
	}

	public void setid_station(int id_station) {
		this.id_station = id_station;
	}

	public String getnom_station() {
		return nom_station;
	}

	public void setnom_station(String nom_station) {
		this.nom_station = nom_station;
	}

	public double getlongitude() {
		return longitude;
	}

	public void setlongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getlatitude() {
		return latitude;
	}

	public void setlatitude(double latitude) {
		this.latitude = latitude;
	}

	public Station() {

	}

	public Station(int id_station, String nom_station, double longitude, double latitude) {
		this.id_station = id_station;
		this.longitude = longitude;
		this.latitude = latitude;
		this.nom_station = nom_station;
	}

	public Station(String nom_station, double longitude, double latitude) {
		this.nom_station = nom_station;
		this.latitude = latitude;
		this.longitude = longitude;

	}

	@Override
	public String toString() {
		return "Id_station:" + this.id_station + "Nom_station: " + this.nom_station + "Longitude :" + this.longitude
				+ "Latitude:" + this.latitude;
	}

	 

}
