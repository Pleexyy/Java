import java.util.ArrayList;

public class Commerce {
    private String nom;
    private ArrayList<Visiteur> lesConsommateurs;

    public Commerce(String nom, ArrayList<Visiteur> lesConsommateurs) {
        this.nom = nom;
        this.lesConsommateurs = lesConsommateurs;
    }

    public String getNom() {
        return this.nom;
    }

    /*
     * récupère la liste des personnes ayant réalisé un ou plusieurs achats et
     * l'affiche au format CSV
     */
    public String getLesConsommateurs() {
        String chaine = "";
        chaine += "\n" + "prénom consommateur, nom consommateur" + "\n";
        for (int i = 0; i < lesConsommateurs.size(); i++) {
            chaine += lesConsommateurs.get(i).toCSV();
        }
        return chaine;
    }

}
