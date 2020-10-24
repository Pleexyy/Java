import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueConnexion extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userText;
	private JButton loginButton;
	private JLabel userLabel, passwordLabel, welcome;
	private JPasswordField passwordText;
	private JFrame frame;

	public VueConnexion(JFrame frame) {
		this.frame = frame;
		this.setLayout(null);

		welcome = new JLabel("Bienvenue sur l'interface administrateur");
		welcome.setFont(new Font("Arial", Font.BOLD, 14));
		welcome.setBounds(90, 40, 380, 100);
		this.add(welcome);

		userLabel = new JLabel("Login");
		userLabel.setBounds(100, 200, 80, 25);
		this.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(205, 200, 160, 25);
		this.add(userText);

		passwordLabel = new JLabel("Mot de passe");
		passwordLabel.setBounds(100, 230, 100, 25);
		this.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(205, 230, 160, 25);
		this.add(passwordText);

		loginButton = new JButton("Se connecter");
		loginButton.setBounds(175, 270, 150, 25);
		this.add(loginButton);

		loginButton.addActionListener(this);

		setVisible(true);

	}

	public void connected() {
		JOptionPane.showMessageDialog(this, "Connexion réussie.");
		revalidate();
	}

	public void notConnected() {
		JOptionPane.showMessageDialog(this, "L'identifiant ou le mot de passe saisi n'est pas correct.",
				"Erreur de connexion", JOptionPane.WARNING_MESSAGE);
		revalidate();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton) {
			String login = userText.getText();
			String mdp = String.valueOf(passwordText.getPassword());
			if (Database.connexion(login, mdp)) {
				connected();
				new VueMenu(this.frame);
				revalidate();
			} else {
				notConnected();
			}
		}
	}
}
