import java.util.Comparator;

public class ComparatorAutoByBrand implements Comparator<Auto> {
    @Override
    public int compare(Auto o1, Auto o2) {
        return o1.getBrand().compareTo(o2.getBrand());
    }
}
