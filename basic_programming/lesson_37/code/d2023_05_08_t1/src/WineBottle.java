public class WineBottle {
  public String title;
  public static double volume;

  public WineBottle(String title) {
    this.title = title;
  }

  public static void staticPrint(){
    System.out.println("Я статический метод");
    // внутри статического не можем использовать слова this, super
    // мы не можем обращаться к не-статическим полям title:
    // например title будет гореть красным цветом
    // внутри статического метода мы можем ссылаться только на другие
    // статические методы
    // nonStaticPrint(); // не будет работать, ошибка
  }
  public void nonStaticPrint(){
    System.out.println("Я не статический метод");
    // можем обращаться к любым полям - и статическим и нет
    // можем обращаться к любым методам - вызывать их
  }

  @Override
  public String toString() {
    return "WineBottle{" +
        "title='" + title + '\'' +
        ", volume=" + volume +
        '}';
  }
}
