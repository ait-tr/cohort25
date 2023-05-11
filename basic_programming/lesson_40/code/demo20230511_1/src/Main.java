import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("Jack",24);
        Person p1 = new Person("John",45);
        System.out.println(p);
        System.out.println(p1);

        Person p2=p;
        System.out.println(p2);

        Object obj = new Object(); // создание объекта класса Object
        Object obj2 = p1;   // переменная типа Object может хранить любой объект
        Person p3=(Person)obj2; // явное преобразование типа переменной obj2 к типу Person
        //String str=(String)obj2; // java.lang.ClassCastException

        ///-----------------------------------------------
        System.out.println("------------- equals -----------------" );
        String s1= "jack";
        String s2= "jack";
        System.out.println(s1.equals(s2));

        Person nick1 = new Person("Nick",23);
        Person nick2 = new Person("Nick",23);
        System.out.println(nick1.equals(nick2));


        Set<String> setString = new HashSet<>();
        setString.add("qwe");
        setString.add("qwe1");
        setString.add("qwe2");
        setString.add("qwe");

        System.out.println(setString);

        Set<Person> setPerson = new HashSet<>();  // обязательно определить equals and hashCode
        setPerson.add(nick1);
        setPerson.add(nick2);
        System.out.println(setPerson);


        Map<Person, Integer> map = new HashMap<>(); // обязательно определить equals and hashCode
                                                    // для ключа т.е. в классе Person


    }
}