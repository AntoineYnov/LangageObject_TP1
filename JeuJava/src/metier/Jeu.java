package metier;

import presentation.Monstre;

public class Jeu {
	Monstre monstre1, monstre2;
	boolean jeu=true;
	
	public Jeu(Monstre monstre1,Monstre monstre2) {
		this.monstre1=monstre1;
		this.monstre1=monstre2;
	}
	public int combat (Monstre monstre1,Monstre monstre2) {
		return 0;
	}
	
	public void menu ()
	{
		System.out.println("Bienvenue dans Monster-Battle");
		System.out.println("Veuillez choisir un monstre avec son num�ro !");
	}
	
}
