public class Main {
    public static void main(String[] args) {
        print("java");
    }
    public static void print(String msg){
        for (int i = msg.length()-1; i >= 0 ; i--) {  // i= 3 .. 2....1 ....0
            System.out.println(msg.charAt(i));
        }
    }
}
