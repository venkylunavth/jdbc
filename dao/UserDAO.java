package com.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecom.model.User;

public class UserDAO {
	private Connection con;

	public UserDAO() {
		con = DBConnection.getConnection();
	}

	public String login(String email, String password) {
		try {
			String query = "select name from user where email=? and password=?";

			PreparedStatement ps;
			ps = con.prepareStatement(query);

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next() == true) {
				return rs.getString(1);
			} else {
				return null;
			}

		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	public boolean register(User u) {
		try {
			String query = "insert into user (name,email,password,mobile) values (?,?,?,?)";

			PreparedStatement ps;
			ps = con.prepareStatement(query);

			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			ps.setInt(4, u.getMobile());
			
			int n = ps.executeUpdate();
			if(n==0)
				return false;
			else
				return true;
			
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}
}
