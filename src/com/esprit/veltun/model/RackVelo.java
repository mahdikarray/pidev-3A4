

package com.esprit.veltun.model;

import com.esprit.veltun.model.base.BaseEntity;

public class RackVelo extends BaseEntity {
    private int refRack;
    private int capacite;
    private int id_station;

    public int getRefRack() {
        return this.refRack;
    }

    public void setRefRack(int refRack) {
        this.refRack = refRack;
    }

    public int getCapacite() {
        return this.capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public int getId_station() {
        return this.id_station;
    }

    public void setId_station(int id_station) {
        this.id_station = id_station;
    }

    public RackVelo() {
    }

    public RackVelo(int refRack, int capacite, int id_station) {
        this.refRack = refRack;
        this.capacite = capacite;
        this.id_station = id_station;
    }
    public RackVelo(int refRack) {
        this.refRack = refRack;
    }

    public String toString() {
        return "RackVelo [refRack=" + this.refRack + ", capacite=" + this.capacite + ", id_station=" + this.id_station + "]";
    }
}
