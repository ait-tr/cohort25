public abstract class Employee {
    private String name;
    private double salaryBase;
    private  int experience;

    private final int BONUS_FOR_EXPERIENCE=5;




    public Employee(String name, double salaryBase, int experience) {
        this.name = name;
        this.salaryBase = salaryBase;
        this.experience = experience;

    }

    public String getName() {
        return name;
    }

    public double getSalaryBase() {
        return salaryBase;
    }

    public int getExperience() {
        return experience;
    }


    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", salaryBase=" + salaryBase +
                ", experience=" + experience +
                '}';
    }



    public abstract double calculateSalary();
    public  double calculateSalary(double additionalBonus){
        double bonusForExperience=getSalaryBase()*(BONUS_FOR_EXPERIENCE*0.01 * getExperience());
        double bonus = getSalaryBase() * additionalBonus*0.01;
        return getSalaryBase() + bonusForExperience +bonus;
    };

    //      IS A
    //       ЭТО

}
