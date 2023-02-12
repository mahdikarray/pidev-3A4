package com.esprit.veltun.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.esprit.veltun.enums.Response;
import com.esprit.veltun.model.Invitation;
import com.esprit.veltun.model.User;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.InvitationSearchCriteria;
import com.esprit.veltun.services.InvitationService;
import com.esprit.veltun.util.MyConnection;

public class InvitationServiceImpl implements InvitationService {

	@Override
	public Invitation findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Invitation> list() {
		List<Invitation> list = new ArrayList<>();
		try {
			Connection conn = MyConnection.getInstance();
			String req = "Select * from invitation";
			Statement st = conn.createStatement();

			ResultSet RS = st.executeQuery(req);
			while (RS.next()) {
				Invitation invi = new Invitation();
				invi.setId(RS.getInt(1));
				invi.setReponse(Response.valueOf(RS.getString(2)));
				invi.setDateInvitation(RS.getDate(3));
				invi.setDateExpiration(RS.getDate(4));
				User invitant = new User();
				invitant.setId(RS.getInt(5));
				invi.setInvitant(invitant);
				User invite = new User();
				invite.setId(RS.getInt(6));
				invi.setInvité(invite);
				list.add(invi);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}

	@Override
	public Invitation save(Invitation entity) {

		try {
			Connection conn = MyConnection.getInstance();
			String req = "INSERT INTO `invitation`( `id` ) VALUES (?)";
			PreparedStatement ps = conn.prepareStatement(req);

			ps.setInt(1, entity.getId());
			Integer id = ps.executeUpdate();
			entity.setId(id);
			System.out.println("invitation ajouté!!!");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return entity;
	}

	@Override
	public Invitation update(Invitation invi) {
		try {
			Connection conn = MyConnection.getInstance();
			String req = "UPDATE `invitation` SET `id` = '" + invi.getId() + "', `reponse` = '" + invi.getReponse().name()
					+ "', `dateInvitation` = '" + invi.getDateInvitation() + "'" + ", `dateExpiration` = '"
					+ invi.getDateExpiration() + "'" + ", `invitant` = '" + invi.getInvitant() + "'" + ", `invité` = '"
					+ invi.getInvité() + "'" + " WHERE `invitation`.`id` LIKE " + invi.getId();
			Statement st = conn.createStatement();
			st.executeUpdate(req);
			System.out.println("invitation updated !");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return invi;
	}

	@Override
	public boolean remove(Integer id) {
		try {
			Connection conn = MyConnection.getInstance();
			String req = "DELETE FROM `invitation` WHERE id = " + id;
			Statement st = conn.createStatement();
			st.executeUpdate(req);
			System.out.println("Invitation deleted !");
			return true;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	@Override
	public Collection<Invitation> search(SearchCriteria<Invitation> searchCriteria) {
		List<Invitation> list = new ArrayList<>();
		try {
			InvitationSearchCriteria invitationSearchCriteria = (InvitationSearchCriteria) searchCriteria;
			Connection conn = MyConnection.getInstance();

			StringBuilder builder = new StringBuilder("Select * from invitation");
			StringBuilder whereBuilder = new StringBuilder();

			if (invitationSearchCriteria.getId() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" AND id=?");
				} else {
					whereBuilder.append(" WHERE id=?");
				}
			}

			if (invitationSearchCriteria.getReponse() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" AND reponse=?");
				} else {
					whereBuilder.append(" WHERE reponse=?");
				}
			}
			if (invitationSearchCriteria.getDateInvitation() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" AND dateInvitation=?");
				} else {
					whereBuilder.append(" WHERE dateInvitation=?");
				}
			}
			if (invitationSearchCriteria.getDateExpiration() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" AND dateExpiration=?");
				} else {
					whereBuilder.append(" WHERE dateExpiration=?");
				}
			}
//			if (invitationSearchCriteria.getInvitant() != null) {
//				if (!whereBuilder.toString().isEmpty()) {
//					whereBuilder.append(" AND Invitant=?");
//				} else {
//					whereBuilder.append(" WHERE Invitant=?");
//				}
//			}
//			if (invitationSearchCriteria.getInvité() != null) {
//				if (!whereBuilder.toString().isEmpty()) {
//					whereBuilder.append(" AND Invité=?");
//				} else {
//					whereBuilder.append(" WHERE Invité=?");
//				}
//			}
			builder.append(whereBuilder);

			PreparedStatement st = conn.prepareStatement(builder.toString());
			int counter = 1;
			if (invitationSearchCriteria.getId() != null) {
				st.setInt(counter, invitationSearchCriteria.getId());
				counter++;
			}

			if (invitationSearchCriteria.getReponse() != null) {
				st.setString(counter, invitationSearchCriteria.getReponse().name());
				counter++;
			}
			if (invitationSearchCriteria.getDateInvitation() != null) {
				st.setDate(counter, invitationSearchCriteria.getDateInvitation());
				counter++;
			}
			if (invitationSearchCriteria.getDateExpiration() != null) {
				st.setDate(counter, invitationSearchCriteria.getDateExpiration());
				counter++;
			}
//			if (invitationSearchCriteria.getInvitant() != null) {
//				st.setInt(counter, invitationSearchCriteria.getInvitant());
//				counter++;
//			}
//			if (invitationSearchCriteria.getInvité() != null) {
//				st.setInt(counter, invitationSearchCriteria.getInvité());
//				counter++;
//			}
			ResultSet RS = st.executeQuery();
			while (RS.next()) {
				Invitation invi = new Invitation();
				invi.setId(RS.getInt(1));
				invi.setReponse(Response.valueOf(RS.getString(2)));
				invi.setDateInvitation(RS.getDate(3));
				invi.setDateExpiration(RS.getDate(4));
				
				User invitant = new User();
				invitant.setId(RS.getInt(5));
				invi.setInvitant(invitant);
				
				User invite = new User();
				invite.setId(RS.getInt(6));
				invi.setInvité(invite);

				list.add(invi);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return list;
	}
}