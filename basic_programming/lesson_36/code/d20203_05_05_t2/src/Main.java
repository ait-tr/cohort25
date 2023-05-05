public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    Musician guitarist = new Musician("Jonhn Petrucci", 47, "guitar");
    System.out.println(guitarist);
    Musician paulMccartney = new Musician("PAul Mccartney", 76, "bass");
    paulMccartney.sayHi();
    guitarist.sayHi();

    // Создайте базовый класс Sportsman
    // с приватными полями:
    // имя, возраст
    // с методом introduce -> "Привет, меня зовут <name>"

    // Создайте производный класс Runner c приватными полями:
    // maxSpeed - максимальная скорость
    // maxDistance - максимальное расстояние, которое может пробежать
    // Пусть у него будет метод
    // info -> "Меня зовут <имя>. Я могу пробежать <maxDistance>.
    // Моя максимальная скорость <maxSpeed>"
    // Создайте объект - вызовите эти методы
    Runner useinBolt = new Runner("Usein bolt", 40, 35, 1);
    useinBolt.introduce();
    useinBolt.info();
  }
}