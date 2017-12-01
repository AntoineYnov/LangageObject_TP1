package metier;

import presentation.Monstre;

public class Jeu {
	Monstre monstre1, monstre2;

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
		if(monstre1.getPdvMonstre()==0) {
			System.out.println("Victoire de "+monstre2.getNomMonstre()+"Le "+monstre1.getNomMonstre()+" est mort au combat");
		}
		else if(monstre2.getPdvMonstre()==0) {
			System.out.println("Victoire de "+monstre1.getNomMonstre()+"Le "+monstre2.getNomMonstre()+" est mort au combat");
		}
		jeuEnCours=false;
	}	
	public void menu ()
	{
		System.out.println("Bienvenue dans Monster-Battle");
		System.out.println("Veuillez choisir un monstre avec son numéro !");
	}
	
	public int combat (Monstre monstre1,Monstre monstre2) {
		return 0;	}
}

