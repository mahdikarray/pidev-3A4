package com.esprit.veltun.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.esprit.veltun.model.Adresse;
import com.esprit.veltun.model.Event;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.EventSearchCriteria;
import com.esprit.veltun.services.EventService;
import com.esprit.veltun.util.MyConnection;

public class EventServiceImpl implements EventService {

	@Override
	public Event findById(Integer id) {
		try {
			Connection conn = MyConnection.getInstance();
			String req = "SELECT FROM `event` WHERE id = " + id;
			Statement st = conn.createStatement();
			ResultSet RS = st.executeQuery(req);
			while (RS.next()) {
				Event event = new Event();
				event.setId(RS.getInt(1));
				event.setTitre(RS.getString(2));
				event.setDateDebut(RS.getDate(3));
				event.setDateFin(RS.getDate(4));
				Adresse adresse = new Adresse();
				adresse.setId(RS.getInt(5));
		
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
			String req = "Select * from event";
			Statement st = conn.createStatement();

			ResultSet RS = st.executeQuery(req);
			while (RS.next()) {
				Event event = new Event();
				event.setId(RS.getInt(1));
				event.setTitre(RS.getString(2));
				event.setDateDebut(RS.getDate(3));
				event.setDateFin(RS.getDate(4));
				Adresse adresse = new Adresse();
				adresse.setId(RS.getInt(5));
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
			String req = "INSERT INTO `event`( `titre`,`description`, `dateDebut`, `dateFin`,"
					+ "	`adresse` ) VALUES (?,?,?,?,?))";
			PreparedStatement pst = conn.prepareStatement(req);
			pst.setString(1, event.getTitre());
			pst.setString(2, event.getDescription());
			pst.setDate(3, event.getDateDebut());
			pst.setDate(4, event.getDateFin());
			pst.setInt(5, event.getAdresse().getId());
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
			String req1 = "UPDATE `event` set `titre` =?, `description``=?,`dateDebut`=?,`dateFin`=?,`adresse`=?"
					+ " WHERE id = ?";

			PreparedStatement pst = conn.prepareStatement(req1);
			pst.setString(1, event.getTitre());
			pst.setString(2, event.getDescription());
			pst.setDate(3, event.getDateDebut());
			pst.setDate(4, event.getDateFin());
			pst.setInt(5, event.getAdresse().getId());
			pst.setInt(6, event.getId());

			pst.executeUpdate(req1);
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

			StringBuilder builder = new StringBuilder("Select * from event");
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
					whereBuilder.append(" AND titre=?");
				} else {
					whereBuilder.append(" WHERE titre=?");
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
//			if (eventSearchCriteria.getAdresse() != null) {
//				if (!whereBuilder.toString().isEmpty()) {
//					whereBuilder.append(" AND adresse=?");
//				} else {
//					whereBuilder.append(" WHERE adresse=?");
//				}
//			}
			

			builder.append(whereBuilder);

			PreparedStatement st = conn.prepareStatement(builder.toString());
			int counter = 1;
			if (eventSearchCriteria.getId() != null) {
				st.setInt(counter, eventSearchCriteria.getId());
				counter++;
			}

			if (eventSearchCriteria.getTitre() != null) {
				st.setString(counter, eventSearchCriteria.getTitre());
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
	//		if (eventSearchCriteria.getAdresse() != null) {
	//		st.setAdresse(counter, eventSearchCriteria.getAdresse());
	//	counter++;
	//}

			ResultSet RS = st.executeQuery();
			while (RS.next()) {
				Event event = new Event();
				event.setId(RS.getInt(1));
				event.setTitre(RS.getString(2));
				event.setDateDebut(RS.getDate(3));
				event.setDateFin(RS.getDate(4));

				Adresse adresse = new Adresse();
				adresse.setId(RS.getInt(5));
				event.setAdresse(adresse);

				list.add(event);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return list;
	}

}
