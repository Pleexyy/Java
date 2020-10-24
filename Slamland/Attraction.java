import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;  

public class Attraction extends JPanel implements ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String nom, ville;

	public Attraction(String nom, String ville) {
		this.nom = nom;
		this.ville = ville;
	}

	public String getNom() {
		return this.nom;
	}

	public String getVille() {
		return this.ville;
    }
    
    // public String toXML() {
    //     // TextArea xml = new TextArea("TestXML");  
    //     // this.add(xml);
    //     String chaine = "";
    //     chaine += 
    // }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

    }
}
