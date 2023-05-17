import java.time.LocalDate;

public abstract class Item {
  private double price;
  private double rating;
  private int discount;
  private LocalDate date;
  public double getDiscountedPrice(){
    return price * (1 - (double) discount / 100);
  };

  public Item(double price, double rating, int discount, LocalDate date) {
    this.price = price;
    this.rating = rating;
    this.discount = discount;
    this.date = date;
  }

  @Override
  public String toString() {
    return "Item{" +
        "price=" + price +
        ", rating=" + rating +
        ", discount=" + discount +
        ", date=" + date +
        '}';
  }

  public double getPrice() {
    return price;
  }

  public double getRating() {
    return rating;
  }

  public int getDiscount() {
    return discount;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public void setDiscount(int discount) {
    this.discount = discount;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }
}
