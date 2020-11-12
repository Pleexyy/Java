import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueAjouter extends JPanel implements ActionListener {
    private JTable table;
    private JFrame frame;
    private JLabel welcome, generate;
    private JButton ajouterButton;
    private JTextField nom, prenom, dateNaissance;
    private JLabel lblnom, lblprenom, lbldate;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public VueAjouter(JFrame frame) {
        this.frame = frame;
        this.setLayout(null);
        welcome = new JLabel();
        welcome.setText("Ajouter un visiteur");
        welcome.setBounds(190, 25, 380, 100);
        
        generate = new JLabel();
        generate.setText("Veuillez saisir les informations nécessaires.");
        generate.setBounds(125, 40, 380, 100);
        
		lblprenom = new JLabel("Prénom");
		lblprenom.setBounds(125, 120, 80, 25);
		
		prenom = new JTextField(10);
		prenom.setBounds(175, 120, 160, 25);
		
		lblnom = new JLabel("Nom");
		lblnom.setBounds(125, 200, 80, 25);
		
		nom = new JTextField(10);
		nom.setBounds(175, 200, 160, 25);
		
		lbldate = new JLabel("Date de naissance");
		lbldate.setBounds(115, 160, 80, 25);

        dateNaissance = new JTextField(20);
        dateNaissance.setBounds(200, 160, 160, 25);
                	
		ajouterButton = new JButton("Ajouter");
		ajouterButton.setBounds(190, 270, 150, 25);
		
		ajouterButton.addActionListener(this);

        /* ajoute les Ã©lÃ©ments Ã  notre panel */
        this.add(welcome);
        this.add(generate);
        
        this.add(lblprenom);
        this.add(lblnom);
        this.add(lbldate);
        
        this.add(prenom);
        this.add(nom);
        this.add(dateNaissance);
        
        this.add(ajouterButton);
        
//        this.add(new JScrollPane(table));

    }

    public void actionPerformed(ActionEvent e) {
        this.frame.setContentPane(this);
        this.frame.revalidate();

        ajouterButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	System.out.println("test");
            }
        });

    }
}