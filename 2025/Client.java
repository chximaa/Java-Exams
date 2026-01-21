public class Client {
    private String nom;

    public Client(String nom) {
        this.nom = nom;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    @Override
    public String toString() { return nom; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return nom.equals(client.nom);
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }
}
