package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;

import fr.diginamic.jdbc.dao.impl.ArticleDaoImpl;
import fr.diginamic.jdbc.dao.impl.BonDaoImpl;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;

public class MenuUpdate {
	
	public static void menuupdate(String anciennom, String nouveaunom) throws SQLException {
	FournisseurDaoImpl f = new FournisseurDaoImpl();
		f.update(anciennom, nouveaunom);
		
	}
	
	public static void menuupdateart(String refe,  String newref, String design, double newprix) throws SQLException {
		ArticleDaoImpl a = new ArticleDaoImpl();
			a.update(refe, newref, design, newprix);
			
		}
	
	public static void menuupdateBon(int numBon, int newdelais) throws SQLException {
		BonDaoImpl a = new BonDaoImpl();
			a.update(numBon, newdelais);
			
		}
	
	public MenuUpdate() {
		// TODO Auto-generated constructor stub
	}

}
