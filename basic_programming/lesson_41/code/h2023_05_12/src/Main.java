import java.util.*;

public class Main {
  public static void main(String[] args) {
//    Задание 1
//    Создать класс Account (String iban, Person owner, double balance).
//    Создать список счетов.
//    Написать метод, который формирует Map< Account, Person>,
//    где ключом является счет Account, а значением Person владелец счета.
//
//    Задание 2
//    Допустим, у вас есть список счетов, в котором счета повторяются.
//    Нужно написать метод List < Account > getUniqueAccounts(List< Account > list)
//    который сформирует список уникальных счетов
    // ==
    // equals
    List<Account> accountList = List.of(
        new Account("de202123232323232304",
            new Person("John", "Malcovich"),
            50000),
        new Account("de202123232323232304",
            new Person("John", "Malcovich"),
            50000),
        new Account("de202123232322323",
            new Person("Bob", "Crouse"),
            10000),
        new Account("de2021232123232313",
            new Person("Anna", "Frank"),
            100000000),
        new Account("de2021232123232313",
            new Person("Georg", "Franko"),
            100000000)
    );
    Map<Account, Person> resultMap = getAccountMap(accountList);
    System.out.println(resultMap);
    System.out.println(getUniqueAccounts(accountList));


  }

  public static Map<Account, Person> getAccountMap(List<Account> accountList) {
    Map<Account, Person> map = new HashMap<>();
    for (Account account : accountList) {
      map.put(account, account.getOwner());
    }
    return map;
  }

  public static List<Account> getUniqueAccounts(List<Account> list) {
    HashSet<Account> set = new HashSet<>(list);
    return new ArrayList<>(set);
  }
}