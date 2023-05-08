public class Passenger {
  private String name;

  public String getName() {
    return name;
  }

  public Passenger(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Passenger{" +
        "name='" + name + '\'' +
        '}';
  }
}
