package dal;

import dao.MonstreDAO;
import metier.Jeu;

public class Exec {

	public static void main(String[] args) {
		Jeu jeu = new Jeu(	Monstre monstre1,Monstre monstre2);
		MonstreDAO monstre = new MonstreDAO();
		
//		monstre.select();
//		monstre.getById(1);
		monstre.insert();

	}

}
