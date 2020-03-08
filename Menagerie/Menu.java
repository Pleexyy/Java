import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        int choice;

        Menagerie menagerie = new Menagerie();

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("\n1 - Afficher les animaux de la ménagerie");
            System.out.println("2 - Ajouter un animal");
            System.out.println("3 - Supprimer un animal ");
            System.out.println("4 - Rechercher un animal");
            System.out.println("5 - Nombre d’animaux présents");
            System.out.println("0 - Quitter");

            System.out.println("\nVeuillez saisir votre choix :");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println(menagerie.toString());
                    break;
                case 2:
                    System.out.println("\nVeuillez saisir le nom de votre animal");
                    String nom = input.nextLine();

                    System.out.println("\nVeuillez saisir l'espece de votre animal");
                    String espece = input.nextLine();

                    Animal unAnimal = new Animal(nom, espece);
                    menagerie.ajouterUnAnimal(unAnimal);
                    break;
                case 3:
                    System.out.println("\nVeuillez choisir quel animal supprimer");
                    System.out.println(menagerie.toString());
                    int index = input.nextInt();
                    menagerie.supprimerUnAnimal(index);
                    break;
                case 4:
                    System.out.println("\nVeuillez choisir l'animal à chercher");
                    String toFind = input.nextLine();
                    menagerie.recherherUnAnimal(toFind);
                    if (menagerie.recherherUnAnimal(toFind) == true) {
                        System.out.println("\nAnimal trouvé");
                    } else {
                        System.out.println("\nAnimal non présent dans la ménagerie");
                    }
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