public class WagonPassagers extends Wagon {
    private final static int nombrePassagersMax = 50;
    private int nombrePassagers;
    private static int nombreWagonsPassagers = 0;

    public WagonPassagers(String code, String description, int nombrePassagers) {
        super(code, description);
        this.nombrePassagers = nombrePassagers;
        nombreWagonsPassagers++;
    }

    @Override
    public String toString() {
        return "WagonPassagers -> " + super.toString() +
                ", Passagers=" + nombrePassagers + "/" + nombrePassagersMax;
    }
}
