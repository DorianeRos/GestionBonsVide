package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;

import fr.diginamic.jdbc.dao.impl.ArticleDaoImpl;
import fr.diginamic.jdbc.dao.impl.BonDaoImpl;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Fournisseur;

public class MenuDelete {
	public static void menudelete(int deleteidfour, String deletenomfour) throws SQLException {
		FournisseurDaoImpl f = new FournisseurDaoImpl();
			f.delete(new Fournisseur(deleteidfour, deletenomfour ));
			
		}
	
	public static void menudeleteart(String deleterefart) throws SQLException {
		ArticleDaoImpl a = new ArticleDaoImpl();
		Article art = new Article();
        art.setRef(deleterefart);
        a.delete(art);
			
		}
	
	public static void menuDeleteBon (int deletenumbon) throws SQLException {
		BonDaoImpl b = new BonDaoImpl();
		Bon bon = new Bon();
        bon.setNumero(deletenumbon);
        b.delete(bon);
			
		}
	public MenuDelete() {
		// TODO Auto-generated constructor stub
	}

}
