package fr.ib.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ajout {
	
	private static final String URL="jdbc:mysql://localhost:3306/db_test2_connexion?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	private static final String USERNAME="root";
	private static final String PASSWORD="root";

	public static void main(String[] args) {
		
		//Etudiant e=new Etudiant();
		
		try {
			// chargement driver :
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//verif connexion:
			Connection cx=DriverManager.getConnection(URL, PASSWORD);
			
			//requete:
			String req1="insert into etudiants (nom,prenom) values (?,?)";
			
			//creation statement:
			PreparedStatement ps1=cx.prepareStatement(req1);
			
			//ps1.setInt(1, 2);
			ps1.setString(1, "tata");
			ps1.setString(2, "toto");
			
			//recuperer resultat:
			int verif2=ps1.executeUpdate();
			System.out.println(verif2);
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}

}
