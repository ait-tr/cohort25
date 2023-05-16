import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<MyDate> list =new ArrayList<>(List.of(
                new MyDate(16,10,2000),
                new MyDate(13,10,2000),
                new MyDate(14,10,2001),
                new MyDate(10,12,2000),
                new MyDate(10,10,2010)
        ));

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }
}