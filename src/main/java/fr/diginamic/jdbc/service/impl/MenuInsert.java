package fr.diginamic.jdbc.service.impl;


import java.sql.SQLException;
import java.time.LocalDateTime;
import fr.diginamic.jdbc.dao.impl.ArticleDaoImpl;
import fr.diginamic.jdbc.dao.impl.BonDaoImpl;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;
import fr.diginamic.jdbc.dao.impl.PromoDaoImpl;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.entites.Promo;

public class MenuInsert extends MenuApp {

	/**
	 * 
	 * INSERTION D'UN FOURNISSEUR
	 */
	public static void menuinsertfour(String input3) {

		try {
			FournisseurDaoImpl f = new FournisseurDaoImpl();
			f.insert(new Fournisseur(0, input3));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * INSERTION D'UN ARTICLE
	 */
	public static void menuInsertArt(String ref, String designation , double prix , int id_fou) throws SQLException {


			ArticleDaoImpl a = new ArticleDaoImpl();
			a.insert(new Article(0, ref, designation, prix, id_fou));

	}
	
	/**
	 * 
	 * INSERTION D'UN BON (problème avec la date)
	 */
	public static void menuInsertBon( int num, LocalDateTime today , int delais , int id_fou) throws SQLException {


		BonDaoImpl b = new BonDaoImpl();
		b.insert(new Bon(0, num, today, delais, id_fou));

}
	
	/**
	 * 
	 * INSERTION D'UN LIEN PROMO (Column count doesn't match value count at row 1)
	 */
	public static void menuInsertPromo(int numart, int numbon, int qte) throws SQLException {
		
			PromoDaoImpl p = new PromoDaoImpl();
			p.insert(new Promo(0, numart, numbon, qte));


}
	
	public MenuInsert() {
		// TODO Auto-generated constructor stub
	}

}
