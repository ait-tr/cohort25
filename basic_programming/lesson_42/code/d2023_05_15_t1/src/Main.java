import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // interface
    Duck duck = new Duck();
    duck.swim();
    Fish fish = new Fish();
    fish.swim();
    ArrayList<Swimmable> swimmables
        = new ArrayList<>();
    swimmables.add(fish);
    swimmables.add(duck);
    //
    duck.fly();
    // еще один интересный момент
    Flyable duck2 = new Duck();
    // ошибка - доступны только те методы,
    // которые перечислены в интерфейсе
    duck2.fly();
    // duck2.swim();
    Duck duck3 = new Duck();
    duck3.swim();
    // создайте интерфейc Vehicle
    // с методами: void goFaster()
    // с методом: void stop();

    // создайте класс Bicycle, который бы
    // имплементировал бы интерфейс Vehicle
    // ускорение происходит на 5км

    // создайте класс Car, который бы
    // имплементировал бы интерфейс Vehicle
    // ускорение происходит на 20км
    List<Vehicle> vehicleList = new ArrayList<>();
    vehicleList.add(new Bicycle());
    vehicleList.add(new Car());
    for (Vehicle v: vehicleList){
      v.goFaster();
      System.out.println(v);
    }

  }
}