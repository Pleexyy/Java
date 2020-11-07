public class Article {
    private String libelle, chaine;
    private float prix;

    public Article(String libelle, float prix) {
        this.libelle = libelle;
        this.prix = prix;
    }

    public String toJSON() {
        chaine = "";
        chaine += "[{\"libelle\":" + "\"" + this.libelle + "\"" + ", \"prix\":" + "\"" + this.prix + "\"" + "}]" + "\n";
        return chaine;
    }

}
