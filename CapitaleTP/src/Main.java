public class Main {
    public static void main(String[] args) {
    	System.out.println("Compteur pays : " + Pays.getCompteurPays());
    	
    	Capitale saCapitale = new Capitale("Paris", 10000000, "5m²");
    	
        Pays unPays = new Pays("france", "france", "euro", saCapitale);
        System.out.println(unPays.toString());
        
        Pays unPays2 = new Pays("france", "france", "euro", saCapitale);
        System.out.println(unPays2.toString2());
        
        Ville uneVille = new Ville("Paris", 10000000, "5m²");
        
        unPays.ajouterUneVille(uneVille);
        
        System.out.println(unPays.getLesVilles());
        
        System.out.println("Compteur pays : " + Pays.getCompteurPays());
        
        unPays.supprimerUneVille2("Paris");
        
        System.out.println(unPays.getLesVilles());
        
        System.out.println(unPays.rechercherUneVille("Pariss"));
    }
}