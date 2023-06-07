public class Pasta extends Food {
  String title;
  double fatContent;

  public Pasta(String title, double fatContent) {
    this.title = title;
    this.fatContent = fatContent;
  }

  @Override
  public String toString() {
    return "Pasta{" +
        "title='" + title + '\'' +
        ", fatContent=" + fatContent +
        '}';
  }
}
