public abstract class FlyableClass implements Flyable{
    protected int height=0;
    protected int distance=0;


    // геттер, который при вызове будет возвращать
    // значение поля из ДОЧЕРНЕГО класса
    // см. printTakeOffHight()
    public abstract int getTakeOffHeight();


    public void printTakeOffHight(){
        System.out.println(getTakeOffHeight());
        // здесь будет вызвана реализация метода getTakeOffHeight() из дочернего класса
    }



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
}
