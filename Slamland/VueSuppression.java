import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VueSuppression extends JPanel implements ActionListener {
    private JFrame frame;
    private JTable table;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public VueSuppression(JFrame frame) {
    	JScrollPane scrollpane = null;
        this.frame = frame;
//        this.setLayout(null);
        
		String[] entetes = {"id visiteur", "nom visiteur", "prénom visiteur", "date de naissance"};
        Object[][] donnees = new Object[Database.getLesVisiteurs().size()][4];

        for (int i = 0; i < Database.getLesVisiteurs().size(); i++) {
        	donnees[i][0] = Database.getLesVisiteurs().get(i).getId();
        	donnees[i][1] = Database.getLesVisiteurs().get(i).getNom();
        	donnees[i][2] = Database.getLesVisiteurs().get(i).getPrenom();
        	donnees[i][3] = Database.getLesVisiteurs().get(i).getDateNaissance();
        }
        
		table = new JTable(donnees, entetes);
		scrollpane = new JScrollPane(table);
		this.add(scrollpane);
		
		frame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        this.frame.setContentPane(this);
        this.frame.revalidate();
		
	}
}