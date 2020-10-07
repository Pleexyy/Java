import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Fenetre extends JFrame implements ActionListener {

	private JMenuBar barre;
	private JMenu menu;
	private JMenuItem inscription, connexion;
	private JPanel panel;
	private JFrame frame;
	private JTextField userText;
	private JButton registerButton;
	private ActionInscription pageInscription;

	
	public Fenetre() {
		
		frame = new JFrame("Formulaire d'identification");
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        // permet de centrer la frame au milieu de l'écran
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        barre = new JMenuBar();
        menu = new JMenu("Menu");
        inscription = new JMenuItem("Inscription");
        connexion = new JMenuItem("Connexion");
        
        menu.add(connexion);
        menu.add(inscription);
        barre.add(menu);
        
		panel = new JPanel();
		panel.add(barre);
		frame.setJMenuBar(barre);
		frame.setVisible(true);
		
		connexion.addActionListener(this);
		inscription.addActionListener(this);
	}
	
	public void panelInscription() {
        
		panel = new JPanel();
		panel.add(barre);
		frame.setJMenuBar(barre);
		
		panel.setLayout(null);

		JLabel userLabel = new JLabel("Login");
		userLabel.setBounds(25, 10, 80, 25);
		panel.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(110, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Mot de passe");
		passwordLabel.setBounds(25, 40, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(110, 40, 160, 25);
		panel.add(passwordText);

		
		frame.add(panel);
		
		frame.setVisible(true);
		JButton registerButton = new JButton("S'inscrire");
		registerButton.setBounds(10, 80, 150, 25);
		panel.add(registerButton);
	}

	class ActionInscription extends JPanel implements ActionListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == inscription) {
				pageInscription =  new ActionInscription();
				setContentPane(pageInscription);
				revalidate();
				
	//		    if (e.getSource() == registerButton) {   	
	//		    	String textFieldValue = userText.getText();
	//		    	System.out.println(textFieldValue);
	//		    }
			}
		}
	}
			
	class ActionConnexion implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == connexion) {
					setContentPane(panel);
//					panelConnexion();
					revalidate();
					
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
	