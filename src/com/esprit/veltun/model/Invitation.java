
package com.esprit.veltun.model;

import com.esprit.veltun.enums.Response;
import com.esprit.veltun.model.base.BaseEntity;
import java.sql.Date;

public class Invitation extends BaseEntity {
    private Response reponse;
    private Date dateInvitation;
    private Date dateExpiration;
    private User invitant;
    private User invite;
    private Event evenement;

    public Event getEvenement() {
        return this.evenement;
    }

    public void setEvenement(Event evenement) {
        this.evenement = evenement;
    }

    public Invitation() {
    }

    public Invitation(Integer id, Response reponse, Date dateInvitation, Date dateExpiration, User invitant, User invite, Event evenement) {
        this.setId(id);
        this.reponse = reponse;
        this.dateInvitation = dateInvitation;
        this.dateExpiration = dateExpiration;
        this.invitant = invitant;
        this.invite = invite;
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

    public User getInvitant() {
        return this.invitant;
    }

    public void setInvitant(User invitant) {
        this.invitant = invitant;
    }

    public User getInvite() {
        return this.invite;
    }

    public void setInvité(User invite) {
        this.invite = invite;
    }

    public String toString() {
        return "Invitation [reponse=" + this.reponse + ", dateInvitation=" + this.dateInvitation + ", dateExpiration=" + this.dateExpiration + ", invitant=" + this.invitant + ", invite=" + this.invite + ", evenement=" + this.evenement + "]";
    }

    public void setInvite(User value) {
    }
}
