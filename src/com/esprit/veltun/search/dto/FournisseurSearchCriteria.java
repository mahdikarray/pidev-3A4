//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.veltun.search.dto;

import com.esprit.veltun.model.Fournisseur;
import com.esprit.veltun.search.base.dto.SearchCriteria;

public class FournisseurSearchCriteria extends SearchCriteria<Fournisseur> {
    private String nomf;
    private String regionf;

    public FournisseurSearchCriteria() {
    }

    public String getNom() {
        return this.nomf;
    }

    public void setNom(String nomf) {
        this.nomf = nomf;
    }

    public String getRegion() {
        return this.regionf;
    }

    public void setRegion(String regionf) {
        this.regionf = regionf;
    }
}
