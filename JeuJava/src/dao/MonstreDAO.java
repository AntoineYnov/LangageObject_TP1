package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import presentation.Monstre;

public class MonstreDAO {
	Connection con = null;
	Scanner demande = new Scanner(System.in);
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
	public Monstre creerMonstre() {
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
        
		System.out.println("Bienvenue dans Monster-Battle");
        System.out.println("Veuillez choisir un monstre avec son numéro !");
		
        String requete2 = "SELECT * FROM MONSTRE;";
		
        System.out.println("Numéro | Nom | PDV | Force");
		try {
			stmt = bddconnection().createStatement();
			rs2 = stmt.executeQuery(requete2);
			while (rs2.next()) {
				System.out.println(rs2.getString("id")+" | "+rs2.getString("nomMonstre")+" | "+rs2.getString("pdvMonstre")+" | "+rs2.getString("forceMonstre"));
			}

		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		

		
		// Ne comprends pas l'erreur SQL.
		
		String demandeIdentifiation = demande.nextLine();
		Integer test = Integer.parseInt(demandeIdentifiation);
		String requete = "SELECT * FROM MONSTRE WHERE id="+test+";";
		
		
		
		try {
			stmt = bddconnection().createStatement();
			rs = stmt.executeQuery(requete);
		} catch (SQLException e) {
			System.out.println("Anomalie lors de l'execution de la requète");
		}
		int id = 0;
		String nomMonstre = null;
		int pvMonstre = 0;
		int forceMonstre = 0;
		
		try {
			rs.next();
			id = rs.getInt("id"); // ICI QUE SA PLANTE
			nomMonstre = rs.getString("nomMonstre");
			pvMonstre = rs.getInt("pdvMonstre");
			forceMonstre = rs.getInt("forceMonstre");
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("nomMonstre"));
				System.out.println(rs.getInt("pdvMonstre"));
				System.out.println(rs.getInt("forceMonstre"));
		} catch (SQLException e) {
			System.out.println("Problème de SQL");
			e.printStackTrace();
		}
		Monstre monstre = new Monstre(id,nomMonstre,pvMonstre,forceMonstre);
		bddclose();
		
		return monstre;
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
		
//		try {
//
//			while (rs.next()) {
//				System.out.println("Numéro | Nom | PDV | Force");
//				System.out.println(rs.getString("id")+" | "+rs.getString("nomMonstre")+" | "+rs.getString("pdvMonstre")+" | "+rs.getString("forceMonstre"));
//			}
//		} catch (SQLException e) {
//			System.out.println("Problème de SQL");
//		}
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
				System.out.println("Numéro | Nom | PDV | Force");
				System.out.println(rs.getString("id")+" | "+rs.getString("nomMonstre")+" | "+rs.getString("pdvMonstre")+" | "+rs.getString("forceMonstre"));
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
