public class Main {
  public static void main(String[] args) {
    Dolphine dolphine = new Dolphine("Nikolay", 200,30);

    // Создайте абстрактный класс Product с полями:
    // price цена
    // description
    // и абстрактным методом double discount

    // Создайте производный класс Tire c полями:
    // boolean isWinter
    // double radius
    // реализуйте метод discount со скидкой 30%

    // Создайте производный класс Alcohol c полями:
    // double strength;
    // реализуйте метод discount - возвращает цену со скидкой:
    // если крепость алкоголя >= 30, то скидка 5 %
    // если крепость алкоголя <30, то скидка 10%

  }
}