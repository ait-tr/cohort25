import java.util.Comparator;

public class PropertyByAdressComparator implements Comparator<RealProperty> {
  @Override
  public int compare(RealProperty o1, RealProperty o2) {
    return o1.getAdress().compareTo(o2.getAdress());
  }
}
