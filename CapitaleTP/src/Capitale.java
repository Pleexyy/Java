public class Capitale {
    private String nom;
    private int nbHabitants;
    private String superficie;

    public Capitale(String unNom, int unNbHabitants, String uneSuperficie) {
        this.nom = unNom;
        this.nbHabitants = unNbHabitants;
        this.superficie = uneSuperficie;
    }
    
    public Capitale(String unNom) {
        this.nom = unNom;
    }
    
    public String getNom2() {
    	return this.nom;
    }
}