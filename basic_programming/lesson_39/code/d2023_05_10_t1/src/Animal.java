public abstract class Animal {
  public String name;
  public double weight;

  public Animal(String name, double weight) {
    this.name = name;
    this.weight = weight;
  }
  public abstract void move();

  @Override
  public String toString() {
    return "Animal{" +
        "name='" + name + '\'' +
        ", weight=" + weight +
        '}';
  }
}
