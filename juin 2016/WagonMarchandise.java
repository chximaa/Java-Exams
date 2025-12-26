public class WagonMarchandise extends Wagon {
    private final static float volumeMax = 72;
    private float volume;
    private static int nombreWagonsMarchandise = 0;

    // (0) Constructeur
    public WagonMarchandise(String code, String description, float volume) {
        super(code, description);
        this.volume = volume;
        nombreWagonsMarchandise++;
    }

    // (1) Getter VolumeMax
    public static float getVolumeMax() { return volumeMax; }

    // (2) Getter & Setter nombre wagons marchandise
    public static int getNombreWagonsMarchandise() { return nombreWagonsMarchandise; }
    public static void setNombreWagonsMarchandise(int n) { nombreWagonsMarchandise = n; }

    // (3) toString
    @Override
    public String toString() {
        return "WagonMarchandise -> " + super.toString() +
                ", Volume=" + volume + "/" + volumeMax;
    }
}
