public class Person {
  private String fullName;
  private String driverLicence;

  public String getFullName() {
    return fullName;
  }

  public String getDriverLicence() {
    return driverLicence;
  }

  public void setDriverLicence(String driverLicence) {
    this.driverLicence = driverLicence;
  }

  public Person(String fullName, String driverLicence) {
    this.fullName = fullName;
    this.driverLicence = driverLicence;
  }

  @Override
  public String toString() {
    return "Person{" +
        "fullName='" + fullName + '\'' +
        ", driverLicence='" + driverLicence + '\'' +
        '}';
  }
}
