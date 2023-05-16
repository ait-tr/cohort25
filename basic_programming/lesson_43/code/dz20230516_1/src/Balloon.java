public class Balloon implements Flyable{
    private final String color;
    private final String name;

    private int height=0;
    private int distance=0;
    private static final int TAKE_OFF_HEIGHT=1500;


    public Balloon(String color, String name) {
        this.color = color;
        this.name = name;
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
        return "Balloon{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", distance=" + distance +
                '}';
    }

    public void changeHeight(int newHeight){
        height=newHeight;
        System.out.println("methodOfBalloon");
    }


}
