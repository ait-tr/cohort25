package nested.example02;

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

        Table.Printer printer1 = new Table.Printer("#");
        Table.Printer printer2 = new Table.Printer("|");

        printer1.print(t1);
        printer2.print(t2);
    }
}
