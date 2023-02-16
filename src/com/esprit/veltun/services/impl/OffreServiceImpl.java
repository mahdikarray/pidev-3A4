package com.esprit.veltun.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.esprit.veltun.model.Abonnement;
import com.esprit.veltun.model.Offre;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.services.OffreService;
import com.esprit.veltun.util.MyConnection;

public class OffreServiceImpl implements OffreService {

	@Override
	public Offre findById(Integer id) {
		try {
			Connection conn = MyConnection.getInstance();
			String req = "SELECT * FROM `offre` WHERE Id_offre = " + id;
			Statement st = conn.createStatement();
			ResultSet RS = st.executeQuery(req);
			while (RS.next()) {
				Offre s = new Offre();
				s.setPrix(RS.getFloat("Prix"));
				s.setId_offre(RS.getInt(1));

				System.out.println("offre founded");
				return s;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public Collection<Offre> list() {

		List<Offre> list = new ArrayList<>();
		try {
			Connection conn = MyConnection.getInstance();
			Statement ste;
			String req = "Select * from Offre";
			Statement st = conn.createStatement();

			ResultSet RS = st.executeQuery(req);
			while (RS.next()) {
				Offre s = new Offre();
				s.setPrix(RS.getFloat("Prix"));
				s.setId_offre(RS.getInt(1));
				list.add(s);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return list;

	}

	@Override
	public Offre save(Offre s) {
		try {
			Connection conn = MyConnection.getInstance();
			String req = "INSERT INTO `offre` ( `Prix`) VALUES (?)";
			PreparedStatement ps = conn.prepareStatement(req);
			ps.setInt(1, s.getId_offre());
			ps.setFloat(1, s.getPrix());

			Integer id = ps.executeUpdate();
			s.setId(id);
			System.out.println("Offre ajouté!!!");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return s;

	}

	@Override
	public Offre update(Offre s) {
		try {
			Connection conn = MyConnection.getInstance();
			String req = "UPDATE `offre` SET `Prix` = '" + s.getPrix() + "' WHERE `offre`.`Id_offre` ="
					+ s.getId_offre();
			Statement st = conn.createStatement();
			st.executeUpdate(req);
			System.out.println("Offre updated !");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public boolean remove(Integer id) {
		try {
			Connection conn = MyConnection.getInstance();
			String req = "DELETE FROM `offre` WHERE Id_offre = " + id;
			Statement st = conn.createStatement();
			st.executeUpdate(req);
			System.out.println("Offre deleted !");
			return true;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}

	}

	@Override
	public Collection<Offre> search(SearchCriteria<Offre> searchCriteria) {
		return null;
	}

}