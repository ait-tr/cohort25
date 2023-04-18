public class Main {
    public static void main(String[] args) {
        Phone phone1= new Phone("Samsung","Android",4, 5.2);
        //printPhone(phone1);

        Phone phone2= new Phone("Apple","AppleOS", 4,6);
        //printPhone(phone2);

        Phone phone3= new Phone("Lg", "Android", 8,6.2);
        //printPhone(phone3);

        //Phone[] phones = {phone1,phone2,phone3};
        Phone[] phones = new Phone[]{phone1,phone2,phone3};
        for (int i = 0; i <phones.length ; i++) {
            printPhone(phones[i]);
            //System.out.println(phones[i]);
        }

    }

    public static void printPhone(Phone phone){
        System.out.println("--------- печатаем телефон --------");
        System.out.println("Brand:"+phone.brand);
        System.out.println("Os:" + phone.os);
        System.out.println("Ram:" +phone.ram);
        System.out.println("screenSize:" + phone.screenSize);
    }
}