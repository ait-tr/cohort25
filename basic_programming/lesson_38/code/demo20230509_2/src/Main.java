import java.util.List;

public class Main {
    public static void main(String[] args) {

        Programmer p1= new Programmer("Jack", 5000);
        Programmer p2= new Programmer("John", 3500);
        QAEngineer q1= new QAEngineer("Lena", 5500);
        QAEngineer q2= new QAEngineer("Nick", 4000);
        Manager m= new Manager("Ted", 4000, 2000);
        Lazzy l = new Lazzy("Lazzy",0);
        List<Employee> employees= List.of( p1,p2,q1,q2,m, l         );

        for (Employee employee:employees){
            employee.paySalary();
            employee.work();
        }


    }




}