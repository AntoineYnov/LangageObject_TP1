package metier;

import presentation.Monstre;

public class Jeu {
	Monstre monstre1, monstre2;

	boolean jeuEnCours=true;
	Jeu jeu;
	double multiplicateurAleatoire = 0;
	
	public double random() {
		multiplicateurAleatoire = Math.random()*100;
		System.out.println(multiplicateurAleatoire);
		return multiplicateurAleatoire;
	}
	
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
	
	public void attaque() {
		if(monstre1.getForceMonstre()*multiplicateurAleatoire > monstre2.getForceMonstre()*multiplicateurAleatoire){
			monstre2.setPdvMonstre(monstre2.getPdvMonstre()-10);
		}
		else if(monstre1.getForceMonstre()*multiplicateurAleatoire < monstre2.getForceMonstre()*multiplicateurAleatoire) {
			monstre1.setPdvMonstre(monstre1.getPdvMonstre()-10);
		}
	}
	public void menu ()
	{
		System.out.println("Bienvenue dans Monster-Battle");
		System.out.println("Veuillez choisir un monstre avec son numéro !");
	}
}

