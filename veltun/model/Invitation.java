package com.esprit.veltun.model;

import java.sql.Date;

import com.esprit.veltun.enums.Response;
import com.esprit.veltun.model.base.BaseEntity;

public class Invitation extends BaseEntity {
	private Response reponse;
	private Date dateInvitation;
	private Date dateExpiration;
	private User invitant;
	private User invite;

	public Invitation() {

	}

	public Invitation(Integer id, Response reponse, Date dateInvitation, Date dateExpiration, User invitant,
			User invite) {
		this.setId(id);
		this.reponse = reponse;
		this.dateInvitation = dateInvitation;
		this.dateExpiration = dateExpiration;
		this.invitant = invitant;
		this.invite = invite;

	}

	public Response getReponse() {
		return reponse;
	}

	public void setReponse(Response reponse) {
		this.reponse = reponse;
	}

	public Date getDateInvitation() {
		return dateInvitation;
	}

	public void setDateInvitation(Date dateInvitation) {
		this.dateInvitation = dateInvitation;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public User getInvitant() {
		return invitant;
	}

	public void setInvitant(User invitant) {
		this.invitant = invitant;
	}

	public User getInvite() {
		return invite;
	}

	public void setInvité(User invite) {
		this.invite = invite;
	}

	@Override
	public String toString() {
		return "Invitation [id=" + getId() + ", reponse=" + reponse + ", dateInvitation=" + dateInvitation
				+ ", dateExpiration=" + dateExpiration + ", invitant=" + invitant + ", invite=" + invite + "]";
	}

}
