import java.sql.*;
import java.util.ArrayList;

public class Database {
	private static Connection connexion;
	private static Statement st;
	private static ResultSet rs;

	public static void connexionBdd() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connexion = DriverManager
					.getConnection("jdbc:mariadb://localhost:3306/slamland?user=root&password=couleuvre");
			st = connexion.createStatement();
		}

		catch (SQLException e) {
			System.err.println("Erreur de connexion à la base de donnéees " + e);
		} catch (ClassNotFoundException e) {
			System.err.println("Driver non chargé " + e);
		}
	}

	public static void deconnexionBdd() {
		try {
			connexion.close();
		} catch (SQLException e) {
			System.err.println("Erreur lors de la déconnexion " + e);
		}
	}

	public static boolean connexion(String login, String mdp) {
		boolean rep = false;
		try {
			connexionBdd();
			rs = st.executeQuery(
					"select login, mdp from utilisateur where login = '" + login + "' and mdp = '" + mdp + "';");
			if (rs.first()) {
				// String getLogin = rs.getString("login");
				rep = true;
			}
			rs.close();
			deconnexionBdd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rep;
	}

	// public static ArrayList<Attraction> getLesAttractions() {
	// 	ArrayList<Attraction> lesAttractions = new ArrayList<Attraction>();
	// 	try {

	// 		connexionBdd();
	// 		rs = st.executeQuery("select nom, ville from parcattractions;");
	// 		while(rs.next()) {
	// 			String nom = rs.getString("nom");
	// 			String ville = rs.getString("ville");
	// 			lesAttractions.add(new Attraction(nom, ville));
	// 		}
	// 		rs.close();
	// 		deconnexionBdd();
	// 	} catch (SQLException e) {
	// 		e.printStackTrace();
	// 	}
	// 	return lesAttractions;
	// }

	public static ArrayList<Attraction> getLesParcs() {
		ArrayList<Attraction> lesParcs = new ArrayList<Attraction>();
		try {

			connexionBdd();
			rs = st.executeQuery("select nom, ville from parcattractions;");
			while(rs.next()) {
				String nom = rs.getString("nom");
				String ville = rs.getString("ville");
				lesParcs.add(new Attraction(nom, ville));
			}
			rs.close();
			deconnexionBdd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lesParcs;
	}
	
}