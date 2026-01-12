public class WagonMinerai extends Wagon {

    private static final float tonnageMax = 22;
    private float tonnage;
    private static int nombreWagonsMinerai = 0;

    public WagonMinerai(String code, String description, float tonnage) {
        super(code, description);
        this.tonnage = tonnage;
        nombreWagonsMinerai++;
    }

    public float getTonnage() {
        return tonnage;
    }

    public void setTonnage(float tonnage) {
        this.tonnage = tonnage;
    }

    public static float getTonnageMax() {
        return tonnageMax;
    }

    public static int getNombreWagonsMinerai() {
        return nombreWagonsMinerai;
    }

    @Override
    public String toString() {
        return "WagonMinerai {" + super.toString() +
                ", Tonnage=" + tonnage + " tonnes }";
    }
}
