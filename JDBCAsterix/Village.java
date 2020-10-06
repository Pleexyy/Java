public class Village {
	
	private String nomVillage;
	private int nbHab;
	private int nbHutte;
	
	public Village(String nom, int nbHab,int nbHutte) {
		this.nomVillage = nom;
		this.nbHab = nbHab;
		this.nbHutte = nbHutte;
	}
	
	public String getNomVillage() {
		return this.nomVillage;
	}
	
	public int getNbHab() {
		return this.nbHab;
	}
	
	public int getNbHutte() {
		return this.nbHutte;
	}
	
	
	
}
