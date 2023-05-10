public class Figure {
  public double calculateArea(){
    return 0;
  }

  @Override
  public String toString(){
    return "Класс " + getClass() + " Площадь: " + calculateArea();
  }
}
