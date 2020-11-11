public class Restaurant {
    private String nbTables;
    private int capacite;

    public Restaurant(String nbTables, int capacite) {
        this.nbTables = nbTables;
        this.capacite = capacite;
    }

    public String getNbTables() {
        return this.nbTables;
    }

    public int getCapacite() {
        return this.capacite;
    }

}
