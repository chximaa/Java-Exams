public class Personnel {

    private String matricule;
    private String nom;
    private String prenom;

    public Personnel(String matricule, String nom, String prenom) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    @Override
    public String toString() {
        return prenom + " " + nom + " (Matricule: " + matricule + ")";
    }
}
