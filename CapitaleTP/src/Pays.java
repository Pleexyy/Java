public class Pays {
    private String nom;
    private String langue;
    private String monnaie;
    private static int compteurPays = 0;
    private static int compteurVilles = 0;
    private Capitale saCapitale;
    private Ville lesVilles[]= new Ville[50];

    public Pays(String unNom, String uneLangue, String uneMonnaie, Capitale uneCapitale) {
        this.nom = unNom;
        this.langue = uneLangue;
        this.monnaie = uneMonnaie;
        this.saCapitale = uneCapitale;
        compteurPays = compteurPays + 1;
    }

    public String getNom() {
        return this.nom.toUpperCase();
    }

    public String getNom2() {
        return this.nom.substring(0, 1).toUpperCase() + this.nom.substring(1);
    }

    public String toString() {
        return "nom : " + this.getNom() + "\nlangue : " + this.langue + "\nmonnaie : " + this.monnaie + "\ncapitale : "
                + this.saCapitale.getNom2() + "\n";
    }

    public String toString2() {
        return "nom : " + this.getNom2() + "\nlangue : " + this.langue + "\nmonnaie : " + this.monnaie + "\ncapitale : "
                + this.saCapitale.getNom2() + "\n";
    }
    	
    public static int getCompteurPays() {
        return compteurPays;
    }
    
    public void ajouterUneVille(Ville uneVille) {
//        this.lesVilles.add(uneVille);
    	this.lesVilles[compteurVilles] = uneVille;
    	compteurVilles++;
    }

    public int rechercherUneVille(String uneVille) {
        int i = 0;
        while (i < compteurVilles && !(this.lesVilles[i].getNom().equals(uneVille))) {
            i++;
        }
        if (i < compteurVilles) {
            return i;
        }
        return -1;
    }

    public boolean supprimerUneVille2(String uneVille) {
    	boolean rep = false;
    	int i = this.rechercherUneVille(uneVille);
    	if (i < compteurVilles) {
    		for (int j = 0; j<compteurVilles - 1; j++) {
    			this.lesVilles[j] = this.lesVilles[j+1];
    		}
    		compteurVilles--;
    		rep = true;
    	}
    	return rep;
    }
    
    public String getLesVilles() {
        String chaine = "";
        for (int i = 0; i < compteurVilles; i++) {
            chaine += this.lesVilles[i].getNom();
        }
        return chaine;
    }
    
}