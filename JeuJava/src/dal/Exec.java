package dal;

import dao.MonstreDAO;
import metier.Jeu;
import presentation.Monstre;


public class Exec {

	public static void main(String[] args) {
//		Jeu jeu = new Jeu(	Monstre monstre1,Monstre monstre2);
		MonstreDAO monstreDAO = new MonstreDAO();
		Jeu jeu = new Jeu();
//		Monstre monstre1 = new Monstre(1,"nomDuMob",0,54);
		
		//monstre.insert();
		//monstre.deleteById(1);
		monstreDAO.creerMonstre();
		jeu.finJeu();
		jeu.victoire();
	}

}
