public class Main {
	public static void main(String[] args) {
		Environnement unEnvironnement = new Environnement("Linux");
		User monUser = new User("Claire", "Mlk", "claire.michka");
		Application uneApplication = new Application("Toma", 1, unEnvironnement);
		
		uneApplication.ajouterUnUser(monUser);
		
		System.out.println(uneApplication.toString());
		
		uneApplication.supprimerUser(0);	
		
		System.out.println(uneApplication.toString());
		
		for (int i = 0; i < uneApplication.getlesUsersZ().size(); i++) {
			System.out.println(uneApplication.getlesUsersZ().get(i).toString());
		}
		
	}
}
