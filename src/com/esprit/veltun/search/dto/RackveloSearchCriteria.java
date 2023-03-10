package com.esprit.veltun.search.dto;

import com.esprit.veltun.model.RackVelo;
import com.esprit.veltun.search.base.dto.SearchCriteria;

public class RackveloSearchCriteria extends SearchCriteria<RackVelo> {
    public int getRefRV() {
        return refRV;
    }

    public void setRefRV(int refRV) {
        this.refRV = refRV;
    }

    private int refRV ;

    public RackveloSearchCriteria() {
        this.refRV = refRV;
    }

    public void setRefRack(int parseInt) {
    }

    public void setRefRV() {
        this.refRV = refRV;
    }

}
