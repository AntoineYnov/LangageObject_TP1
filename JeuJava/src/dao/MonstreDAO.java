package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import presentation.Monstre;

public class MonstreDAO {
	Monstre monstre;
	Connection con = null;
	private Connection bddconnection() {
		 //Enregistrement en BDD
		 //chargement du pilote
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Impossible de charger le pilote ");
		}

		// connection a la base de donnÃ©es
		try {
			String DBurl = "jdbc:mysql://localhost:3306/bddjeujava";
			con = DriverManager.getConnection(DBurl, "root", "");
		} catch (SQLException e) {
			System.out.println("Connexion à la base de données impossible");
		}
		return con;
	}
	
	
	//Méthode pour select *
	public void select() {
		Statement stmt = null;
		ResultSet rs = null;
		String requete = "SELECT * FROM MONSTRE";
		bddconnection();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(requete);
		} catch (SQLException e) {
			System.out.println("Anomalie lors de l'execution de la requète");
		}
		Integer idParseInt = 0;
		String nomMonstre = null;
		Integer pvMonstre = null;
		Integer forceMonstre = null;
		
		try {

			while (rs.next()) {
			// System.out.println(rs.getString("nomMonstre")+" | "+rs.getString("pdvMonstre")+" | "+rs.getString("forceMonstre"));
			String id	= rs.getString("id");
			idParseInt = Integer.parseInt(id);
			nomMonstre = rs.getString("nomMonstre");
			String pv = rs.getString("pdvmonstre");
			pvMonstre = Integer.parseInt(pv);
			String force = rs.getString("forcemonstre");
			forceMonstre = Integer.parseInt(force);

				//System.out.println(rs.getString("id"));

			Monstre sam = new Monstre(idParseInt, nomMonstre, pvMonstre, forceMonstre);
			sam.afficherMonstre();
			/*	System.out.println(rs.getString("id"));
				System.out.println(rs.getString("nomMonstre"));
				System.out.println(rs.getString("pdvMonstre"));
				System.out.println(rs.getString("forceMonstre"));*/
			}
		} catch (SQLException e) {
			System.out.println("Problème de SQL");
		}
		
		bddclose();
		

		Monstre monstre1 = new Monstre(idParseInt, nomMonstre, pvMonstre, forceMonstre);
		//monstre1.afficherMonstre();

	}
	
	//Méthode pour insert
	public void insert() {
		String requete3="INSERT INTO `monstre` (`nomMonstre`, `pdvMonstre`, `forceMonstre`) VALUES ('Noukeu', '200', '50');";
		Statement stmt = null;
		int insert =0;
		bddconnection();
		try {
		stmt = con.createStatement();
		insert = stmt.executeUpdate(requete3);
	} catch (SQLException e) {
		System.out.println("Anomalie lors de l'execution de la requète");
	}
		bddclose();
	}
	
	//Méthode pour getById
	public ResultSet getById(int id) {
		Statement stmt = null;
		ResultSet rs = null;
		String requete = "SELECT * FROM monstre WHERE id="+id+";";
		bddconnection();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(requete);
		} catch (SQLException e) {
			System.out.println("Anomalie lors de l'execution de la requète");
		}
		
		try {

			while (rs.next()) {
				System.out.println(rs.getString("nomMonstre")+" | "+rs.getString("pdvMonstre")+" | "+rs.getString("forceMonstre"));
			}
		} catch (SQLException e) {
			System.out.println("Problème de SQL");
		}
		bddclose();
		return rs;
	}
	
	
	//Méthode pour getByName where
	public ResultSet getByNameWhere(String nom) {
		Statement stmt = null;
		ResultSet rs = null;
		String requete = "SELECT * FROM monstre WHERE Nom='"+nom+"';";
		bddconnection();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(requete);
		} catch (SQLException e) {
			System.out.println("Anomalie lors de l'execution de la requète");
		}
		
		try {

			while (rs.next()) {
				System.out.println(rs.getString("nomMonstre")+" | "+rs.getString("pdvMonstre")+" | "+rs.getString("forceMonstre"));
			}
		} catch (SQLException e) {
			System.out.println("Problème de SQL");
		}
		bddclose();
		return rs;
	}
	
	
	
	// Méthode pour delete avec un id 
	public ResultSet deleteById(int id) {
		//Partie pour le delete
		Statement stmt = null;
		ResultSet rs = null;
		int delete=0;
		String requete = "delete FROM monstre WHERE ID="+id+";";
		bddconnection();
		try {
			stmt = con.createStatement();
			delete = stmt.executeUpdate(requete);
		} catch (SQLException e) {
			System.out.println("Anomalie lors de l'execution de la requète");
		}
		bddclose();
		return rs;
	}
	
	
	
	
	private Connection bddclose() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Problème de fermeture de connexion");
		}
		return con;
	}
}
