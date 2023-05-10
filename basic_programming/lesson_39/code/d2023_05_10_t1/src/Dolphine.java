public class Dolphine extends Animal{
  double speedInWater;

  public Dolphine(String name, double weight, double speedInWater) {
    super(name, weight);
    this.speedInWater = speedInWater;
  }
  @Override
  public void move(){
    System.out.println("Плыву со скоростью " + speedInWater);
  }
}
