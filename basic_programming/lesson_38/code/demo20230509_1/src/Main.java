import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Jack");
        Person p2 = new Person("John");

        Student s1= new Student("Ann","Java");
        Student s2= new Student("Nick","Java");

        p1.introduce();
        s1.introduce();

        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(s1);
        people.add(s2);
        System.out.println(people);

        for (Person p: people){
            p.introduce();
        }

    }
}