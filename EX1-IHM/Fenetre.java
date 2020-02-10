import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Fenetre extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel monPanel;
    private JButton btnValider;
    private JButton btnAnnuler;
    private JLabel lblMessage;

    public Fenetre() {

        this.setTitle("Exercice 1");
        this.setLocationRelativeTo(null);
        this.setSize(400, 250);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        monPanel = new JPanel();

        monPanel.setLayout(new BorderLayout());

        monPanel.setBackground(Color.yellow);

        btnValider = new JButton();
        btnValider.setText("Valider");
        monPanel.add(btnValider, BorderLayout.WEST);

        lblMessage = new JLabel();
        lblMessage.setText("Message à afficher ici");
        monPanel.add(lblMessage, BorderLayout.CENTER);

        btnAnnuler = new JButton();
        btnAnnuler.setText("Annuler");
        monPanel.add(btnAnnuler, BorderLayout.EAST);

        // Ajoute les composants crées, à la fenetre
        this.getContentPane().add(monPanel);
        this.setVisible(true);
    }
}
