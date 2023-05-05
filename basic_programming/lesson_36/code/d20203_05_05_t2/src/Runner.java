public class Runner extends Sporstman {
  private double maxSpeed;
  private double maxDistance;

  public Runner(String name, int age, double maxSpeed, double maxDistance) {
    super(name, age);
    this.maxSpeed = maxSpeed;
    this.maxDistance = maxDistance;
  }

  public void info(){
    System.out.println("Меня зовут " + getName()
        + " Я могу пробежать: " + maxDistance
        + " Моя максимальная скорость: " + maxSpeed);
  }

  @Override
  public String toString() {
    return "Runner{" +
        "maxSpeed=" + maxSpeed +
        ", maxDistance=" + maxDistance +
        '}';
  }
}
