public class Furniture {
  private double price; // цена за куб
  private double timberAmount;

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getTimberAmount() {
    return timberAmount;
  }

  public void setTimberAmount(double timberAmount) {
    this.timberAmount = timberAmount;
  }

  public Furniture(double price, double timberAmount) {
    this.price = price;
    this.timberAmount = timberAmount;
  }

  @Override
  public String toString() {
    return "Furniture{" +
        "price=" + price +
        ", timberAmount=" + timberAmount +
        '}';
  }
}
