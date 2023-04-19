public class Person {
    String firstName;
    String lastName;
    MyDate birthday;
    Person(String firstName, String lastName, MyDate birthday){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }
    public String toString(){
        return firstName + " " + lastName + " " + birthday;
    }
}
