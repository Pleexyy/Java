import java.io.*;

public class Personne implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom, prenom;
	private int dateNaissance;
	
	Personne(String nom, String prenom, int dateNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public int getDateNaissance() {
		return this.dateNaissance;
	}
	
}
