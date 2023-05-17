import java.util.Comparator;

public class ItemByDiscountPriceComparator implements Comparator<Item> {

  @Override
  public int compare(Item o1, Item o2) {
    return Double.compare(o1.getDiscountedPrice(), o2.getDiscountedPrice());
  }
}
