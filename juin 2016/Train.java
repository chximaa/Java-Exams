import java.util.ArrayList;

public class Train {
    private String code;
    private Personnel conducteur;
    private TypeTrain type;
    private int longueur;
    private ArrayList<Wagon> wagons;

    // (4) Constructeur simple
    public Train(String code, Personnel conducteur, TypeTrain type) {
        this.code = code;
        this.conducteur = conducteur;
        this.type = type;
        this.wagons = new ArrayList<>();
        this.longueur = 0;
    }

    // (5) Constructeur avec wagons
    public Train(String code, Personnel conducteur, TypeTrain type, ArrayList<Wagon> wagons) {
        this(code, conducteur, type);
        this.wagons = wagons;
        this.longueur = wagons.size();
    }

    // (6) Setter/Getter longueur
    public int getLongueur() { return longueur; }
    public void setLongueur(int longueur) { this.longueur = longueur; }

    // FOURNI (passagers)
    public void ajouterWagonPassagers(String code, String description, int nombrePassagers)
            throws TrainWagonIncompatiblesException {}

    // (7) ajouter wagon minerai
    public void ajouterWagonMinerai(String code, String description, float tonnage)
            throws TrainWagonIncompatiblesException {
        if(type!=TypeTrain.Minerai)
            throw new TrainWagonIncompatiblesException("Train incompatible avec Minerai!");
        wagons.add(new WagonMinerai(code,description,tonnage));
        longueur++;
    }

    // (8) ajouter wagon générique (must check type train)
    public void ajouterWagon(Wagon wagon) throws TrainWagonIncompatiblesException {
        if((wagon instanceof WagonPassagers && type!=TypeTrain.Passagers && type!=TypeTrain.PassagersMarchandise)
        || (wagon instanceof WagonMarchandise && type!=TypeTrain.Marchandise && type!=TypeTrain.PassagersMarchandise)
        || (wagon instanceof WagonMinerai && type!=TypeTrain.Minerai))
            throw new TrainWagonIncompatiblesException("Type wagon incompatible avec le train!");

        wagons.add(wagon);
        longueur++;
    }

    // (9) supprimer wagon par code
    public boolean supprimerWagon(String code) {
        for(Wagon w : wagons){
            if(w.getCode().equals(code)){
                wagons.remove(w);
                longueur--;
                return true;
            }
        }
        return false;
    }

    // (10) afficher charge selon type
    public void AfficherCharge() {
        float total = 0;

        for(Wagon w : wagons){
            if(w instanceof WagonPassagers) total++;
            if(w instanceof WagonMarchandise) total += ((WagonMarchandise)w).getVolumeMax();
            if(w instanceof WagonMinerai) total += 22;
        }

        System.out.println("Charge totale = " + total);
    }
}
