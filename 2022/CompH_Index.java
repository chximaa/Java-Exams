import java.util.Comparator;

public class CompH_Index implements Comparator<Chercheur> {
    @Override
    public int compare(Chercheur c1, Chercheur c2) {
        if (c1.getH_index() > c2.getH_index())
            return -1; // plus grand H_index d'abord
        else if (c1.getH_index() < c2.getH_index())
            return 1;
        else
            return 0;
    }
}
