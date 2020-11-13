import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class VueSuppression extends JPanel implements ActionListener {
    private JFrame frame;
    private JTable table;
    private JButton btnSupprimer;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public VueSuppression(JFrame frame) {
        JScrollPane scrollpane = null;
        this.frame = frame;

        /*
         * création de notre bouton pour supprimer un visiteur de notre base de données
         */
        btnSupprimer = new JButton("Supprimer");
        btnSupprimer.setBounds(190, 270, 150, 25);
        btnSupprimer.setBounds(175, 270, 150, 25);
        btnSupprimer.setBackground(new Color(59, 89, 182));
        btnSupprimer.setForeground(Color.WHITE);
        btnSupprimer.setFocusPainted(false);
        btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnSupprimer.addActionListener(this);

        /* création des titres de notre JTable */
        String[] entetes = { "id visiteur", "nom visiteur", "pr�nom visiteur", "date de naissance" };
        Object[][] donnees = new Object[Database.getLesVisiteurs().size()][4];

        /* ajout à notre tableau à 2 dimensions des informations du visiteur */
        for (int i = 0; i < Database.getLesVisiteurs().size(); i++) {
            donnees[i][0] = Database.getLesVisiteurs().get(i).getId();
            donnees[i][1] = Database.getLesVisiteurs().get(i).getNom();
            donnees[i][2] = Database.getLesVisiteurs().get(i).getPrenom();
            donnees[i][3] = Database.getLesVisiteurs().get(i).getDateNaissance();
        }
        /* création du table + remplissage */
        table = new JTable(donnees, entetes);
        /* ajout du tableau à un scrollpane */
        scrollpane = new JScrollPane(table);
        /* ajout du scrollpane au panel */
        this.add(scrollpane);

        /* ajout du bouton supprimer au panel */
        this.add(btnSupprimer);

        frame.setVisible(true);
    }

    /*
     * fonction qui affiche une boite de dialogue pour confirmer la supression d'un
     * visiteur
     */
    public void removed() {
        JOptionPane.showMessageDialog(this, "Suppression réussie.");
        revalidate();

    }

    /*
     * fonction qui affiche une boite de dialogue pour signaler une erreur lors de
     * la supression
     */
    public void notRemoved() {
        JOptionPane.showMessageDialog(this, "Erreur.", "Erreur lors de la suppression", JOptionPane.WARNING_MESSAGE);
        revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.frame.setContentPane(this);
        this.frame.revalidate();

        if (e.getSource() == btnSupprimer) {
            /* on récupère la colonne et la ligne sur laquelle la sélection est faite */
            int row = table.getSelectedRow();
            int column = 0;
            /* on converti la valeur récuperée en entier */
            int id = Integer.parseInt(table.getModel().getValueAt(row, column).toString());
            /*
             * appelle la boite de dialogue en fonction du résultat renvoyé par la fonction
             */
            if (Database.supprimerVisiteur(id) == 1) {
                removed();
            } else {
                notRemoved();
            }

        }

    }
}