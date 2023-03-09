//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.veltun.search.dto;

import com.esprit.veltun.model.Station;
import com.esprit.veltun.search.base.dto.SearchCriteria;

public class StationSearchCriteria extends SearchCriteria<Station> {
    private int id_station;
    private String gouvernorat ;

    public String getGouvernorat() {
        return gouvernorat;
    }
    public String getNom_station() {
        return nom_station;
    }

    public void setNom_station(String nom_station) {
        this.nom_station = nom_station;
    }

    private  String nom_station;

    public int getId_station() {
        return this.id_station;
    }

    public void setId_station(int id_station) {
        this.id_station = id_station;
    }

    public StationSearchCriteria(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public StationSearchCriteria(int id_station) {
        this.id_station = id_station;
    }

    public StationSearchCriteria() {
    }
}
