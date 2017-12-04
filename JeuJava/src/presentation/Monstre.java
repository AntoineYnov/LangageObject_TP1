package presentation;

public class Monstre {
	public Integer id;
	private String nomMonstre;
	public int pdvMonstre;
	public int forceMonstre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Monstre(Integer mid, String mnom, int mpdv, int mforce) {
		id = mid;
	    nomMonstre = mnom;
	    pdvMonstre = mpdv;
	    forceMonstre = mforce;
	}

	public Monstre() {
		// TODO Auto-generated constructor stub
	}
}
