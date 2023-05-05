public class Panda extends Animal {
  boolean isCute;

  public Panda(String name, int age, boolean isCute) {
    super(name, age);
    this.isCute = isCute;
  }

  @Override
  public String toString() {
    return "Panda{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", isCute=" + isCute +
        '}';
  }
}
