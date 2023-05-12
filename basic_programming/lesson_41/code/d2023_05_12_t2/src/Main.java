public class Main {
  public static void main(String[] args) {

    // Создайте класс Clam c полями:
    // - numberOfPearls - сколько жемчужин в устрице,
    // пусть значения поля генерируется случайным образом в диапазоне от 0 до 4 включительно

    // Создать класс ныряльщик ClamDiver с полями:
    // - имя
    // - pearls; - количество жемчуга у ныряльщика
    // Метод:
    // void dive()
    // - генерирует случайное количество устриц
    // - и ныряльщик получает жемчуг из этих устриц
    // - от 0 до 10 включительно устриц он может поднять за одно погружение
    Clam clam1 = new Clam();
    Clam clam2 = new Clam();
    Clam clam3 = new Clam();
    System.out.println(clam1);
    System.out.println(clam2);
    System.out.println(clam3);

    ClamDiver ichtiandr = new ClamDiver("Ichtiandr");
    System.out.println("до погружения " + ichtiandr);
    ichtiandr.dive();
    System.out.println("после погружения" + ichtiandr);
  }
}