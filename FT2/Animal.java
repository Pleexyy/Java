public class Animal {
    private String espece;
    private String nom;

    /
     * @param unNom
     */
    public Animal(String unNom) {
        this.nom = unNom;
    }

    /
     * @param unNom
     * @param uneEspece
     */
    public Animal(String unNom, String uneEspece) {
        this.nom = unNom;
        this.espece = uneEspece;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String unNom) {
        this.nom = unNom;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String uneEspece) {
        this.espece = uneEspece;
    }

    public String toString() {
        String chaine = "";
        if (this.nom != null) {
            chaine += "nom : " + this.nom;
        }
        if (this.espece != null) {
            chaine += " | espèce : " + this.espece;
        }
        return chaine;
    }
}