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
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.AdresseSearchCriteria;
import com.esprit.veltun.services.AdresseService;
import com.esprit.veltun.util.MyConnection;

public class AdresseServiceImpl implements AdresseService {

	@Override
	public Adresse findById(Integer id) {
		try {
			Connection conn = MyConnection.getInstance();
			String req = "SELECT * FROM `adresse` WHERE id = " + id;
			Statement st = conn.createStatement();
			ResultSet RS = st.executeQuery(req);
			while (RS.next()) {
				Adresse adresse = new Adresse();
				adresse.setId(RS.getInt(1));
				adresse.setRue(RS.getString(2));
				adresse.setRegion(RS.getString(3));
				adresse.setLongitude(RS.getDouble(4));
				adresse.setLatitude(RS.getDouble(5));
				System.out.println("Adresse founded");
		
				return adresse;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public Collection<Adresse> list() {
		List<Adresse> list = new ArrayList<>();
		try {
			Connection conn = MyConnection.getInstance();
			String req = "Select * from adresse";
			Statement st = conn.createStatement();
			ResultSet RS = st.executeQuery(req);
			while (RS.next()) {
				Adresse adresse = new Adresse();
				adresse.setId(RS.getInt(1));
				adresse.setRue(RS.getString(2));
				adresse.setRegion(RS.getString(3));
				adresse.setLongitude(RS.getDouble(4));
				adresse.setLatitude(RS.getDouble(5));
				list.add(adresse);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}

	@Override
	public Adresse save(Adresse adresse) {

		try {
			Connection conn = MyConnection.getInstance();
			String req = "INSERT INTO `adresse`( `rue`, `region`, `longitude`,`latitude` ) VALUES (?,?,?,?);";
			
			PreparedStatement pst = conn.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, adresse.getRue());
			pst.setString(2, adresse.getRegion());
			pst.setDouble(3, adresse.getLongitude());
			pst.setDouble(4, adresse.getLatitude());

			pst.execute();
			ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                adresse.setId(generatedKeys.getInt(1));
            }
			System.out.println("Adresse ajouté!!!");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return adresse;
	}

	@Override
	public Adresse update(Adresse adresse) {
		try {
			Connection conn = MyConnection.getInstance();
			String req1 = "UPDATE `adresse` set `rue` =?, `region``=?,`longitude`=?,`latitude`=? WHERE id = ?";

			PreparedStatement pst = conn.prepareStatement(req1);
			pst.setString(1, adresse.getRue());
			pst.setString(2, adresse.getRegion());
			pst.setDouble(3, adresse.getLongitude());
			pst.setDouble(4, adresse.getLatitude());
			pst.setInt(5, adresse.getId());

			pst.executeUpdate(req1);
			System.out.println("invitation updated !");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return adresse;
	}

	@Override
	public boolean remove(Integer id) {
		try {
			Connection conn = MyConnection.getInstance();
			String req = "DELETE FROM `adresse` WHERE id = " + id;
			Statement st = conn.createStatement();
			st.executeUpdate(req);
			System.out.println("adresse deleted !");
			return true;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	@Override
	public Collection<Adresse> search(SearchCriteria<Adresse> searchCriteria) {
		List<Adresse> list = new ArrayList<>();
		try {
			AdresseSearchCriteria adresseSearchCriteria = (AdresseSearchCriteria) searchCriteria;
			Connection conn = MyConnection.getInstance();

			StringBuilder builder = new StringBuilder("SELECT * FROM `adresse`");
			StringBuilder whereBuilder = new StringBuilder();

			if (adresseSearchCriteria.getId() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" AND `id`=?");
				} else {
					whereBuilder.append(" WHERE `id`=?");
				}
			}

			if (adresseSearchCriteria.getRue() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" AND `rue`=?");
				} else {
					whereBuilder.append(" WHERE `rue`=?");
				}
			}
			if (adresseSearchCriteria.getRegion() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" AND `region`=?");
				} else {
					whereBuilder.append(" WHERE `region`=?");
				}
			}
			if (adresseSearchCriteria.getLongitude() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" AND `longitude`=?");
				} else {
					whereBuilder.append(" WHERE `longitude`=?");
				}
			}
			if (adresseSearchCriteria.getLatitude() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" AND `latitude`=?");
				} else {
					whereBuilder.append(" WHERE `latitude`=?");
				}
			}
			builder.append(whereBuilder);

			PreparedStatement st = conn.prepareStatement(builder.toString());
			int counter = 1;
			if (adresseSearchCriteria.getId() != null) {
				st.setInt(counter, adresseSearchCriteria.getId());
				counter++;
			}

			if (adresseSearchCriteria.getRue() != null) {
				st.setString(counter, adresseSearchCriteria.getRue());
				counter++;
			}
			if (adresseSearchCriteria.getRegion() != null) {
				st.setString(counter, adresseSearchCriteria.getRegion());
				counter++;
			}
			if (adresseSearchCriteria.getLongitude() != null) {
				st.setDouble(counter, adresseSearchCriteria.getLongitude());
				counter++;
			}
			if (adresseSearchCriteria.getLatitude() != null) {
				st.setDouble(counter, adresseSearchCriteria.getLatitude());
				counter++;
			}

			ResultSet RS = st.executeQuery();
			while (RS.next()) {
				Adresse adresse = new Adresse();
				adresse.setId(RS.getInt(1));
				adresse.setRue(RS.getString(2));
				adresse.setRegion(RS.getString(3));
				adresse.setLongitude(RS.getDouble(4));
				adresse.setLatitude(RS.getDouble(5));

				list.add(adresse);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return list;
	}

}
