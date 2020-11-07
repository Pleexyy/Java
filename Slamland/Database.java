import java.sql.*;
import java.util.ArrayList;

public class Database {
	private static Connection connexion;

	public static void connexionBdd() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connexion = DriverManager
					.getConnection("jdbc:mariadb://localhost:3306/slamland?user=root&password=couleuvre");
			connexion.createStatement();
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
			String rsInfo = "select login, mdp from utilisateur where login = ? and mdp = ?;";
			PreparedStatement preparedStatement = connexion.prepareStatement(rsInfo);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, mdp);
			ResultSet result = preparedStatement.executeQuery();
			if (result.first()) {
				// String getLogin = rs.getString("login");
				rep = true;
			}
			result.close();
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
			String rsParc = "select id, nom, ville from parcattractions;";
			PreparedStatement preparedStatement = connexion.prepareStatement(rsParc);
			ResultSet resultParc = preparedStatement.executeQuery();
			while (resultParc.next()) {
				ArrayList<Attraction> lesAttractions = new ArrayList<Attraction>();
				int id = resultParc.getInt("id");
				String nom = resultParc.getString("nom");
				String ville = resultParc.getString("ville");

				String rsAttractions = "select nom, capaciteMax, duree, prix from attractions where idparc  = ?;";
				PreparedStatement preparedStatement2 = connexion.prepareStatement(rsAttractions);
				preparedStatement2.setInt(1, id);
				ResultSet result = preparedStatement2.executeQuery();

				while (result.next()) {
					String nomAttraction = result.getString("nom");
					int capaciteMax = result.getInt("capaciteMax");
					int duree = result.getInt("duree");
					float prix = result.getInt("prix");

					lesAttractions.add(new Attraction(nomAttraction, capaciteMax, duree, prix));
				}
				lesParcs.add(new Parc(id, nom, ville, lesAttractions));
			}
			resultParc.close();
			deconnexionBdd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lesParcs;
	}

	public static ArrayList<Attraction> getLesAttractions() {
		ArrayList<Attraction> lesAttractions = new ArrayList<Attraction>();
		try {
			connexionBdd();
			String rsAttractions = "select id, nom from attractions;";
			PreparedStatement preparedStatement = connexion.prepareStatement(rsAttractions);
			ResultSet resultAttractions = preparedStatement.executeQuery();

			while (resultAttractions.next()) {
				ArrayList<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
				int idattraction = resultAttractions.getInt("id");
				String nom = resultAttractions.getString("nom");

				String rsVisiteurs = "select prenom, nom, dateNaissance from participer where idattraction = ?;";
				PreparedStatement preparedStatement2 = connexion.prepareStatement(rsVisiteurs);
				preparedStatement2.setInt(1, idattraction);
				ResultSet resultVisiteurs = preparedStatement2.executeQuery();

				while (resultVisiteurs.next()) {
					String prenom = resultVisiteurs.getString("prenom");
					String nomVisiteur = resultVisiteurs.getString("nom");
					String dateNaissance = resultVisiteurs.getString("dateNaissance");

					lesVisiteurs.add(new Visiteur(prenom, nomVisiteur, dateNaissance));
				}
				lesAttractions.add(new Attraction(nom, lesVisiteurs));
			}
			resultAttractions.close();
			deconnexionBdd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lesAttractions;
	}

	public static ArrayList<Commerce> getLesCommerces() {
		ArrayList<Commerce> lesCommerces = new ArrayList<Commerce>();
		try {
			connexionBdd();
			String rsCommerces = "select id, nom from commerce;";
			PreparedStatement preparedStatement = connexion.prepareStatement(rsCommerces);
			ResultSet resultCommerces = preparedStatement.executeQuery();

			while (resultCommerces.next()) {
				ArrayList<Visiteur> lesConsommateurs = new ArrayList<Visiteur>();
				int idcommerce = resultCommerces.getInt("id");
				String nomcommerce = resultCommerces.getString("nom");

				String rsConsommateurs = "select idachat, nomconsommateur, prenomconsommateur from acheter where idcommerce = ?;";
				PreparedStatement preparedStatement2 = connexion.prepareStatement(rsConsommateurs);
				preparedStatement2.setInt(1, idcommerce);
				ResultSet resultConsommateurs = preparedStatement2.executeQuery();

				while (resultConsommateurs.next()) {
					String nomconsommateur = resultConsommateurs.getString("nomconsommateur");
					String prenomconsommateur = resultConsommateurs.getString("prenomconsommateur");

					lesConsommateurs.add(new Visiteur(prenomconsommateur, nomconsommateur));
				}
				lesCommerces.add(new Commerce(nomcommerce, lesConsommateurs));
			}
			resultCommerces.close();
			deconnexionBdd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lesCommerces;
	}

	public static ArrayList<Magasin> getLesMagasins() {
		ArrayList<Magasin> lesMagasins = new ArrayList<Magasin>();
		try {
			connexionBdd();
			String rsMagasins = "select idmagasin, nom from magasin;";
			PreparedStatement preparedStatement = connexion.prepareStatement(rsMagasins);
			ResultSet resultMagasins = preparedStatement.executeQuery();

			while (resultMagasins.next()) {
				ArrayList<Article> lesArticles = new ArrayList<Article>();
				int idmagasin = resultMagasins.getInt("idmagasin");
				String nommagasin = resultMagasins.getString("nom");

				String rsArticles = "select idarticle, idmagasin, libelle, prix from posseder where idmagasin = ?;";
				PreparedStatement preparedStatement2 = connexion.prepareStatement(rsArticles);
				preparedStatement2.setInt(1, idmagasin);
				ResultSet resultArticles = preparedStatement2.executeQuery();

				while (resultArticles.next()) {
					String libellearticle = resultArticles.getString("libelle");
					float prixarticle = resultArticles.getFloat("prix");

					lesArticles.add(new Article(libellearticle, prixarticle));
				}
				lesMagasins.add(new Magasin(nommagasin, lesArticles));
			}
			resultMagasins.close();
			deconnexionBdd();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lesMagasins;
	}

}