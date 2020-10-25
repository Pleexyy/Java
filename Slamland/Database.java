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

	public static ArrayList<Parc> getLesParcs() {
		ArrayList<Parc> lesParcs = new ArrayList<Parc>();

		try {
			connexionBdd();
			rs = st.executeQuery("select id, nom, ville from parcattractions;");
			while (rs.next()) {
				ArrayList<Attraction> lesAttractions = new ArrayList<Attraction>();
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String ville = rs.getString("ville");

				ResultSet rsAttractions = st.executeQuery("select nom, capaciteMax, duree, prix from attractions where idparc  = '" + id + "';");
				while (rsAttractions.next()) {
					String nomAttraction = rsAttractions.getString("nom");
					int capaciteMax = rsAttractions.getInt("capaciteMax");
					int duree = rsAttractions.getInt("duree");
					float prix = rsAttractions.getInt("prix");
					lesAttractions.add(new Attraction(nomAttraction, capaciteMax, duree, prix));
				}
				lesParcs.add(new Parc(id, nom, ville, lesAttractions));
			}
			rs.close();
			deconnexionBdd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lesParcs;
	}
}