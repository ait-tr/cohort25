public class Main {
    public static void main(String[] args) {
        int[] a={10};
        System.out.println("1. До метода a=" +a[0]);
        int b[]= method1(a);  // массив b и массив a - один и тот же массив
        System.out.println("4. После метода a=" +a[0]);
    }



    // данный метод меняет исходный массив
    public static int[] method1(int[] a){
        System.out.println("2. в методе a="+a[0]);
        a[0]=a[0]+188;
        System.out.println("3. в методе a="+a[0]);
        return a;
    }

    // данный метод меняет копию

    public static int[] method2(int[] a){
        // что бы не менять исходный массив в методе, нужно сделать его копию
        int[] copyA = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            copyA[i]=a[i];
        }

        System.out.println("2. в методе a="+copyA[0]);
        copyA[0]=copyA[0]+188;
        System.out.println("3. в методе a="+copyA[0]);
        return copyA;
    }


}