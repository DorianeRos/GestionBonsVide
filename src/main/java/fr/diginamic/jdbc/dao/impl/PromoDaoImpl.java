package fr.diginamic.jdbc.dao.impl;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import fr.diginamic.jdbc.connection.ConnexionBdd;
import fr.diginamic.jdbc.dao.PromoDao;
import fr.diginamic.jdbc.entites.Promo;
import fr.diginamic.jdbc.service.impl.MenuApp;

public class PromoDaoImpl extends MenuApp implements PromoDao {
	private Connection con;
	private Statement stm;

	/**
	 * CONNEXION
	 */
	public PromoDaoImpl() throws SQLException {
		con = ConnexionBdd.getConnection();
		if (con == null)
			throw new SQLException("connection inexistante");
	}

	/**
	 * DECONNEXION
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		if (con != null)
			con.close();
	}


	public void insert(Promo promo) throws SQLException {
		/** REQUETE SQL */
		
		
		String sql = "INSERT INTO COMPO (ID_ART, ID_BON, QTE) VALUES (" + promo.getId_art() + ", " + promo.getId_bon()+ ", " + promo.getQte() + ")";

		try {
			this.stm = this.con.createStatement();
			this.stm.executeUpdate(sql);
		} finally {
			if (this.stm != null && this.stm.isClosed())
				this.stm.close();
		}

	}

	/*
	 * public List<Promo> extraire() throws SQLException {
	 * 
	 * ArrayList<Promo> list = new ArrayList<Promo>(); PreparedStatement extraire =
	 * con.prepareStatement("SELECT ID, ID_ART, ID_BON, QTE FROM COMPO"); Array
	 * array = con.createArrayOf("INT", list.toArray()); extraire.setArray(1,
	 * array); ResultSet rs = extraire.executeQuery(); return list;
	 * 
	 * }
	 * 
	 * @Override public int update(int id, int qte) throws SQLException {
	 * PreparedStatement update = con.prepareStatement
	 * ("UPDATE COMPO SET QTE = ? WHERE ID = ? "); update.setInt(1, qte);
	 * update.setInt(2, id); return update.executeUpdate();
	 * 
	 * }
	 * 
	 * 
	 * @Override public Promo extraireOne(Integer id) throws SQLException { // TODO
	 * Auto-generated method stub
	 * 
	 * PreparedStatement fiche = con.
	 * prepareStatement("SELECT ID, NUMERO, DATE_CMDE, DELAI, ID_FOU fROM BON WHERE ID = ?"
	 * ); fiche.setInt(1, id); ResultSet rs = fiche.executeQuery(); return (Promo)
	 * rs;
	 * 
	 * }
	 * 
	 * @Override public boolean delete(Promo compo) throws SQLException { // TODO
	 * Auto-generated method stub PreparedStatement delete =
	 * con.prepareStatement("DELETE FROM COMPO WHERE ID = ? ");
	 * delete.setInt(compo.getId(), compo.getId()); return false; }
	 */

}
