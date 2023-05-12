import java.util.Random;

public class Main {
  public static void main(String[] args) {
    Math.random(); // из диапазона 0 включительно до 1 не включительно
    double min = 5;
    double max = 10;
//    System.out.println((int)(Math.random() * (max + 1)));
    System.out.println(min + (int)(Math.random() * (max - min + 1)));
    // Создайте класс рыба Fish с полями:
    // String type
    // double weight;
    // int length;
    // Сделайте так, чтобы при создании объекта рыба - мы указывали только ее тип,
    // а остальные значения рассчитывались бы случайно:
    // длинна рыбы должна быть случайной в диапазоне от 7 см до 60 см
    // вес - рассчитывается по формуле 40 г за 1 см;
    Fish sawfish = new Fish("Sawfish");
    Fish pufferfish = new Fish("Pufferfish");
    Fish moonfish = new Fish("Moonfish");
    Fish catfish = new Fish("Catfish");
    Fish clownfish = new Fish("Clownclown");
    System.out.println(sawfish);
    System.out.println(pufferfish);
    System.out.println(moonfish);
    System.out.println(catfish);
    System.out.println(clownfish);
    // Класс Random - для генерации случных значений
    // можно генерировать случайные типы
    // Сначала нужно объект - это так же как было со сканером
    Random random = new Random();
    int randomNumber =  random.nextInt(5); // верхняя не включительно
    System.out.println(randomNumber);
    //




  }
}