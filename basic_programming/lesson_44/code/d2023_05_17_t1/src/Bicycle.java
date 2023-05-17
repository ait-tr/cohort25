import java.time.LocalDate;

public class Bicycle extends Item{
  private String brand;
  private int numberOfWheels;

  public Bicycle(double price, double rating, int discount, LocalDate date,
                 String brand, int numberOfWheels) {
    super(price, rating, discount, date);
    this.brand = brand;
    this.numberOfWheels = numberOfWheels;
  }

  @Override
  public String toString() {
    return "Bicycle{" +
        "brand='" + brand + '\'' +
        ", numberOfWheels=" + numberOfWheels +
        "} " + super.toString();
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public int getNumberOfWheels() {
    return numberOfWheels;
  }

  public void setNumberOfWheels(int numberOfWheels) {
    this.numberOfWheels = numberOfWheels;
  }
}
