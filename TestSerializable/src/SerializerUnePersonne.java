// nécessaire aux inputs/outputs
import java.io.*;

public class SerializerUnePersonne {
	public static void main(String[] args) {
		Personne unePersonne = new Personne("Martin", "Nicolas", 1987);
		try {
			FileOutputStream fichier = new FileOutputStream("Personnes.obj");
			ObjectOutputStream stream = new ObjectOutputStream(fichier);
			
			stream.writeObject(unePersonne);
			stream.flush();
			stream.close();
		} catch(IOException e) {
			System.out.println("Problème I/O");
		}
	}
}