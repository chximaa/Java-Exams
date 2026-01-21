import java.time.LocalDate;
import java.util.Map;

public class ArticleJournal extends Publication {
    private String journal;
    private int volume;
    private int nombre;

    public ArticleJournal(String journal, int volume, int nombre,
                          int doi, String titre, LocalDate année, Chercheur auteur, Map<Integer, Publication> citations) {
        super(doi, titre, année, auteur, citations);
        this.journal = journal;
        this.volume = volume;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Journal=" + journal +
               ", Volume=" + volume +
               ", Nombre=" + nombre +
               ", Titre=" + getTitre() +
               ", Année=" + getAnnée() +
               ", Nombre de citations=" + getNombreCitations();
    }

    // Getters
    public String getJournal() { return journal; }
    public int getVolume() { return volume; }
    public int getNombre() { return nombre; }
}
