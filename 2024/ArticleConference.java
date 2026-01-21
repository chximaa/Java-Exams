import java.time.LocalDate;
import java.util.Map;

public class ArticleConference extends Publication {
    private String conference;
    private String ville;
    private String pays;

    public ArticleConference(String conference, String ville, String pays,
                             int doi, String titre, LocalDate année, Chercheur auteur) {
        super(doi, titre, année, auteur);
        this.conference = conference;
        this.ville = ville;
        this.pays = pays;
    }

    public ArticleConference(String conference, String ville, String pays,
                             int doi, String titre, LocalDate année, Chercheur auteur, Map<Integer, Publication> citations) {
        super(doi, titre, année, auteur, citations);
        this.conference = conference;
        this.ville = ville;
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "Conférence=" + conference +
               ", Titre=" + getTitre() +
               ", Année=" + getAnnée() +
               ", Nombre de citations=" + getNombreCitations();
    }
}
