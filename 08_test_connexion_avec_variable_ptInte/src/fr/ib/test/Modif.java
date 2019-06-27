package fr.ib.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Modif {
	
	private static final String URL="jdbc:mysql://localhost:3306/db_test2_connexion?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	private static final String USERNAME="root";
	private static final String PASSWORD="root";
	
	public static void main(String[] args) {
		// chargement driver :
		try {
			// chargement driver :
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//connexion verif :
			Connection cx=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			//requetes 
			String req3="UPDATE etudiants SET nom=? , prenom=? WHERE id=?";
			
			//creation statement :
			PreparedStatement ps= cx.prepareStatement(req3);
			
			ps.setString(1, "gogo" );
			ps.setString(2, "gege");
			ps.setInt(3, 2);
			
			
			//recuperer resultat :
			int verif4=ps.executeUpdate();
			
			System.out.println(verif4);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
