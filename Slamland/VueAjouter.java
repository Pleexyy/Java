import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueAjouter extends JPanel implements ActionListener {
    private JFrame frame;
    private JLabel welcome, generate;
    private JButton ajouterButton;
    private JTextField nom, prenom, dateNaissance, id;
    private JLabel lblnom, lblprenom, lbldate, lblid;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public VueAjouter(JFrame frame) {
        this.frame = frame;
        this.setLayout(null);
        welcome = new JLabel();
        welcome.setText("Ajouter un visiteur");
        welcome.setBounds(180, 10, 380, 100);

        generate = new JLabel();
        generate.setText("Veuillez saisir les informations n�cessaires.");
        generate.setBounds(105, 25, 380, 100);

        /* label id */
        lblid = new JLabel("Id");
        lblid.setBounds(110, 100, 80, 25);

        /* champ de texte id */
        id = new JTextField(10);
        id.setBounds(175, 100, 160, 25);

        /* label prénom */
        lblprenom = new JLabel("Pr�nom");
        lblprenom.setBounds(110, 140, 80, 25);

        /* champ de texte prénom */
        prenom = new JTextField(10);
        prenom.setBounds(175, 140, 160, 25);

        /* label nom */
        lblnom = new JLabel("Nom");
        lblnom.setBounds(125, 180, 80, 25);

        /* champ de texte nom */
        nom = new JTextField(20);
        nom.setBounds(175, 180, 160, 25);

        /* label date de naissance */
        lbldate = new JLabel("Date de naissance");
        lbldate.setBounds(40, 220, 150, 25);

        /* champ de texte date de naissance */
        dateNaissance = new JTextField(10);
        dateNaissance.setBounds(175, 220, 160, 25);

        ajouterButton = new JButton("Ajouter");
        ajouterButton.setBounds(175, 270, 150, 25);
        ajouterButton.setBackground(new Color(59, 89, 182));
        ajouterButton.setForeground(Color.WHITE);
        ajouterButton.setFocusPainted(false);
        ajouterButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        // ajouterButton.addActionListener(this);

        /* ajoute les éléments à notre panel */
        this.add(welcome);
        this.add(generate);

        this.add(lblid);
        this.add(lblprenom);
        this.add(lblnom);
        this.add(lbldate);

        this.add(id);
        this.add(prenom);
        this.add(nom);
        this.add(dateNaissance);

        this.add(ajouterButton);

    }

    /*
     * fonction qui affiche une boite de dialogue pour confirmer l'ajout d'un
     * utilisateur
     */
    public void added() {
        JOptionPane.showMessageDialog(this, "Ajout réussi.");
        revalidate();
        removeAll();
    }

    /*
     * fonction qui affiche une boite de dialogue pour signaler une erreur lors de
     * l'ajout
     */
    public void notAdded() {
        JOptionPane.showMessageDialog(this, "L'id saisi existe déjà.", "Erreur d'ajout'", JOptionPane.WARNING_MESSAGE);
        revalidate();
    }

    public void actionPerformed(ActionEvent e) {
        this.frame.setContentPane(this);
        this.frame.revalidate();

        ajouterButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int valId = Integer.parseInt(id.getText());
                String valPrenom = prenom.getText();
                String valNom = nom.getText();
                String valDateNaissance = dateNaissance.getText();

                System.out.println(valId + " " + valPrenom + " " + valNom + " " + valDateNaissance);
                Database.ajouterVisiteur(valId, valNom, valPrenom, valDateNaissance);
                if (Database.ajouterVisiteur(valId, valNom, valPrenom, valDateNaissance) == 1) {
                    added();
                } else {
                    notAdded();
                }
            }
        });

    }
}