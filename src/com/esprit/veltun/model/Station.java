
package com.esprit.veltun.model;

import com.esprit.veltun.model.base.BaseEntity;

public class Station extends BaseEntity {
    private int id_station;
    private String nom_station;
    private double longitude;
    private double latitude;
    private String gouvernorat;

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public int getid_station() {
        return this.id_station;
    }

    public void setid_station(int id_station) {
        this.id_station = id_station;
    }

    public String getnom_station() {
        return this.nom_station;
    }

    public void setnom_station(String nom_station) {
        this.nom_station = nom_station;
    }

    public double getlongitude() {
        return this.longitude;
    }

    public void setlongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getlatitude() {
        return this.latitude;
    }

    public void setlatitude(double latitude) {
        this.latitude = latitude;
    }

    public Station() {
    }

    public Station(int id_station, String nom_station, double longitude, double latitude ) {
        this.id_station = id_station;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nom_station = nom_station;
    }
    public Station(int id_station, String nom_station, double longitude, double latitude ,String gouvernorat ) {
        this.id_station = id_station;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nom_station = nom_station;
        this.gouvernorat = gouvernorat ;
    }
    public Station(int id_station) {
        this.id_station = id_station;
    }

    public Station(String nom_station, double longitude, double latitude) {
        this.nom_station = nom_station;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public Station(String nom_station, double longitude, double latitude , String gouvernorat) {
        this.nom_station = nom_station;
        this.latitude = latitude;
        this.longitude = longitude;
        this.gouvernorat = gouvernorat ;
    }

    public String toString() {
        return "Id_station:" + this.id_station + "Nom_station: " + this.nom_station + "Longitude :" + this.longitude + "Latitude:" + this.latitude + "Gouvernorat:" +this.gouvernorat;
    }
}
