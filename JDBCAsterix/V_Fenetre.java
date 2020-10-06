import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class V_Fenetre extends JFrame {
	//Panel côté Village

	private V_TabVillage pageVillage;
	
	//Panel côté Habitant
	private V_TabHabitant pageHabitant;
	
	//Menu
	private JMenuBar bar;
	private JMenu menu;
	private JMenuItem itemVillage;
	private JMenuItem itemHabitant;
	
	public V_Fenetre() {
		this.setTitle("TP_Asterix");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,400);
		
		//Côté menu 
		
		bar = new JMenuBar();
		menu = new JMenu("Menu");
		itemVillage = new JMenuItem("Village");
		itemHabitant = new JMenuItem("Habitant");
		
		menu.add(itemVillage);
		menu.add(itemHabitant);
		bar.add(menu);
		
		itemVillage.addActionListener(new ActionVillage());
		itemHabitant.addActionListener(new ActionHabitant());
		
		this.add(bar);
		this.setJMenuBar(bar);

		this.setVisible(true);
		
	}

	class ActionVillage implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			pageVillage =  new V_TabVillage(Modele.getLesVillages());
			//panelChange(pageVillage);
			setContentPane(pageVillage);
			revalidate();
		}
	}
	class ActionHabitant implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			pageHabitant = new V_TabHabitant(Modele.getNbTotalHabitants(),Modele.getLesHabitants());
			setContentPane(pageHabitant);
			revalidate();
		}
	}
}
