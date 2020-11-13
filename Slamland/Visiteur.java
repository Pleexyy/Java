public class Visiteur {

    private String nom, prenom, dateNaissance, chaine;
    private int id;

    public Visiteur(String nom, String prenom, String dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }
    	

    public Visiteur(int id, String nom, String prenom, String dateNaissance) {
    	this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    
    public Visiteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
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
    
    public int getId() {
    	return this.id;
    }
    	
    public String toJSON() {
        chaine = "";
        chaine += "[{ \"prenom\":" + "\"" + this.prenom + "\"" + ", \"nom\":" + "\"" + this.nom + "\""
                + ", \"dateNaissance\": " + "\"" + this.dateNaissance + "\"" + "}]" + "\n";
        return chaine;
    }

    public String toCSV() {
        chaine = "";
        chaine += this.prenom + "," + this.nom;
        return chaine;
    }

}
