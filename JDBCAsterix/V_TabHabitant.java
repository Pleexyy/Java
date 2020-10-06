import java.util.ArrayList;

import javax.swing.*;

public class V_TabHabitant extends JPanel  {
	private JTable tableHabitant;
	private JScrollPane scroll;
	
	public V_TabHabitant(int nbTotal, ArrayList<Habitant> lesHab) {
		int i =0;
		String [][] tabHabitant = new String [nbTotal][4];
		for( Habitant unHabitant : lesHab){
			tabHabitant[i][0] = unHabitant.getNomHabitant();
			tabHabitant[i][1] = unHabitant.getNomVillage();
			tabHabitant[i][2] = unHabitant.getAge();
			tabHabitant[i][3] = unHabitant.getQualite();
			i++;
		}
		String [] titreColonnesHabitants = {"Nom Habitant","Nom Village","Age","Qualité"};
		
		tableHabitant = new JTable(tabHabitant, titreColonnesHabitants);
		scroll = new JScrollPane(tableHabitant);
		this.add(scroll);	
	}
}
