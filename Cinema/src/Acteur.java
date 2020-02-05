public class Acteur {
	private String nom;
	private String prenom;
	private int anneeNaiss;
	private String nationalite;
	private Film leFilm;
	private Film lesFilms[];
	private int nbFilms;
	
	// Constructeur par d�faut
	
	public Acteur() {
		this.nbFilms = 0;
		this.lesFilms = new Film[10];
	}
	
	public Acteur(String unNom, String unPrenom, int uneAnneeNaiss, String uneNationalite,
			Film lesFilms[]) {
		this.nbFilms = 0;
		this.nom = unNom;
		this.prenom = unPrenom;
		this.anneeNaiss = uneAnneeNaiss;
		this.nationalite = uneNationalite;
		this.lesFilms = new Film[10];
	}
	
	public Acteur(String unNom, String unPrenom, int uneAnneeNaiss, String uneNationalite) {
		this.nbFilms = 0;
		this.nom = unNom;
		this.prenom = unPrenom;
		this.anneeNaiss = uneAnneeNaiss;
		this.nationalite = uneNationalite;
		this.lesFilms = new Film[10];
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
	
	public boolean rechercherFilm(String titre) {
		int i = 0;
		boolean flag = false;
		while (i < nbFilms && !titre.equals(this.lesFilms[i].getTitre())) {
			i++;
		}
		if (i < nbFilms) {
			flag = true;
		} 
	return flag;
	}
	
	public int rechercherIndex(String titre) {
			int i = 0;
			int index = 0;
			while (i < nbFilms && !titre.equals(this.lesFilms[i].getTitre())) {
				i++;
				index++;
			}
			if (i >= nbFilms) {
				index = -1;
			} 
		return index;
		}
	
	public String supprimer(String titre) {
		int rep = 0;
		
		if (i > nbFilms) {
			rep = -1;
		} else {
			for (int x = i; x < nbFilms; x++) {
				this.lesFilms[x] = this.lesFilms[x + 1];
			}
			
		}
		
		return rep;
		
		
	}
	

	public Film getUnFilm() {
		return this.leFilm;
	}
	
	public String toString() {
		String chaine = "[-----Acteur-----]\nNom : " + this.nom + 
						"\nPr�nom : " + this.prenom + 
						"\nAnn�e de naissance : " + this.anneeNaiss;
		if(this.nationalite != null) {
			chaine += "\n Cat�gorie : " + this.nationalite + "\n";
		}
		for(int i = 0; i < nbFilms; i++) {
			chaine += "\nFilm : " + this.lesFilms[i].versChaine();
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

//	public void setLeFilm(Film unFilm) {
//		this.leFilm = unFilm;
//	}
	
	public void ajouterLesFilms(Film unFilm) {
		this.lesFilms[nbFilms] = unFilm;
		nbFilms++;
	}
	
}
