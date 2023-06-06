package generics.example02;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Nokia3310 nokia = new Nokia3310(); // создали объект Нокии
        IPhone iPhone = new IPhone(); // создали объект Айфона

        Cover coverForNokia = new Cover(nokia); // положили нокиую в обложку
        Cover coverForIPhone = new Cover(iPhone); // положили айфон в обложку

        Nokia3310 nokiaFromCover = (Nokia3310)coverForNokia.getPhone(); // получаем нокию как объект
        IPhone iPhoneFromCover = (IPhone)coverForIPhone.getPhone();

        nokiaFromCover.call();
        iPhoneFromCover.takePhoto();
    }
}
