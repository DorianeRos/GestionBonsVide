package fr.diginamic.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * A compléter avec l'utilisation de databa.properties
 * @author chris
 *
 */
public class ConnexionBdd {


	public static Connection getConnection() {
		return ConnexionBdd.getConnection("database");
	}
	
	public static Connection getConnection(String database) {
		try {
			ResourceBundle cont = ResourceBundle.getBundle(database);
			String url = cont.getString("database.url");
			String driver = cont.getString("database.driver");

			String user = cont.getString("database.user");
			String mtp = cont.getString("database.password");
	
			/**
			 * Une première connexion à une BDD
			 */
			Class.forName(driver);
	        return DriverManager.getConnection(url,user,mtp);
		}
		catch(SQLException ex) {
			System.err.println("Erreur SQL : "+ex.getMessage());
		}
		catch(Exception ex) {
			System.err.println("Autres erreurs  : "+ex.getMessage());
		}

			return null;

	}
}