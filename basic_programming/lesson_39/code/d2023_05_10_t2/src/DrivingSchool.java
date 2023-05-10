public class DrivingSchool extends School {
  public DrivingSchool(String title) {
    super(title);
  }

  @Override
  public void teach(Person person) {
    person.setDriverLicence("de-871-18-12");
  }

  public void teach(Person person, String category) {
    person.setDriverLicence("de-871-18-12 " + category);
  }
}
