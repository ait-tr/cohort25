public class Person {
  private String name;
  private int height;

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", height=" + height +
        '}';
  }

  public Person(String name, int height) {
    this.name = name;
    this.height = height;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }
}
