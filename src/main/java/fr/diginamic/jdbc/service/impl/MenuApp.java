package fr.diginamic.jdbc.service.impl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Fournisseur;

public class MenuApp {
	private static String four = "fournisseur";
	private static String art = "article";
	private static String bon = "bon";
	private static String promo = "promo";


	public static void DisplayMenu() throws SQLException {
		System.out.println(" ------------------------------ ");
		System.out.println(" GESTION BASE DE DONNEES COMPTA ");
		System.out.println(" ------------------------------ ");
		System.out.println(" -------------MENU------------- ");
		System.out.println(" ------------------------------ ");
		System.out.println(" 1- Gérer Fournisseurs ");
		System.out.println(" 2- Gérer Articles ");
		System.out.println(" 3- Gérer Bons ");
		System.out.println(" 4- Créer lien Promos ");
		System.out.println(" ------------------------------ ");
		
		String input = Scan.ScanLauch();

		switch (input) {
		case "1":
			System.out.println(" ------------------------------------- ");
			System.out.println(" GESTION BASE DE LA TABLE FOURNISSEURS ");
			System.out.println(" ------------------------------------- ");
			System.out.println(" -----------------MENU---------------- ");
			System.out.println(" ------------------------------------- ");
			System.out.println(" 1- Créer un " + four);
			System.out.println(" 2- Modifier un " + four);
			System.out.println(" 3- Supprimer un " + four);
			System.out.println(" 4- Liste complète des " + four + "s");
			System.out.println(" 5- Visualisation d'un " + four);
			System.out.println(" ------------------------------------- ");
			System.out.println(" 6- Menu principal" );
			
		input = Scan.ScanLauch();
			
			/** 
			 * FOURNISSEURS
			 * 
			 */
			
			switch (input) {
			
			case "1": /** INSERTION d'un nouveau fournisseur */
				
				System.out.println("Nom du nouveau fournisseur : ");
				String input3 = Scan.ScanLauchOne();
				MenuInsert.menuinsertfour(input3);
				System.out.println("Le nouveau fournisseur Ã  bien Ã©tÃ© crÃ©Ã© !");	
				MenuApp.DisplayMenu();
			
			case "2": /** 	MODIFICATION d'un fournisseur */
			
				System.out.println("Nom du fournisseur Ã  modifier : ");
				String anciennom = Scan.ScanLauchOne();
				System.out.println("Nouveau nom du fournisseur : ");
				String nouveaunom = Scan.ScanLauch();
				MenuUpdate.menuupdate(anciennom, nouveaunom);
				System.out.println("La modification Ã  bien Ã©tÃ© effectuÃ©e !");				
				MenuApp.DisplayMenu();
				
	
			case "3": /** SUPPRESSION d'un fournisseur */
				
				System.out.println("Nom du fournisseur a  supprimer : ");
				String deletenomfour = Scan.ScanLauchOne();
				System.out.println("ID du fournisseur a  supprimer : ");
				int deleteidfour = Scan.ScanLauchInt();
				MenuDelete.menudelete(deleteidfour,deletenomfour);
				System.out.println("La suppression a  bien été effectuée !");				
				MenuApp.DisplayMenu();
				
			case "4": /** AFFICHAGE des fournisseurs */
				
				List<Fournisseur> listefour = MenuExtract.menuextract();
				System.out.println(listefour);
				MenuApp.DisplayMenu();
				

			case "5": /** AFFICHAGE d'un seul fournisseur */
				
				System.out.println("ID du fournisseur a  afficher : ");
				int afficherfour = Scan.ScanLauchInt();
				Fournisseur f = MenuExtractOne.menuextractone(afficherfour);
				System.out.println(f);
				MenuApp.DisplayMenu();
				
				
			case "6" : /** retour au MENU PRINCIPAL */
			default:
				System.out.println("erreur de saisie ! ");
				input = Scan.ScanLauch();
				MenuApp.DisplayMenu();
			}
			
		}
		
		/** 
		 * ARTICLES
		 * 
		 */
		switch (input) {
		case "2":
			System.out.println(" ------------------------------------- ");
			System.out.println(" --GESTION BASE DE LA TABLE ARTICLES-- ");
			System.out.println(" ------------------------------------- ");
			System.out.println(" -----------------MENU---------------- ");
			System.out.println(" ------------------------------------- ");
			System.out.println(" 1- Créer un " + art);
			System.out.println(" 2- Modifier un " + art);
			System.out.println(" 3- Supprimer un " + art);
			System.out.println(" 4- Liste complète des " + art + "s");
			System.out.println(" 5- Visualisation d'un " + art);
			System.out.println(" ------------------------------------- ");
			System.out.println(" 6- Menu principal" );
			input = Scan.ScanLauch();
			
			
			switch (input) {
			
			case "1": /** INSERTION d'un nouvel article */
				
				System.out.println("REFERENCE : ");
				String ref = Scan.ScanLauchOne();
				System.out.println("DESIGNATION : ");
				String designation = Scan.ScanLauchOne();
				System.out.println("PRIX : ");
				Double prix = Double.parseDouble(Scan.ScanLauchOne());
				System.out.println("ID FOURNISSEUR : ");
				int id_fou = Scan.ScanLauchInt();
				
				MenuInsert.menuInsertArt(ref,designation,prix,id_fou);
				System.out.println("Le nouveau fournisseur a bien été créé !");	
				MenuApp.DisplayMenu();
				
				
				
			case "2": /** 	MODIFICATION d'un article */
			
				System.out.println("Référence de l'article a  modifier : ");
				String refe = Scan.ScanLauchOne();
				System.out.println("Nouvelle REF de l'article : ");
				String newref = Scan.ScanLauchOne();
				System.out.println("Nouvelle designation de l'article : ");
				String design = Scan.ScanLauchOne();
				System.out.println("Nouveau prix de l'article : ");
				double newprix = Scan.ScanLauchDouble();
				MenuUpdate.menuupdateart(refe, newref, design, newprix);
				System.out.println("La modification a  bien été effectuée !");				
				MenuApp.DisplayMenu();
				
				
				
			case "3": /** SUPPRESSION d'un article */
				
				System.out.println("REF de l'article a  supprimer : ");
				String deleterefart = Scan.ScanLauchOne();
				MenuDelete.menudeleteart(deleterefart);
				System.out.println("La suppression a  bien été effectuée !");				
				MenuApp.DisplayMenu();
				
				
				
			case "4": /** AFFICHAGE des Articles */
				
				List<Article> listeart = MenuExtract.menuextractart();
				System.out.println(listeart);
				MenuApp.DisplayMenu();
				
				
				
			case "5": /** AFFICHAGE d'un seul article */
				
				System.out.println("Designation de l'article a afficher : ");
				String afficherart = Scan.ScanLauchOne();
				Article a = MenuExtractOne.menuextractoneart(afficherart);
				System.out.println(a);
				MenuApp.DisplayMenu();
				
			case "6":/** retour au MENU PRINCIPAL */
			default:
				System.out.println("erreur de saisie ! ");
				input = Scan.ScanLauch();
				MenuApp.DisplayMenu();
			}
		}

		switch (input) {
		case "3":
			System.out.println(" ------------------------------------- ");
			System.out.println(" ----GESTION BASE DE LA TABLE BONS---- ");
			System.out.println(" ------------------------------------- ");
			System.out.println(" -----------------MENU---------------- ");
			System.out.println(" ------------------------------------- ");
			System.out.println(" 1- Créer un " + bon);
			System.out.println(" 2- Modifier un " + bon);
			System.out.println(" 3- Supprimer un " + bon);
			System.out.println(" 4- Liste complète des " + bon + "s");
			System.out.println(" 5- Visualisation d'un " + bon);
			System.out.println(" ------------------------------------- ");
			System.out.println(" 6- Menu principal" );
			input = Scan.ScanLauch();
			
			
			switch (input) {
			
			
			case "1": /** INSERTION d'un nouveau bon */
				
				// PROBLEME D'INSERTION DU BON (DATE ??)
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDateTime today = LocalDateTime.now();
				
				
				System.out.println(today);
				System.out.println("NUMERO : ");
				int num = Scan.ScanLauchInt();
				
				System.out.println("DELAIS : ");
				int delais = Scan.ScanLauchInt();
				System.out.println("ID FOURNISSEUR : ");
				int id_fou = Scan.ScanLauchInt();
				
				MenuInsert.menuInsertBon(num, today , delais , id_fou);
				System.out.println("Le nouveau bon a bien été créé !");	
				
				MenuApp.DisplayMenu();
				
				
			case "2": /** 	MODIFICATION d'un BON */
			
				System.out.println("Numéro du bon a été modifier : ");
				int numBon = Scan.ScanLauchInt();
				System.out.println("Nouveau delais : ");
				int newdelais = Scan.ScanLauchInt();
				MenuUpdate.menuupdateBon(numBon, newdelais);
				System.out.println("La modification a  bien été effectuée !");				
				MenuApp.DisplayMenu();
				
				
			case "3": /** SUPPRESSION d'un BON */
				
				System.out.println("NUMERO du bon a supprimer : ");
				int numBonSupp = Scan.ScanLauchInt();
				MenuDelete.menuDeleteBon(numBonSupp);
				System.out.println("La suppression a bien été effectuée !");				
				MenuApp.DisplayMenu();
				
				
				
			case "4":/** AFFICHAGE des Bons */
				
				List<Bon> listebon = MenuExtract.menuextractbon();
				System.out.println(listebon);
				MenuApp.DisplayMenu();
				
				
				
			case "5":/** AFFICHAGE d'un seul bon */
				
				System.out.println("Numéro du bon a afficher : ");
				int afficherbon = Scan.ScanLauchInt();
				Bon b = MenuExtractOne.menuextractoneBon(afficherbon);
				System.out.println(b);
				MenuApp.DisplayMenu();
				
				
				
				
			case "6":
			default:
				System.out.println("erreur de saisie ! ");
				input = Scan.ScanLauch();
				MenuApp.DisplayMenu();
			}
		}
		switch (input) {
		case "4":
			
			
			
			/** CREATION D'UN LIEN PROMO 
			*/
			
			
			
			
			System.out.println("Numero de l'article : ");
			int numart = Scan.ScanLauchInt();
			System.out.println("Numéro du bon : ");
			int numbon = Scan.ScanLauchInt();
			System.out.println("Quantité : ");
			int qte = Scan.ScanLauchInt();
			
			MenuInsert.menuInsertPromo(numart,numbon,qte);
			System.out.println("Le nouveau lien promo a bien été créé !");	
			MenuApp.DisplayMenu();
			
			
		case "6":
			default:
				System.out.println("erreur de saisie ! ");
				input = Scan.ScanLauch();
				MenuApp.DisplayMenu();
			}
		
		switch (input) {
		default:
			System.out.println("erreur de saisie ! ");
			input = Scan.ScanLauch();
			MenuApp.DisplayMenu();
		}
		

	}

}
