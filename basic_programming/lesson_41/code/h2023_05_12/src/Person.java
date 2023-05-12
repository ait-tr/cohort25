import java.util.Objects;

public class Person {
  private String firstName;
  private String secondName;

  public String getFirstName() {
    return firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public Person(String firstName, String secondName) {
    this.firstName = firstName;
    this.secondName = secondName;
  }

  @Override
  public String toString() {
    return "Person{" +
        "firstName='" + firstName + '\'' +
        ", secondName='" + secondName + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return Objects.equals(firstName, person.firstName) && Objects.equals(secondName, person.secondName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, secondName);
  }
}
