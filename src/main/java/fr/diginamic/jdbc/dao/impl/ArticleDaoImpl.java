package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.connection.ConnexionBdd;
import fr.diginamic.jdbc.dao.ArticleDao;
import fr.diginamic.jdbc.entites.Article;


public class ArticleDaoImpl implements ArticleDao {

	private Connection con;
	private Statement stm;

/**
 * CONNEXION
 */
public ArticleDaoImpl() throws SQLException {
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

	public List<Article> extraire() throws SQLException {

		/** REQUETE SQL */
		String sql = "SELECT ID, REF, DESIGNATION, PRIX, ID_FOU FROM ARTICLE";

		ArrayList<Article> listeArticle = new ArrayList<>();

		try {
			this.stm = this.con.createStatement();

			ResultSet rs = this.stm.executeQuery(sql); // curseur

			while (rs.next()) {
				Article art = new Article(rs.getInt("ID"), rs.getString("REF"), rs.getString("DESIGNATION"), rs.getDouble("PRIX"),rs.getInt("ID_FOU")); // obj de type fournisseur
				listeArticle.add(art);

			}
			rs.close(); // je ferme le curseur
			return listeArticle; // retourne la liste
		} finally {

			/** demande si il est null et si il ne l'est pas le fermer */
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
		}
	}
	

	public void insert(Article article)throws SQLException {
		/** REQUETE SQL */
		 String sql = "INSERT INTO ARTICLE (REF, DESIGNATION, PRIX, ID_FOU) VALUES ('" + article.getRef()+"','" + article.getDesignation()+"','" + article.getPrix()+"','" +  article.getId_fou() + "')";

		try {
			this.stm = this.con.createStatement();
			this.stm.executeUpdate(sql);
			
		} finally {
			if (this.stm != null && this.stm.isClosed())
				this.stm.close();
		}
	}

	public int update(String ref, String newRef, String newdesign,
						double nouveauPrix) throws SQLException{
		/** REQUETE SQL */
		String sql = "UPDATE ARTICLE SET REF= '" + newRef + "',DESIGNATION= '" + newdesign + "',PRIX = '" + nouveauPrix  +"' WHERE REF ='" + ref + "'";

		try {
			this.stm = this.con.createStatement();
			return this.stm.executeUpdate(sql);
		} finally {
			if (this.stm != null && this.stm.isClosed())
				this.stm.close();
		}
	}

	public boolean delete(Article article) throws SQLException {

		String sql = "DELETE FROM ARTICLE WHERE REF =" + article.getRef();

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
	public Article extraireOne(Integer id) throws SQLException {
		/** REQUETE SQL */
		String sql = "SELECT ID, REF, DESIGNATION, PRIX, ID_FOU FROM ARTICLE WHERE ID=" + id;
		ResultSet rs= null;
		try {
			this.stm = this.con.createStatement();

			rs = this.stm.executeQuery(sql); // curseur

			if (rs.next()) {
				
				return new Article(rs.getInt("ID"), rs.getString("REF"), rs.getString("DESIGNATION"),rs.getDouble("PRIX"), rs.getInt("ID_FOU")); // obj de type fournisseur

			}
			return null; // retourne la liste
			
		} finally {

			/** demande si il est null et si il ne l'est pas le fermer */
			if(rs != null && !rs.isClosed()) rs.close();
			if (this.stm != null && !this.stm.isClosed()) this.stm.close();

		}
	}

	@Override
	public int update(int id, String ref, String designation, double prix) {
		// TODO Auto-generated method stub
		return 0;
	}	
	
	
}
