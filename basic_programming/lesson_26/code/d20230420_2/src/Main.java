import java.util.ArrayList;
import java.util.List;

/*
Дан лист имен, необходимо написать метод, который возвращает самое длинное имя.
Если самых длинных несколько, то последнее встретившееся.
 */
public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Jack","Nickolaus", "Nick","NickolQWE","John");
        System.out.println(getLongestName(names));
    }

    public static String  getLongestName(List<String> list){
        String max =list.get(0);
        for (String str : list) {
            if(max.length() <= str.length()){
                max=str;
            }
        }
        return max;
    }

}