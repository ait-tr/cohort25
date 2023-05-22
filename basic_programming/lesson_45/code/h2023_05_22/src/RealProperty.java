public abstract class RealProperty {
  private String cadastralNumber;
  private double price;
  private Person owner;
  private double area;

  private String adress;

  public double calculateTax(){
    return price * 0.001;
  }
  public RealProperty(String cadastralNumber, double price, Person owner, double area, String adress) {
    this.cadastralNumber = cadastralNumber;
    this.price = price;
    this.owner = owner;
    this.area = area;
    this.adress = adress;
  }

  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

  public String getCadastralNumber() {
    return cadastralNumber;
  }

  public double getPrice() {
    return price;
  }

  public Person getOwner() {
    return owner;
  }

  public double getArea() {
    return area;
  }

  public void setCadastralNumber(String cadastralNumber) {
    this.cadastralNumber = cadastralNumber;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setOwner(Person owner) {
    this.owner = owner;
  }

  public void setArea(double area) {
    this.area = area;
  }

  @Override
  public String toString() {
    return "RealProperty{" +
        "cadastralNumber='" + cadastralNumber + '\'' +
        ", price=" + price +
        ", owner=" + owner +
        ", area=" + area +
        ", adress='" + adress + '\'' +
        '}';
  }
}
