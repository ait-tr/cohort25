public abstract class Transport implements Vehicle {
  private double speed;

  public double getSpeed() {
    return speed;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public void stop() {
    speed = 0;
  }
}
