public class QAEngineer extends Employee{


    public QAEngineer(String name, int salary) {
        super(name,salary);
    }

    @Override
    public String toString() {
        return "QA{" +
                "name='" + getName() + '\'' +
                ", salary=" + getSalary() +
                '}';
    }
    @Override
    public void work(){
        System.out.println(getName() + ": I'm a QA. I check the code ");
    }


}
