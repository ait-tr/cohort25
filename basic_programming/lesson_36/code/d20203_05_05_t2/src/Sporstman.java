public class Sporstman {
  private String name;
  private int age;

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public Sporstman(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void introduce(){
    System.out.println("Привет! Меня зовут " + name);
  }

  @Override
  public String toString() {
    return "Sportman{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
