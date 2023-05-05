public class Wolf extends Animal {
  boolean isAggressive;

  public Wolf(String name, int age, boolean isAggressive) {
    super(name, age);
    this.isAggressive = isAggressive;
  }

  @Override
  public String toString() {
    return "Wolf{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", isAgressive=" + isAggressive +
        '}';
  }
}
