import java.util.Comparator;

public class PropertyByTaxComparator implements Comparator<RealProperty> {

  @Override
  public int compare(RealProperty o1, RealProperty o2) {
    return Double.compare(o1.calculateTax(), o2.calculateTax());
  }
}
