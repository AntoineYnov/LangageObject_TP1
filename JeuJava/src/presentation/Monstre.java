package presentation;

public class Monstre {
	public int id;
	private String nomMonstre;
	public int pdvMonstre;
	public int forceMonstre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomMonstre() {
		return nomMonstre;
	}

	public void setNomMonstre(String nomMonstre) {
		this.nomMonstre = nomMonstre;
	}

	public int getPdvMonstre() {
		return pdvMonstre;
	}

	public void setPdvMonstre(int pdvMonstre) {
		this.pdvMonstre = pdvMonstre;
	}

	public int getForceMonstre() {
		return forceMonstre;
	}

	public void setForceMonstre(int forceMonstre) {
		this.forceMonstre = forceMonstre;
	}

	public Monstre(int mid, String mnom, int mpdv, int mforce) {
		id = mid;
	    nomMonstre = mnom;
	    pdvMonstre = mpdv;
	    forceMonstre = mforce;
	}
	
	public void afficherMonstre()
	{
		String nomDuMonstre = getNomMonstre();
		System.out.println(nomDuMonstre);
		Integer pvDuMonstre = getPdvMonstre();
		System.out.println(pvDuMonstre);
		Integer forceDuMonstre = getForceMonstre();
		System.out.println(forceDuMonstre);
	}

}
