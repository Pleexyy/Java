import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueInscription extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userText;
	private JButton registerButton;
	private JLabel userLabel, passwordLabel, registered;
	private JPasswordField passwordText;

	public VueInscription() {
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
		registerButton.addActionListener(this);
		this.add(registerButton);
	}

	public void registered() {
		registered = new JLabel("Inscription réussie");
		registered.setBounds(25, 80, 150, 25);
		this.add(registered);
		revalidate();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == registerButton) {
			String login = userText.getText();
			String pwd = passwordText.getText();
			if (Database.inscription(login, pwd)) {
				System.out.println("ok");
				registered();
			}
		}
	}
}
