import java.util.ArrayList;

public class Application {
	private String nom;
	private int version;
	private ArrayList <User> lesUsers;
	private Environnement sonEnvironnement;


	public Application(String unNom, int uneVersion, Environnement unEnv) {
		this.nom = unNom;
		this.version = uneVersion;
		this.sonEnvironnement = unEnv;
		this.lesUsers = new ArrayList <User> ();
	}
	
	public String toString() {
		String chaine = this.nom + " " + this.version + " " + this.sonEnvironnement.getNom();
		for (int i = 0; i < this.lesUsers.size(); i++) {
			chaine += " " + this.lesUsers.get(i).toString();
		}
		return chaine;
	}
	
	public boolean rechercherUser(String unNom, String unLogin, String unMotdePasse) {
		boolean rep = false;
		int i = 0;
		while (i < this.lesUsers.size() && !this.lesUsers.get(i).getNom().equals(unNom) && 
				!this.lesUsers.get(i).getLogin().equals(unLogin) && !this.lesUsers.get(i).getMotdePasse().equals(unMotdePasse)) {
				++i;
		}
		if (i < this.lesUsers.size()) {
			rep = true;
		} 
		return rep;
	}
	
	public void ajouterUnUser(User unUser) {
		this.lesUsers.add(unUser);
	}

	public void supprimerUser(int index) {
		this.lesUsers.remove(index);
	}
	
	public Environnement getSonEnvironnement() {
		return this.sonEnvironnement;
	}
	
	public void setSonEnvironnement(Environnement unEnvironnement) {
		this.sonEnvironnement = unEnvironnement;
	}
	
	public ArrayList<User> getlesUsersZ() {
		ArrayList <User> tempLesUsers = new ArrayList <User> ();
			for (int i = 0; i < lesUsers.size(); ++i) {
				if(this.lesUsers.get(i).getNom().substring(0, 1).equals("Z")) {
					tempLesUsers.add(lesUsers.get(i));
				}
			}
		return tempLesUsers;
	}
	
}