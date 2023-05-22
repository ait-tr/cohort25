import java.util.Comparator;

public class PropertyByAreaComparator implements Comparator<RealProperty> {
  @Override
  public int compare(RealProperty o1, RealProperty o2) {
    return Double.compare(o1.getArea(), o2.getArea());
  }
}
