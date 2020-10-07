import java.sql.*;

public class Insertion {
	private static Connection connexion;
	private static Statement st;
	private static ResultSet rs;
	
	public static void connexionBdd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			connexion = DriverManager.getConnection("jdbc:mysql://172.16.203.100/asterix?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","agarapati","123456");
		}

		catch(SQLException e ) {
			System.out.println("Erreur de connexion à la base de données " + e);
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver non chargé " + e);
		}
	}
	
	public static void deconnexionBdd() {
		try {
			connexion.close();
			rs.close();
		}
		catch(SQLException e ) {
			System.out.println("Erreur lors de la déconnexion " + e);
		}
	}
}
