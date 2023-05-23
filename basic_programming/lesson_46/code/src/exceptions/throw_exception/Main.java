package throw_exception;

public class Main {

    public static void main(String[] args) {
        String password = "Hello";

        try {
            validate(password);
        } catch (PasswordException e) {
            System.out.println("Упс, ошибка " + e.getMessage());
        }
    }

    public static void validate(String password) {
        if (password.length() < 7) {
            throw new PasswordException("Плохая длина пароля");
        }
    }
}
