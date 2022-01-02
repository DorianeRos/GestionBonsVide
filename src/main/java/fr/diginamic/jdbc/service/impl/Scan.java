package fr.diginamic.jdbc.service.impl;
import java.io.InputStream;
import java.util.Scanner;

public class Scan {

	public Scan(InputStream in) {
		// TODO Auto-generated constructor stub
	}



	public static String ScanLauch() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        // Affiche "Ecrire un nombre: "
        System.out.println("Ecrire un nombre : ");

        //Lit l'entier écrit par l'utilisateur et l'affecte 
        // à  la variable nombre du programme
        String nombre = scanner.nextLine();
        // Affiche le nombre saisit par l'utilisateur
       
		return nombre;		
	}

	
	public static String ScanLauchOne() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        //Lit l'entier écrit par l'utilisateur et l'affecte 
        // à  la variable nombre du programme
        String nombre = scanner.nextLine();
        // Affiche le nombre saisit par l'utilisateur
       
		return nombre;		
	}
	

	
	public static int ScanLauchInt() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        //Lit l'entier écrit par l'utilisateur et l'affecte 
        // à  la variable nombre du programme
        int nombre = scanner.nextInt();
        // Affiche le nombre saisit par l'utilisateur
		return nombre;
       
			
	}
	
	public static double ScanLauchDouble() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        //Lit l'entier écrit par l'utilisateur et l'affecte 
        // à  la variable nombre du programme
        double nombre = scanner.nextInt();
        // Affiche le nombre saisit par l'utilisateur
		return nombre;
}}
