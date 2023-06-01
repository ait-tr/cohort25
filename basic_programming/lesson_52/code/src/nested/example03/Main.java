package nested.example03;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        Table.Pair pair  = new Table.Pair("Марсель", 29);

        Table t1 = new Table();
        t1.add("Марсель", 29);
        t1.add("Maiia", 18);
        t1.add("Марсель", 30);

        Table t2 = new Table();
        t2.add("Константин", 30);
        t2.add("Ruslan", 41);

        Table.Printer printer1 = t1.new Printer("#");
        Table.Printer printer2 = t2.new Printer("|");
        Table.Printer printer3 = t1.new Printer("*");

        printer1.print();
        printer2.print();
        printer3.print();

        Random random = new Random();

    }
}
