import java.util.ArrayList;

public class PremiereCollection {
	
	public static void afficher(ArrayList<String> maCollection) {
		for (int i = 0; i < maCollection.size(); ++i) {
			System.out.println(maCollection.get(i));
		}
		if (maCollection.isEmpty()) {
			System.out.println("La liste est vide");
		} else {
			for (int i = 0; i < maCollection.size(); ++i) {
				System.out.println(maCollection.get(i));
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> mesElements = new ArrayList<String>(); // Cr�� un objet de arraylist
		mesElements.add("lundi");
		mesElements.add("mardi");
		mesElements.add("mercredi");
		mesElements.add("jeudi");
		mesElements.add("vendredi");
		
		System.out.println("mesElements");
		
		System.out.println("\t Nombre d'�l�ments dans la liste : " + mesElements.size());
		
		// System.out.println(mesElements.get(0)); // affiche premier �l�ment
		
		afficher(mesElements);
		System.out.println("\n");
		mesElements.remove(2);
		
		afficher(mesElements);
		System.out.println("\n");
		mesElements.add(2, "mercredi");
		
		afficher(mesElements);
		System.out.println("\n");
		
		mesElements.remove("vendredi");
		afficher(mesElements);
		
		System.out.println(mesElements.indexOf("mercredi"));
		
		System.out.println(mesElements.contains("lundi")); // renvoie vrai si �l�ment est pr�sent
		
		System.out.println(mesElements.indexOf("vendredi"));
		
		mesElements.add("lundi");
		mesElements.remove("lundi"); // supprime uniquement la premi�re occurence trouv�e
		System.out.println("\n");
		afficher(mesElements);
		System.out.println("\n");
		
		mesElements.removeAll(mesElements);
		
		afficher(mesElements);
		
		
	}
	
}
