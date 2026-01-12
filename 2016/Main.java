public class Main {
    public static void main(String[] args) {

        try {
            Personnel p = new Personnel("C01", "Smith", "John");
            Train train = new Train("T100", p, TypeTrain.PassagersMarchandise);

            train.ajouterWagonPassagers("WP1", "Voiture A", 40);
            train.ajouterWagonMarchandise("WM1", "Fret", 30);

            System.out.println(train);
            train.afficherCharge();

        } catch (TrainWagonIncompatiblesException e) {
            System.out.println(e.getMessage());
        }
    }
}
