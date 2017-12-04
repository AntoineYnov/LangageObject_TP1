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

		// connection a la base de données
		try {
			String DBurl = "jdbc:mysql://localhost:3306/bddjeujava";
			con = DriverManager.getConnection(DBurl, "root", "");
		} catch (SQLException e) {
			System.out.println("Connexion � la base de donn�es impossible");
		}
		return con;
	}
	
	
	//M�thode pour select *
	public Monstre creerMonstre() {
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
        
		System.out.println("Bienvenue dans Monster-Battle");
        System.out.println("Veuillez choisir un monstre avec son num�ro !");
		
        String requete2 = "SELECT * FROM MONSTRE;";
		
        System.out.println("Num�ro | Nom | PDV | Force");
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
			System.out.println("Anomalie lors de l'execution de la requ�te");
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
			System.out.println("Probl�me de SQL");
			e.printStackTrace();
		}
		Monstre monstre = new Monstre(id,nomMonstre,pvMonstre,forceMonstre);
		bddclose();
		
		return monstre;
	}
	
	//M�thode pour insert
	public void insert() {
		String requete3="INSERT INTO `monstre` (`nomMonstre`, `pdvMonstre`, `forceMonstre`) VALUES ('Noukeu', '200', '50');";
		Statement stmt = null;
		int insert =0;
		bddconnection();
		try {
		stmt = con.createStatement();
		insert = stmt.executeUpdate(requete3);
	} catch (SQLException e) {
		System.out.println("Anomalie lors de l'execution de la requ�te");
	}
		bddclose();
	}
	
	//M�thode pour getById
	public ResultSet getById(int id) {
		Statement stmt = null;
		ResultSet rs = null;
		String requete = "SELECT * FROM monstre WHERE id="+id+";";
		bddconnection();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(requete);
		} catch (SQLException e) {
			System.out.println("Anomalie lors de l'execution de la requ�te");
		}
		
//		try {
//
//			while (rs.next()) {
//				System.out.println("Num�ro | Nom | PDV | Force");
//				System.out.println(rs.getString("id")+" | "+rs.getString("nomMonstre")+" | "+rs.getString("pdvMonstre")+" | "+rs.getString("forceMonstre"));
//			}
//		} catch (SQLException e) {
//			System.out.println("Probl�me de SQL");
//		}
		bddclose();
		return rs;
	}
	
	
	//M�thode pour getByName where
	public ResultSet getByNameWhere(String nom) {
		Statement stmt = null;
		ResultSet rs = null;
		String requete = "SELECT * FROM monstre WHERE Nom='"+nom+"';";
		bddconnection();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(requete);
		} catch (SQLException e) {
			System.out.println("Anomalie lors de l'execution de la requ�te");
		}
		
		try {

			while (rs.next()) {
				System.out.println("Num�ro | Nom | PDV | Force");
				System.out.println(rs.getString("id")+" | "+rs.getString("nomMonstre")+" | "+rs.getString("pdvMonstre")+" | "+rs.getString("forceMonstre"));
			}
		} catch (SQLException e) {
			System.out.println("Probl�me de SQL");
		}
		bddclose();
		return rs;
	}
	
	
	
	// M�thode pour delete avec un id 
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
			System.out.println("Anomalie lors de l'execution de la requ�te");
		}
		bddclose();
		return rs;
	}
	
	
	
	
	private Connection bddclose() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Probl�me de fermeture de connexion");
		}
		return con;
	}
}
