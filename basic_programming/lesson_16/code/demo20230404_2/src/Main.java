public class Main {
    public static void main(String[] args) {
        print("java");
    }
    /*
    public static void print(String msg){
        for (int i = 0; i < msg.length() ; i++) {
            System.out.println(msg.charAt(i));  // j...  a...  v... a..
        }
    }
    */

    public static void print(String msg){
        int i = 0;
        while (i < msg.length()){
            char ch=msg.charAt(i);
            System.out.println(ch);
            i++;
        }
    }
}
