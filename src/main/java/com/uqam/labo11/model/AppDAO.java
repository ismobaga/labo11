package com.uqam.labo11.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AppDAO {
	private String url;
	private String user;
	private String password;

	public AppDAO() {
		url = "jdbc:mysql://localhost:3306/inf5190?serverTimezone=UTC";
		user = "root";
		password = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public static Connection conn() throws SQLException {
		return (new AppDAO()).getConnection();
	}

	public User getUser(String uname) {
		Connection conn;
		User u = null;
		try {
			conn = getConnection();
			PreparedStatement pstmnt = conn.prepareStatement("SELECT * FROM users WHERE username=?");
			pstmnt.setString(1, uname);

			ResultSet rs = pstmnt.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String role = rs.getString("role");
				u = new User(id, username, password, role);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}

	public List<User> getUsers() {

		Connection conn;
		List<User> users = new ArrayList<User>();

		try {
			conn = conn();

			Statement stmnt = conn.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT * FROM users");

			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String role = rs.getString("role");

				users.add(new User(id, username, password, role));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

}
