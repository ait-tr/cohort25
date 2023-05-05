public class Person {
  private String name;
  private int age;

  public String getName(){
    return name;
  }
  public int getAge(){
    return age;
  }
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
  public void sayHi(){
    System.out.println("Hi! My name is " + name);
  }
}
