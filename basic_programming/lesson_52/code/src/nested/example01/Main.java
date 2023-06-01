package nested.example01;

public class Main {
    public static void main(String[] args) {
        Table t1 = new Table();
        t1.add("Марсель", 29);
        t1.add("Maiia", 18);
        t1.add("Марсель", 30);

        Table t2 = new Table();
        t2.add("Константин", 30);
        t2.add("Ruslan", 41);

        TablePrinter printer1 = new TablePrinter("#");
        TablePrinter printer2 = new TablePrinter("|");

        printer1.print(t1);
        printer2.print(t2);

        Pair[] p = t1.getPairs();
        p[0].setValue(700);
        p[1] = null;

        printer1.print(t1);
    }
}
