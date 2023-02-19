//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.veltun.search.dto;

import com.esprit.veltun.enums.Response;
import com.esprit.veltun.model.Event;
import com.esprit.veltun.model.Invitation;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import java.sql.Date;

public class InvitationSearchCriteria extends SearchCriteria<Invitation> {
    private Integer id;
    private Response reponse;
    private Date dateInvitation;
    private Date dateExpiration;
    private String invitant;
    private String invité;
    private Event evenement;

    public InvitationSearchCriteria() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Event getEvenement() {
        return this.evenement;
    }

    public void setEvenement(Event evenement) {
        this.evenement = evenement;
    }

    public Response getReponse() {
        return this.reponse;
    }

    public void setReponse(Response reponse) {
        this.reponse = reponse;
    }

    public Date getDateInvitation() {
        return this.dateInvitation;
    }

    public void setDateInvitation(Date dateInvitation) {
        this.dateInvitation = dateInvitation;
    }

    public Date getDateExpiration() {
        return this.dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public String getInvitant() {
        return this.invitant;
    }

    public void setInvitant(String invitant) {
        this.invitant = invitant;
    }

    public String getInvité() {
        return this.invité;
    }

    public void setInvité(String invité) {
        this.invité = invité;
    }

    public String toString() {
        return "Invitation [id=" + this.getId() + ", reponse=" + this.reponse + ", dateInvitation=" + this.dateInvitation + ", dateExpiration=" + this.dateExpiration + ", invitant=" + this.invitant + ", invité=" + this.invité + "]";
    }
}
