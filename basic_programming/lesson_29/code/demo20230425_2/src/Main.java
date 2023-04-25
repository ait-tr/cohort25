import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Person[] people = {
                new Person("Иван","Иванов",20),
                new Person("Василий","Васильев",30),
                new Person("Евгений","Дятлов",25),
                new Person("Олег","Шаров",22)
        };

        HashMap<String, Person> lNameToPersonMap = new HashMap<>();
        for (Person person: people){
            lNameToPersonMap.put(person.lName, person );
        }
        System.out.println(lNameToPersonMap);

        Person person= lNameToPersonMap.get("Иванов");
        System.out.println(person);

        ///////////////////////////////////////////////////////////////
        HashMap<String, String> lNameTofName = new HashMap<>();
        for (Person p: people){
           lNameTofName.put(p.lName, p.fName);
        }
        System.out.println(lNameTofName);

        HashMap<Integer,String> ageTofName = new HashMap<>();
        for (Person p1: people){
            ageTofName.put(p1.age, p1.fName);
        }
        System.out.println(ageTofName);
    }
}