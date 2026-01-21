import java.util.HashMap;
import java.util.Map;

public class Indexeur {
    private String nom;
    private Map<Integer, Publication> articles;

    public Indexeur(String nom) {
        this.nom = nom;
        this.articles = new HashMap<>();
    }

    public Indexeur(String nom, Map<Integer, Publication> articles) {
        this.nom = nom;
        this.articles = articles;
    }

    public Publication recupererPublication(int doi) {
        return articles.get(doi);
    }

    public boolean ajouterPublication(Publication p) {
        if (articles.containsKey(p.getDoi())) {
            return false;
        }
        articles.put(p.getDoi(), p);
        return true;
    }

    @Override
    public String toString() {
        return "Nom Indexeur=" + nom + ", Nombre articles=" + articles.size();
    }
}
