public class Main {
  public static void main(String[] args) {
   // Обобщенные методы
    // как и классы методы можно сделать с дженериками
    // параметризованный тип указывает до возвращаемого значения
    Integer x = 10;
    Double y = 25.0;
    print(x);
    print(y);
    print("Со стрингом тоже работает");
    int z = 12;
    print(z);
    printNumber(2.2);
    // Строка в комментарии ниже выдаст ошибку - тип String не подходит
    // printNumber("apple");
    // Задание 2 - на закрепление темы
    // Создайте родительский класс Furniture - мебель
    // - с полем стоимость price за куб древесины
    // - timberAmount - сколько кубов древесины в этом объекте
    // Два производных класс:
    // - Chair - стул
    // - Table - стол

    // Создайте обобщенный метод в мейн, который принимает любую мебель
    // и рассчитывает ее общую стоимость: price * timberAmount

    // дополнительно можете реализовать в производных классах
    // какие-нибудь отличительные черты
    Chair eames = new Chair(20, 0.1);
    System.out.println(calculateTotalPrice(eames));
    // Дополнительно задание
    // создайте в Main метод, который бы понижал стоимость за куб метр на 10 процентов
    // makeProductCheaper(table); // после вызова метода - у объекта table стоимость снизилась на 10
    // пусть метод возвращает сам объект - в данном примере table - точнее говоря ссылку
    Chair discountedChair = makeProductCheaper(eames);
    // discountedChair и eames ссылку на один и тот объект
    // не очень хорошая практика
    System.out.println(discountedChair);
  }
  //
  public static <T extends Furniture> T makeProductCheaper(T furniture){
    furniture.setPrice(furniture.getPrice() * 0.9);
    return furniture;
  }

  public static <T extends Furniture> double calculateTotalPrice(T furniture){
    return furniture.getPrice() * furniture.getTimberAmount();
  }
  // print печатает вообще все что угодно
  public static <T> void print(T argument){
    System.out.println(argument);
  }
  // Создадим print который печатает только числа
  // класс Number - это родительский класс для классов оберток: Integer, Double...
  public static <T extends Number> void printNumber(T number){
    System.out.println(number);
  }
}