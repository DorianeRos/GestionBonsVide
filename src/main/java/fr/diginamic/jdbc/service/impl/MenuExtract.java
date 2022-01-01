package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.dao.impl.ArticleDaoImpl;
import fr.diginamic.jdbc.dao.impl.BonDaoImpl;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Fournisseur;
public class MenuExtract extends MenuApp{

	public static List<Fournisseur> menuextract() throws SQLException {

			// TODO Auto-generated method stub
			 try{
				 FournisseurDaoImpl listefour = new FournisseurDaoImpl();
					return listefour.extraire() ;
					
				 	} catch (SQLException e) {
						e.printStackTrace();
					}
			return null;
			
		
	}
	public static List<Article> menuextractart() throws SQLException {

		// TODO Auto-generated method stub

			 ArticleDaoImpl listeart = new ArticleDaoImpl();
				return listeart.extraire() ;
}
	
	public static List<Bon> menuextractbon() throws SQLException {

		// TODO Auto-generated method stub

			 BonDaoImpl listebon = new BonDaoImpl();
				return listebon.extraire() ;
}

	
	public MenuExtract() {
		// TODO Auto-generated constructor stub
		
	}
	


}
