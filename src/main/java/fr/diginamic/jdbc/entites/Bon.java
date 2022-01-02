package fr.diginamic.jdbc.entites;

import java.sql.Date;
import java.time.LocalDateTime;



public class Bon {
private int id;
private int numero;
private Date dateCmd;
private int delai;
private int id_fou;
private int id2;
private int num;
private LocalDateTime today;
private int delais;
private int id_fou2;



public Bon(int id, int numero, Date date, int delai, int id_fou) {
	super();
	this.id = id;
	this.numero = numero;
	this.dateCmd = date;
	this.delai = delai;
	this.id_fou = id_fou;
}
public Bon() {
	// TODO Auto-generated constructor stub
}
public Bon(int id2, int num, LocalDateTime today, int delais, int id_fou2) {
	// TODO Auto-generated constructor stub
	this.id2 = id2;
	this.num = num;
	this.today = today;
	this.delais = delais;
	this.id_fou2 = id_fou2;
}
public int getId() {
	return id;
}
public int getId2() {
	return id2;
}
public void setId2(int id2) {
	this.id2 = id2;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public LocalDateTime getToday() {
	return today;
}
public void setToday(LocalDateTime today) {
	this.today = today;
}
public int getDelais() {
	return delais;
}
public void setDelais(int delais) {
	this.delais = delais;
}
public int getId_fou2() {
	return id_fou2;
}
public void setId_fou2(int id_fou2) {
	this.id_fou2 = id_fou2;
}
public void setId(int id) {
	this.id = id;
}
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public Date getDateCmd() {
	return dateCmd;
}
public void setDateCmd(Date dateCmd) {
	this.dateCmd = dateCmd;
}
public int getDelai() {
	return delai;
}
public void setDelai(int delai) {
	this.delai = delai;
}

public int getId_fou() {
	return id_fou;
}
public void setId_fou(int id_fou) {
	this.id_fou = id_fou;
}
@Override
public String toString() {
	return "Bon " + id + ", numero : " + numero + ", date commande : " + dateCmd + ", delai : " + delai + ", id fournisseur : " + id_fou
			+ "]\n";
}



}
