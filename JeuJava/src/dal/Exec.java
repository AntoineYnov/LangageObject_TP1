package dal;

import dao.MonstreDAO;
import metier.Jeu;


public class Exec {

	public static void main(String[] args) {
//		Jeu jeu = new Jeu(	Monstre monstre1,Monstre monstre2);
		MonstreDAO monstre = new MonstreDAO();
		Jeu jeu = new Jeu();

		

		jeu.menu();
		//monstre.getById(2);
		//monstre.insert();
		//monstre.deleteById(1);
		monstre.select();
		jeu.attaque();
		jeu.victoire();
		jeu.finJeu();
	}

}
