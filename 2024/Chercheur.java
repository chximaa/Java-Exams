import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Chercheur {
    private String nom;
    private String prenom;
    private String laboratoire;
    private String université;
    private int nombrePublications;
    private int totalCitations;
    private int h_index;
    private Set<Publication> publications;

    // nouveau chercheur sans publications
    public Chercheur(String nom, String prenom, String laboratoire, String université) {
        this.nom = nom;
        this.prenom = prenom;
        this.laboratoire = laboratoire;
        this.université = université;
        this.publications = new HashSet<>();
        this.nombrePublications = 0;
        this.totalCitations = 0;
        this.h_index = 0;
    }

    // nouveau chercheur avec publications
    public Chercheur(String nom, String prenom, String laboratoire, String université, Set<Publication> publications) {
        this.nom = nom;
        this.prenom = prenom;
        this.laboratoire = laboratoire;
        this.université = université;
        this.publications = publications;
        this.nombrePublications = publications.size();
        this.totalCitations = nombreCitations();
        this.h_index = calculerHindex();
    }

    public void ajouterPublication(Publication nouvellePublication) {
        publications.add(nouvellePublication);
        nombrePublications = publications.size();
        totalCitations = nombreCitations();
        h_index = calculerHindex();
    }

    public void ajouterArticleJournal(String journal, int volume, int nombre,
                                      int doi, String titre, LocalDate année,
                                      Chercheur auteur, Map<Integer, Publication> citations) {

        Publication article = new ArticleJournal(journal, volume, nombre, doi, titre, année, auteur, citations);
        publications.add(article);
        nombrePublications = publications.size();
        totalCitations = nombreCitations();
        h_index = calculerHindex();
    }

    public void ajouterArticleConference(String conference, String ville, String pays,
                                         int doi, String titre, LocalDate année,
                                         Chercheur auteur, Map<Integer, Publication> citations) {

        Publication article = new ArticleConference(conference, ville, pays, doi, titre, année, auteur, citations);
        publications = publications.stream().collect(Collectors.toSet()); // using streams
        publications.add(article);
        nombrePublications = publications.size();
        totalCitations = nombreCitations();
        h_index = calculerHindex();
    }

    public int nombrePublications() {
        return publications.size();
    }

    private int nombreCitations() {
        return publications.stream()
                .mapToInt(Publication::getNombreCitations)
                .sum();
    }

    public int nombreArticlesJournaux() {
        return (int) publications.stream()
                .filter(p -> p instanceof ArticleJournal)
                .count();
    }

    public int nombreArticlesConferences() {
        return (int) publications.stream()
                .filter(p -> p instanceof ArticleConference)
                .count();
    }

    @Override
    public String toString() {
        return "Chercheur=" + nom + " " + prenom +
               ", Nombre de publications=" + nombrePublications() +
               ", Total citations=" + totalCitations +
               ", h-index=" + h_index +
               ", Articles journaux=" + nombreArticlesJournaux() +
               ", Articles conférences=" + nombreArticlesConferences();
    }

    public int calculerHindex() {
        List<Integer> citationsList = publications.stream()
                .map(Publication::getNombreCitations)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int h = 0;
        for (int i = 0; i < citationsList.size(); i++) {
            if (citationsList.get(i) >= i + 1) {
                h = i + 1;
            } else {
                break;
            }
        }
        return h;
    }
}
