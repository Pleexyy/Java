import javax.swing.*;

public class ActionInscription extends JPanel {
	private JMenuBar barre;
	private JMenu menu;
	private JMenuItem inscription, connexion;
	private JTextField userText;
	private JButton registerButton;
	private JLabel userLabel, passwordLabel;
	private JPasswordField passwordText;
	public ActionInscription() {

		userLabel = new JLabel("Login");
		userLabel.setBounds(25, 10, 80, 25);
		this.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(110, 10, 160, 25);
		this.add(userText);

		passwordLabel = new JLabel("Mot de passe");
		passwordLabel.setBounds(25, 40, 80, 25);
		this.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(110, 40, 160, 25);
		this.add(passwordText);

		registerButton = new JButton("S'inscrire");
		registerButton.setBounds(10, 80, 150, 25);
		this.add(registerButton);
		setVisible(true);
	}
}
