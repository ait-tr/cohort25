public class Student extends Person{

    private String kurs;

    public Student(String name, String kurs) {
        super(name);
        this.kurs = kurs;
    }

    // Переопределение (overriding) метода. Определяем метод с тем же названием и параметрами, но в дочернем классе
    @Override
    public void introduce(){
        System.out.println("Hello my name is " + getName() + " I'am a student. I study  "+ kurs);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", kurs='" + kurs + '\'' +
                '}';
    }

}
