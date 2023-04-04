public class Main {
    public static void main(String[] args) {
        /*
            Дана строка. Реализовать метод, который выводит на экран
            только буквы стоящие на четных позициях в этой строке.

            "java is very popular" -> "jv s vr pplr"
            "012345678" -> "02468"
         */
        print("012345678");
        print("java is very popular");
        System.out.println(getString("java is very popular"));

    }
    public static void print(String word){
        for(int i=0; i < word.length(); i++ ){
            if(i%2==0) {
                char ch = word.charAt(i);
                System.out.print(ch);
            }
        }
        System.out.println();
    }

    public static void print2(String word){
        for(int i=0; i < word.length(); i+=2 ){ // i= 0... 2....4.....6...
                char ch = word.charAt(i);
                System.out.print(ch);
        }
        System.out.println();
    }

    public static String getString(String word){
        String result="";
        for(int i=0; i<word.length(); i+=2){
            result+= word.charAt(i);  // result=result+word.charAt(i);
        }
        return result;
    }

}