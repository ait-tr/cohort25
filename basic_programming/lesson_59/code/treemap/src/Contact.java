public class Contact implements Comparable<Contact>{
  private String firstName;
  private String secondName;

  public String getFirstName() {
    return firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public Contact(String firstName, String secondName) {
    this.firstName = firstName;
    this.secondName = secondName;
  }

  @Override
  public String toString() {
    return  secondName + ' ' + firstName;
  }

  @Override
  public int compareTo(Contact o) {
    if(secondName.equals(o.secondName)){
      return firstName.compareTo(o.firstName);
    }
    return secondName.compareTo(o.secondName);
  }
}
