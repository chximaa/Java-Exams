import java.util.*;
import java.util.stream.*;

public class Parent {
    private String cin;
    private String nom;
    private String prénom;
    private TypeParent type;
    private Set<Eleve> enfants;

    public Parent(String cin, String nom, String prénom, TypeParent type) {
        this.cin = cin;
        this.nom = nom;
        this.prénom = prénom;
        this.type = type;
        this.enfants = new HashSet<>();
    }

    // Getters
    public String getCin() { return cin; }
    public String getNom() { return nom; }
    public String getPrénom() { return prénom; }
    public TypeParent getType() { return type; }
    public Set<Eleve> getEnfants() { return enfants; }

    // Add children
    public void ajouterEnfant(Eleve eleve) {
        eleve.setParent(this);
        this.enfants.add(eleve);
    }

    public void ajouterEnfant(String id, String nom, String prenom) {
        Eleve eleve = new Eleve(id, nom, prenom, this);
        this.enfants.add(eleve);
    }

    public void ajouterEnfants(Set<Eleve> enfants) {
        enfants.stream().forEach(e -> {
            e.setParent(this);
            this.enfants.add(e);
        });
    }

    // Search child
    public Eleve chercherEnfant(String id) {
        return this.enfants.stream()
                           .filter(e -> e.getId().equals(id))
                           .findFirst()
                           .orElse(null);
    }

    // Remove child
    public boolean supprimerEnfant(String id) {
        return this.enfants.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public String toString() {
        return nom + " " + prénom + " (" + type + "), enfants: " + enfants;
    }
}
