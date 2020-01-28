public class Main {
    public static void main(String[] args) {
        Animal unAnimal = new Animal("Arthur");
        Animal unAutreAnimal = new Animal("Max","Tortue");

        System.out.println(unAnimal.toString());
        System.out.println("\n");
        System.out.println(unAutreAnimal.toString());
    }
}