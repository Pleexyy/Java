public class Ville {
//    ArrayList<Ville> lesVilles = new ArrayList<Ville>();
    private String nom;
    private int nbHabitants;
    private String superficie;

    public Ville(String unNom, int unNbHabitants, String uneSuperficie) {
        this.nom = unNom;
        this.nbHabitants = unNbHabitants;
        this.superficie = uneSuperficie;
    }

	public String getNom() {
		return this.nom;
	}

}