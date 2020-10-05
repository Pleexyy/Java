public class Main {
	public static void main(String[] args) {
		Gui unGui = new Gui();
		Modele.connecterBdd();
		unGui.fenetre();
		Modele.fermetureConnexions();
	}
}
