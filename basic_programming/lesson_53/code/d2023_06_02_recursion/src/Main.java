public class Main {
  public static void main(String[] args) {
    recursivePrint(0); // сразу попали в блок else
    //
    recursivePrint(1);
    // 1. попали в блок if - распечатали 1 - recursivePrint(1-1)
    // 2. попали в else    - распечатали 0 - готово
    recursivePrint(5);
    // 1. попали в if - распечатали 5 - recursivePrint(5 -1)
    // 2. попали в if - распечатали 4 - recursivePrint(4 -1)
    // 3. попали в if - распечатали 3 - recursivePrint(3 -1)
    // 4. попали в if - распечатали 2 - recursivePrint(2 -1)
    // 5. попали в if - распечатали 1 - recursivePrint(1 -1)
    // 6. попали в else- распечатали 0 - больше не вызываем
    System.out.println("Конец кода");
    printWordParts("hello");
    System.out.println(recursiveSum(5));
    // recursiveSum(5)
    // 5 + recursiveSum(4)
    // 5 + 4 + recursiveSum(3)
    // 5 + 4 + 3 + recursiveSum(2)
    // 5 + 4 + 3 + 2 + recursiveSum(1)
    // 5 + 4 + 3 + 2 + 1
    System.out.println(factorial(4));
    // Вызов для числа Фибоначчи
    System.out.println(getFibNumber(3)); // 2
    System.out.println(getFibNumber(6)); // 8
    System.out.println(getFibNumber(7)); // 13
  }
    // Попробуйте посчитать факториал
    // 8!   8*7*6*5*4*3*2*1
    // 4!   4*3*2*1
  public static int factorial(int number){
    if(number == 1){
      return 1;
    } else {
      return number * factorial(number-1);
    }
  }
  // 1 1 2 3 5 8 13 21 34 55
  // допустим число для нуля это ноль
  // номер числа в ряде    - расшифровка
  // [0]        0  // прописано в базовом случае
  // [1]        1  // прописано в базовом случае
  // [2]        1
  // [3]        2
  // [4]        3
  // [5]        5
  // [6]        8
  // [7]        13
  public static int getFibNumber(int n){
    // базовый случай
    if(n == 0) {
      return 0;
    }
    // базовый случай вторая часть
    if(n == 1) {
      return 1;
    } else {
      // шаг
      return getFibNumber(n-1) + getFibNumber(n-2);
    }
  }
  // посчитать сумму чисел от указанного числа до нуля
  public static int recursiveSum(int number){
    System.out.println("Вызов функции recursiveSum");
    if(number == 1){
      return 1;
    } else {
      return number + recursiveSum(number - 1);
    }
  }

  public static void recursivePrint(int number){
    if (number > 0){
      System.out.println(number);
      // шаг рекурсии - то что мы меняем параметр
      recursivePrint(number-1);
    } else {
      // базовый случай - когда рекурсия прекращается
      System.out.println(0);
    }
  }
  // printWordParts("apple")  -> "apple", "appl", "app", "ap", "a"
  public static void printWordParts(String word){
      if(word.length() == 1){
        System.out.println(word);
      } else {
        System.out.println(word);
        printWordParts(word.substring(0, word.length()-1));
      }
  }



}