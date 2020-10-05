import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
public class Gui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void fenetre() {
		JScrollPane scrollpane = null;
		JTable tableau = null;
		//Parametres de la fenetre
		this.setTitle("TP Astérix - IHM");
		this.setSize(500,600);
		this.setResizable(false);
		
		String[] entetes = {"Nom du village", "Nombre d'habitants", "Nombre de huttes"};
		
		tableau = new JTable(Modele.getLesVillages(), entetes);
		scrollpane = new JScrollPane(tableau);

		getContentPane().add(scrollpane);
		// permet de centrer la frame au milieu de l'écran
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}