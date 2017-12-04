package dal;

import dao.MonstreDAO;
import metier.Jeu;


public class Exec {

	public static void main(String[] args) {
		
//		Insertion de monstre a optimiser
		MonstreDAO monstreDAO = new MonstreDAO();
		monstreDAO.insert();
		Jeu jeu = new Jeu();

		jeu.attaque();
		jeu.victoire();
		jeu.finJeu();


	}

}
