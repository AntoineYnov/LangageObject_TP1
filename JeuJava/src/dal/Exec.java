package dal;

import dao.MonstreDAO;
import metier.Jeu;
import presentation.Monstre;

public class Exec {

	public static void main(String[] args) {
		MonstreDAO monstre = new MonstreDAO();
		Jeu jeu = new Jeu();
		Monstre monstre1 = new Monstre(1,"nomDuMob",0,54);
		
		//monstre.getById(1);
		//monstre.insert();
		//monstre.deleteById(1);
		monstre.select();
		jeu.finJeu();
		jeu.victoire();
	}

}
