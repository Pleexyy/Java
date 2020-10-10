import java.sql.*;

public class Database {
	private static Connection connexion;
	private static Statement st;
	private static ResultSet rs;

	public static void connexionBdd() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connexion = DriverManager
					.getConnection("jdbc:mariadb://localhost:3306/utilisateurs?user=root&password=couleuvre");
			st = connexion.createStatement();
		}

		catch (SQLException e) {
			System.err.println("Erreur de connexion à la base de données " + e);
		} catch (ClassNotFoundException e) {
			System.err.println("Driver non chargé " + e);
		}
	}

	public static void deconnexionBdd() {
		try {
			rs.close();
			connexion.close();
		} catch (SQLException e) {
			System.err.println("Erreur lors de la déconnexion " + e);
		}
	}

	public static boolean inscription(String login, String pwd) {
		boolean rep = false;
		try {
			rs = st.executeQuery("insert into utilisateurs (login, mdp) values ('" + login + "','" + pwd + "');");
			rep = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rep;
	}

	public static boolean connexion(String login, String pwd) {
		boolean rep = false;
		try {
			rs = st.executeQuery(
					"select login, mdp from utilisateurs where login = '" + login + "' and mdp = '" + pwd + "';");
			if (rs.first()) {
				String getLogin = rs.getString("login");
				rep = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rep;
	}

}
