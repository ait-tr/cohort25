import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    Violin violin1 = new Violin("Stradivari",
        LocalDate.of(1665, 12, 12));
    Violin violin2 = new Violin("Sokolov",
        LocalDate.of(1975, 12, 12));
    Violin violin3 = new Violin("Devil",
        LocalDate.of(1611, 12, 12));
    System.out.println(getMasterNameOfOldest(violin1, violin2, violin3));

    // Task 2
    // естественный порядок сортировки - то есть, который от Comparable
    Set<Firm> firmSet = new TreeSet<>();
    firmSet.add(new Firm("Hoofs and horns", 20));
    firmSet.add(new Firm("Amazon", 800_000));
    firmSet.add(new Firm("DB", 20_000));
    firmSet.add(new Firm("DB", 30_000));
    System.out.println(firmSet);

    // захотелось реализовать другую логику сортировки - Comparator
    // по количеству
    Set<Firm> firmSet2 = new TreeSet<>(
        (o1, o2) -> {
          if (o1.getNumberOfEmployees() == o2.getNumberOfEmployees()){
            return o1.getTitle().compareTo(o2.getTitle());
          }
          return Integer.compare(o1.getNumberOfEmployees(), o2.getNumberOfEmployees());
        }
    );
    firmSet2.add(new Firm("Hoofs and horns", 20));
    firmSet2.add(new Firm("Amazon", 800_000));
    firmSet2.add(new Firm("DB", 20_000));
    firmSet2.add(new Firm("DB", 30_000));
    System.out.println(firmSet2);
  }
  public static String getMasterNameOfOldest(Violin ... violins){
    Violin oldest = violins[0];
    for (Violin violin: violins){
      if(violin.getDateOfManufacturing().isBefore(oldest.getDateOfManufacturing())){
        oldest = violin;
      }
    }
    return oldest.getNameOfMaster();
  }
}