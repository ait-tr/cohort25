public class Main {
    /*
          Есть прибор у которого есть 2 колбы. В программе дано две переменных,
          которые содержат температуру каждой колбы. Считается, что прибор работает корректно
          если температура в одной из колб  меньше 0, а температура друго больше 100;
     */
    public static void main(String[] args) {
        // данные с датчика температуры могут быть любые
        int flask1= 110;
        int flask2= 13;
        //------------------------

        boolean isDeviceWorkCorrect = ( (flask1<0) & (flask2>100) )  |   ((flask2<0) & (flask1>100));

        System.out.println("Температура первой колбы: \"" + flask1 +"\"" );
        System.out.println("Температура второй колбы: " + flask2);
        if(isDeviceWorkCorrect){
            System.out.println("Прибор работает корректно");
        } else {
            System.out.println("Прибор работает не корректнно");
        }

    }
}