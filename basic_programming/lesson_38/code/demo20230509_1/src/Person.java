public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
    public void introduce(){
        System.out.println("Hello my name is " + name);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
