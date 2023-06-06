package generics.example03;

public class Main {
    public static void main(String[] args) {
        System.out.println("Программа работает");
        Nokia3310 nokia = new Nokia3310();
        IPhone iPhone = new IPhone();

        Cover<Nokia3310> coverForNokia = new Cover<>(nokia);
        Cover<IPhone> coverForIPhone = new Cover<>(iPhone);

        Nokia3310 nokiaFromCover = coverForNokia.getPhone();
        IPhone iPhoneFromCover = coverForIPhone.getPhone();

        nokiaFromCover.call();
        iPhoneFromCover.takePhoto();
    }
}
