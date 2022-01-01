package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.connection.ConnexionBdd;
import fr.diginamic.jdbc.dao.FournisseurDao;
import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.service.impl.MenuApp;

public class FournisseurDaoImpl extends MenuApp implements FournisseurDao {
	private Connection con;
	private Statement stm;

	/**
	 * CONNEXION
	 */
	public FournisseurDaoImpl() throws SQLException {
		con = ConnexionBdd.getConnection();
		if (con == null)
			throw new SQLException("connection inexistante");
	}

	/**
	 * DECONNEXION
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		if (con != null)
			con.close();
	}

	public List<Fournisseur> extraire() throws SQLException {

		/** REQUETE SQL */
		String sql = "SELECT ID,NOM FROM FOURNISSEUR";

		ArrayList<Fournisseur> listeFour = new ArrayList<>();

		try {
			this.stm = this.con.createStatement();

			ResultSet rs = this.stm.executeQuery(sql); // curseur

			while (rs.next()) {
				Fournisseur f = new Fournisseur(rs.getInt("ID"), rs.getString("NOM")); // obj de type fournisseur
				listeFour.add(f);

			}
			rs.close(); // je ferme le curseur
			return listeFour; // retourne la liste
		} finally {

			/** demande si il est null et si il ne l'est pas le fermer */
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
		}
	}

	public void insert(Fournisseur fournisseur) throws SQLException {
		/** REQUETE SQL */
		String sql = "INSERT INTO FOURNISSEUR (NOM) VALUES ('" + fournisseur.getNom() + "')";
		try {
			this.stm = this.con.createStatement();
			this.stm.executeUpdate(sql);
		} finally {
			if (this.stm != null && this.stm.isClosed())
				this.stm.close();
		}

	}

	public int update(String ancienNom, String nouveauNom) throws SQLException {
		/** REQUETE SQL */
		String sql = "UPDATE FOURNISSEUR SET NOM=  '" + nouveauNom + "' WHERE NOM='" + ancienNom + "'";

		try {
			this.stm = this.con.createStatement();
			return this.stm.executeUpdate(sql);
		} finally {
			if (this.stm != null && this.stm.isClosed())
				this.stm.close();
		}
	}

	public boolean delete(Fournisseur fournisseur) throws SQLException {

		String sql = "DELETE FROM FOURNISSEUR WHERE ID =" + fournisseur.getId();

		try {
			this.stm = this.con.createStatement();
			if (this.stm.executeUpdate(sql) > 0)
				return true;
		} finally {
			if (this.stm != null && this.stm.isClosed())
				this.stm.close();
		}
		return false;
	}

	
	@Override
	public Fournisseur extraireOne(Integer idFour) throws SQLException {
		/** REQUETE SQL */
		String sql = "SELECT ID,NOM FROM FOURNISSEUR WHERE ID=" + idFour;
		ResultSet rs= null;
		try {
			this.stm = this.con.createStatement();

			rs = this.stm.executeQuery(sql); // curseur

			if (rs.next()) {
				
				return new Fournisseur(rs.getInt("ID"), rs.getString("NOM")); // obj de type fournisseur

			}
			return null; // retourne le fournisseur
			
		} finally {

			/** demande si il est null et si il ne l'est pas le fermer */
			if(rs != null && !rs.isClosed()) rs.close();
			if (this.stm != null && !this.stm.isClosed()) this.stm.close();

		}
	}

}
