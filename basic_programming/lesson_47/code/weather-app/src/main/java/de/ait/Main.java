package de.ait;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }
  // odd number - нечетное число
  // even number - четное
  public static boolean isEven(int number){
    return number % 2 == 0;
  }

  // напишем метод
  // public static boolean isValidLogin(String login)
  // Валидны логины отвечающие данным характеристикам:
  // - больше или равно 8 символам
  // - короче чем 20 символов
  // - обязательно должна быть '@'
  // -
  // Сделайте   @ParameterizedTest
  public static boolean isValidLogin(String login){
    return login.length() >= 8
        && login.length() <= 20
        && login.contains("@");
  }
  public static String getRectangleArea(int a, int b){
    // getRectangleArea(4, 5) --> "Прямоугольник с площадью 20";
    return "Прямоугольник с площадью " + (a * b);
  }
}