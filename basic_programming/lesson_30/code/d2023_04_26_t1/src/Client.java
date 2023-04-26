public class Client {
    String name;
    int age;
    boolean isGym;
    Client(String name, int age, boolean isGym){
        this.name = name;
        this.age = age;
        this.isGym = isGym;
    }
    public String toString(){
        return name + " " + age + " " + isGym;
    }
}
