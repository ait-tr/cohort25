public class Chicken {
    String name;
    int age;
    double weight;
    Chicken(String name, int age, double weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    public String toString(){
        return name + " " + age + " " + weight;
    }
    public void eat(double foodWeight){
        weight += foodWeight;
    }
}
