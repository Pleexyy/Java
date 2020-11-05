import java.util.ArrayList;

public class Attraction {

    private String nom, chaine;
    private int capaciteMax, duree;
    private float prix;
    private ArrayList<Visiteur> lesVisiteurs;

    public Attraction(String nom, int capaciteMax, int duree, float prix){
        this.nom = nom;
        this.capaciteMax = capaciteMax;
        this.duree = duree;
        this.prix = prix;
    }
    public Attraction(String nom, int capaciteMax, int duree, float prix, ArrayList <Visiteur> lesVisiteurs){
        this.nom = nom;
        this.capaciteMax = capaciteMax;
        this.duree = duree;
        this.prix = prix;
        this.lesVisiteurs = lesVisiteurs;
    }

    public Attraction(String nom, ArrayList <Visiteur> lesVisiteurs){
        this.nom = nom;
        this.lesVisiteurs = lesVisiteurs;
    }
    
    public Attraction(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }
	// public String getNom() {
    //     return this.nom;
    // }

    // public int getCapaciteMax() {
    //     return this.capaciteMax;
    // }

    // public int getDuree() {
    //     return this.duree;
    // }

    // public float getPrix() {
    //     return this.prix;
    // }

    
	public String getLesVisiteurs() {
        String chaine = "\n";
        chaine += "{'visiteur':" + '\n';
        for (int i = 0; i < this.lesVisiteurs.size(); i++) {
            chaine += this.lesVisiteurs.get(i).toJSON();
        }
        chaine += "}";
        return chaine;
    }

    public String toXML() {
        chaine ="";
        chaine += "     <attraction>" + "\n";
        chaine += "          <nom>" + this.nom + "</nom>" + "\n";
        chaine += "          <capaciteMax>" + this.capaciteMax + "</capaciteMax>" + "\n";
        chaine += "          <duree>" + this.duree + "</duree>" + "\n";
        chaine += "          <prix>" + this.prix + "</prix>" + "\n";
        chaine += "     </attraction>" + "\n";
        return chaine;
    }

}
