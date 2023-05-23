package throw_exception;

public class PasswordException extends RuntimeException {
    public PasswordException(String message) {
        super(message); // вызов конструктора предка
    }
}
