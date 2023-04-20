import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> listOfNames = List.of("jack","john","ann"); // создание листа с начальными значениями
        // но это неизменяемый список!!!!

        //listOfNames.add("nick");   // UnsupportedOperationException
        System.out.println(listOfNames);

        // for стандартный
        System.out.println("for стандартный");
        for (int i = 0; i < listOfNames.size() ; i++) {
            System.out.println(listOfNames.get(i));
        }

        // for ... each
        System.out.println("for ... each");
        for (String str : listOfNames){    //   str=listOfNames.get(i)
            System.out.println(str);
        }
        // нельзя использовать если:
        // 1) если нужен не весь лист, а только диапазон значений
        // 2) если нужен индекс
        // 3) нестандартный перебор, например, в обратном порядке

    }
}