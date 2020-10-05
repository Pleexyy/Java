public class Main {
	public static void main(String[] args) {
		Modele unModele = new Modele();
		Gui unGui = new Gui();
		unModele.connecterBdd();
		unGui.fenetre();
		unModele.fermetureConnexions();
	}
}
