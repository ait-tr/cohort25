import java.time.LocalDate;

public class Suitcase extends Item{
  private String brand;
  private String size;

  public Suitcase(double price, double rating, int discount,
                  LocalDate date, String brand, String size) {
    super(price, rating, discount, date);
    this.brand = brand;
    this.size = size;
  }

  public String getBrand() {
    return brand;
  }

  public String getSize() {
    return size;
  }

  @Override
  public String toString() {
    return "Suitcase{" +
        "brand='" + brand + '\'' +
        ", size='" + size + '\'' +
        "} " + super.toString();
  }
}
