import java.util.*;

public class CompNbEnfants implements Comparator<Parent> {
    @Override
    public int compare(Parent p1, Parent p2) {
        return Integer.compare(p1.getEnfants().size(), p2.getEnfants().size());
    }
}
