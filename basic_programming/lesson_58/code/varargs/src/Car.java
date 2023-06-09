public class Car implements Comparable<Car>{
  private String title;
  private double price;

  public Car(String title, double price) {
    this.title = title;
    this.price = price;
  }

  public String getTitle() {
    return title;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Car{" +
        "title='" + title + '\'' +
        ", price=" + price +
        '}';
  }

  @Override
  public int compareTo(Car o) {
    return Double.compare(this.price, o.price);
  }
}
