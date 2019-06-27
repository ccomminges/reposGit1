package fr.ib.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AfficherListe {
	
	private static final String URL="jdbc:mysql://localhost:3306/db_test2_connexion?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	private static final String USERNAME="root";
	private static final String PASSWORD="root";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection cx=DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String req="SELECT * FROM etudiants";
			
			PreparedStatement ps= cx.prepareStatement(req);
			
			ResultSet rs=ps.executeQuery();
			
			
			while(rs.next())
			{
				
				System.out.println("id="+rs.getInt("id")+" nom="+rs.getString("nom")+" prenom="+rs.getString("prenom")+"");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
