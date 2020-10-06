import javax.swing.*;

public class V_TabVillage extends JPanel {
	private JTable tableVillage;
	private JScrollPane scroll;
	
	public V_TabVillage(String [][] village) {
		tableVillage = new JTable ();
		String[] titreColonnes = {
				"Nom Village",
				"Nombre Habitants",
				"Nombre Huttes"
		}; 
		tableVillage = new JTable(village, titreColonnes);
		scroll = new JScrollPane(tableVillage);
		this.add(scroll);
		
	}
	
	
	
	
	
	
}
