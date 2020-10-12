import java.sql.*;

public class Database {
	private static Connection connexion;
	private static Statement st;
	private static ResultSet rs;

	public static void connexionBdd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://172.16.203.100/2019bonneville?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","tbonneville","123456");
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

	public static boolean inscription(String login, String pwd) {
		boolean rep = false;
		try {
			connexionBdd();
			st.executeUpdate("insert into utilisateurs (login, pwd) values ('" + login + "','" + pwd + "');");
			rep = true;
			deconnexionBdd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rep;
	}

	public static boolean connexion(String login, String pwd) {
		boolean rep = false;
		try {
			connexionBdd();
			rs = st.executeQuery("select login, pwd from utilisateurs where login = '" + login + "' and pwd = '" + pwd + "';");
			if (rs.first()) {
				String getLogin = rs.getString("login");
				rep = true;
			}
			rs.close();
			deconnexionBdd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rep;
	}

}
