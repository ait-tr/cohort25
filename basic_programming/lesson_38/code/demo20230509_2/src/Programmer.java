public class Programmer extends Employee {

    public Programmer(String name, int salary) {
        super(name,salary);
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "name='" + getName() + '\'' +
                ", salary=" + getSalary() +
                '}';
    }
    @Override
    public void work(){
        System.out.println(getName() +": I'm a programmer. I write code ");
    }

}
