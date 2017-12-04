package dal;

import metier.Jeu;


public class Exec {

	public static void main(String[] args) {
		
//		Insertion de monstre a optimiser
		Jeu jeu = new Jeu();

		jeu.attaque();
		jeu.victoire();
		jeu.finJeu();


	}

}
