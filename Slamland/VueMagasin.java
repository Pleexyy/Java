import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VueMagasin extends JPanel implements ActionListener {
    private JTable table;
    private ArrayList<Magasin> listeMagasins;
    private JFrame frame;
    private JComboBox<String> articles = new JComboBox<>();
    private JLabel welcome, generate, generate2;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public VueMagasin(JFrame frame) {
        this.frame = frame;
        listeMagasins = Database.getLesMagasins();
        welcome = new JLabel();
        welcome.setText("Veuillez sélectionner un magasin.");
        welcome.setBounds(50, 50, 50, 50);

        /* ajoute chaque élément de notre liste de magasins dans une JComboBox */
        for (int i = 0; i < listeMagasins.size(); i++) {
            articles.addItem(listeMagasins.get(i).getNom());
        }

        /* texte informatif */
        generate = new JLabel();
        generate.setText("Un tableau sera généré.");
        generate.setBounds(150, 150, 100, 100);

        /* texte informatif */
        generate2 = new JLabel();
        generate2.setText("Il contiendra la liste des articles présents dans le magasin choisi.");
        generate2.setBounds(175, 150, 100, 100);

        /* ajoute les éléments à notre panel */
        this.add(welcome);
        this.add(generate);
        this.add(generate2);
        this.add(articles);
        this.add(new JScrollPane(table));

    }

    public void actionPerformed(ActionEvent e) {
        this.frame.setContentPane(this);
        this.frame.revalidate();

        articles.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int index = articles.getSelectedIndex();

                Magasin magasin = listeMagasins.get(index);
                System.out.println(magasin.getLesArticles());
            }
        });

    }
}