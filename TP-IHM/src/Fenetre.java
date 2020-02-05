
import java.awt.*;

import javax.swing.*;

public class Fenetre extends JFrame {
	private JPanel monPanel;
	private JLabel lblMessage;
//	private JLabel lblMessage2;
	private JTextField jtfNom;
	private JButton btnValider;
	private JButton btnAnnuler;
	
	public Fenetre() {
		
		this.setTitle("Formulaire");
		this.setLocationRelativeTo(null);
		this.setSize(400,250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		monPanel = new JPanel();
		monPanel.setBackground(Color.gray);
		

	
		lblMessage = new JLabel();
		lblMessage.setText("Votre nom: ");
		monPanel.add(lblMessage);
		
		//Passage par le constructeur
		//lblMessage2 = new JLabel("La princesse Michka");
		//monPanel.add(lblMessage2);
		
		jtfNom = new JTextField("Saisissez votre nom");
		Font police = new Font("Arial", Font.BOLD, 14);
		jtfNom.setFont(police);
		jtfNom.setPreferredSize(new Dimension(150, 25));
		jtfNom.setForeground(Color.blue);
		monPanel.add(jtfNom);
		
		btnValider = new JButton();
		btnValider.setText("Valider");
		btnValider.setEnabled(false);
		monPanel.add(btnValider);
		
		btnAnnuler = new JButton();
		btnAnnuler.setText("Annuler");
		monPanel.add(btnAnnuler);
		
		// Ajoute les composants créés à la fenetre
		this.getContentPane().add(monPanel);
		this.setVisible(true);
	}
}
