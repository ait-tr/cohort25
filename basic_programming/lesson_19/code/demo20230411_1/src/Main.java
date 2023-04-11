public class Main {
    public static void main(String[] args) {
        int a=10;
        System.out.println("1. До метода a=" +a);
        int b= method1(a);
        System.out.println("4. После метода a=" +a);
    }

    public static int method1(int a){
        System.out.println("2. в методе a="+a);
        a=a+188;
        System.out.println("3. в методе a="+a);
        return a;
    }



}