public class Tire extends Product {
  // Создайте производный класс Tire c полями:
  // boolean isWinter
  // double radius
  // реализуйте метод discount со скидкой 30%
  private boolean isWinter;
  private double radius;

  public Tire(double price, String description, boolean isWinter, double radius) {
    super(price, description);
    this.isWinter = isWinter;
    this.radius = radius;
  }
  @Override
  public double discount(){
    return getPrice() * 0.7;
  }

  @Override
  public String toString() {
    return "Tire{" +
        "isWinter=" + isWinter +
        ", radius=" + radius +
        "} " + super.toString();
  }
}
