public class Main {
    public static void main(String[] args) {
     /*
        Создайте класс пират Pirate со следующими полями:
            name;
            nickName;
            boolean isDrunk;
         Создать конструктор и toString
         Создать в классе Pirate метод say
         метод должен выводить в консоль
         "It is a bad day" - если пират трезв
         "Yohohoho, what a good life" - если пират пьян
         Создайте несколько пиратов, вызовите метод say

         *** сделайте метод drink
         метод должен менять знaчение поля isDrunk на true
        */
        Pirate jack = new Pirate("Jack", "Sparrow", true);
        Pirate john = new Pirate("John", "Black beard", false);
        System.out.println(jack);
        jack.say(); // Yohohoho, what a good life
        john.say(); // It's a bad day
        john.drink();
        jack.say(); // Yohohoho, what a good life
        john.say(); // Yohohoho, what a good life

    }

}