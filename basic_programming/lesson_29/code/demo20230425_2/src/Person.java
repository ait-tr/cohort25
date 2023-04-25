public class Person {
    String fName;
    String lName;
    int age;

    Person(String fName, String lName, int age){
        this.fName= fName;
        this.lName= lName;
        this.age = age;
    }

    public String toString(){
        return fName+" "+lName +" ("+ age+")";
    }

}
