package fr.diginamic.jdbc.entites;

public class Fournisseur {
	private int id;
	private String Nom;

	public Fournisseur(int id, String nom) {
		super();
		this.id = id;
		Nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", Nom=" + Nom + "]\n";
	}
}
