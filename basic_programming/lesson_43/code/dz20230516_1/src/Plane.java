public class Plane implements Flyable {
    private final String number;
    private int height=0;
    private int distance=0;
    private static final int TAKE_OFF_HEIGHT=7500;


    public Plane(String number) {
        this.number = number;
    }

    @Override
    public void takeOff() {
        height=TAKE_OFF_HEIGHT;
    }

    @Override
    public void land() {
        height=0;
    }

    @Override
    public void fly(double distance) {
        this.distance+=distance;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "number='" + number + '\'' +
                ", height=" + height +
                ", distance=" + distance +
                '}';
    }

    public void changeHeight(int newHeight){
        height=newHeight;
        System.out.println("methodOfBalloon");
    }
}
