package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import fr.diginamic.jdbc.entites.Bon;

public interface BonDao {
	List<Bon> extraire() throws SQLException;
	void insert(Bon bon)throws SQLException;
	int update(int delais)throws SQLException;
	boolean delete(Bon bon)throws SQLException;
	Bon extraireOne(Integer id) throws SQLException;

}