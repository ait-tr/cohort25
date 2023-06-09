public class Person implements Comparable<Person>{
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public int compareTo(Person o) {
    if (age == o.age){
      return name.compareTo(o.name);
    }
    return Integer.compare(age, o.age);
  }
}
