package com.esprit.veltun.services.impl;

import com.esprit.veltun.enums.Response;
import com.esprit.veltun.model.Event;
import com.esprit.veltun.model.Invitation;
import com.esprit.veltun.model.User;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.InvitationSearchCriteria;
import com.esprit.veltun.services.InvitationService;
import com.esprit.veltun.util.MyConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InvitationServiceImpl implements InvitationService {


	private static InvitationService instance;

	private InvitationServiceImpl() {}
	public static synchronized InvitationService getInstance() {
		if (instance == null) {
			InvitationServiceImpl.instance = new InvitationServiceImpl();
		}
		return InvitationServiceImpl.instance;
	}
	@Override
	public Invitation findById(Integer id) {
		try {
			Connection conn = MyConnection.getInstance();
			String req = "SELECT `invitation`.`id`, `invitation`.`reponse`, `invitation`.`date_invitation`,"
					+ "`invitation`.`date_expiration`,"
					+ " `invitation`.`invitant_id`, "
					+ " `invitation`.`invite_id`, "
					+ "`event`.`id`, `event`.`titre`, "
					+ "`event`.`description`, `event`.`dateDebut`, "
					+ "`event`.`heure_debut`, `event`.`dateFin`, "
					+ "`event`.`heure_fin`, `event`.`adresse` "
					+ "FROM `invitation` "
					+ "LEFT JOIN `event` ON `event`.`id`= `invitation`.`evenement_id`"
					+ "WHERE `invitation`.`id` = " + id;
					
					
			Statement st = conn.createStatement();
			ResultSet RS = st.executeQuery(req);
			while (RS.next()) {
				Invitation invi = new Invitation();
				invi.setId(RS.getInt(1));
				invi.setReponse(Response.valueOf(RS.getString(2)));
				invi.setDateInvitation(RS.getDate(3));
				invi.setDateExpiration(RS.getDate(4));
				User invitant = new User();
				invitant.setCIN(RS.getString(5));
				invi.setInvitant(invitant);
				User invite = new User();
				invite.setCIN(RS.getString(6));
				invi.setInvite(invite);
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
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public Collection<Invitation> list() {
		List<Invitation> list = new ArrayList<>();
		try {
			Connection conn = MyConnection.getInstance();
			String req = "SELECT `invitation`.`id`, `invitation`.`reponse`, `invitation`.`date_invitation`,"
					+ "`invitation`.`date_expiration`,"
					+ " `invitation`.`invitant_id`, "
					+ " `invitation`.`invite_id`, "
					+ "`event`.`id`, `event`.`titre`, "
					+ "`event`.`description`, `event`.`dateDebut`, "
					+ "`event`.`heure_debut`, `event`.`dateFin`, "
					+ "`event`.`heure_fin`, `event`.`adresse` "
					+ "FROM `invitation` "
					+ "LEFT JOIN `event` ON `event`.`id`= `invitation`.`evenement_id`";
			Statement st = conn.createStatement();

			ResultSet RS = st.executeQuery(req);
			while (RS.next()) {
				Invitation invi = new Invitation();
				invi.setId(RS.getInt(1));
				invi.setReponse(Response.valueOf(RS.getString(2)));
				invi.setDateInvitation(RS.getDate(3));
				invi.setDateExpiration(RS.getDate(4));
				User invitant = new User();
				invitant.setCIN(RS.getString(5));
				invi.setInvitant(invitant);
				User invite = new User();
				invite.setCIN(RS.getString(6));
				invi.setInvite(invite);
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
				
				list.add(invi);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}

	@Override
	public Invitation save(Invitation invi) {

		try {
			Connection conn = MyConnection.getInstance();
			
		    String req = "INSERT INTO `invitation`(`reponse`, `date_invitation`, `date_expiration`, `invitant_id`, `invite_id`,`evenement_id`) VALUES (?,?,?,?,?,?)";
			
		PreparedStatement pst = conn.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
			if (invi.getReponse() != null) {
				pst.setString(1, invi.getReponse().name());
			} else {
				pst.setNull(1, Types.VARCHAR);
			}
			pst.setDate(2, invi.getDateInvitation());
			pst.setDate(3, invi.getDateExpiration());
			if (invi.getInvitant() != null && invi.getInvitant().getCIN() != null) {
				pst.setString(4, invi.getInvitant().getCIN());
			} else {
				pst.setNull(4, Types.INTEGER);
			}
			if (invi.getInvite() != null && invi.getInvite().getCIN() != null) {
				pst.setString(5, invi.getInvite().getCIN());
			} else {
				pst.setNull(5, Types.INTEGER);
			}
			if (invi.getEvenement() != null && invi.getEvenement().getId() != null) {
				pst.setInt(6, invi.getEvenement().getId());
			} else {
				pst.setNull(6, Types.INTEGER);
			}
			
			pst.execute();
			ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                invi.setId(generatedKeys.getInt(1));
            }
			System.out.println("invitation ajouté!!!");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return invi;
	}

	@Override
	public Invitation update(Invitation invi) {
		try {
			Connection conn = MyConnection.getInstance();
			String req1 = "UPDATE `invitation` SET `reponse`=?,`date_invitation`=?,`date_expiration`=?,`invitant_id`=?,`invite_id`=?,`evenement_id`=? WHERE `id`=?";

			PreparedStatement pst = conn.prepareStatement(req1);
			pst.setString(1, invi.getReponse().name());
			pst.setDate(2, invi.getDateInvitation());
			pst.setDate(3, invi.getDateExpiration());
			if (invi.getInvitant() != null && invi.getInvitant().getCIN() != null) {
				pst.setString(4, invi.getInvitant().getCIN());
			} else {
				pst.setNull(4, Types.INTEGER);
			}
			if (invi.getInvite() != null && invi.getInvite().getCIN() != null) {
				pst.setString(5, invi.getInvite().getCIN());
			} else {
				pst.setNull(5, Types.INTEGER);
			}
			if (invi.getEvenement() != null && invi.getEvenement().getId() != null) {
				pst.setInt(6, invi.getEvenement().getId());
			} else {
				pst.setNull(6, Types.INTEGER);
			}
			
			pst.setInt(7, invi.getId());

			pst.executeUpdate();
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
			Connection conn = MyConnection.getInstance();
			InvitationSearchCriteria invitationSearchCriteria = (InvitationSearchCriteria) searchCriteria;

			StringBuilder builder = new StringBuilder("SELECT `invitation`.`id`, `invitation`.`reponse`, `invitation`.`date_invitation`," +
					" `invitation`.`date_expiration`, `invitation`.`invitant_id`, `invitation`.`invite_id`, `invitation`.`evenement_id`, " +
					" `invitant`.`CIN`, `invitant`.`nom`, `invitant`.`prenom`, `invitant`.`date_naiss`, `invitant`.`type`, `invitant`.`code_postal`, `invitant`.`email`, " +
					" `invite`.`CIN`, `invite`.`nom`, `invite`.`prenom`, `invite`.`date_naiss`, `invite`.`type`, `invite`.`code_postal`, `invite`.`email` " +
					"FROM `invitation` " +
					"	LEFT JOIN `user` as `invitant` on  `invitant`. `CIN`=`invitation`. `invitant_id`" +
					"	LEFT JOIN `user` as `invite` on  `invite`. `CIN`=`invitation`. `invite_id` ");
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
			if (invitationSearchCriteria.getInvitant() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" OR invitant_id =?");
				} else {
					whereBuilder.append(" WHERE invitant_id =?");
				}
			}
			if (invitationSearchCriteria.getInvité() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" OR invite_id =?");
				} else {
					whereBuilder.append(" WHERE invite_id =?");
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
			if (invitationSearchCriteria.getInvitant() != null) {
				st.setString(counter, invitationSearchCriteria.getInvitant());
				counter++;
			}
			if (invitationSearchCriteria.getInvité() != null) {
				st.setString(counter, invitationSearchCriteria.getInvité());
				counter++;
			}
			
			if (invitationSearchCriteria.getEvenement() != null && invitationSearchCriteria.getEvenement().getId() != null) {
				st.setInt(counter, invitationSearchCriteria.getEvenement().getId());
				counter++;
			}
			ResultSet RS = st.executeQuery();
			while (RS.next()) {
				Invitation invi = new Invitation();
				invi.setId(RS.getInt(1));
				invi.setReponse(Response.valueOf(RS.getString(2)));
				invi.setDateInvitation(RS.getDate(3));
				invi.setDateExpiration(RS.getDate(4));

				User invitant = new User();
				invitant.setCIN(RS.getString(8));
				invitant.setNom(RS.getString(9));
				invitant.setPrenom(RS.getString(10));
				invitant.setDateNaiss(RS.getDate(11));
				invitant.setType(RS.getString(12));
				invitant.setCodePos(RS.getInt(13));
				invitant.setEmail(RS.getString(14));
				invi.setInvitant(invitant);

				User invite = new User();
				invite.setCIN(RS.getString(15));
				invite.setNom(RS.getString(16));
				invite.setPrenom(RS.getString(17));
				invite.setDateNaiss(RS.getDate(18));
				invite.setType(RS.getString(19));
				invite.setCodePos(RS.getInt(20));
				invite.setEmail(RS.getString(21));
				invi.setInvite(invite);

				Event evenement = new Event();
				evenement.setId(RS.getInt(7));
				invi.setEvenement(evenement);

				list.add(invi);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return list;
	}

	@Override
	public String veloDominante() {
		return null;
	}

	@Override
	public void checkExpiredInvitation() {
		Thread runner = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(15000L);
						Collection<Invitation> invitations = list();
						System.out.println("checking expired invitations");
						invitations.stream().filter(invit->{
							boolean exp = invit.getDateExpiration().before(Date.valueOf(LocalDate.now()));
							exp = exp && (invit.getReponse() == null || invit.getReponse() != Response.OUI);
							return exp;
						}).forEach(invit->{
							System.out.println("This invitation has been removed");
							remove(invit.getId());
							System.out.println(invit);
						});
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		runner.start();
	}
}