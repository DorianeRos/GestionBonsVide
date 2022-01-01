package fr.diginamic.jdbc.dao;

import java.sql.SQLException;
import fr.diginamic.jdbc.entites.Promo;

public interface PromoDao {
	
	void insert(Promo promo) throws SQLException;

}
