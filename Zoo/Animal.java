package Zoo;

public class Animal {
	private String race;
	private Habitat habitat;
	
	public Animal(String uneRace) {
		this.race = uneRace;
	}
	
	public String getRace() {
		return this.race;
	}
	
	public Habitat getHabitat() {
		return this.habitat;
	}
	
	public void setHabitat(Habitat unHabitat) {
		this.habitat = unHabitat;
	}
	
	public String toString() {
		String chaine = "[-----Animal-----]\nNom : " + this.race;

		if(this.habitat != null) {
			chaine += "\n" + this.habitat.versChaine();
		}
		chaine += "\n";
		return chaine;
	}
}
