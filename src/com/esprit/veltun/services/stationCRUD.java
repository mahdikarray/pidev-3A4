package com.esprit.veltun.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.esprit.veltun.interfaces.interfaceCRUDstation;
import com.esprit.veltun.model.Station;
import com.esprit.veltun.util.MyConnection;

public class stationCRUD implements interfaceCRUDstation {
	Statement ste;
	Connection conn = MyConnection.getInstance();

	@Override
	public void ajouterStation(Station s) {
		try {

			String req = "INSERT INTO `station` ( `nom_station` , `longitude`,`latitude`) VALUES ('" + s.getlongitude()
					+ "','" + s.getnom_station() + "','" + s.getlatitude() + "')";
			ste = conn.createStatement();
			ste.executeUpdate(req);
			System.out.println("Station ajouté!!!");
		} catch (SQLException ex) {
			System.out.println("Station non ajouté");
		}
	}

	@Override
	public void modifierStation(Station s) {
		try {

			String req = "UPDATE `station` SET `longitude` ='" + s.getlongitude() + "', `nom_station` = '"
					+ s.getnom_station() + "', `latitude=` = '" + s.getlatitude() + "' WHERE 'station'.'id'= "
					+ s.getid_station();
			Statement st = conn.createStatement();
			st.executeUpdate(req);
			System.out.println("Station updated !");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void supprimerStation(int id) {
		try {
			String req = "DELETE FROM `station` WHERE id = " + id;
			Statement st = conn.createStatement();
			st.executeUpdate(req);
			System.out.println("Station deleted !");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void ajouterStation2(Station s) {
		try {
			String req = "INSERT INTO `station` (`nom_station`,`longitude`,`latitude`) VALUES (?,?)";
			PreparedStatement ps = conn.prepareStatement(req);

			ps.setString(1, s.getnom_station());
			ps.executeUpdate();
			System.out.println("Station ajouté!!!");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 *
	 * @return
	 */
	@Override
	public List<Station> afficherStation() {
		List<Station> list = new ArrayList<>();
		try {
			String req = "Select * from station";
			Statement st = conn.createStatement();
			ResultSet RS = st.executeQuery(req);
			while (RS.next()) {
				Station s = new Station();
				s.setlongitude(RS.getDouble("longitude"));
				s.setlatitude(RS.getDouble("latitude"));
				s.setnom_station(RS.getString("nom_station"));
				s.setid_station(RS.getInt(00000001));
				list.add(s);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return list;
	}

}
