package com.esprit.veltun.search.dto;

import java.sql.Date;

import com.esprit.veltun.enums.Response;
import com.esprit.veltun.model.Invitation;
import com.esprit.veltun.search.base.dto.SearchCriteria;

public class InvitationSearchCriteria extends SearchCriteria<Invitation> {
	private Integer id;
	private Response reponse;
	private Date dateInvitation;
	private Date dateExpiration;
	private String invitant;
	private String invité;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getInvitant() {
		return invitant;
	}
	public void setInvitant(String invitant) {
		this.invitant = invitant;
	}
	public String getInvité() {
		return invité;
	}
	public void setInvité(String invité) {
		this.invité = invité;
	}
	@Override
	public String toString() {
		return "Invitation [id=" + id + ", reponse=" + reponse + ", dateInvitation=" + dateInvitation
				+ ", dateExpiration=" + dateExpiration + ", invitant=" + invitant + ", invité=" + invité + "]";
	}
	
	
	
}
