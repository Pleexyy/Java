
/**
 * @author tpuissant
 *
 */
public class Acteur {
	
	
	//Attributs 
	
	private String prenom;
	private String nom;
	private int anneeNaiss;
	private String nationalite;
	private Film lesFilms[];
	private int nbFilms;
	
	
	
	//Constructeurs
	
	public Acteur(){
		
		this.lesFilms = new Film[20];
		this.nbFilms = 0;
		
		
	}
	
	/**
	 * Constructeur de l'objet Acteur
	 * @param unNom : Le nom de l'acteur.
	 * @param unPrenom : Son prénom.
	 * @param uneAnneeNaiss : Son année de naissance.
	 * @param uneNationalite : Sa nationalité.
	 */
	public Acteur(String unPrenom, String unNom, int uneAnneeNaiss, String uneNationalite){
		
		this.prenom = unPrenom;
		this.nom = unNom;
		this.anneeNaiss = uneAnneeNaiss;
		this.nationalite = uneNationalite;
		this.lesFilms = new Film[20];
		this.nbFilms = 0;
		
	}
	
	/**
	 * Constructeur de l'objet Acteur
	 * @param unNom : Le nom de l'acteur.
	 * @param unPrenom : Son prénom.
	 * @param uneAnneeNaiss : Son année de naissance.
	 * @param uneNationalite : Sa nationalité.
	 * @param lesFilms : les films dans lequel il a joué.
	 */
	public Acteur(String unPrenom, String unNom, int uneAnneeNaiss, String uneNationalite, Film lesFilms){
		
		this.prenom = unPrenom;
		this.nom = unNom;
		this.anneeNaiss = uneAnneeNaiss;
		this.nationalite = uneNationalite;
		//this.leFilm = unFilm;
		this.lesFilms = new Film[20];
		this.nbFilms = 0;
		
	}
	
	//Getters & Setters
	
	/**
	 * Getter de l'attribut prenom
	 * @return Le Prenom de l'acteur.
	 */
	public String getPrenom() {
		return this.prenom;
	}
	
	/**
	 * Setter de l'attribut prenom
	 */
	public void setPrenom(String unPrenom) {
		this.prenom = unPrenom;
	}
	
	/**
	 * Getter de l'attribut nom
	 * @return Le nom de l'acteur.
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Setter de l'attribut nom
	 */
	public void setNom(String unNom) {
		this.nom = unNom;
	}
	
	/**
	 * Getter de l'attribut anneeNaiss
	 * @return L'annee de naissance de l'acteur.
	 */
	public int getAnneeNaiss() {
		return this.anneeNaiss;
	}
	
	/**
	 * Setter de l'attribut anneeNaiss
	 */
	public void setAnneeNaiss(int uneAnneeNaiss) {
		this.anneeNaiss = uneAnneeNaiss;
	}
	
	/**
	 * Getter de l'attribut nationalite
	 * @return La nationalite de l'acteur.
	 */
	public String getNationalite() {
		return this.nationalite;
	}
	
	/**
	 * Setter de l'attribut nationalite
	 */
	public void setNationalite(String uneNationalite) {
		this.nationalite = uneNationalite;
	}
	
	/*public Film getLeFilm(){
		return this.leFilm;
	}
	
	public void setLeFilm(Film unFilm){
		this.leFilm = unFilm;
	}*/
	
	/**
	 * Getter de l'attribut nationalite
	 * @return La nationalite de l'acteur.
	 */
	public void ajouterUnFilm(Film unFilm){
		this.lesFilms[nbFilms] = unFilm;
		this.nbFilms++;
	}
	
	
	/**
	 * recherhcerUnFilm()
	 * @return un booléen qui contient true ou false si le film est dans le tableau ou non.
	 */
	/*public boolean rechercherUnFilm(String unTitre){
		boolean rep = false;
		int i = 0;
		
		while(i < this.nbFilms && !this.lesFilms[i].getTitre().toLowerCase().equals(unTitre.toLowerCase())){
			i++;
		}
		if(i < this.nbFilms)
			rep = true;
		
		return rep;
	}*/
	
	/**
	 * rechercherUnFilm()
	 * @return un entier qui contient la place du film dans le tableau
	 */
	public int rechercherUnFilm(String unTitre){
		int i = 0;
		
		while(i < this.nbFilms && !this.lesFilms[i].getTitre().toLowerCase().equals(unTitre.toLowerCase())){
			i++;
		}
		if(i < this.nbFilms)
			return i;
		else
			return 404;
	}
	
	/**
	 * supprimerUnFilm()
	 * @return un booléen true si un film a été supprimé
	 */
	public boolean supprimerUnFilm(String unTitre){
		boolean rep = false;
		/*int i = 0;
		while(i < this.nbFilms && !this.lesFilms[i].getTitre().toLowerCase().equals(unTitre.toLowerCase())){
			i++;
		}*/
		int i = this.rechercherUnFilm(unTitre);
		if (i == 404)
			rep = false;
		else
			if (i != 19){	
				for(int j = i ; j < this.nbFilms; j++){
					this.lesFilms[j] = this.lesFilms[j+1];
			
				}
			}
			this.nbFilms--;
			rep = true;
		return rep;
		
	}
	
	/**
	 * toString()
	 * @return Une chaine de caractères qui contient le contenu des attributs.
	 */
	public String toString() {
		String chaine = "[-----Acteur-----]\nNom : " + this.nom + 
						"\nPrénom : " + this.prenom + 
						"\nAnnée de naissance : " + this.anneeNaiss;
		if(this.nationalite != null) {
			chaine += "\nNationalité : " + this.nationalite;
		}
		for(int i = 0; i < nbFilms; i++){
			chaine += "\n" + this.lesFilms[i].versChaine()+ "\n";
		}
		
		chaine += "\nNombre de film joué" + this.nbFilms;
		
		return chaine;
	}
	

}
