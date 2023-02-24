package com.esprit.veltun.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.esprit.veltun.model.User;
import com.esprit.veltun.services.UserService;
import com.esprit.veltun.search.base.dto.SearchCriteria;
import com.esprit.veltun.search.dto.UserSearchCriteria;
import com.esprit.veltun.util.MyConnection;

public class UserServiceImpl implements UserService {

	@Override
	public User save(User u) {

		try {
		    Connection conn = MyConnection.getInstance();
			String req = "INSERT INTO `user`( `CIN`,`nom`, `prenom`, `date_naiss`, "
					+ "`type`, `code_postal`, `email` ) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(req);
			ps.setString(1, u.getCIN());
			ps.setString(2, u.getNom());
			ps.setString(3, u.getPrenom());
			ps.setDate(4, u.getDateNaiss());
			ps.setString(5, u.getType());
			ps.setInt(6, u.getCodePos());
			ps.setString(7, u.getEmail());
			Integer id = ps.executeUpdate();
			u.setId(id);
			System.out.println("user ajouté!!!");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return u;
	}

	@Override
	public User update(User u) {
		try {
		    Connection conn = MyConnection.getInstance();
		    Statement ste;
		    
			String req = "UPDATE `user` SET `nom` = '" + u.getNom() + "', `prenom` = '" + u.getPrenom() + "'"
					+ ", `date_naiss` = '" + u.getDateNaiss() + "'" + ", `type` = '" + u.getType() + "'"
					+ ", `code_postal` = '" + u.getCodePos() + "'" + ", `email` = '" + u.getEmail() + "'"
					+ " WHERE `user`.`CIN` LIKE " + u.getCIN();
			Statement st = conn.createStatement();
			st.executeUpdate(req);
			System.out.println("user updated !");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return u;
	}

	@Override
	public boolean remove(Integer id) {
		try {
		    Connection conn = MyConnection.getInstance();
			String req = "DELETE FROM `user` WHERE id = " + id;
			Statement st = conn.createStatement();
			st.executeUpdate(req);
			System.out.println("Personne deleted !");
			return true;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}


	@Override
	public boolean remove(String cin) {
		try {
			Connection conn = MyConnection.getInstance();
			String req = "DELETE FROM `user` WHERE cin LIKE " + cin;
			Statement st = conn.createStatement();
			st.executeUpdate(req);
			System.out.println("User deleted !");
			return true;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	@Override
	public User findByCin(String cin) {
		User u=new User();
		try {
			Connection conn=MyConnection.getInstance();
			String req = "SELECT * FROM `user` WHERE cin LIKE " + cin;
			Statement st= conn.createStatement();
			ResultSet RS = st.executeQuery(req);
			while (RS.next()) {
				u.setCIN(RS.getString(1));
				u.setNom(RS.getString(2));
				u.setPrenom(RS.getString(3));
				u.setDateNaiss(RS.getDate(4));
				u.setType(RS.getString(5));
				u.setCodePos(RS.getInt(6));
				u.setEmail(RS.getString(7));
			}

			return u;
		}
		catch (SQLException ex){
			System.out.println(ex.getMessage());
		}
		return null;
	}


	@Override
	public List<User> list() {
		List<User> list = new ArrayList<>();
		try {
		    Connection conn = MyConnection.getInstance();
		    Statement ste;
			String req = "Select * from user";
			Statement st = conn.createStatement();

			ResultSet RS = st.executeQuery(req);
			while (RS.next()) {
				User u = new User();

				u.setCIN(RS.getString(1));
				u.setNom(RS.getString(2));
				u.setPrenom(RS.getString(3));
				u.setDateNaiss(RS.getDate(4));
				u.setType(RS.getString(5));
				u.setCodePos(RS.getInt(6));
				u.setEmail(RS.getString(7));
				list.add(u);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return list;
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<User> search(SearchCriteria<User> searchCriteria) {
		List<User> list = new ArrayList<>();
		try {
			UserSearchCriteria userSearchCriteria = (UserSearchCriteria) searchCriteria;
			Connection conn = MyConnection.getInstance();

			StringBuilder builder = new StringBuilder("Select * from user");
			StringBuilder whereBuilder = new StringBuilder();

			if (userSearchCriteria.getCin() != null && !userSearchCriteria.getCin().isEmpty()) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" OR cin = ?");

				} else {
					whereBuilder.append(" WHERE cin = ?");
				}
			}



			if (userSearchCriteria.getNom() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" OR nom = ?");

				} else {
					whereBuilder.append(" WHERE nom = ?");
				}
			}


			if (userSearchCriteria.getPrenom() != null) {
				if (!whereBuilder.toString().isEmpty()) {
					whereBuilder.append(" OR prenom = ?");

				} else {
					whereBuilder.append(" WHERE prenom = ?");
				}
			}
			builder.append(whereBuilder);



			PreparedStatement st = conn.prepareStatement(builder.toString());
			int counter = 1;
			if (userSearchCriteria.getCin() != null && !userSearchCriteria.getCin().isEmpty()) {
					st.setString(counter, userSearchCriteria.getCin());
				counter++;
			}

			if (userSearchCriteria.getNom() != null) {
				st.setString(counter, userSearchCriteria.getNom());
				counter++;
			}

			if (userSearchCriteria.getPrenom() != null) {
				st.setString(counter, userSearchCriteria.getPrenom());
			}

			ResultSet RS = st.executeQuery();
			while (RS.next()) {
				User u = new User();


				u.setCIN(RS.getString(1));
				u.setNom(RS.getString(2));
				u.setPrenom(RS.getString(3));
				u.setDateNaiss(RS.getDate(4));
				u.setType(RS.getString(5));
				u.setCodePos(RS.getInt(6));
				u.setEmail(RS.getString(7));

				list.add(u);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return list;
	}



}
