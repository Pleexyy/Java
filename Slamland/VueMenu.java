import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueMenu extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JMenuBar barre;
    private JMenu menu;
    private JMenuItem attraction, visiteurs, commerces, magasins;

    public VueMenu(JFrame frame) {
        barre = new JMenuBar();
        menu = new JMenu("Menu");
        attraction = new JMenuItem("Afficher les attractions des parcs");
        visiteurs = new JMenuItem("Afficher les visiteurs d'une attraction");
        commerces = new JMenuItem("Afficher les consommateurs");
        magasins = new JMenuItem("Afficher les articles d'un magasin");

        attraction.addActionListener(new VueAttractions(frame));
        visiteurs.addActionListener(new VueVisiteurs(frame));
        commerces.addActionListener(new VueCommerce(frame));
        magasins.addActionListener(new VueMagasin(frame));

        menu.add(attraction);
        menu.add(visiteurs);
        menu.add(commerces);
        menu.add(magasins);
        barre.add(menu);

        this.add(barre);

        frame.getContentPane().add(this);

        frame.setJMenuBar(barre);

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

    }
}