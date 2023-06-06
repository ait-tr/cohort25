package generics.example01;

public class Main {
    public static void main(String[] args) {
        Nokia3310 nokia = new Nokia3310();
        IPhone iPhone = new IPhone();

        CoverForNokia coverForNokia = new CoverForNokia(nokia);
        CoverForIPhone coverForIPhone = new CoverForIPhone(iPhone);

        Nokia3310 nokiaFromCover = coverForNokia.getPhone();
        IPhone iPhoneFromCover = coverForIPhone.getPhone();
    }
}
