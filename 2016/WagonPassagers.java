public class WagonPassagers extends Wagon {

    private static final int nombrePassagersMax = 50;
    private int nombrePassagers;
    private static int nombreWagonsPassagers = 0;

    public WagonPassagers(String code, String description, int nombrePassagers) {
        super(code, description);
        this.nombrePassagers = nombrePassagers;
        nombreWagonsPassagers++;
    }

    public int getNombrePassagers() {
        return nombrePassagers;
    }

    public void setNombrePassagers(int nombrePassagers) {
        this.nombrePassagers = nombrePassagers;
    }

    public static int getNombrePassagersMax() {
        return nombrePassagersMax;
    }

    public static int getNombreWagonsPassagers() {
        return nombreWagonsPassagers;
    }

    @Override
    public String toString() {
        return "WagonPassagers {" + super.toString() +
                ", Passagers=" + nombrePassagers + " }";
    }
}
