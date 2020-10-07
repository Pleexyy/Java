import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Fenetre extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar barre;
	private JMenu menu;
	private JMenuItem inscription, connexion;
	private JPanel panel;
//	private ActionConnexion pageConnexion;

	
	public Fenetre() {
		
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        // permet de centrer la frame au milieu de l'écran
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        barre = new JMenuBar();
        menu = new JMenu("Menu");
        inscription = new JMenuItem("Inscription");
        connexion = new JMenuItem("Connexion");
        
        menu.add(connexion);
        menu.add(inscription);
        barre.add(menu);
        
		panel = new JPanel();
		panel.add(barre);
		
		
		inscription.addActionListener(new ActionInscription());
//		connexion.addActionListener(new ActionConnexion());
		
		this.getContentPane().add(panel);
		
		this.setJMenuBar(barre);
		this.setVisible(true);
	}
	
	public void menuInscription() {
		ActionInscription pageInscription =  new ActionInscription();
		setContentPane(pageInscription);
		revalidate();
	}
	

	class ActionInscription implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			menuInscription();
		}
	}
	
//	class ActionInscription extends JPanel implements ActionListener {
//		/**
//		 * 
//		 */
//		private static final long serialVersionUID = 1L;
//		public void actionPerformed(ActionEvent e) {
//			if (e.getSource() == inscription) {
//				System.out.println("inscription");
//
//				
//				//		    if (e.getSource() == registerButton) {   	
//				//		    	String textFieldValue = userText.getText();
//				//		    	System.out.println(textFieldValue);
//				//		    }
//			}
//		}
//	}
	
//	class ActionConnexion extends JPanel implements ActionListener {
//		/**
//		 * 
//		 */
//		private static final long serialVersionUID = 1L;
//		public void actionPerformed(ActionEvent e) {
//			if(e.getSource() == connexion) {
//				System.out.println("connexion");
//				pageConnexion = new ActionConnexion();
//				setContentPane(pageConnexion);
//				setContentPane(panel);
//				revalidate();
//					
//			}
//		}
//	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	