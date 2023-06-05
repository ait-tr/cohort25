import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) {
    // anonymous classes
    Animal animal1 = new Animal();
    animal1.run();
    Panda panda = new Panda();
    panda.run();
    // анонимные классы нужны когда объект нам нужен
    // только один раз
    // создали особенный уникальный объект
    Animal lenivets = new Animal() {
      @Override
      public void run() {
        System.out.println("Бежит не двигаясь");
      }
    };
    lenivets.run();
    // Создайте класс Plant
    // с полями:
    //  - height
    //  - colorOfFlower
    // и методом
    // public void grow() - "Растет со скоростью <10% от высоты>"
    // public void blossom() - "Цвет бутона: <цвет>"

    // Создайте объект анонимного класса
    // чтобы рос со скоростью 25%
    // А метод blossom имел другую фразу:
    // "Цвет быстрорастущего: <цвет>"

    Plant rose = new Plant(2, "red") {
      @Override
      public void grow() {
        System.out.println("Растет со скоростью:  " + height * 0.25);
        ;
      }

      @Override
      public void blossom() {
        System.out.println("Цвет быстрорастущего: " + colorOfFlower);
      }
    };

    rose.blossom();
    rose.grow();
    // Создали анонимный класс на основании интерфейса Flyable
    Flyable plane = new Flyable() {
      final int size = 10;
      @Override
      public void fly() {
        System.out.println("Самолет летит: уииии");
      }
    };
    plane.fly();
    ArrayList<Plant> plants = new ArrayList<>();
    plants.add(rose);
    plants.add(new Plant(14, "yellow"));
    plants.add(new Plant(5, "blue"));
    Collections.sort(
        plants,
        new Comparator<Plant>() {
          @Override
          public int compare(Plant o1, Plant o2) {
            return Double.compare(o1.height, o2.height);
          }
        }
    );
    System.out.println(plants);
  }
}