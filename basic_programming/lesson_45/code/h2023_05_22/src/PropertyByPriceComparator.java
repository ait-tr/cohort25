import java.util.Comparator;

public class PropertyByPriceComparator implements Comparator<RealProperty> {
  @Override
  public int compare(RealProperty o1, RealProperty o2) {
    return Double.compare(o1.getPrice(), o2.getPrice());
  }
}
