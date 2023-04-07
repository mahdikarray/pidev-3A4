//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.veltun.search.dto;

import com.esprit.veltun.model.Adresse;
import com.esprit.veltun.search.base.dto.SearchCriteria;

public class AdresseSearchCriteria extends SearchCriteria<Adresse> {
    private String rue;
    private String region;
    private Double longitude;
    private Double latitude;

    public AdresseSearchCriteria() {
    }

    public String getRue() {
        return this.rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String toString() {
        return "Adresse [id=" + this.getId() + ", rue=" + this.rue + ", region=" + this.region + ", longitude=" + this.longitude + ", latitude=" + this.latitude + "]";
    }
}
