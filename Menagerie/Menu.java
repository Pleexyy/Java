import java.util.Scanner;

public class Menu {
		
	static Scanner input = new Scanner(System.in);
	
	public static void choix() {
        System.out.println("\n1 - Afficher les animaux de la ménagerie");
        System.out.println("2 - Ajouter un animal");
        System.out.println("3 - Supprimer un animal ");
        System.out.println("4 - Rechercher un animal");
        System.out.println("5 - Nombre d'animaux présents");
        System.out.println("0 - Quitter");

        System.out.println("\nVeuillez saisir votre choix :");
	}
	
	public static void ajouterAnimal(Menagerie menagerie) {
		System.out.println("\nVeuillez saisir le nom de votre animal");
		String nom = input.nextLine();
		
		System.out.println("\nVeuillez saisir l'espece de votre animal");
		String espece = input.nextLine();
		
		Animal unAnimal = new Animal(nom, espece);
		menagerie.ajouterUnAnimal(unAnimal);
	}
	
	public static void supprimerAnimal(Menagerie menagerie2) {
        System.out.println("\nVeuillez choisir quel animal supprimer");
        System.out.println(menagerie2.toString());
        int index = input.nextInt();
        menagerie2.supprimerUnAnimal(index);
	}
	
	public static void rechercherAnimal(Menagerie menagerie3) {
        System.out.println("\nVeuillez choisir l'animal à chercher");
        String toFind = input.nextLine();
        menagerie3.recherherUnAnimal(toFind);
        if (menagerie3.recherherUnAnimal(toFind) == true) {
            System.out.println("\nAnimal trouvé");
        } else {
            System.out.println("\nAnimal non présent dans la ménagerie");
        }
	}
    public static void main(String[] args) {
        int choice;

        Menagerie menagerie = new Menagerie();
        
        do {
        	choix();
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println(menagerie.toString());
                    break;
                case 2:
                	ajouterAnimal(menagerie);
                    break;
                case 3:
                	supprimerAnimal(menagerie);
                    break;
                case 4:
                	rechercherAnimal(menagerie);
                    break;
                case 5:
                    System.out.println("\nLa ménagerie comporte " + menagerie.getNombreAnimaux() + " animal(aux)");
                    break;
                case 0:
                    break;
                default:
            }
        } while (choice != 0);
        System.out.println("A bientot");
        input.close();
    }
    
    
}