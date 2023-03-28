public class Main {
    public static void main(String[] args) {
        int a = 100;
        System.out.println(a);
        System.out.println(Math.abs(a));
        System.out.println("отрицательное число:");
        a = -100;
        System.out.println(a);
        System.out.println(Math.abs(a));

        int flask1 = 70;
        int flask2 = 75;
        boolean b1= Math.abs(flask1-flask2) <= 10;

       // ( (flask1-flask2) <=10 )  &&   ( flask1>=flask2 ) ||    ( (flask2-flask1) <=10 )  &&   ( flask2>=flask1 )
        System.out.println("----------------------------");
        flask1 = 69;
        flask2 = 72;
        int aa = flask1 + -10;
        System.out.println(aa);
        int bb = flask2 + -10;
        System.out.println(bb);
                                 //                  true
                                 //                               false
                                //       true              false       false
        boolean isDeviceWorkCorrect =(flask1>70) ||    (flask2>70) && (aa==bb)  ;
        System.out.println(isDeviceWorkCorrect);

                int temp1 = 71;
                int temp2 = 98;
                int temp3 = temp1 - temp2; // -27

                boolean isCorrect =  (temp3<=10) & (temp3>=-10) & ( (temp1 > 70 ) ||(temp2 > 70) ) ;
                System.out.println(isCorrect);


    }
}