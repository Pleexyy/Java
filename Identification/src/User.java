public class User {
	private String nom;
	private String login;
	private String motPasse;
	
	public User(String unNom, String unLogin, String unMotdePasse) {
		this.nom = unNom;
		this.login = unLogin;
		this.motPasse = unMotdePasse;
	}

	public String getNom() {
		return this.nom;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public String getMotdePasse() {
		return this.motPasse;
	}
	
	public String toString() {
		return this.nom + " " + this.login + " " + this.motPasse;
	}
	
}
