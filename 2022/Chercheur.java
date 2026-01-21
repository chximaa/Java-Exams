import java.util.Objects;

public class Chercheur {
    private String id;
    private String nom;
    private String prenom;
    private int H_index;

    public Chercheur(String id, String nom, String prenom, int H_index) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.H_index = H_index;
    }

    // Getters et setters
    public String getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public int getH_index() { return H_index; }

    public void setId(String id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setH_index(int h_index) { this.H_index = h_index; }

    // equals() et hashCode() pour contains() et listes
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chercheur)) return false;
        Chercheur c = (Chercheur) o;
        return id.equals(c.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString
    @Override
    public String toString() {
        return "Chercheur{nom = " + nom + ", prenom = " + prenom + ", H_index=" + H_index + "}";
    }
}
