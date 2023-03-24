import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // У нас три раунда напитков -
        // В меню три позиции: "wine", "beer", "vodka"
        // Официант спрашивает у человека три раза, что тот будет пить.
        // Выберите первый напиток, и т.д.
        // a.
        // Если выпили водку хотя бы в одном из раундов:
        // - то выводим в консоль фразу: "Не стоило этого делать, не помню,
        // что произошло дальше"
        // b.
        // Если пили пиво после вина - то нужно вывести фразу:
        // "Ох, не стоило понижать градус"
        // В противном случае вывести фразу:
        // "Какой прекрасной была вечеринка"
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите напиток раунд 1");
        String drink1 = scanner.nextLine();
        System.out.println("Выберите напиток раунд 2");
        String drink2 = scanner.nextLine();
        System.out.println("Выберите напиток раунд 3");
        String drink3 = scanner.nextLine();

        boolean isDrunkVodka = (
                drink1.equals("vodka")
                        || drink2.equals("vodka")
                        || drink3.equals("vodka")
        );
        if(isDrunkVodka){
            System.out.println(
                    "Не стоило этого делать, не помню, что произошло дальше");
        } else {
            // вино вино пиво - понижение   *1  *2
            // вино пиво пиво - понижение   *1
            // вино пиво вино - понижение   *1
            // пиво вино пиво - понижение       *2
            // Условие проверяет для случаев, когда вино в первом раунде
            boolean wineFirstCondition =
                    drink1.equals("wine") &&
                            (drink2.equals("beer") || drink3.equals("beer"));
            // Условие проверяет для случаев, когда вино во втором раунде
            boolean wineSecondCondition =
                    drink2.equals("wine") && drink3.equals("beer");
            // Объединили оба условия через ИЛИ
            boolean isBadComboOfDrinks =
                    wineFirstCondition || wineSecondCondition;
            if (isBadComboOfDrinks){
                System.out.println("Ох, не стоило понижать градус");
            } else {
                System.out.println("Какой прекрасной была вечеринка");
            }
        }
    }
}