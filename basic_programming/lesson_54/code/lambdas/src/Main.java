
public class Main {
  public static void main(String[] args) {
    // интерфейс в котором только один метод называет - функциональным интерфейсом.
//    Operationable sum = new Operationable() {
//      @Override
//      public int calculate(int a, int b) {
//        return a + b;
//      }
//    };
    // Лямбды делаются только на основании функциональных интерфейсов
    // однострочная лямбда - return подразумевается
    Operationable sum = (a, b) -> a + b;
    // то же самое, но блочная
    // блочная лямбда - если что-то возращает нужно эксплицитно(явным образом) указать return
    Operationable sum2 = (a, b) -> {
      return a + b;
    };
    Operationable subtraction = (a, b) -> a - b;
    System.out.println(sum.calculate(15, 20));
    System.out.println(subtraction.calculate(10, 2));
    Printable printInUpper = (str)->{
      System.out.println(str.toUpperCase());
    };
    printInUpper.print("хехей");
    // создайте функциональный интерфейc CanWelcome
    // c методом void hello(String name)
    // на основании интерфейса создайте лямбду
    // Чтобы реализация метода печатала: "Добрый день <имя>!"
    CanWelcome butler = (name)-> System.out.println("Добрый день, " + name);
    butler.hello("John");

    // лямбды можно передавать в качестве параметров
    Calculator calculator = new Calculator();
    int result = calculator.process((a, b) -> a * b , 10, 22);
    System.out.println(result);
    int result2 = calculator.process(subtraction, 10, 22);
    System.out.println(result2);
  }
}