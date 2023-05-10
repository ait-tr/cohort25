public abstract class Product {
  // Создайте абстрактный класс Product с полями:
  // price цена
  // description
  // и абстрактным методом double discount
  private double price;
  private String description;

  public Product(double price, String description) {
    this.price = price;
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public String getDescription() {
    return description;
  }

  public abstract double discount();

  @Override
  public String toString() {
    return "Product{" +
        "price=" + price +
        ", description='" + description + '\'' +
        '}';
  }
}

