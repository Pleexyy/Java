public class Visiteur {

    private String nom, prenom, dateNaissance, chaine;

    public Visiteur(String nom, String prenom, String dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

	public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getDateNaissance() {
        return this.dateNaissance;
    }

    public String toJSON() {
        chaine = "";
        chaine += "[{ 'prenom':" + this.prenom + ", 'nom':" + this.nom + ", :'dateNaissance': " + this.dateNaissance
                + "}]" + "\n";
        return chaine;
    }
    

    // public String toCSV() {

    // }

}
