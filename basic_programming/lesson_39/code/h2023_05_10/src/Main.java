import java.util.List;

public class Main {
  public static void main(String[] args) {
    Square square = new Square(3);
    double area1 = square.calculateArea();
    System.out.println(area1);

    Circle circle = new Circle(2);
    System.out.println(circle.calculateArea());

    Rectangle rectangle = new Rectangle(4, 9);
    System.out.println(rectangle.calculateArea());

    List<Figure> figureList = List.of(
        circle, rectangle, square);
    Figure fig1 = new Square(2);
    System.out.println(fig1.calculateArea());
    for (Figure figure: figureList){
      System.out.println(figure.calculateArea());
    }
    Figure maxFigure =  getMaxAreaFigure(figureList);
    System.out.println(maxFigure.calculateArea());

    System.out.println(figureList);
    Figure fig2 = new Figure();

  }
  public static Figure getMaxAreaFigure(List<Figure> list){
    Figure temp = list.get(0);
    for(Figure figure: list){
      if(figure.calculateArea() > temp.calculateArea()){
        temp = figure;
      }
    }
    return temp;
  }

}