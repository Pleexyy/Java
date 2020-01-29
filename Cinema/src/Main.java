public class Main {
	public static void main(String[] args) {
		
		// On passe par le constructeur pour set
		
		Acteur unActeur = new Acteur("SY", "Omar", 1978, "Française");
		Film unFilm = new Film("Intouchables", 2011, 113, "Comédie dramatique");
		Film nouveauFilm = new Film("Mishka l'horreur", 2019, 250, "SF");
		
//		unActeur.setLeFilm(unFilm);
		
		System.out.println(unActeur.toString());	
		System.out.println(unFilm.versChaine());
		
		unActeur.ajouterLesFilms(unFilm);
		unActeur.ajouterLesFilms(nouveauFilm);		
		
		System.out.println(unActeur.toString());
		
		System.out.println(unActeur.rechercherFilm("Intouchables"));
	}
}