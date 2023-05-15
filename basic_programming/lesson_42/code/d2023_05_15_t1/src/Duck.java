public class Duck implements Swimmable, Flyable {
  @Override
  public void swim() {
    System.out.println("I swim, quak-quak");
  }
  @Override
  public void fly() {
    System.out.println("Whoo-hoo, I believe I can fly");
  }
}
