import java.util.Comparator;

public class ItemByDateComparator implements Comparator<Item> {
  @Override
  public int compare(Item o1, Item o2) {
    return o1.getDate().compareTo(o2.getDate());
  }
}
