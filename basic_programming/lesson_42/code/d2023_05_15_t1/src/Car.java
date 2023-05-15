public class Car implements Vehicle{
  double speed;

  @Override
  public void goFaster() {
    speed += 20;
  }

  @Override
  public void stop() {
    speed = 0;
  }

  @Override
  public String toString() {
    return "Car{" +
        "speed=" + speed +
        '}';
  }
}
