package Zoo;

public class Main {
	public static void main(String[] args) {
		Animal unAnimal = new Animal("chien");
		Habitat unHabitat = new Habitat("maison");
		
		System.out.println(unAnimal.toString());
		System.out.println(unHabitat.versChaine() + "\n");
		unAnimal.setHabitat(unHabitat);
		System.out.println(unAnimal.toString());
	}
}
