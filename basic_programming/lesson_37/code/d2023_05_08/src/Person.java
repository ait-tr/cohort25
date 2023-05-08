public class Person {
  public int age;
  public String name;

  public String familyName;
  public boolean isRetired;
  public Person(String ageAndNameAsString){
    // "12Ivan"
    String ageString = ageAndNameAsString.substring(0,2); // "12"
    int age = Integer.parseInt(ageString);
    String name = ageAndNameAsString.substring(2);
    this.age = age;
    this.name = name;
  }

  public Person(int age, String name, String familyName, boolean isRetired) {
    this.age = age;
    this.name = name;
    this.familyName = familyName;
    this.isRetired = isRetired;
  }

  public Person(int age, String name) {
    this.age = age;
    this.name = name;
  }

  @Override
  public String toString() {
    return "Person{" +
        "age=" + age +
        ", name='" + name + '\'' +
        '}';
  }
}
