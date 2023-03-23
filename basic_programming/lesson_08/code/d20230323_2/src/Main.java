public class Main {
    public static void main(String[] args) {
        /*
            изучем логическое И и ИЛИ
         */
        boolean isDoneTask1= false;
        boolean isDoneTask2 = false;
        boolean isDZdone= isDoneTask1 & isDoneTask2;
        System.out.println("ДЗ выполнено: " + isDZdone);

        if(isDZdone){
            System.out.println("выполнены обе задачи");
        } else {
            System.out.println("dz не выполнено");
        }
        System.out.println();
        //--------------- или --------
        System.out.println("------------- ИЛИ -----------");
        boolean isAuto=false;
        boolean isBus=false;

        boolean isGo = isBus | isAuto;
        System.out.println("Поехали: " + isGo);




    }
}