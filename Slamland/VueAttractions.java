import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VueAttractions extends JPanel implements ActionListener {
    private JTable table;
    private ArrayList<Parc> listeParcs;
    private JFrame frame;
    private JComboBox<String> parcs = new JComboBox<>();
    private JLabel welcome, generate;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public VueAttractions(JFrame frame) {
        this.frame = frame;
        listeParcs = Database.getLesParcs();
        welcome = new JLabel();
        welcome.setText("Veuillez sélectionner un parc d'attractions");
        welcome.setBounds(50, 50, 50, 50);

        for (int i = 0; i < listeParcs.size(); i++) {
            parcs.addItem(listeParcs.get(i).getNom() + " " + listeParcs.get(i).getVille());
        }

        generate = new JLabel();
        generate.setText("Un texte au format XML sera affiché dans la console");
        generate.setBounds(150, 150, 100, 100);

        this.add(welcome);
        this.add(generate);
        this.add(parcs);

        this.add(new JScrollPane(table));

    }

    public void actionPerformed(ActionEvent e) {
        this.frame.setContentPane(this);
        this.frame.revalidate();

        parcs.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int index = parcs.getSelectedIndex();

                Parc parc = listeParcs.get(index);
                System.out.println(parc.getLesAttractions());
            }
        });

    }
}