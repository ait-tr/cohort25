public class Square extends Figure{
  private double side;

  public Square(double side) {
    this.side = side;
  }
  @Override
  public double calculateArea(){
    return side * side;
  }
}
