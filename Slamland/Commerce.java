import java.util.ArrayList;

public class Commerce {
    private String nom;
    private ArrayList <Visiteur> lesConsommateurs;

    public Commerce(String nom, ArrayList <Visiteur> lesConsommateurs) {
        this.nom = nom;
        this.lesConsommateurs = lesConsommateurs;
    }
}
