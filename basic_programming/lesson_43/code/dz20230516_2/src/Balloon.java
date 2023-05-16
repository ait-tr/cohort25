public class Balloon extends FlyableClass {
    private final String color;
    private final String name;

    private static final int TAKE_OFF_HEIGHT=1500;

    public void takeOff() {
        height=TAKE_OFF_HEIGHT;
    }

    public int getTakeOffHeight(){
        return TAKE_OFF_HEIGHT;
    }

    public Balloon(String color, String name) {
        this.color = color;
        this.name = name;
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
