import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee dantistMark = new Employee(
                "Mark",
                "Gusinsky",
                1,
                "dantist",
                20000
        );
        System.out.println(dantistMark);
        Employee accountant = new Employee(
                "Irina",
                "Borisova",
                20,
                "accountant",
                5000
        );
        Firm zubDaju = new Firm(
                "Зуб даю",
                new LinkedList<Employee>(
                        List.of(dantistMark, accountant))
        );
        System.out.println(zubDaju);
        zubDaju.paySelaryToAll();
        System.out.println(zubDaju);
    }
}