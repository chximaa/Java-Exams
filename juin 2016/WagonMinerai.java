public class WagonMinerai extends Wagon {
    private final static float tonnageMax=22;
    private float tonnage;
    private static int nombreWagonsMinerai=0;

    public WagonMinerai(String code, String description, float tonnage) {
        super(code, description);
        this.tonnage = tonnage;
        nombreWagonsMinerai++;
    }

    @Override
    public String toString() {
        return "WagonMinerai -> " + super.toString() +
                ", Tonnage=" + tonnage + "/" + tonnageMax;
    }
}
