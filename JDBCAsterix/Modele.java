import java.sql.*;
import java.util.ArrayList;
/**
 * Classe modele qui gère toute les requêtes SQL et la connexion à la BDD
 * @author CHHIM Shenda
 *
 */
public class Modele {
	private static Connection connexion;
	private static Statement st ;
	private static ResultSet rs ;
	
	/**
	 * Methode connexionBDD : Elle gère le chargement du driver et la connexion à la BDD
	 * @return connexion.
	 */
	public static Connection connexionBDD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion=DriverManager.getConnection("jdbc:mysql://172.16.203.100/asterix?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","schhim","123456");
			st = connexion.createStatement();
		}
		catch (ClassNotFoundException e) {
			System.out.println("Driver non chargé! " +e);
		}
		catch (SQLException e) {
			System.out.println("La connexion à la base de données a échoué "+e);
		}
		return connexion;
		
	}
	/**
	 * Methode qui sert à deconnecter la BDD
	 */
	public static void  deconnexionBDD() {
		try {
			connexion.close();
		} catch (SQLException e) {
			System.out.println("Nous n'arrivons pas a vous deconnecter à la base de données");
		}
	}
	
	public static String getLesNomVillages() {
		connexionBDD();
		String chaine = "";
		String requete = "SELECT NomVillage FROM Village;";
		String nomV= "";
		
		try {
			rs = st.executeQuery(requete);
			while(rs.next()) {
				nomV = rs.getString("NomVillage");
				chaine += "Nom des villages :" + nomV + "\n";
			}
			rs.close();
		}catch(SQLException e) {
			chaine += "Votre requête ne peux aboutir.";
		}
		
		deconnexionBDD();
		return chaine;
		
	}
	
	public String getLesNombreHuttes() {
		connexionBDD();
		String chaine = "";
		String requete = "SELECT NbHuttes FROM Village;";
		int nbH= 0;
		
		try {
			this.rs = this.st.executeQuery(requete);
			while(this.rs.next()) {
				nbH = this.rs.getInt("NbHuttes");
				chaine += "Nombres de huttes :" + nbH + "\n";
			}
			this.rs.close();
		}catch(SQLException e) {
			chaine += "Votre requête ne peux aboutir.";
		}
		
		deconnexionBDD();
		return chaine;
		
	}
	
	public static String getLesNombreHabitants() {
		connexionBDD();
		String chaine = "";
		String requete = "SELECT NomVillage FROM Village;";
		int nbHab= 0;
		
		try {
			rs =st.executeQuery(requete);
			while(rs.next()) {
				nbHab = rs.getInt("NbHab");
				chaine += "Nom des villages :" + nbHab + "\n";
			}
			rs.close();
		}catch(SQLException e) {
			chaine += "Votre requête ne peux aboutir.";
		}
		
		deconnexionBDD();
		return chaine;
		
	}
	
public static ArrayList<Habitant> getLesHabitants() {
		
		connexionBDD();
		ArrayList<Habitant> chaine= new ArrayList<Habitant>();
		String requete = "SELECT * FROM Habitant;";
		String nomH = "";
		String nomV = "";
		String age = "";
		String qualite = "";
		try {
			rs = st.executeQuery(requete);
			while(rs.next()) {
				nomH = rs.getString ("NomHabitant");
				nomV= rs.getString("NomVillage");
				age = rs.getString("Age");
				qualite = rs.getString("Qualite");
				Habitant habitant = new Habitant(nomH, nomV, age, qualite);
				chaine.add(habitant);
			}
			rs.close();
		} catch (SQLException e) {
		}
		
		deconnexionBDD();
		
		return chaine;
	}


	public static String afficherLesHabitants(ArrayList<Habitant> habitant) {
		String chaine ="";
		String nomH = "";
		String nomV = "";
		String age = "";
		String qualite = "";
		for(int i = 0; i<getNbTotalHabitants(); i++) {
			nomH = habitant.get(i).getNomHabitant();
			nomV = habitant.get(i).getNomVillage();
			age = habitant.get(i).getAge();
			qualite = habitant.get(i).getQualite();
			chaine+= nomH + nomV + age + qualite;	
		}
		return chaine;
	}
	
	
	
	
	
	
	
	
	
	
	public static String[][] getLesVillages () {
		
		connexionBDD();
		String[][] chaine= new String [getNbTotalVillages()][3] ;
		String requete = "SELECT * FROM Village;";
		String nomV ="";
		String nbHab = "";
		String nbHutte = "";
		int compteur = 0;
		try {
			rs = st.executeQuery(requete);
			while(rs.next()) {
				nomV = rs.getString ("NomVillage");
				nbHab = rs.getString("NbHab");
				nbHutte = rs.getString("NbHuttes");
				chaine[compteur][0]= nomV ;
				chaine[compteur][1]= nbHab ;
				chaine[compteur][2]= nbHutte ;
				compteur++;
			}
			
			rs.close();
		} catch (SQLException e) {
		}
		
		deconnexionBDD();
		
		return chaine;
	}
	
	public static int getNbTotalVillages() {
		connexionBDD();
		int total=0;
		String requete = "SELECT COUNT(NomVillage) AS nbTotal  FROM Village;";
		
		try {
			rs = st.executeQuery(requete);
			rs.next();
			total = rs.getInt("nbTotal");
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return total;
	}
	public static int getNbTotalHabitants() {
		connexionBDD();
		int total=0;
		String requete = "SELECT COUNT(NomHabitant) AS nbTotal  FROM Habitant;";
		
		try {
			rs = st.executeQuery(requete);
			rs.next();
			total = rs.getInt("nbTotal");
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return total;
	}
}
