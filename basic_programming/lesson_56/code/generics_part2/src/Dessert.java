public class Dessert extends Food{
  public double sugarContent;
  public String title;

  public Dessert(double sugarContent, String title) {
    this.sugarContent = sugarContent;
    this.title = title;
  }

  @Override
  public String toString() {
    return "Dessert{" +
        "sugarContent=" + sugarContent +
        ", title='" + title + '\'' +
        "} " + super.toString();
  }
}
