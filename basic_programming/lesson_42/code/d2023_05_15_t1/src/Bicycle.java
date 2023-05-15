public class Bicycle extends Transport{
  // implements Vehicle - уже указали в родителе, поэтому здесь можно опустить
  @Override
  public void goFaster() {
//    speed += 5;
    setSpeed(getSpeed() + 5);
  }

  @Override
  public String toString() {
    return "Bicycle{" +
        "speed=" + getSpeed() +
        '}';
  }

}
