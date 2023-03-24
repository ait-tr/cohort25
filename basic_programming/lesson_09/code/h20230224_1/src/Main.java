public class Main {
    public static void main(String[] args) {
        System.out.println(false && true); // false
        // && - и || - или
        System.out.println(8 == 8 && 9 == 8); // false
        System.out.println(false && false); // false
        System.out.println(false || true); // true
        System.out.println((false && true) || true);
        boolean condition = 8 == 9;
        // && - сокращенное и - использует ленивую семантику & - логичесвкое и
        // false && (не будет смотреть) -
        // || -
        // true || (не будет смотреть)
        // !=  - не равно
        // Отрицание:
        // !true == false
        // !(9 == 8)   // true
        // !false      // true
        // !(age > 10) //
        //
        String name = "Anna";
        String gender = "Female";
        if (gender.equals("Female")) {

            if (name.equals("Anna")) {
                System.out.println("Bingo Anna");
            }
            if (name.equals("Maria")) {
                System.out.println("Bingo Maria");
            }
        } else {
            System.out.println("");
        }


    }
}