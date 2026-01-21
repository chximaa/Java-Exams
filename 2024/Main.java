import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // --------------------------
        // 1️⃣ Create a researcher
        // --------------------------
        Chercheur c1 = new Chercheur("Elmehdaoui", "Chaimaa", "LRI", "ENSET");

        // --------------------------
        // 2️⃣ Add a journal article
        // --------------------------
        Map<Integer, Publication> citationsJournal = new HashMap<>();
        c1.ajouterArticleJournal(
                "Journal of AI", 12, 100, 101, "Deep Learning Advances",
                LocalDate.of(2023, 5, 1), c1, citationsJournal
        );

        // --------------------------
        // 3️⃣ Add a conference article
        // --------------------------
        Map<Integer, Publication> citationsConf = new HashMap<>();
        c1.ajouterArticleConference(
                "ICML", "Paris", "France", 102, "ML in 2023",
                LocalDate.of(2023, 6, 10), c1, citationsConf
        );

        // --------------------------
        // 4️⃣ Print researcher info
        // --------------------------
        System.out.println(c1);

        // --------------------------
        // 5️⃣ Create Indexeur and add publications
        // --------------------------
        Indexeur indexeur = new Indexeur("ScienceIndex");
        for (Publication pub : c1.nombrePublications() > 0 ? c1.publications : new HashMap<>().values()) {
            indexeur.ajouterPublication(pub);
        }

        // Better: manually add since publications is private (or add getter)
        indexeur.ajouterPublication(c1.nombreArticlesJournaux() > 0 ? new ArticleJournal(
                "Journal of AI", 12, 100, 101, "Deep Learning Advances",
                LocalDate.of(2023,5,1), c1, citationsJournal
        ) : null);

        indexeur.ajouterPublication(c1.nombreArticlesConferences() > 0 ? new ArticleConference(
                "ICML","Paris","France",102,"ML in 2023",
                LocalDate.of(2023,6,10), c1, citationsConf
        ): null);

        // --------------------------
        // 6️⃣ Print indexeur info
        // --------------------------
        System.out.println(indexeur);

        // --------------------------
        // 7️⃣ Retrieve a publication
        // --------------------------
        Publication p = indexeur.recupererPublication(101);
        if (p != null) {
            System.out.println("Récupéré: " + p);
        }
    }
}
