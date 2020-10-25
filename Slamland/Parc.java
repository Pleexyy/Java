import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Parc extends JPanel implements ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String nom, ville;
    private int id;
    private ArrayList<Attraction> listeAttractions;

    public Parc(int id, String nom, String ville, ArrayList<Attraction> listeAttractions) {
        this.id = id;
        this.nom = nom;
        this.ville = ville;
        this.listeAttractions = listeAttractions;
    }

	public String getNom() {
        return this.nom;
    }

    public String getVille() {
        return this.ville;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

    }

    public String getLesAttractions() {
        String chaine ="";
        chaine += "\n" + "<lesAttractions>" + "\n";
        for (int i = 0; i < listeAttractions.size(); i++) {
            chaine += listeAttractions.get(i).toXML();
        }
        chaine += "</lesAttractions>";
        return chaine;
    }
}
