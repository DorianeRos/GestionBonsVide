package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.diginamic.jdbc.connection.ConnexionBdd;
import fr.diginamic.jdbc.dao.BonDao;
import fr.diginamic.jdbc.entites.Bon;

public class BonDaoImpl implements BonDao {
	private Connection con;
	private Statement stm;

	/**
	 * CONNEXION
	 */
	public BonDaoImpl() throws SQLException {
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

	public List<Bon> extraire() throws SQLException {
		/** REQUETE SQL */
		String sql = "SELECT ID,NUMERO, DATE_CMDE, DELAI, ID_FOU FROM BON";

		ArrayList<Bon> listebon = new ArrayList<>();

		try {
			this.stm = this.con.createStatement();

			ResultSet rs = this.stm.executeQuery(sql); // curseur

			while (rs.next()) {
				Bon b = new Bon(rs.getInt("ID"), rs.getInt("NUMERO"), rs.getDate("DATE_CMDE"), rs.getInt("DELAI"),
						rs.getInt("ID_FOU")); // obj de type fournisseur
				listebon.add(b);
			}
			rs.close(); // je ferme le curseur
			return listebon; // retourne la liste
		} finally {
			/** demande si il est null et si il ne l'est pas le fermer */
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}

		}
	}

	public void insert(Bon bon) throws SQLException {
		/** REQUETE SQL */
		String sql = "INSERT INTO BON (ID, NUMERO, DATE_CMDE, DELAI, ID_FOU) VALUES (" + bon.getNum()
				+ " " + bon.getToday() + " " + bon.getDelais() + " " + bon.getId_fou2() + ")";
		try {
			this.stm = this.con.createStatement();
			this.stm.executeUpdate(sql);
		} finally {
			if (this.stm != null && this.stm.isClosed())
				this.stm.close();
		}

	}

	public int update(int anciennumero, int nouveaudelai) throws SQLException {
		/** REQUETE SQL */
		String sql = "UPDATE BON SET DELAI =  '" + nouveaudelai + "' " + "		WHERE NUMERO='" + anciennumero + "'";

		try {
			this.stm = this.con.createStatement();
			return this.stm.executeUpdate(sql);
		} finally {
			if (this.stm != null && this.stm.isClosed())
				this.stm.close();
		}

	}

	public boolean delete(Bon bon) throws SQLException {
		String sql = "DELETE FROM BON WHERE NUMERO =" + bon.getNumero();

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
	public Bon extraireOne(Integer id) throws SQLException {
		/** REQUETE SQL */
		String sql = "SELECT ID, NUMERO, DATE_CMDE, DELAI, ID_FOU FROM BON WHERE ID=" + id;
		
		ResultSet rs = null;
		try {
			this.stm = this.con.createStatement();

			rs = this.stm.executeQuery(sql); // curseur

			if (rs.next()) {

				return new Bon(rs.getInt("ID"), rs.getInt("NUMERO"), rs.getDate("DATE_CMDE"), rs.getInt("DELAI"),
						rs.getInt("ID_FOU")); // obj de type bon

			}
			return null; // retourne la liste

		} finally {

			/** demande si il est null et si il ne l'est pas le fermer */
			if (rs != null && !rs.isClosed())
				rs.close();
			if (this.stm != null && !this.stm.isClosed())
				this.stm.close();

		}
	}

	@Override
	public int update(int delais) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
