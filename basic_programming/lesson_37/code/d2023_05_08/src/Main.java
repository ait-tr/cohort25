public class Main {
  public static void main(String[] args) {
//    System.out.println("Hello world!");
//    Person ivan = new Person( "2Ivan");
//    System.out.println(ivan);
//    Person vasya = new Person(12, "Vasya");
//    Person katya = new Person(
//        12, "Katya", "Zahartseva", false);
    Transport bus = new Transport("Ekarus",90, 80);
    bus.printPassengers();
    bus.pickPassenger(new Passenger("Alisher"));
    bus.pickPassenger(new Passenger("Alisher"));
    bus.printPassengers();
    bus.dropPassenger("Alisher");
    bus.printPassengers();
    Ship ship = new Ship("Avrora", 200,
        30, "Michail Ilyich Nickolskiy");
    ship.captainGreeting();
  }
}