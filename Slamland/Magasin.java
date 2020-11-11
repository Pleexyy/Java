import java.util.ArrayList;

public class Magasin {
    private String nom;
    private ArrayList<Article> lesArticles;

    public Magasin(ArrayList<Article> lesArticles) {
        this.lesArticles = lesArticles;
    }

    public Magasin(String nom, ArrayList<Article> lesArticles) {
        this.nom = nom;
        this.lesArticles = lesArticles;
    }

    public String getNom() {
        return this.nom;
    }

    /* fonction qui récupère les articles et l'affiche au format JSON */
    public String getLesArticles() {
        String chaine = "\n";
        chaine += "{\"articles\":" + '\n';
        for (int i = 0; i < this.lesArticles.size(); i++) {
            chaine += this.lesArticles.get(i).toJSON();
        }
        chaine += "}";
        return chaine;
    }

}
