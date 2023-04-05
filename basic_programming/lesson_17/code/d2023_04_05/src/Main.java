public class Main {
    public static void main(String[] args) {
        char a = 'a'; //
        char t = 't'; //
        String cat = "c";
        cat += a;
        cat = cat + t;
        System.out.println(cat);
        String word = "Panda";
        System.out.println(word.charAt(0)); // P
        System.out.println(word.charAt(3)); // d
        System.out.println(word.charAt(word.length() - 1)); // a
        // word.charAt(90); //  это будет ошибкой StringIndexOutOfBoundsException
    }
}