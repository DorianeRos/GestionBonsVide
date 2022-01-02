package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Article;


public interface ArticleDao {
	List<Article> extraire() throws SQLException;
	Article extraireOne(String designation)throws SQLException;
	void insert(Article article) throws SQLException;
	int update(int id, String ref, String designation, double prix);
	boolean delete(Article article) throws SQLException;


}