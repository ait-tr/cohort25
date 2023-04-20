import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //ArrayList<String> list = new ArrayList<>();
        //LinkedList<String> list = new LinkedList<>();

        List<String> list = new ArrayList<>();
        List<String> immutableList = List.of("qwe","rttyy");

        System.out.println("------------- MyArr -----");
        MySmartArray myArray= new MySmartArray();

        myArray.add("111");
        myArray.add("112");
        myArray.add("113");
        myArray.add("114");


        for (int i = 0; i < myArray.size; i++) {
            System.out.println(myArray.get(i));
        }
        
    }
}