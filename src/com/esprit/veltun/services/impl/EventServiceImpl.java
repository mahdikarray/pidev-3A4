package com.esprit.veltun.services.impl;

import com.esprit.veltun.model.Event;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.EventSearchCriteria;
import com.esprit.veltun.services.EventService;
import com.esprit.veltun.util.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EventServiceImpl implements EventService {

	private static EventService instance;

	private EventServiceImpl() {
	}

	public static synchronized EventService getInstance() {
		if (instance == null) {
			EventServiceImpl.instance = new EventServiceImpl();
		}
		return EventServiceImpl.instance;
	}

	@Override
	public Event findById(Integer id) {
		try {
			Connection conn = MyConnection.getInstance();
			String req = "SELECT `event`.`id`, `event`.`titre`, "
					+ "`event`.`description`, `event`.`dateDebut`, "
					+ "`event`.`heure_debut`, `event`.`dateFin`, "
					+ "`event`.`heure_fin`, `event`.`adresse` "
					+ "FROM `event` "
					+ "WHERE `event`.`id` = " + id;
			Statement st = conn.createStatement();
			ResultSet RS = st.executeQuery(req);
			while (RS.next()) {
				Event event = new Event();
				event.setId(RS.getInt(1));
				event.setTitre(RS.getString(2));
				event.setDescription(RS.getString(3));
				event.setDateDebut(RS.getDate(4));
				event.setHeureDebut(RS.getTime(5));
				event.setDateFin(RS.getDate(6));
				event.setAdresse(RS.getString(7));
				System.out.println("Event founded");
				return event;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public Collection<Event> list() {
		List<Event> list = new ArrayList<>();
		try {
			Connection conn = MyConnection.getInstance();
			String req = "SELECT `event`.`id`, `event`.`titre`, `event`.`description`, `event`.`dateDebut`, `event`.`heure_debut`, `event`.`dateFin`, `event`.`heure_fin`, `event`.`adresse`  FROM `event` ";

			Statement st = conn.createStatement();

			ResultSet RS = st.executeQuery(req);
			while (RS.next()) {
				Event event = new Event();
				event.setId(RS.getInt(1));
				event.setTitre(RS.getString(2));
				event.setDescription(RS.getString(3));
				event.setDateDebut(RS.getDate(4));
				event.setHeureDebut(RS.getTime(5));
				event.setDateFin(RS.getDate(6));
				event.setHeureFin(RS.getTime(7));
				event.setAdresse(RS.getString(8));
				list.add(event);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}

	@Override
	public Event save(Event event) {

		try {

			Connection conn = MyConnection.getInstance();
			String req = "INSERT INTO `event`(`titre`, `description`, `dateDebut`, "
					+ "`heure_debut`, `dateFin`, `heure_fin`, `adresse`)"
					+ " VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, event.getTitre());
			pst.setString(2, event.getDescription());
			pst.setDate(3, event.getDateDebut());
			pst.setTime(4, event.getHeureDebut());
			pst.setDate(5, event.getDateFin());
			pst.setTime(6, event.getHeureFin());
			pst.setString(7, event.getAdresse());

			pst.execute();
			
			ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                event.setId(generatedKeys.getInt(1));
            }
			System.out.println("Event ajouté!!!");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return event;
	}

	@Override
	public Event update(Event event) {
		try {
			Connection conn = MyConnection.getInstance();
			String req1 = "UPDATE `event` SET `titre`=?,`description`=?,`dateDebut`=?,`heure_debut`=?,`dateFin`=?,`heure_fin`=?,`adresse`=? WHERE `id`=?";

			PreparedStatement pst = conn.prepareStatement(req1);
			pst.setString(1, event.getTitre());
			pst.setString(2, event.getDescription());
			pst.setDate(3, event.getDateDebut());
			pst.setTime(4, event.getHeureDebut());
			pst.setDate(5, event.getDateFin());
			pst.setTime(6, event.getHeureFin());
			pst.setString(7, event.getAdresse());


			pst.setInt(8, event.getId());

			pst.executeUpdate();
			System.out.println("Event updated !");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return event;
	}

	@Override
	public boolean remove(Integer id) {
		try {
			Connection conn = MyConnection.getInstance();
			String req = "DELETE FROM `event` WHERE id = " + id;
			Statement st = conn.createStatement();
			st.executeUpdate(req);
			System.out.println("Event deleted !");
			return true;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	@Override
	public Collection<Event> search(SearchCriteria<Event> searchCriteria) {
		List<Event> list = new ArrayList<>();
		try {
			EventSearchCriteria eventSearchCriteria = (EventSearchCriteria) searchCriteria;
			Connection conn = MyConnection.getInstance();

			StringBuilder builder = new StringBuilder("SELECT `event`.`id`, `event`.`titre`, " +
					"`event`.`description`, `event`.`dateDebut`, `event`.`heure_debut`, `event`.`dateFin`," +
					" `event`.`heure_fin`, `event`.`adresse` " +
					" FROM `event`");
			StringBuilder whereBuilder = new StringBuilder();

			if (eventSearchCriteria.getId() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" AND id=?");
				} else {
					whereBuilder.append(" WHERE id=?");
				}
			}

			if (eventSearchCriteria.getTitre() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" AND titre like ?");
				} else {
					whereBuilder.append(" WHERE titre like ?");
				}
			}
			if (eventSearchCriteria.getDescription() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" AND description=?");
				} else {
					whereBuilder.append(" WHERE description=?");
				}
			}
			if (eventSearchCriteria.getDateDebut() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" AND dateDebut=?");
				} else {
					whereBuilder.append(" WHERE dateDebut=?");
				}
			}
			if (eventSearchCriteria.getDateFin() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" AND dateFin=?");
				} else {
					whereBuilder.append(" WHERE dateFin=?");
				}
			}
			if (eventSearchCriteria.getAdresse() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" AND adresse=?");} else {
					whereBuilder.append(" WHERE adresse=?");
				}
			}
			

			builder.append(whereBuilder);

			PreparedStatement st = conn.prepareStatement(builder.toString());
			int counter = 1;
			if (eventSearchCriteria.getId() != null) {
				st.setInt(counter, eventSearchCriteria.getId());
				counter++;
			}

			if (eventSearchCriteria.getTitre() != null) {
				st.setString(counter, "%" + eventSearchCriteria.getTitre() + "%");
				counter++;
			}
			if (eventSearchCriteria.getDateDebut() != null) {
				st.setDate(counter, eventSearchCriteria.getDateDebut());
				counter++;
			}
			if (eventSearchCriteria.getDateFin() != null) {
				st.setDate(counter, eventSearchCriteria.getDateFin());
				counter++;
			}
			if (eventSearchCriteria.getAdresse() != null) {
			st.setString(counter,   eventSearchCriteria.getAdresse() );
				counter++;
			}

			ResultSet RS = st.executeQuery();
			while (RS.next()) {
				Event event = new Event();
				event.setId(RS.getInt(1));
				event.setTitre(RS.getString(2));
				event.setDescription(RS.getString(3));
				event.setDateDebut(RS.getDate(4));
				event.setHeureDebut(RS.getTime(5));
				event.setDateFin(RS.getDate(6));
				event.setHeureFin(RS.getTime(7));
				event.setAdresse(RS.getString(3));

				list.add(event);
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

}
