public class Main {
    public static void main(String[] args) {
        Person[] people={
          new Person("Илон", "Маск",40),
          new Person("Марк", "Цукерберг",43),
          new Person("Сергей", "Брин",50)
        };
        for (int i = 0; i <people.length ; i++) {
            //people[i].print();
            System.out.println(people[i]);
        }

        MyDate date1 = new MyDate(10,11,2021);
        System.out.println(date1.toString());    // вызвали метод toString объекта data1
        System.out.println(date1);    // вызвали метод toString объекта data1
        System.out.println(people[0]);

        System.out.println("-----------------------------------------------");
        MyDate birtday1=new MyDate(02,03,1993);
        Persson2 p1 = new Persson2("Иванов","Иван",birtday1);
        System.out.println(p1);

    }



}