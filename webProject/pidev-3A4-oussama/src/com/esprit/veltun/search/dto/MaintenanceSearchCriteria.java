package com.esprit.veltun.search.dto;

import com.esprit.veltun.model.Maintenance;
import com.esprit.veltun.search.base.dto.SearchCriteria;

public class MaintenanceSearchCriteria extends SearchCriteria<Maintenance> {
    private int id_demande;

    public int getId_demande() {
        return id_demande;
    }

    public void setId_demande(int id_demande) {
        this.id_demande = id_demande;
    }

}
