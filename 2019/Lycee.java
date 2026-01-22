import java.util.*;
import java.util.stream.*;

public class Lycee {
    private String nom;
    private Set<Parent> parents;
    private Map<String, Parent> délégués;

    public Lycee(String nom) {
        this.nom = nom;
        this.parents = new TreeSet<>(new CompNbEnfants());
        this.délégués = new HashMap<>();
    }

    public void ajouterParent(Parent parent) {
        this.parents.add(parent);
    }

    public Parent chercherParent(String CIN) {
        return this.parents.stream()
                           .filter(p -> p.getCin().equals(CIN))
                           .findFirst()
                           .orElse(null);
    }

    public void ajouterDélégué(String CIN) throws ParentInexistantException {
        Parent p = chercherParent(CIN);
        if(p == null) throw new ParentInexistantException();
        this.délégués.put(CIN, p);
    }

    public void ajouterDélégué(Parent p) throws ParentInexistantException {
        if(p == null || !this.parents.contains(p)) throw new ParentInexistantException();
        this.délégués.put(p.getCin(), p);
    }

    public void ajouterDélégués(String[] tabCIN) throws ParentInexistantException {
        for(String cin : tabCIN) {
            ajouterDélégué(cin);
        }
    }

    public void afficherPourcentageTypes() {
        long total = délégués.size();
        if(total == 0) {
            System.out.println("Aucun délégué.");
            return;
        }

        long nbPere = délégués.values().stream()
                              .filter(p -> p.getType() == TypeParent.pere)
                              .count();
        long nbMere = délégués.values().stream()
                              .filter(p -> p.getType() == TypeParent.mere)
                              .count();
        long nbTuteur = délégués.values().stream()
                                .filter(p -> p.getType() == TypeParent.tuteur)
                                .count();

        System.out.printf("Pourcentage des pères: %.2f%%\n", (nbPere * 100.0) / total);
        System.out.printf("Pourcentage des mères: %.2f%%\n", (nbMere * 100.0) / total);
        System.out.printf("Pourcentage des tuteurs: %.2f%%\n", (nbTuteur * 100.0) / total);
    }

    @Override
    public String toString() {
        return "Lycée " + nom + "\nParents: " + parents + "\nDélégués: " + délégués.values();
    }
}
