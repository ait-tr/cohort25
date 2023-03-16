public class Main {
   public static void main(String[] args) {
    int day=3;
    int month =16;
    int year=2023;
    System.out.println(day + "-" + month + "-" + year);
/*
    day=17;
    System.out.println(day + "-" + month + "-" + year);
*/
    // Меняем местами значения переменных day и month
    System.out.print("Корректная дата: ");
    int x=day;
    day = month;
    month=x;
    System.out.println(day + "-" + month + "-" + year);
   }
}