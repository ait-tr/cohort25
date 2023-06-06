package generics.example02;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        System.out.println("Программа работает");
        Nokia3310 nokia = new Nokia3310();
        IPhone iPhone = new IPhone();
        Scanner scanner = new Scanner(System.in);

        Cover coverForNokia = new Cover(iPhone);
        Cover coverForIPhone = new Cover(scanner);

        Nokia3310 nokiaFromCover = (Nokia3310)coverForNokia.getPhone();
        IPhone iPhoneFromCover = (IPhone)coverForIPhone.getPhone();

        nokiaFromCover.call();
        iPhoneFromCover.takePhoto();
    }
}
