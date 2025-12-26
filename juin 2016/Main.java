public class Main {
    public static void main(String[] args) throws Exception {
        Personnel p = new Personnel("M01","Ahmed","Ali");
        Train t = new Train("T1",p,TypeTrain.Marchandise);

        t.ajouterWagon(new WagonMarchandise("W1","Bois",30));
        t.ajouterWagon(new WagonMarchandise("W2","Fer",40));

        t.AfficherCharge();
        System.out.println("Longueur = "+t.getLongueur());
    }
}
