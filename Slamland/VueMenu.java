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
    private JMenuItem attraction;

    public VueMenu(JFrame frame) {
        barre = new JMenuBar();
        menu = new JMenu("Menu");
        attraction = new JMenuItem("Afficher les attractions des parcs");

        attraction.addActionListener(new VueAttractions(frame));

        menu.add(attraction);
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