import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Window extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar barre;
	private JMenu menu;
	private JMenuItem inscription, connexion;
	private JPanel panel;
	private VueInscription pageInscription;
	private VueConnexion pageConnexion;

	public Window() {
		this.setResizable(false);
		this.setSize(350, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// permet de centrer la frame au milieu de l'écran
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		barre = new JMenuBar();
		menu = new JMenu("Menu");
		inscription = new JMenuItem("Inscription");
		connexion = new JMenuItem("Connexion");

		menu.add(inscription);
		menu.add(connexion);
		barre.add(menu);

		panel = new JPanel();
		panel.add(barre);

		inscription.addActionListener(new ActionInscription());
		connexion.addActionListener(new ActionConnexion());

		this.getContentPane().add(panel);

		this.setJMenuBar(barre);
		this.setVisible(true);
	}

	class ActionInscription implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pageInscription = new VueInscription();
			setContentPane(pageInscription);
			revalidate();
		}
	}

	class ActionConnexion implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pageConnexion = new VueConnexion();
			setContentPane(pageConnexion);
			revalidate();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
