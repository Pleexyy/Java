public class Ville {
    protected String nom;
    private int nbHabitants;
    private String superficie;
    private Pays lePays;

    public Ville(String unNom, int unNbHabitants, String uneSuperficie) {
        this.nom = unNom;
        this.nbHabitants = unNbHabitants;
        this.superficie = uneSuperficie;
    }
    
    public Ville(String unNom) {
    	this.nom = unNom;
    }

	public String getNom() {
		return this.nom;
	}
	
	public Ville(String unNom, int unNbHabitants, String uneSuperficie, Pays unPays) {
        this.nom = unNom;
        this.nbHabitants = unNbHabitants;
        this.superficie = uneSuperficie;
        this.lePays = unPays;
        this.lePays.ajouterUneVille(this);
	}

}