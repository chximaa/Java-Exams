import java.util.ArrayList;
import java.util.Collections;

public class Universite {
    private String nom;
    private ArrayList<Laboratoire> laboratoires;

    public Université(String nom) {
        this.nom = nom;
        this.laboratoires = new ArrayList<>();
    }

    public void ajouterLaboratoire(String nom) {
        laboratoires.add(new Laboratoire(nom));
    }

    public void ajouterLaboratoire(Laboratoire lab) {
        laboratoires.add(lab);
    }

    public void ajouterChercheur(Laboratoire laboratoire, Chercheur chercheur) {
        try {
            laboratoire.ajouterChercheur(chercheur);
        } catch (ChercheurDejaExistant e) {
            System.out.println("Chercheur déjà existant !");
        }
    }

    public void supprimerChercheur(Laboratoire laboratoire, Chercheur chercheur) {
        try {
            laboratoire.supprimerChercheur(chercheur);
        } catch (ChercheurNonExistant e) {
            System.out.println("Chercheur non existant !");
        }
    }

    public void trierLaboratoires() {
        Collections.sort(laboratoires, new CompLabH_Index());
    }

    public void afficherLaboratoires() {
        trierLaboratoires();
        for (Laboratoire lab : laboratoires) {
            System.out.println(lab);
        }
    }

    // Getter
    public ArrayList<Laboratoire> getLaboratoires() {
        return laboratoires;
    }
}
