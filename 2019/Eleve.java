import java.util.*;

public class Eleve implements Comparable<Eleve> {
    private String id;
    private String nom;
    private String prenom;
    private Parent parent;

    public Eleve(String id, String nom, String prenom, Parent parent) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.parent = parent;
    }

    public Eleve(String id, String nom, String prenom) {
        this(id, nom, prenom, null);
    }

    // Getters & setters
    public String getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public Parent getParent() { return parent; }
    public void setParent(Parent parent) { this.parent = parent; }

    @Override
    public int compareTo(Eleve autre) {
        return this.nom.compareTo(autre.nom);
    }

    @Override
    public String toString() {
        return nom + " " + prenom + " (" + id + ")";
    }
}
