package fr.diginamic.jdbc.entites;

public class Promo {
private int id;
private int id_art;
private int id_bon;
private int qte;


	public Promo(int id, int id_art, int id_bon, int qte) {
		super();
	this.id = id;
	this.id_art = id_art;
	this.id_bon = id_bon;
	this.qte = qte;
}
	public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getId_art() {
	return id_art;
}

public void setId_art(int id_art) {
	this.id_art = id_art;
}

public int getId_bon() {
	return id_bon;
}

public void setId_bon(int id_bon) {
	this.id_bon = id_bon;
}

public int getQte() {
	return qte;
}

public void setQte(int qte) {
	this.qte = qte;
}



	public Promo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Promo [id=" + id + ", id_art=" + id_art + ", id_bon=" + id_bon + ", qte=" + qte + "]";
	}

}
