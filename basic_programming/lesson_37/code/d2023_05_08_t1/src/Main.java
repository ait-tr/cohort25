import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    WineBottle cianty =
        new WineBottle("Cianty");
    WineBottle noviySvet =
        new WineBottle("Noviy Svet");
    cianty.volume = 1.0;

    System.out.println(cianty);
    System.out.println(noviySvet);

    // к статическим полям мы можем обращаться
    // через имя класса, а не через имя объекта
    WineBottle.volume = 2.0;
    System.out.println("***");
    System.out.println(cianty);
    System.out.println(noviySvet.volume);
    // статический метод вызываем от имени класса
    WineBottle.staticPrint();
    // не статический метод вызываем от имени объекта
    cianty.nonStaticPrint();

    String[] names = new String[]{"Vasya", "Petya", "Sasha"};
    ArrayTools.print(names);  // вызвали статический метод класса, который сами и создали
    System.out.println(Arrays.toString(names)); // вызвали статический метод класса, который кто-то написал за нас

    // вызов нестатического метода - сначала создали объект
    // после это от имени объекта вызвали метод
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
  }

  public void print() {
    System.out.println("bla-bla");
  }


}
