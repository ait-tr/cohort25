import java.util.LinkedList;

public class Firm {
    String title;
    LinkedList<Employee> employees;

    Firm(String title, LinkedList<Employee> employees){
        this.employees = employees;
        this.title = title;
    }
    public String toString(){
        return title + " " + employees;
    }
    public void paySelaryToAll(){
        for(Employee employee : employees){
            if(employee.experience > 2){
                // по 2 % надбавки за каждый год
                employee.moneyAccount += 3000 + 3000 * 0.02 * employee.experience;
            } else {
                employee.moneyAccount += 3000;
            }
            if(employee.position.equals("dantist")){
                // дантисту, чтобы он не ушел - еще бонус
                employee.moneyAccount += 1000;
            }
        }
    }
}
