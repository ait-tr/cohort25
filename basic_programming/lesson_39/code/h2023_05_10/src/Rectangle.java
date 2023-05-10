public class Rectangle extends Figure{
  private double sideA;
  private double sideB;

  public Rectangle(double sideA, double sideB) {
    this.sideA = sideA;
    this.sideB = sideB;
  }
  @Override
  public double calculateArea(){
    return sideA * sideB;
  }
}
