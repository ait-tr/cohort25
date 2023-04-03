public class ElseIf {
    public static void main(String[] args) {
        int a = 9;
        int b = 10;
        int c = 11;
        if (a == 91) {
            System.out.println("первый блок");
            // этот блок читается, если первое == true
        } else if (b == 10) {  // это условие проверяется, только если первое false
            System.out.println("второй блок");
            // этот блок читается, если первое == false, втрое условие == true
        } else {
            System.out.println("третий блок");
            // этот блок читается, если первое == false, втрое условие == false
        }



    }
}
