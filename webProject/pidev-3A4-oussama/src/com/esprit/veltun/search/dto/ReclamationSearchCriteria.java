package com.esprit.veltun.search.dto;

import com.esprit.veltun.model.Reclamation;
import com.esprit.veltun.search.base.dto.SearchCriteria;

public class ReclamationSearchCriteria extends SearchCriteria<Reclamation> {
    private int id_reclamation;

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

}
