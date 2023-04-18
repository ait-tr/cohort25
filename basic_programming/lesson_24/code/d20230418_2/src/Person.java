public class Person {
    String firstName;
    String lastName;
    int age;

    Person(String firstName, String lastName, int age){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
    }

    public void print(){
        System.out.println(firstName + " " + this.lastName + "("+this.age+")");
    }

    public String toString(){
        return firstName+ " " + this.lastName + "("+this.age+")";   // если нет конфликта this можно писать, а можно не писать
    }

}
