package metier;

import presentation.Monstre;

public class Jeu {
	Monstre monstre1 = new Monstre(5,"Antoine",50,60);
	Monstre monstre2 = new Monstre(6,"Samory",50,60);
	


	boolean jeuEnCours=true;
	Jeu jeu;
	double random1 = 0;
	double random2 = 0;
	
//	public double random() {
//		random1 = Math.random()*100;
//		//System.out.println(multiplicateurAleatoire);
//		return random1;
//	}

	
	public boolean finJeu() {
		if (jeuEnCours==false) {
			System.out.println("-- Fin du jeu --");
			System.out.println("-- Fin du programme --");
		}
		return jeuEnCours;	
	}
	
	public void victoire() {
		if(monstre1.getPdvMonstre()<=0) {
			System.out.println("Victoire de "+monstre2.getNomMonstre()+" sur "+monstre1.getNomMonstre());
		}
		else if(monstre2.getPdvMonstre()<=0) {
			System.out.println("Victoire de "+monstre1.getNomMonstre()+" sur "+monstre2.getNomMonstre());
		}
		jeuEnCours=false;
	}	
	
	public void attaque() {
		
		while (monstre1.getPdvMonstre()>0 && monstre2.getPdvMonstre()>0) {
			random1 = Math.random()*100;
			random2 = Math.random()*100;
				if(monstre1.getForceMonstre()*random1 > monstre2.getForceMonstre()*random2){
				monstre2.setPdvMonstre(monstre2.getPdvMonstre()-10);
				System.out.println("Score de "+monstre1.getNomMonstre()+": "+monstre1.getForceMonstre()*random1+" Score de "+monstre2.getNomMonstre()+": "+monstre2.getForceMonstre()*random2);
				System.out.println(monstre2.getNomMonstre()+" perd 10 points de vie, il lui reste "+monstre2.getPdvMonstre()+" points de vie");
			}
			else if(monstre1.getForceMonstre()*random1 < monstre2.getForceMonstre()*random2) {
				monstre1.setPdvMonstre(monstre1.getPdvMonstre()-10);
				System.out.println("Score de "+monstre2.getNomMonstre()+": "+monstre2.getForceMonstre()*random2+" Score de "+monstre1.getNomMonstre()+": "+monstre1.getForceMonstre()*random1);
				System.out.println(monstre1.getNomMonstre()+" perd 10 points de vie, il lui reste "+monstre1.getPdvMonstre()+" points de vie");
			}
		}
	}
	public void menu ()
	{
		System.out.println("Bienvenue dans Monster-Battle");
		System.out.println("Veuillez choisir un monstre avec son numéro !");
	}
}

