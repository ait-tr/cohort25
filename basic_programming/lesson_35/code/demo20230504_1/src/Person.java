public class Person {
    String name;
    int age;

    String auto;


    Person(String name, int age, String auto){
        this.name = name;
        this.age= age;
        this.auto = auto;
    }

    Person(String name, int age){
        this.name = name;
        this.age= age;
        this.auto = "";
    }
    /*
    Person(String name){
        this.name = name;
        this.age=-1;
        this.auto = "";
    }
    */

    //Person(){  }
    public String toString(){
        return name + " " +( (age==-1)?"нет данных":age) + " " + auto;
    }

    public void sayHello(){
        System.out.println("Hello! I'am " + name);
    }



}
