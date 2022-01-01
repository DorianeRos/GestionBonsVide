package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;

import fr.diginamic.jdbc.dao.impl.ArticleDaoImpl;
import fr.diginamic.jdbc.dao.impl.BonDaoImpl;
import fr.diginamic.jdbc.dao.impl.FournisseurDaoImpl;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Fournisseur;


public class MenuExtractOne {

	public MenuExtractOne() {
		// TODO Auto-generated constructor stub
	}

	public static Fournisseur menuextractone(int afficherfour) {
		
		 try{
				FournisseurDaoImpl f = new FournisseurDaoImpl();
				return f.extraireOne(afficherfour);
				
			 	} catch (SQLException e) {
					e.printStackTrace();
				}
		return null;
		}
	public static Article menuextractoneart(int afficherart) {
		
		 try{
				ArticleDaoImpl a = new ArticleDaoImpl();
				return a.extraireOne(afficherart);
				
			 	} catch (SQLException e) {
					e.printStackTrace();
				}
		return null;
		}
	
	public static Bon menuextractoneBon(int afficherbon) {
		
		 try{
				BonDaoImpl b = new BonDaoImpl();
				return b.extraireOne(afficherbon);
				
			 	} catch (SQLException e) {
					e.printStackTrace();
				}
		return null;
		}
	}


