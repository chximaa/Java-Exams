import java.util.ArrayList;

public class Train {

    private String code;
    private Personnel conducteur;
    private TypeTrain type;
    private int longueur;
    private ArrayList<Wagon> wagons;

    public Train(String code, Personnel conducteur, TypeTrain type) {
        this.code = code;
        this.conducteur = conducteur;
        this.type = type;
        this.wagons = new ArrayList<>();
        this.longueur = 0;
    }

    public Train(String code, Personnel conducteur, TypeTrain type, ArrayList<Wagon> wagons) {
        this.code = code;
        this.conducteur = conducteur;
        this.type = type;
        this.wagons = wagons;
        this.longueur = wagons.size();
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public void ajouterWagonPassagers(String code, String description, int nombrePassagers)
            throws TrainWagonIncompatiblesException {

        if (!(type == TypeTrain.Passagers || type == TypeTrain.PassagersMarchandise))
            throw new TrainWagonIncompatiblesException("Wagon Passagers incompatible");

        wagons.add(new WagonPassagers(code, description, nombrePassagers));
        longueur++;
    }

    public void ajouterWagonMinerai(String code, String description, float tonnage)
            throws TrainWagonIncompatiblesException {

        if (type != TypeTrain.Minerai)
            throw new TrainWagonIncompatiblesException("Wagon Minerai incompatible");

        wagons.add(new WagonMinerai(code, description, tonnage));
        longueur++;
    }

    public void ajouterWagonMarchandise(String code, String description, float volume)
            throws TrainWagonIncompatiblesException {

        if (!(type == TypeTrain.Marchandise || type == TypeTrain.PassagersMarchandise))
            throw new TrainWagonIncompatiblesException("Wagon Marchandise incompatible");

        wagons.add(new WagonMarchandise(code, description, volume));
        longueur++;
    }

    public void ajouterWagon(Wagon wagon) throws TrainWagonIncompatiblesException {

        if (wagon instanceof WagonMinerai && type != TypeTrain.Minerai)
            throw new TrainWagonIncompatiblesException("Wagon Minerai incompatible");

        if (wagon instanceof WagonMarchandise &&
                !(type == TypeTrain.Marchandise || type == TypeTrain.PassagersMarchandise))
            throw new TrainWagonIncompatiblesException("Wagon Marchandise incompatible");

        if (wagon instanceof WagonPassagers &&
                !(type == TypeTrain.Passagers || type == TypeTrain.PassagersMarchandise))
            throw new TrainWagonIncompatiblesException("Wagon Passagers incompatible");

        wagons.add(wagon);
        longueur++;
    }

    public boolean supprimerWagon(String code) {
        for (Wagon w : wagons) {
            if (w.getCode().equals(code)) {
                wagons.remove(w);
                longueur--;
                return true;
            }
        }
        return false;
    }

    public void afficherCharge() {

        switch (type) {

            case Minerai:
                float totalTonnage = 0;
                for (Wagon w : wagons)
                    totalTonnage += ((WagonMinerai) w).getTonnage();
                System.out.println("Tonnage total : " + totalTonnage + " tonnes");
                break;

            case Marchandise:
                float totalVolume = 0;
                for (Wagon w : wagons)
                    totalVolume += ((WagonMarchandise) w).getVolume();
                System.out.println("Volume total : " + totalVolume + " m3");
                break;

            case Passagers:
            case PassagersMarchandise:
                int totalPassagers = 0;
                for (Wagon w : wagons)
                    if (w instanceof WagonPassagers)
                        totalPassagers += ((WagonPassagers) w).getNombrePassagers();
                System.out.println("Nombre de passagers : " + totalPassagers);
                break;
        }
    }

    @Override
    public String toString() {
        return "Train " + code + " | Type=" + type +
                " | Conducteur=" + conducteur +
                " | Longueur=" + longueur;
    }
}
