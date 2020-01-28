package Zoo;

public class Habitat {
	private String lieu;
	
	public Habitat(String unLieu) {
		this.lieu = unLieu;
	}
	
	public String getLieu() {
		return this.lieu;
	}
	
	public String versChaine() {
		// variables
		String chaine = "[-----Habitat-----]\nHabitat : " + this.lieu;
		return chaine;
	}

}
