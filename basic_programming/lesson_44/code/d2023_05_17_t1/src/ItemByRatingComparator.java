import java.util.Comparator;

public class ItemByRatingComparator implements Comparator<Item> {
  @Override
  public int compare(Item o1, Item o2) {
    return Double.compare(o1.getRating(), o2.getRating());
  }
}
