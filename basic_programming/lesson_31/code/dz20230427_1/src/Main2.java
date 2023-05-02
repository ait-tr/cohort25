import java.io.File;

public class Main2 {
    public static void main(String[] args) {
        File file = new File("./");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
        
    }
}
