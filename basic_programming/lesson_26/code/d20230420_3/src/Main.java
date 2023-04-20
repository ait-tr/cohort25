import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
LinkedList
 */
public class Main {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        /*
            Переменная типа List может содержать любой лист,
            хоть LinkedList, хоть ArrayList
         */


        //LinkedList<String> list = new LinkedList<>();
        //ArrayList<String> list = new ArrayList<>();

        list.add("jack");
        list.add("lena");
        list.add("alexandr");
        list.add("nick");

        list.add(1, "klod"); // добавляем в позицию 1 значение "klod"
        list.set(2,"elena"); // клод добавился, лена имеет индекс 2. Заменили на elena

        System.out.println(list);

    }

    public static void printList(List<String> list){   // можно передать любой лист в качестве параметра
        System.out.println(list);
    }


}