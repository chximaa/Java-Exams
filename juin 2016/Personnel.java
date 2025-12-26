public class Personnel {
    private String matricule, nom, prenom;

    public Personnel(String matricule, String nom, String prenom) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString(){
        return nom+" "+prenom+" ("+matricule+")";
    }
}
