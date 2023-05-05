public class SoftDrink extends Drink{
  double sugarContent;

  public SoftDrink(String title, double volume, double sugarContent) {
    super(title, volume);
    this.sugarContent = sugarContent;
  }

  @Override
  public String toString() {
    return "SoftDrink{" +
        "sugarContent=" + sugarContent +
        ", title='" + title + '\'' +
        ", volume=" + volume +
        '}';
  }
}
