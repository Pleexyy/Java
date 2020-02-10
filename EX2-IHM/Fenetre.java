import java.awt.*;
import javax.swing.*;

public class Fenetre extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel monPanel;
    private JPanel monPanel2;
    private JButton btnRouge;
    private JButton btnVert;
    private JButton btnBleu;
    private JButton btnJaune;

    public Fenetre() {

        this.setTitle("Exercice 2");
        this.setLocationRelativeTo(null);
        this.setSize(400, 250);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        monPanel = new JPanel();
        monPanel2 = new JPanel();

        monPanel2.setBackground(Color.white);
        monPanel.setBackground(Color.red);

        btnRouge = new JButton();
        btnRouge.setText("Rouge");
        monPanel2.add(btnRouge);

        btnVert = new JButton();
        btnVert.setText("Vert");
        monPanel2.add(btnVert);

        btnBleu = new JButton();
        btnBleu.setText("Bleu");
        monPanel2.add(btnBleu);

        btnJaune = new JButton();
        btnJaune.setText("Jaune");
        monPanel2.add(btnJaune);

        monPanel.setLayout(new BorderLayout());

        // ajoute le panel contenant les boutons au panel avec le fond rouge
        monPanel.add(monPanel2, BorderLayout.NORTH);

        // Ajoute les composants crées, à la fenetre
        this.getContentPane().add(monPanel);
        this.setVisible(true);
    }
}
