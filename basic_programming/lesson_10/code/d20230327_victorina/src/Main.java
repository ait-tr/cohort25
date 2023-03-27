import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Что вы положите вниз?");
        String firstLayer = scanner.nextLine();
        System.out.println("Что вы положите на второй слой?");
        String secondLayer = scanner.nextLine();
        System.out.println("Что вы положите на третий слой?");
        String thirdLayer = scanner.nextLine();
        System.out.println("Что вы положите на самый верх слой?");
        String fourthLayer = scanner.nextLine();

        boolean isUnusualSandwich = !firstLayer.equalsIgnoreCase("bread");
//        boolean isUnusual = firstLayer.equals("tomato") || firstLayer.equals("cheese")
//                || firstLayer.equals("ham");
        if (isUnusualSandwich) {
            System.out.println("Какой необычный бутерброд");
        } else {
            // в else попадут все, в которых хлеб на первом месте
            // какие есть возможные комбинации
            // хлеб, cheese, ham, ?
            boolean hamOnThird = secondLayer.equalsIgnoreCase("cheese")
                    && thirdLayer.equalsIgnoreCase("ham");
            // хлеб, ?cheese     , ?cheese  , ham
            boolean hamOnFourth = (secondLayer.equalsIgnoreCase("cheese") ||
                    thirdLayer.equalsIgnoreCase("cheese"))
                    && fourthLayer.equalsIgnoreCase("ham");
            // && истинно только, когда истина && истина
            // || истинно, когда хотя бы один из операндов истинен
            boolean isIdealSandwich = hamOnThird || hamOnFourth;
            // хлеб, хлеб, сыр, ветчина
            // хлеб, сыр, ветчина, хлеб
            // хлеб, сыр, сыр, ветчина
            // хлеб, сыр, ветчина, ветчина
            if (isIdealSandwich) {
                System.out.println("Идеальный сэндвич");
            } else {
                System.out.println("Вкусный сэндвич");
            }
            // !
            // "Кот".equals("Cобака");      // false
            // !("Кот".equals("Cобака"));   // true
            // !text1.equals(text2);        // они не равны
            // age > 14                     // все подростки и старше - старше 14 не включительной
            // !(age > 14)                  // все те, кому 14 и меньше включительно
        }

    }
}