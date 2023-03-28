public class Main {
    public static void main(String[] args) {
         /*Задача 1
        Написать программу для подсчета периметра и площади круга.
        Задайте значение радиуса в программе и выведите на экран значение периметра и площади.*/

        int r = 20;
        //-------------

        double perimeter= 2 * r *Math.PI;
        double area= r * r * Math.PI;

        //Округление результата до второго знака
        double perimeter1= (Math.round(perimeter*100))/100.0;
        // 12566.370614359172


        //-------------
        System.out.println("Perimeter: " + perimeter );
        System.out.println("Perimeter: " + perimeter1 );
        System.out.println("Area: " + area );


    }
}