import java.io.*;

public class DeSerializerUnePersonne {
	public static void main(String[] args) {
		try {
			FileInputStream fichier = new FileInputStream("personnes.obj");
			ObjectInputStream stream = new ObjectInputStream(fichier);
			Personne unePersonne = (Personne) stream.readObject();
			System.out.println("Personne : \n");
			System.out.println("nom : " + unePersonne.getNom());
			System.out.println("prénom : " + unePersonne.getPrenom());
			System.out.println("date de naissance : " + unePersonne.getDateNaissance());
			
			stream.close();
		} catch(IOException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
