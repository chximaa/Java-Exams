import java.util.Comparator;

public class CompLabH_Index implements Comparator<Laboratoire> {
    @Override
    public int compare(Laboratoire l1, Laboratoire l2) {
        if (l1.getLab_Hindex() > l2.getLab_Hindex()) return -1;
        else if (l1.getLab_Hindex() < l2.getLab_Hindex()) return 1;
        else return 0;
    }
}
