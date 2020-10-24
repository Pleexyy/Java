import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VueAttractions extends JPanel implements ActionListener {
    private JTable table;
    private ArrayList<Attraction> listeAttractions, listeParcs;
    private JFrame frame;
    private JButton export;
    private String chaine;
    private JComboBox<String> parcs = new JComboBox<>();
    private JLabel welcome, generate;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public VueAttractions(JFrame frame) {
        this.frame = frame;
        // DefaultTableModel lesAttractions = new DefaultTableModel(new String[]{"Nom du
        // parc d'attractions", "Ville du parc d'attractions"}, 0);
        // listeAttractions = Database.getLesAttractions();
        // for (int i = 0; i < listeAttractions.size(); i++) {
        // lesAttractions.addRow(new String[]{listeAttractions.get(i).getNom(),
        // listeAttractions.get(i).getVille()});
        // table = new JTable(lesAttractions);
        // }
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
        if (e.getSource() == export) {
            chaine = "";

            // ------> AFFICHER DANS LA CONSOLE LES ATTRACTIONS CORRESPONDANTS AU PARC CHOISI AU FORMAT XML <------

            // for (int i = 0; i < listeAttractions.size(); i++) {
            // chaine += "<lesAttractions> + \n" + "<attraction>"
            // listeAttractions.get(i).getNom() + " " + listeAttractions.get(i).getVille();
            // }
            // System.out.println(chaine);
            // }
            //
        }
    }
}