public class D2023_04_13_p2 {
    public static void main(String[] args) {
        try {
            goWalking("кеды");
        } catch(Exception e){
            System.out.println(e.getMessage());
            // e.printStackTrace();
        }
        // Создайте метод void eatHealthy(String food)
        // Если еда равна "бургер"
        // то метод бросает ошибку с сообщением "Бургеры тебя убьют, не ешь"
        // Если еда не равна "бургер" - выводит в консоль "Приятного аппетита"
        // вызовите этот  метод в мейне и оберните в try catch
        try {
            eatHealthy("яблоко");
            goWalking("кеды");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    // создали потенциально опасный метод, который выбрасывает ошибки
    public static void eatHealthy(String food) throws Exception{
        if (food.equals("бургер")){
            throw new Exception("Бургеры тебя убьют, не ешь");
        } else {
            System.out.println("Приятного аппетита");
        }
    }
    public static void goWalking(String boots) throws Exception {
        if (boots.equals("кеды")){
            // создадим ошибку при помощи слова new и класса Exception
            // throw - выкидывает/бросает ошибку
            throw new Exception("Кеды не подходят для прогулки в горах");
        } else {
            System.out.println("Отличный выбор обуви");
        }
    }
}
