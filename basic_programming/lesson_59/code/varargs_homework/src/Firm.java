public class Firm implements Comparable<Firm>{
  private String title;
  private int numberOfEmployees;

  public String getTitle() {
    return title;
  }

  public int getNumberOfEmployees() {
    return numberOfEmployees;
  }

  public Firm(String title, int numberOfEmployees) {
    this.title = title;
    this.numberOfEmployees = numberOfEmployees;
  }

  @Override
  public String toString() {
    return "Firm{" +
        "title='" + title + '\'' +
        ", numberOfEmployees=" + numberOfEmployees +
        '}';
  }

  @Override
  public int compareTo(Firm o) {
    if(title.equals(o.title)){
      return Integer.compare(numberOfEmployees, o.numberOfEmployees);
    }
    return title.compareTo(o.title);
  }
}
