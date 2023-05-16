public class Plane extends FlyableClass {
    private final String number;
    private static final int TAKE_OFF_HEIGHT=7500;

    public int getTakeOffHeight(){
        return TAKE_OFF_HEIGHT;
    }

    public Plane(String number) {
        this.number = number;
    }

    public void takeOff() {
        height=TAKE_OFF_HEIGHT;
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
