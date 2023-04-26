import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
      /*
        Дан список объектов Account. Каждый Account
        содержит 3 поля String iban – номер счета, String nameOfOwner –
        имя владельца, double balance – баланс счета.
        Необходимо создать map в котором ключем будет имя владельца счета а значением его Account.
*/
        HashMap<String, Account> accountsByNames = new HashMap<>();
        accountsByNames.put(
                "Ivan",
                new Account("de123123", "Ivan", 2000)
        );
        accountsByNames.put(
                "Irina",
                new Account("de3912938", "Iryna", 15000)
        );
        System.out.println(accountsByNames);
        //<String, String>  "пароль"  "слово"
        //<String, Integer> "пароль"  12
        //<String, Pirate>  "пароль"  Объект: Jack Sparrow 28
        print(accountsByNames);
    }
    public static void print(HashMap<String, Account> map){
        // Map.Entry entry - текущий объект - который содержит в себе ключ и значения
        // .entrySet() - возвращает множество entries
        // map - в данном случае это просто имя переменной, которую мы сами выбрали
        for(Map.Entry entry: map.entrySet()){
//            System.out.println(entry);
            // Entry - это класс у которого есть поля key, value
            // получаем из entry ключ при помощи метод .getKey()
            // получаем из entry значение при помощи метода .getValue()
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}