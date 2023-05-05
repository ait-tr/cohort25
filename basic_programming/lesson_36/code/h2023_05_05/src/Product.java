import java.util.ArrayList;

public class Product {
  private String title;
  private double price;
  private Category category;

  private ArrayList<Double> history = new ArrayList<>();

  public String getTitle() {
    return title;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    if (price > 0) {
      history.add(this.price);
      this.price = price;
    }
  }
  public void printPriceHistory(){
    System.out.println("История изменения цены " + title + ": " + history);
  }

  public Product(String title, double price, Category category) {
    this.title = title;
    this.price = price;
    this.category = category;
  }

  @Override
  public String toString() {
    return "Product{" +
        "title='" + title + '\'' +
        ", price=" + price +
        ", category=" + category +
        '}';
  }
}
