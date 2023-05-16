public abstract class FlyableClass implements Flyable{
    protected int height=0;
    protected int distance=0;


    // геттер, который вызывается из дочернего класса и возвращает
    // значение поля из ДОЧЕРНЕГО класса
    public abstract int getTakeOffHeight();

    @Override
    public abstract void takeOff();

    @Override
    public void land() {
        height=0;
    }

    @Override
    public void fly(double distance) {
        this.distance+=distance;
    }

    public void printTakeOffHight(){
        System.out.println(getTakeOffHeight());
    }
}
