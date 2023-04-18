public class Persson2 {
    String firstName;
    String lastName;
    MyDate birthday; // в поле храним объект класса MyDate

    Persson2(String firstName, String lastName, MyDate birthday){
        this.firstName=firstName;
        this.lastName=lastName;
        this.birthday=birthday;
    }

    public String toString(){
        return firstName + " " + lastName + "("+ birthday.toString() +")";
    }

}
