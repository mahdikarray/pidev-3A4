//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.veltun.search.dto;

import com.esprit.veltun.model.Station;
import com.esprit.veltun.search.base.dto.SearchCriteria;

public class StationSearchCriteria extends SearchCriteria<Station> {
    private int id_station;

    public int getId_station() {
        return this.id_station;
    }

    public void setId_station(int id_station) {
        this.id_station = id_station;
    }

    public StationSearchCriteria(int id_station) {
        this.id_station = id_station;
    }

    public StationSearchCriteria() {
    }
}
