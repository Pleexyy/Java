public class Film {
	private String titre;
	private int anneeSortie;
	private int duree;
	private String genre;
	
	public Film(String unTitre, int uneAnneeSortie, int uneDuree, String unGenre) {
		this.titre = unTitre;
		this.anneeSortie = uneAnneeSortie;
		this.duree = uneDuree;
		this.genre = unGenre;
	}

	public String versChaine() {
		// variables
		String chaine = "[-----Film-----]\nTitre : " + this.titre;
		if(this.anneeSortie != 0) {
			chaine += "\nAnn�e de sortie : " + this.anneeSortie;
		}
		if(this.duree != 0) {
			chaine += "\nDur�e du film : " + this.duree + " minutes";
		}
		if(this.genre != null) {
			chaine += "\nNationalit�e : " + this.genre;
		}
		chaine += "\n";
		return chaine;
	}
	
}
