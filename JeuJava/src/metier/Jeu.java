package metier;

import dao.MonstreDAO;
import presentation.Monstre;

public class Jeu {
	MonstreDAO monstre = new MonstreDAO();
	Monstre monstre2;

	boolean jeuEnCours=true;
	Jeu jeu;
	
	public boolean finJeu() {
		if (jeuEnCours==false) {
			System.out.println("-- Fin du jeu --");
			System.out.println("-- Fin du programme --");
		}
		return jeuEnCours;	
	}
	
	public void victoire() {
		Monstre monstre1 = monstre.creerMonstre();
		Monstre monstre2 = monstre.creerMonstre();
		System.out.println(monstre1.getNomMonstre());
		System.out.println(monstre2.getNomMonstre());
		if(monstre1.getPdvMonstre()==0) {
			System.out.println("Victoire de "+monstre2.getNomMonstre()+"Le "+monstre1.getNomMonstre()+" est mort au combat");
		}
		else if(monstre2.getPdvMonstre()==0) {
			System.out.println("Victoire de "+monstre1.getNomMonstre()+"Le "+monstre2.getNomMonstre()+" est mort au combat");
		}
		jeuEnCours=false;
	}
	public int combat (Monstre monstre1,Monstre monstre2) {
		return 0;	}
}

