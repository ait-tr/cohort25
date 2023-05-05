public class Alcohol extends Drink {
  double strength;

  public Alcohol(String title, double volume, double strength) {
    super(title, volume);
    this.strength = strength;
  }

  @Override
  public String toString() {
    return "Alcohol {" +
        "strength=" + strength +
        ", title='" + title + '\'' +
        ", volume=" + volume +
        '}';
  }
}
