package dal;

import dao.MonstreDAO;
import metier.Jeu;


public class Exec {

	public static void main(String[] args) {
		MonstreDAO monstreDAO = new MonstreDAO();
		Jeu jeu = new Jeu();
		jeu.menu();
		jeu.finJeu();
		jeu.victoire();
		jeu.random();
		jeu.finJeu();

	}

}
