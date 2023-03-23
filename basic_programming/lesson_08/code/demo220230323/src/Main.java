public class Main {
    public static void main(String[] args) {
        int a=10;
        String str="дождь";
        String str1=str.toUpperCase();
        String str2="ДОЖДЬ";


        System.out.println("str=" +str);
        System.out.println("str1=" +str1);
        System.out.println("str2=" +str2);

        System.out.println("str1==str2 -"+ (str1==str2));
        System.out.println("str1.equals(str2) -"+ (str1.equals(str2)));
        System.out.println("str.equalsIgnoreCase(str2) -"+ (str.equalsIgnoreCase(str2)));

        // при сравнение строк == использовать нельзя
        if(str1.equals(str2)){    // правильное сравнение строк на равенство
            System.out.println("Привет!");
        }

        if(str.equalsIgnoreCase(str2)){ //сравнение строк без учета регистра
            System.out.println("Строки равны без учета больших-маленьких букв");
        }
        System.out.println(str1);

    }
}