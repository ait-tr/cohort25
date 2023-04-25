import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
       // Map - хранит пару: ключ и значение

        HashMap<Integer, String> month = new HashMap<>();
        month.put(1,"Январь");
        month.put(2,"Февраль");
        month.put(3,"Март");
        month.put(4,"Апрель");
        month.put(5,"Май");
        month.put(6,"Июнь");
        System.out.println(month);

        System.out.println(month.get(3));
        System.out.println(month.get(13));

        month.put(17,"qwertyu");
        System.out.println(month);

        /// мэп пользователей сайта
        // обычно получаем из базы данных
        HashMap<String,String> users = new HashMap<>(); // ключ строка е-мэйл, значение строк - ФИО
        users.put("jack@gmail.com","Jack Johnson");
        users.put("nick134@gmail.com","Nick Cave");
        users.put("ann1984@hotmail.com","Anna Rahr");
        System.out.println(users);

        // пользователь ввел емайл
        String inputtedEmail= "nick134@gmail.com";

        // проверяем есть ли такой email в map
        String user= users.get(inputtedEmail); // получить пользователя по его email (получить значение по ключу)
        if(user!=null){
            System.out.println("Привет "+ user);
        } else {
            System.out.println("Нужно зарегистрироваться");
        }


        users.put("ann1984@hotmail.com","Rick");
        System.out.println(users);

        users.put("rick@hotmail.com","Rick");
        System.out.println(users);

        // ключи - уникальные,
        // а значения могут повторяться

        Set<String> keys = users.keySet(); // получить множество ВСЕХ ключей мэп
        System.out.println(keys);

        // перебрать все пары мэпа
        System.out.println("перебрать все пары мэпа");
        for (String key: keys){
            String value = users.get(key);
            System.out.println("key: " + key + " value:" + value);

            /* Сэт из email
            nick134@gmail.com, null
            jack@gmail.com, null
            rick@hotmail.com, null
             */

        }
    }
}