public class Acteur {
	private String nom;
	private String prenom;
	private int anneeNaiss;
	private String nationalite;
	private Film leFilm;
	
	// Constructeur par défaut
	
	public Acteur(String unNom, String unPrenom, int uneAnneeNaiss, String uneNationalite) {
		this.nom = unNom;
		this.prenom = unPrenom;
		this.anneeNaiss = uneAnneeNaiss;
		this.nationalite = uneNationalite;
	}
	
	// getter
	
	public String getNom() {
		return this.nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public int getAnneeNaiss() {
		return this.anneeNaiss;
	}
	
	public String getNationalite() {
		return this.nationalite;
	}
	
	public Film getUnFilm() {
		return this.leFilm;
	}
	
//	private String makeLogin() {
//		String res = this.prenom.substring(0, 1) + this.nom;
//		return res.toLowerCase();
//	}
	
	public String toString() {
		String chaine = "[-----Acteur-----]\nNom : " + this.nom + 
						"\nPrénom : " + this.prenom + 
						"\nAnnée de naissance : " + this.anneeNaiss;
		if(this.nationalite != null) {
			chaine += "\nNationalité : " + this.nationalite + "\n";
		}
		if(this.leFilm != null) {
			chaine += "\nFilm : " + this.leFilm.versChaine();
		}
		chaine += "\n";
		return chaine;
	}
	
	// setter
	
	public void setNom(String unNom) {
		this.nom = unNom;
	}
	
	public void setPrenom(String unPrenom) {
		this.prenom = unPrenom;
	}
	
	public void setAnneeNaiss(int uneAnneeNaiss) {
		this.anneeNaiss = uneAnneeNaiss;
	}
	
	public void setNationalite(String uneNationalite) {
		this.nationalite = uneNationalite;
	}

	public void setLeFilm(Film unFilm) {
		this.leFilm = unFilm;
	}
	
	
}
