package fr.ib.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Supprimer {
	
	private static final String URL="jdbc:mysql://localhost:3306/db_test2_connexion?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	private static final String USERNAME="root";
	private static final String PASSWORD="root";
	
	
	public static void main(String[] args) {
	

		
		
	try {
		
        //////////////////SUPPRIMER UN ELEMENT DE LA TABLE :
		 
		   Class.forName("com.mysql.cj.jdbc.Driver");  //chargement driver
		
		   Connection cx= DriverManager.getConnection(URL, USERNAME, PASSWORD);  //on verifie la connexion
		String sql="DELETE FROM etudiants WHERE id=? ";
		
		PreparedStatement ps=cx.prepareStatement(sql);
		
		ps.setInt(1, 1);
		
		int verif =ps.executeUpdate();
		
		System.out.println(verif); 	
		
	}
      
	catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
	
	
	
	}

}
