public class Main {
	public static void main(String[] args) {
		
		/* On passe par le constructeur pour set */
		
		Acteur unActeur = new Acteur("SY", "Omar", 1978, "Française");
		Film unFilm = new Film("Intouchables", 2011, 113, "Comédie dramatique");
		
		unActeur.setLeFilm(unFilm);
		
		System.out.println(unActeur.toString());	

		System.out.println(unFilm.versChaine());
		
	}
}