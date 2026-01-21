import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public abstract class Publication implements Comparable<Publication> {
    private int doi;
    private String titre;
    private LocalDate année;
    private Chercheur auteur;
    private int nombreCitations;
    private Map<Integer, Publication> citations;

    // nouvelle publication non encore citée
    public Publication(int doi, String titre, LocalDate année, Chercheur auteur) {
        this.doi = doi;
        this.titre = titre;
        this.année = année;
        this.auteur = auteur;
        this.nombreCitations = 0;
        this.citations = new HashMap<>();
    }

    // nouvelle publication citée
    public Publication(int doi, String titre, LocalDate année, Chercheur auteur, Map<Integer, Publication> citations) {
        this.doi = doi;
        this.titre = titre;
        this.année = année;
        this.auteur = auteur;
        this.citations = citations;
        this.nombreCitations = citations.size();
    }

    public void setCitations(Map<Integer, Publication> citations) {
        this.citations = citations;
        this.nombreCitations = citations.size();
    }

    public boolean ajouterCitation(Publication pub) {
        if (citations.containsKey(pub.getDoi())) {
            return false;
        }
        citations.put(pub.getDoi(), pub);
        nombreCitations++;
        return true;
    }

    @Override
    public String toString() {
        return "Titre=" + titre + ", Année=" + année + ", Nombre de citations=" + nombreCitations;
    }

    @Override
    public int compareTo(Publication autrePublication) {
        int cmp = Integer.compare(autrePublication.nombreCitations, this.nombreCitations);
        if (cmp != 0) return cmp;

        cmp = this.année.compareTo(autrePublication.année);
        if (cmp != 0) return cmp;

        return this.titre.compareTo(autrePublication.titre);
    }

    // Getters
    public int getDoi() { return doi; }
    public String getTitre() { return titre; }
    public LocalDate getAnnée() { return année; }
    public int getNombreCitations() { return nombreCitations; }
    public Map<Integer, Publication> getCitations() { return citations; }
}
