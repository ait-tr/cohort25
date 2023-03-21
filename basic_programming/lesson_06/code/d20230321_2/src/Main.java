public class Main {
    public static void main(String[] args) {
        char ch1= 0xC4;
        char ch2 = 196;
        String str="Этот символ \u00C4 называется а с умляутом";

        System.out.println("Hel\tlo \u00C4  \u0068\u0065\n");
        System.out.println("Символ табу\u0009ляции можно заменть");
        System.out.println(ch1);
        System.out.println(ch2);// 196 -> Ä
        System.out.println(str);
        System.out.println("Ковычка \" и слэш \\");


        // String
        System.out.println("----------- STRING --------------");
        char aChar='a';         // char
        String strName = "The String уцацуа Example !";   // String

        System.out.println(strName.toUpperCase());  // заглавные буква
        System.out.println(strName.toLowerCase());  // строчные буквы
        System.out.println("length() Длинна строки: " + strName.length());       // длина строки
        System.out.println(strName.charAt(0));      // первый по порядку ссимввол
        System.out.println(strName.charAt(1));      // второй по порядку ссимввол
        System.out.println(strName.charAt(19));      // двадцатый по порядку ссимввол

        int len = strName.length();
        System.out.println(strName.charAt(len-1));   // последний символ
        System.out.println(strName.charAt(strName.length()-1));   // последний символ

        String subStr1 =strName.substring(0, 5);
        System.out.println("substring(0, 5) :" + subStr1 );

//                                                  "String уцацу"
        System.out.println("substring(3, 16) :" + strName.substring(3, 16) );
        System.out.println("substring(7) :" + strName.substring(7));



    }
}