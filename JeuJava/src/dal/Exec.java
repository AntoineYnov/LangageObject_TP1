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
		jeu.menu();
		monstre.select();
<<<<<<< HEAD
		jeu.choixMonstre();
		// jeu.finJeu();
		jeu.victoire();
=======
		jeu.random();
		jeu.finJeu();
		//jeu.victoire();
		//7jeu.attaque();
>>>>>>> 286c64e24c25c8fb2c543487325d7be9c1476ec5
	}

}
