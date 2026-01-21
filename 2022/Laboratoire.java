import java.util.ArrayList;
import java.util.Collections;

public class Laboratoire {
    private String nom;
    private ArrayList<Chercheur> chercheurs;
    private int lab_Hindex;
    private char categorie;

    // Méthode pour mettre à jour la catégorie
    private char mettreAjourCategorie() {
        if (lab_Hindex < 40) return 'D';
        else if (lab_Hindex < 60) return 'C';
        else if (lab_Hindex < 80) return 'B';
        else return 'A';
    }

    // Constructeur simple
    public Laboratoire(String nom) {
        this.nom = nom;
        this.chercheurs = new ArrayList<>();
        this.lab_Hindex = 0;
        this.categorie = mettreAjourCategorie();
    }

    // Constructeur avec liste de chercheurs
    public Laboratoire(String nom, ArrayList<Chercheur> chercheurs) {
        this.nom = nom;
        this.chercheurs = chercheurs;
        this.lab_Hindex = 0;
        for (Chercheur c : chercheurs) {
            this.lab_Hindex += c.getH_index();
        }
        this.categorie = mettreAjourCategorie();
    }

    // Ajouter un chercheur
    public void ajouterChercheur(Chercheur chercheur) throws ChercheurDejaExistant {
        if (chercheurs.contains(chercheur)) throw new ChercheurDejaExistant();
        chercheurs.add(chercheur);
        lab_Hindex += chercheur.getH_index();
        categorie = mettreAjourCategorie();
    }

    // Supprimer un chercheur
    public void supprimerChercheur(Chercheur chercheur) throws ChercheurNonExistant {
        if (!chercheurs.contains(chercheur)) throw new ChercheurNonExistant();
        chercheurs.remove(chercheur);
        lab_Hindex -= chercheur.getH_index();
        categorie = mettreAjourCategorie();
    }

    // Trier les chercheurs
    public void trierChercheurs() {
        Collections.sort(chercheurs, new CompH_Index());
    }

    // Afficher chercheurs
    public void afficherChercheurs() {
        trierChercheurs();
        int i = 1;
        for (Chercheur c : chercheurs) {
            System.out.println(i + " : " + c);
            i++;
        }
    }

    // Getters
    public String getNom() { return nom; }
    public ArrayList<Chercheur> getChercheurs() { return chercheurs; }
    public int getLab_Hindex() { return lab_Hindex; }
    public char getCategorie() { return categorie; }

    // toString
    @Override
    public String toString() {
        return "Laboratoire{nom=" + nom + " Lab_H_Index =" + lab_Hindex + ", categorie=" + categorie + "}";
    }
}
