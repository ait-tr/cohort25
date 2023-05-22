public class Forest extends RealProperty{
  private boolean isProtectedZone;

  public boolean isProtectedZone() {
    return isProtectedZone;
  }

  public Forest(String cadastralNumber, double price, Person owner, double area, String adress, boolean isProtectedZone) {
    super(cadastralNumber, price, owner, area, adress);
    this.isProtectedZone = isProtectedZone;
  }

  public void setProtectedZone(boolean protectedZone) {
    isProtectedZone = protectedZone;
  }


  @Override
  public String toString() {
    return "Forrest{" +
        "isProtectedZone=" + isProtectedZone +
        "} " + super.toString();
  }
}
