import org.w3c.dom.ls.LSOutput;

public class Break {
    public static void main(String[] args) {
        // break -- останавливает цикл, "выбрасывает из циклав"
        for (int i = 1; i <= 50; i++) {
            System.out.println(i);
            if (i % 15 == 0) {
                break;
            }
        }
        // continue -- "выбрасывает из итерации",
        // код от continue; до конца итерации не читается
        for (int i = 0; i< 10; i++){
            if (i == 2){
                continue;
            }
            System.out.println(i);
        }

        for(int i= 1; i<10; i++){
            System.out.println("Начало итерации №" + i);
            System.out.println("Выполнил задачу 1");
            System.out.println("Выполнил задачу 2");
            if(i == 7) {
                continue;
            }
            System.out.println("Выполнил задачу 3");
            System.out.println("Конец итерации №" + i);
        }

    }
    public static void print(){
        for (int i = 0; i< 10; i++){
            if (i == 2){
                return; // return выбросит из метода, а вместе с этим и из цикла
            }
            System.out.println(i);
        }
    }

}
