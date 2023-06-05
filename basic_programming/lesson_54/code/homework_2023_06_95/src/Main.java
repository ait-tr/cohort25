public class Main {
  public static void main(String[] args) {
    printNumbers(3);
    // printNumbers(2);
    // printNumbers(1);
    // printNumbers(0)
    isPalindrom("lahal");
    isPalindrom("aha");
    isPalindrom("h");  // базовый случай
    isPalindrom("laal");
    isPalindrom("aa");
    isPalindrom("");   // тоже базовый случай
    System.out.println("****");
    System.out.println(isPalindrom("lahal"));
    System.out.println(isPalindrom("laal"));
    System.out.println(isPalindrom("labl"));
    System.out.println(isPalindrom("labcl"));
    System.out.println(isPalindrom("ll"));
    System.out.println(isPalindrom("l"));

  }

  public static String isPalindrom(String word) {
    if (word.length() <= 1) {
      return "yes"; // базовый случай, когда одна буква или не одна
    }
    if (word.charAt(0) != word.charAt(word.length() - 1)) {
      return "no";  // тоже случай выхода - базовый случай
    }
    // рекурсия - с шагом - шаг состоит в том, что мы обрезаем слово
    return isPalindrom(word.substring(1, word.length() - 1));
  }

  public static void printNumbers(int number) {
    if (number == 1) {
      System.out.println(1);
    } else {
      printNumbers(number - 1);
      System.out.println(number);
    }
  }

}