//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.esprit.veltun.services.impl;

import com.esprit.veltun.enums.Response;
import com.esprit.veltun.model.Event;
import com.esprit.veltun.model.Invitation;
import com.esprit.veltun.model.User;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.InvitationSearchCriteria;
import com.esprit.veltun.services.InvitationService;
import com.esprit.veltun.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class InvitationServiceImpl implements InvitationService {
	public InvitationServiceImpl() {
	}

    public static InvitationService getInstance() {
    return null;
	}

    public Invitation findById(Integer id) {
		try {
			Connection conn = MyConnection.getInstance();
			String req = "SELECT `invitation`.`id`, `invitation`.`reponse`, `invitation`.`date_invitation`,`invitation`.`date_expiration`, `invitation`.`invitant_id`,  `invitation`.`invite_id`, `event`.`id`, `event`.`titre`, `event`.`description`, `event`.`dateDebut`, `event`.`heure_debut`, `event`.`dateFin`, `event`.`heure_fin`, `event`.`adresse_id` FROM `invitation` LEFT JOIN `event` ON `event`.`id`= `invitation`.`evenement_id`WHERE `invitation`.`id` = " + id;
			Statement st = conn.createStatement();
			ResultSet RS = st.executeQuery(req);
			if (RS.next()) {
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
				if (RS.getInt(7) > 0) {
					Event event = new Event();
					event.setId(RS.getInt(7));
					event.setTitre(RS.getString(8));
					event.setDescription(RS.getString(9));
					event.setDateDebut(RS.getDate(10));
					event.setHeureDebut(RS.getTime(11));
					event.setDateFin(RS.getDate(12));
					event.setHeureFin(RS.getTime(13));
					invi.setEvenement(event);
				}

				System.out.println("Invitation founded");
				return invi;
			}
		} catch (SQLException var10) {
			System.out.println(var10.getMessage());
		}

		return null;
	}

	public Collection<Invitation> list() {
		ArrayList list = new ArrayList();

		try {
			Connection conn = MyConnection.getInstance();
			String req = "SELECT `invitation`.`id`, `invitation`.`reponse`, `invitation`.`date_invitation`,`invitation`.`date_expiration`, `invitation`.`invitant_id`,  `invitation`.`invite_id`, `event`.`id`, `event`.`titre`, `event`.`description`, `event`.`dateDebut`, `event`.`heure_debut`, `event`.`dateFin`, `event`.`heure_fin`, `event`.`adresse_id` FROM `invitation` LEFT JOIN `event` ON `event`.`id`= `invitation`.`evenement_id`";
			Statement st = conn.createStatement();

			Invitation invi;
			for(ResultSet RS = st.executeQuery(req); RS.next(); list.add(invi)) {
				invi = new Invitation();
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
				if (RS.getInt(7) > 0) {
					Event event = new Event();
					event.setId(RS.getInt(7));
					event.setTitre(RS.getString(8));
					event.setDescription(RS.getString(9));
					event.setDateDebut(RS.getDate(10));
					event.setHeureDebut(RS.getTime(11));
					event.setDateFin(RS.getDate(12));
					event.setHeureFin(RS.getTime(13));
					invi.setEvenement(event);
				}
			}
		} catch (SQLException var10) {
			System.out.println(var10.getMessage());
		}

		return list;
	}

	public Invitation save(Invitation invi) {
		try {
			Connection conn = MyConnection.getInstance();
			String req = "INSERT INTO `invitation`(`reponse`, `date_invitation`, `date_expiration`, `invitant_id`, `invite_id`,`evenement_id`) VALUES (?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(req, 1);
			pst.setString(1, invi.getReponse().name());
			pst.setDate(2, invi.getDateInvitation());
			pst.setDate(3, invi.getDateExpiration());
			if (invi.getInvitant() != null && invi.getInvitant().getId() != null) {
				pst.setInt(4, invi.getInvitant().getId());
			} else {
				pst.setNull(4, 4);
			}

			if (invi.getInvite() != null && invi.getInvite().getId() != null) {
				pst.setInt(5, invi.getInvite().getId());
			} else {
				pst.setNull(5, 4);
			}

			if (invi.getEvenement() != null && invi.getEvenement().getId() != null) {
				pst.setInt(6, invi.getEvenement().getId());
			} else {
				pst.setNull(6, 4);
			}

			pst.execute();
			ResultSet generatedKeys = pst.getGeneratedKeys();
			if (generatedKeys.next()) {
				invi.setId(generatedKeys.getInt(1));
			}

			System.out.println("invitation ajouté!!!");
		} catch (SQLException var6) {
			var6.printStackTrace();
		}

		return invi;
	}

	public Invitation update(Invitation invi) {
		try {
			Connection conn = MyConnection.getInstance();
			String req1 = "UPDATE `invitation` SET `reponse`=?,`date_invitation`=?,`date_expiration`=?,`invitant_id`=?,`invite_id`=?,`evenement_id`=? WHERE `id`=?";
			PreparedStatement pst = conn.prepareStatement(req1);
			pst.setString(1, invi.getReponse().name());
			pst.setDate(2, invi.getDateInvitation());
			pst.setDate(3, invi.getDateExpiration());
			if (invi.getInvitant() != null && invi.getInvitant().getId() != null) {
				pst.setInt(4, invi.getInvitant().getId());
			} else {
				pst.setNull(4, 4);
			}

			if (invi.getInvite() != null && invi.getInvite().getId() != null) {
				pst.setInt(5, invi.getInvite().getId());
			} else {
				pst.setNull(5, 4);
			}

			if (invi.getEvenement() != null && invi.getEvenement().getId() != null) {
				pst.setInt(6, invi.getEvenement().getId());
			} else {
				pst.setNull(6, 4);
			}

			pst.setInt(7, invi.getId());
			pst.executeUpdate();
			System.out.println("invitation updated !");
		} catch (SQLException var5) {
			System.out.println(var5.getMessage());
		}

		return invi;
	}

	public boolean remove(Integer id) {
		try {
			Connection conn = MyConnection.getInstance();
			String req = "DELETE FROM `invitation` WHERE id = " + id;
			Statement st = conn.createStatement();
			st.executeUpdate(req);
			System.out.println("Invitation deleted !");
			return true;
		} catch (SQLException var5) {
			System.out.println(var5.getMessage());
			return false;
		}
	}

	public Collection<Invitation> search(SearchCriteria<Invitation> searchCriteria) {
		ArrayList list = new ArrayList();

		try {
			Connection conn = MyConnection.getInstance();
			InvitationSearchCriteria invitationSearchCriteria = (InvitationSearchCriteria)searchCriteria;
			StringBuilder builder = new StringBuilder("SELECT * FROM `invitation`");
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
					whereBuilder.append(" AND date_invitation=?");
				} else {
					whereBuilder.append(" WHERE date_invitation=?");
				}
			}

			if (invitationSearchCriteria.getDateExpiration() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" AND date_expiration=?");
				} else {
					whereBuilder.append(" WHERE date_expiration=?");
				}
			}

			if (invitationSearchCriteria.getEvenement() != null && invitationSearchCriteria.getEvenement().getId() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" AND evenement_id=?");
				} else {
					whereBuilder.append(" WHERE evenement_id=?");
				}
			}

			builder.append(whereBuilder);
			PreparedStatement st = conn.prepareStatement(builder.toString());
			int counter = 1;
			if (invitationSearchCriteria.getId() != null) {
				st.setInt(counter, invitationSearchCriteria.getId());
				++counter;
			}

			if (invitationSearchCriteria.getReponse() != null) {
				st.setString(counter, invitationSearchCriteria.getReponse().name());
				++counter;
			}

			if (invitationSearchCriteria.getDateInvitation() != null) {
				st.setDate(counter, invitationSearchCriteria.getDateInvitation());
				++counter;
			}

			if (invitationSearchCriteria.getDateExpiration() != null) {
				st.setDate(counter, invitationSearchCriteria.getDateExpiration());
				++counter;
			}

			if (invitationSearchCriteria.getEvenement() != null && invitationSearchCriteria.getEvenement().getId() != null) {
				st.setInt(counter, invitationSearchCriteria.getEvenement().getId());
				++counter;
			}

			ResultSet RS = st.executeQuery();

			while(RS.next()) {
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
				Event evenement = new Event();
				evenement.setId(RS.getInt(6));
				invi.setEvenement(evenement);
				list.add(invi);
			}
		} catch (SQLException var14) {
			System.out.println(var14.getMessage());
		}

		return list;
	}
}
