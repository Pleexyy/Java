import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VueVisiteurs extends JPanel implements ActionListener {
    private JTable table;
    private ArrayList<Attraction> listeAttractions;
    private JFrame frame;
    private JComboBox<String> attractions = new JComboBox<>();
    private JLabel welcome, generate, generate2;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public VueVisiteurs(JFrame frame) {
        this.frame = frame;
        listeAttractions = Database.getLesAttractions();
        welcome = new JLabel();
        welcome.setText("Veuillez sélectionner une attraction");
        welcome.setBounds(50, 50, 50, 50);

        for (int i = 0; i < listeAttractions.size(); i++) {
            attractions.addItem(listeAttractions.get(i).getNom());
        }

        generate = new JLabel();
        generate.setText("Un texte au format JSON sera affiché dans la console.");
        generate.setBounds(150, 150, 100, 100);

        generate2 = new JLabel();
        generate2.setText("Il contiendra la liste des visiteurs ayant participé à l'attraction choisie");
        generate2.setBounds(175,150,100,100);

        this.add(welcome);
        this.add(generate);
        this.add(generate2);
        this.add(attractions);

        this.add(new JScrollPane(table));

    }

    public void actionPerformed(ActionEvent e) {
        this.frame.setContentPane(this);
        this.frame.revalidate();

        attractions.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int index = attractions.getSelectedIndex();

                Attraction attraction = listeAttractions.get(index);
                System.out.println(attraction.getLesVisiteurs());
            }
        });

    }
}