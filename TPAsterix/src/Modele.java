import java.sql.*;

public class Modele {
	private Connection connexion;
	private static Statement st;
	private static ResultSet rs;

	public void connecterBdd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://172.16.203.100/asterix?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "tbonneville", "123456");
			st = connexion.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver non chargé " + e);
		} catch (SQLException e) {
			System.out.println("Erreur lors de la connexion à la base de données " + e);
		}		
	}
	
	public void fermetureConnexions() {
		try {
			rs.close();
			connexion.close();
		} catch (SQLException e) {
			System.out.println("Erreur lors de la fermeture des flux " + e);
		}
	}
	
	public Object[][] getLesVillages() {
		String req = "select * from village";
		Object[][] donnees = new Object[15][4] ;
		try {
			rs = st.executeQuery(req);
		} catch (SQLException e) {
			System.out.println("Erreur lors de l'éxecution de la requete SQL " + e);
		}
		// Pour accéder aux lignes des résultats <=> fetch
		try {
			int i = 0;
			while (rs.next()) {
				donnees[i][0] = rs.getString(1);
				donnees[i][1] = rs.getInt(2);
				donnees[i][2] = rs.getInt(3);
				i++;
			}
		} catch (SQLException e) {
			System.out.println("Erreur lors de la récupération des données du tableau associatif " + e);
		}
		return donnees;
	}
}