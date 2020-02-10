import java.awt.*;
import javax.swing.*;

public class Fenetre extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel monPanel;
	private JLabel lblMessage;
	// private JLabel lblMessage2;
	// private JTextField jtfNom;
	// private JButton btnValider;
	// private JButton btnAnnuler;
	private JButton btnClic1;
	private JButton btnClic2;
	private JButton btnClic3;
	private JButton btnClic4;
	private JButton btnClic5;
	private JButton btnClic6;

	public Fenetre() {

		this.setTitle("Formulaire");
		this.setLocationRelativeTo(null);
		this.setSize(400, 250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		monPanel = new JPanel();
		monPanel.setBackground(Color.gray);

		lblMessage = new JLabel();
		lblMessage.setText("Votre nom: ");
		// monPanel.add(lblMessage);

		// Passage par le constructeur
		// lblMessage2 = new JLabel("La princesse Michka");
		// monPanel.add(lblMessage2);

		// champ de texte
		// jtfNom = new JTextField("Saisissez votre nom");
		// Font police = new Font("Arial", Font.BOLD, 14);
		// jtfNom.setFont(police);
		// jtfNom.setPreferredSize(new Dimension(150, 25));
		// jtfNom.setForeground(Color.blue);
		// monPanel.add(jtfNom);

		// // bouton valider
		// btnValider = new JButton();
		// btnValider.setText("Valider");
		// btnValider.setEnabled(false);
		// monPanel.add(btnValider);

		// // bouton annuler
		// btnAnnuler = new JButton();
		// btnAnnuler.setText("Annuler");
		// monPanel.add(btnAnnuler);

		// layout par défaut
		// monPanel.setLayout(new FlowLayout());

		// monPanel.setLayout(new BorderLayout());
		// monPanel.add(btnValider, BorderLayout.NORTH);

		// Définition du GridLayout et du nombre de lignes (3) et de colonnes (2)
		monPanel.setLayout(new GridLayout(3, 2));
		btnClic1 = new JButton("1"); // Penser à déclarer les boutons dans les attributs privés....
		btnClic2 = new JButton("2");
		btnClic3 = new JButton("3");
		btnClic4 = new JButton("4");
		btnClic5 = new JButton("5");
		btnClic6 = new JButton("6");

		monPanel.add(btnClic1);
		monPanel.add(btnClic2);
		monPanel.add(btnClic3);
		monPanel.add(btnClic4);
		monPanel.add(btnClic5);
		monPanel.add(btnClic6);

		// Ajoute les composants crées, à la fenetre
		this.getContentPane().add(monPanel);
		this.setVisible(true);
	}
}
