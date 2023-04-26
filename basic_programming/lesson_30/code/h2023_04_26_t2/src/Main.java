import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       /*
        Дан список имен.
        Имена в списке повторяются.
        Необходимо получить map в котором ключ будет имя,
        а значение – сколько раз это имя встретилось в исходном списке.
        Например:{jack,john,ann, jack, jack,ann} -> [jack=3, ann=2, john=1]
        */
        ArrayList<String> names = new ArrayList<>(
                List.of("jack","john","ann", "jack", "jack","ann"));
        // вариант 2 - сразу можно создать List
        List<String> names2 = List.of("jack","john","ann", "jack", "jack","ann");
        HashMap<String, Integer> countsByNames = new HashMap<>();
        for(String name: names){
            if(countsByNames.get(name) != null){ // countsByNames.containsKey(name)
                //  countsByNames.get(name) - мы получили старое значение счетчика
                countsByNames.put(name, countsByNames.get(name) + 1);
            } else {
                countsByNames.put(name, 1);
            }
        }
        System.out.println(countsByNames);
    }
}