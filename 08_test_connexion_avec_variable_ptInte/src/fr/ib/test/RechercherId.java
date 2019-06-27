package fr.ib.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RechercherId {
	
	private static final String URL="jdbc:mysql://localhost:3306/db_test2_connexion?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	private static final String USERNAME="root";
	private static final String PASSWORD="root";

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cx=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String req="SELECT * FROM etudiants WHERE id=? ";
			
			PreparedStatement ps=cx.prepareStatement(req);
			
			ps.setInt(1, 2);
			
			ResultSet rs=ps.executeQuery();
			rs.next();
			
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("nom"));
			System.out.println(rs.getString("prenom"));
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
