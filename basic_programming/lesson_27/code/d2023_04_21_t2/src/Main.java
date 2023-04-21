import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создайте класс курица Chicken с полями
        //   - name;
        //   - age;
        //   - double weight;
        // Создайте конструктор и toString
        // Создать метод public void eat(double foodWeight)
        // --> в результате вызова этого метода вес курицы увеличивается на foodWeight
        // chicken1.eat(100); // после этой строки вес курицы изменится на 100

        // Создайте класс Yard - скотный двор
        //  - адрес
        //  - ArrayList<Chicken> chickens;
        // Создайте конструктор и toString
        // Создайте метод
        // public void feedAll() --> кормит каждую курицу скотного двора по 200 грамм еды
        // Подсказка: вам потребуется метод .eat(200);

        // Создайте в мейн скотный двор с определенным количество кур.
        // вызовите метод feedAll

        Chicken cipa = new Chicken("Cipa", 6, 1000);
        cipa.eat(500); // основной обед
        cipa.eat(150); // десерт
        System.out.println(cipa);
        Chicken piper = new Chicken("Piper", 2, 500);
        //
        piper.eat(100);
        System.out.println(piper);
        //
        ArrayList<Chicken> chickens = new ArrayList<>(List.of(cipa, piper));
        Yard yard1 = new Yard("Central avenue 19", chickens);
        System.out.println(yard1);
        yard1.feedAll();
        System.out.println(yard1);
    }
}