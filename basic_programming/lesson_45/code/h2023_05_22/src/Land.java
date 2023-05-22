public class Land extends RealProperty {
  private LandPurpose purpose;

  public Land(String cadastralNumber, double price, Person owner, double area, String adress, LandPurpose purpose) {
    super(cadastralNumber, price, owner, area, adress);
    this.purpose = purpose;
  }

  public LandPurpose getPurpose() {
    return purpose;
  }

  public void setPurpose(LandPurpose purpose) {
    this.purpose = purpose;
  }

  @Override
  public String toString() {
    return "Land{" +
        "purpose=" + purpose.PURPOSE +
        "} " + super.toString();
  }
}
