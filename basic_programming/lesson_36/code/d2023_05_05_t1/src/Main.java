public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    // inheritance
    Panda po = new Panda("Po", 18, true);

    // Создайте базовый класс Drink
    // c полями:
    // - volume - объем
    // - title  - название

    // Создайте производный от напитка класс Alcohol
    // с полями:
    // - strength - крепость алкоголя - проценты спирта

    // Создайте производный от напитка класс SoftDrink
    // с полями:
    // - sugarContent - сколько процентов сахара
    SoftDrink orangeJuice = new SoftDrink(
        "Orange juice", 0.5, 5);
    SoftDrink cola = new SoftDrink(
        "Cola", 0.7, 30);
    Alcohol martini = new Alcohol(
        "Martini", 1.5, 15);
    Alcohol beer = new Alcohol(
        "Berliner Kindle", 0.5, 4
    );
    System.out.println(orangeJuice);
    System.out.println(cola);
    System.out.println(martini);
    System.out.println(beer);
  }
}