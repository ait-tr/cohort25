public class Rectangle {
  private double length;
  private double width;

  @Override
  public String toString() {
    return "Rectangle{" +
        "length=" + length +
        ", width=" + width +
        '}';
  }

  public Rectangle(double length, double width) {
    this.length = length;
    this.width = width;
  }

  public double getLength() {
    return length;
  }

  public double getWidth() {
    return width;
  }

  public double calculateArea(){
    return length * width;
  }
  public boolean isEqualToSixteen(){
    return calculateArea() == 16;
  }
}
