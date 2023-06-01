package nested.example01;

public class TablePrinter {
    private final String separator;

    public TablePrinter(String separator) {
        this.separator = separator;
    }

    public void print(Table table) {
        System.out.println("Печатаем таблицу");
        Pair[] pairs = table.getPairs();
        for (int i = 0; i < table.getCount(); i++) {
            System.out.println(pairs[i].getKey()
                    + separator + pairs[i].getValue());
        }
    }
}
